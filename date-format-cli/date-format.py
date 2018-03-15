#!/usr/bin/env python3
# -*- coding: utf-8 -*-
#
# Copyright (c) 2018  Erik Martin-Dorel
#
# This file is distributed under the BSD-3 license, which is available
# at https://opensource.org/licenses/BSD-3-Clause

# This script depends on the requests package.
# You can get the right environment by running:
# $ sudo pip3 install --upgrade pip && sudo pip3 install requests

import os
import sys
import requests


def usage(exit_code=0):
    prog = os.path.basename(__file__)
    print("Example of Python3 CLI interface for the 'date-format' Web Service")
    print("The 'WS_URL' env. variable should be set for commands list and now")
    print("\nUsage: \t%s help\n"
          "\t%s list\n"
          "\t%s now <time zone>\n"
          "\t%s repl\n"
          % (prog, prog, prog, prog))
    exit(exit_code)


def get_ws_url():
    try:
        ws_url = os.environ['WS_URL']
    except KeyError as e:
        print("Environment variable %s not set!" % str(e), file=sys.stderr)
        usage(1)
    if ws_url[-1] != '/':
        ws_url += '/'
    print("WS_URL=%s" % ws_url, file=sys.stderr)
    return ws_url


def now(timezone):
    ws_url = get_ws_url()
    params = dict(
        tz=timezone
    )
    response = requests.get(url=ws_url + "now", params=params)
    if response.status_code != 200:
        print("Erreur %d" % response.status_code)
        print(response.text)
        return
    data = response.json()
    print("La date et l'heure actuelles : %s" % data["dateTime"])
    print("Le nom du fuseau horaire est : %s" % data["timeZone"])


def list_tz():
    ws_url = get_ws_url()
    response = requests.get(url=ws_url + "list")
    if response.status_code != 200:
        print("Erreur %d" % response.status_code)
        print(response.text)
        return
    data = response.json()
    print("--8<---------------cut here---------------start------------->8---")
    for item in data:
        print(item)
    print("--8<---------------cut here---------------end--------------->8---")


def repl():
    get_ws_url()  # just to check

    def recap():
        print("Mode interactif.  Tapez :\n"
              "  ? pour afficher cette aide\n"
              "  ENTREE pour afficher la liste des fuseaux horaires\n"
              "  Le nom d'un fuseau horaire suivi d'ENTREE pour le choisir\n"
              "  Ctrl+D pour quitter")

    recap()
    try:
        while True:
            print("> ", end="")
            query = input().strip()
            if query == "?":
                recap()
            elif len(query) == 0:
                list_tz()
            else:
                now(query)
    except EOFError:
        print("Fin du mode interactif.")
        exit(0)


def main(argv):
    if len(argv) < 1:
        usage(0)
    command = argv[0]
    if command == "help":
        usage(0)
    elif command == "list":
        list_tz()
    elif command == "now":
        if len(argv) == 2:
            tz = argv[1]
            now(tz)
        else:
            print("Error: command 'now' expects one argument", file=sys.stderr)
            usage(1)
    elif command == "repl":
        repl()
    else:
        print("Error: unknown command '%s'" % command, file=sys.stderr)
        usage(1)


if __name__ == "__main__":
    main(sys.argv[1:])
