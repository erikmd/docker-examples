# docker-examples

Ce dépôt contient des exemples et supports d'exercices sur Docker.

## Prérequis : [Installer Docker](https://docs.docker.com/get-docker/) et docker-compose

Plus précisément :

### Sous GNU/Linux (architecture *x86_64* = *amd64* requise)

Pour installer **Docker Engine**, consulter les
[instructions d'installation dans la documentation
officielle](https://docs.docker.com/engine/install/)
ou bien (pour Debian stretch/buster ou Ubuntu ≥ 16.04) exécuter directement le
script [bin/install-docker.sh](./bin/install-docker.sh#L7-L23)
fourni dans ce dépôt Git après l'avoir inspecté, en faisant :

```bash
$ bash ./bin/install-docker.sh
```

Pour installer **docker-compose**, consulter les
[instructions d'installation dans la documentation
officielle](https://docs.docker.com/compose/install/)
ou bien exécuter directement le script
[bin/install-docker-compose.sh](./bin/install-docker-compose.sh#L5-L12)
fourni dans ce dépôt Git après l'avoir inspecté, en faisant :

```bash
$ bash ./bin/install-docker-compose.sh
```

(à moins que vous ne souhaitiez installer `docker-compose` avec `pip3`
comme il s'agit d'un programme Python, mais dans ce cas vérifiez les
dépendances juste après avec `pip check && pip3 check` !)

### Sous macOS

Suivre l'une des approches suivantes :

* <https://docs.docker.com/docker-for-mac/install/> (Docker + docker-compose pour macOS)
* <https://docs.docker.com/docker-for-mac/docker-toolbox/> (installation alternative)

### Sous Windows

Suivre l'une des approches suivantes :

* <https://docs.docker.com/docker-for-windows/install/> (Docker for Windows 10 Pro/Enterprise)  
  (*attention cela active Hyper-V, qui est incompatible avec VirtualBox*)
* <https://docs.docker.com/toolbox/overview/> (Docker Toolbox for Windows)  
  (*ancienne distribution utilisant `docker-machine` et VirtualBox*)

## Prérequis : Définir des alias pour Docker

- Ouvrir le fichier `~/.bashrc` avec l'éditeur de votre choix (ou
  créer ce fichier s'il n'existe pas)
- Y ajouter le contenu de [ce fichier](./bin/docker.bashrc)
  (ou [tout sauf les 2 premiers alias](./bin/docker.bashrc#L9-L16) si
  vous êtes sous Windows)
- Redémarrer le terminal (ou faire `. ~/.bashrc`)
- Pour vérifier, exécuter `dinfo` puis `docker version`

## Auteur et licence

Le code de ce projet a été développé par
[Erik Martin-Dorel](https://github.com/erikmd) et est distribué sous
licence [BSD-3](./LICENSE).
