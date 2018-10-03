# docker-examples

Ce dépôt contient des exemples et supports d'exercices sur Docker.

## Prérequis : Installer Docker CE et docker-compose

### Sous Debian GNU/Linux

Pour installer **Docker CE**, consulter les instructions
d'installation dans la documentation
<https://docs.docker.com/install/linux/docker-ce/debian/>
ou bien exécuter directement le script
[bin/install-docker](./bin/install-docker#L5-L21) fourni dans ce dépôt Git
en faisant :

```bash
$ ./bin/install-docker
```

Pour installer **docker-compose**, consulter les instructions
d'installation dans la documentation
<https://docs.docker.com/compose/install/>
ou bien exécuter directement le script
[bin/install-docker-compose](./bin/install-docker-compose#L5-L12) fourni
dans ce dépôt Git en faisant :

```bash
$ ./bin/install-docker-compose
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

* <https://docs.docker.com/docker-for-windows/install/> (Docker for Windows)  
  (*attention cela active Hyper-V, qui est incompatible avec VirtualBox*)
* <https://docs.docker.com/toolbox/overview/> (Docker Toolbox for Windows)  
  (*ancienne distribution utilisant `docker-machine` et VirtualBox*)

## Auteur et licence

Le code de ce projet a été développé par
[Erik Martin-Dorel](https://github.com/erikmd) et est distribué sous
licence [BSD-3](./LICENSE).
