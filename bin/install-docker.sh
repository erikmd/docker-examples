#!/usr/bin/env bash

set -e

sudo apt-get update
sudo apt-get install \
  apt-transport-https \
  ca-certificates \
  curl \
  gnupg2 \
  software-properties-common
curl -fsSL \
  https://download.docker.com/linux/$(. /etc/os-release; echo "$ID")/gpg | sudo apt-key add -
apt-key fingerprint 0EBFCD88  # Cela doit afficher :
echo "pub   9DC8 5822 9FC7 DD38 854A  E2D8 8D81 803C 0EBF CD88  # valeur attendue"
read -r -s -n 1 -p "Appuyez sur une touche pour continuer (ou Ctrl+C pour quitter)..."; echo
sudo add-apt-repository \
  "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
  $(lsb_release -cs) stable"
sudo apt-get update
sudo apt-get install docker-ce
