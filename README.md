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
  Choisir `Mac with Apple silicon` si la ligne de commande `uname -m` renvoie `arm64`.

### Sous Windows

Suivre l'une des approches suivantes :

* <https://docs.docker.com/desktop/windows/install/> + `WSL 2 backend`
* <https://docs.docker.com/desktop/windows/install/> + `Hyper-V backend`

Bien vérifier les prérequis, notamment, Hyper-V est efficace mais *incompatible avec VirtualBox*.

### Sous GNU/Linux

Suivre l'une des approches suivantes :

* <https://docs.docker.com/engine/install/> (Docker Engine), stratégie recommandée :
  * si vous utilisez un serveur ([Debian](https://docs.docker.com/engine/install/debian/) ou [Ubuntu](https://docs.docker.com/engine/install/ubuntu/)…),
  * si vous êtes à l'aise en ligne de commande,
  * ou simplement si vous ne voulez pas être confrontés à ce problème :  
    [Docker bind mount permissions - unexpected mounting as root:root](https://stackoverflow.com/q/64106038/9164010)
* <https://docs.docker.com/desktop/install/linux-install/#system-requirements> (Docker Desktop for Linux)

Docker Desktop embarque implicitement **docker-compose**, mais si vous avez installé Docker Engine :

* Installer **docker-compose** après avoir consulté les
  [instructions d'installation dans la doc officielle](https://docs.docker.com/compose/install/).

(*Remarque :* si jamais vous souhaitiez installer `docker-compose` avec `pip3`
comme il s'agit d'un programme Python,
**ce n'est pas l'approche recommandée !** ;
et il est très fréquent d'aboutir à des conflits de dépendances PyPI
− vérifiable en faisant `pip check && pip3 check`)

## Attention ! note aux utilisateurs de Docker Engine

**⚠️ N'ajoutez pas** votre compte au groupe `docker` comme cela est suggéré
dans beaucoup de tutoriels en ligne (~`sudo usermod -aG docker $USER`~),
mais pour plus de facilité − pour éviter de devoir taper à la main `sudo docker`
mais juste `docker`, tout en ayant un *prompt* redemandant votre mot de passe −,
vous pouvez suivre la configuration mentionnée ci-dessous
(["Prérequis : Définir des alias pour Docker Engine"](#pr%C3%A9requis--d%C3%A9finir-des-alias-pour-docker-engine)).

Pour les détails : le souci de sécurité sous-jacent est résumé sur StackOverflow,
cf. ["docker.sock permission denied"](https://stackoverflow.com/a/65956808/9164010).

## Prérequis : Définir des alias pour Docker Engine

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
licence [MIT](./LICENSE).
