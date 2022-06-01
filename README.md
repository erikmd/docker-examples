# docker-examples

Ce dépôt contient des exemples et supports d'exercices sur Docker.

## Metadata

### LAST NAME : 
### First name : 
### TP group :
- [ ] Linux
- [ ] macOS
- [ ] Windows

## Prérequis : [Installer Docker](https://docs.docker.com/get-docker/) et docker-compose

Plus précisément :

### Sous macOS

Suivre l'approche suivante :

* <https://docs.docker.com/desktop/mac/install/> (Docker + docker-compose pour macOS)  
  Choisir `Mac with Apple chip` si la ligne de commande `uname -m` renvoie `arm64`.

### Sous Windows

Suivre l'une des approches suivantes :

* <https://docs.docker.com/desktop/windows/install/> + `WSL 2 backend`
* <https://docs.docker.com/desktop/windows/install/> + `Hyper-V backend`

Bien vérifier les prérequis, notamment, Hyper-V est efficace mais *incompatible avec VirtualBox*.

### Sous GNU/Linux

Pour installer **Docker Engine**, consulter les
[instructions d'installation dans la documentation
officielle](https://docs.docker.com/engine/install/) :

* <https://docs.docker.com/engine/install/debian/> pour Debian et al.
* <https://docs.docker.com/engine/install/ubuntu/> pour Ubuntu et al.

Pour installer **docker-compose**, consulter les
[instructions d'installation dans la documentation
officielle](https://docs.docker.com/compose/install/).

(*Remarque :* si jamais vous souhaitiez installer `docker-compose` avec `pip3`
comme il s'agit d'un programme Python,
**ce n'est pas l'approche recommandée…**
et il est très fréquent d'aboutir à des conflits de dépendances PyPI !
− vérifiable en faisant `pip check && pip3 check`)

## Attention !

**⚠️ N'ajoutez pas** votre compte au groupe `docker` comme cela est suggéré
dans beaucoup de tutoriels en ligne (~`sudo usermod -aG docker $USER`~),
mais pour plus de facilité − pour éviter de devoir taper à la main `sudo docker`
mais juste `docker`, tout en ayant un *prompt* redemandant votre mot de passe −,
vous pouvez suivre la configuration mentionnée ci-dessous
(["Prérequis : Définir des alias pour Docker"](#pr%C3%A9requis--d%C3%A9finir-des-alias-pour-docker)).

Pour les détails : le souci de sécurité sous-jacent est résumé sur StackOverflow,
cf. ["docker.sock permission denied"](https://stackoverflow.com/a/65956808/9164010).

## Prérequis : Définir des alias pour Docker

- Ouvrir le fichier **`~/.bashrc`** avec l'éditeur de votre choix
  (**`~/.zshrc`** sous macOS) ou créer ce fichier s'il n'existe pas.
- Y ajouter le contenu de [ce fichier](./bin/docker.bashrc)
  (ou [tout sauf les 2 premiers alias](./bin/docker.bashrc#L16-L23) si
  vous êtes sous Windows ou macOS)
- Redémarrer le terminal (ou faire `. ~/.bashrc` sous GNU/Linux)
- Pour vérifier, exécuter `dinfo` puis `docker version`

## Auteur et licence

Le code de ce projet a été développé par
[Erik Martin-Dorel](https://github.com/erikmd) et est distribué sous
licence [BSD-3](./LICENSE).
