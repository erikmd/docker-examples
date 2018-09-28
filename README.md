# docker-examples

Ce dépôt contient des exemples et supports d'exercices sur Docker.

## Prérequis : Installer Docker CE et docker-compose

### Sous Debian GNU/Linux

Pour installer **Docker CE**, suivre les étapes ci-dessous ou bien
consulter directement les instructions d'installation dans la
documentation :
<https://docs.docker.com/install/linux/docker-ce/debian/>

```bash
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
echo "pub   9DC8 5822 9FC7 DD38 854A  E2D8 8D81 803C 0EBF CD88"
sudo add-apt-repository \
  "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
  $(lsb_release -cs) stable"
sudo apt-get update
sudo apt-get install docker-ce
```

Pour installer **docker-compose**, suivre les étapes ci-dessous ou
bien consulter directement les instructions d'installation dans la
documentation : <https://docs.docker.com/compose/install/>  
(à moins que vous ne souhaitiez installer `docker-compose` avec `pip3`
comme il s'agit d'un programme Python, mais dans ce cas vérifiez les
dépendances juste après avec `pip check && pip3 check` !)

```bash
version=$(curl -fsS https://api.github.com/repos/docker/compose/releases/latest \
  | grep '"tag_name":' | cut -d : -f 2 | tr -d \ ,\")
binary="docker-compose-$(uname -s)-$(uname -m)"
sudo curl \
  -L https://github.com/docker/compose/releases/download/${version}/${binary} \
  -o /usr/local/bin/docker-compose
sudo chmod a+x /usr/local/bin/docker-compose
docker-compose --version
```

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
