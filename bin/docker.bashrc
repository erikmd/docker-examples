# -*- mode: shell-script; -*-

# Alias pour Docker à copier-coller dans votre fichier ~/.bashrc
# (ne copiez pas les 2 premiers alias si vous êtes sous Windows)

alias docker='sudo docker'
alias docker-compose='sudo docker-compose'

alias dinfo='docker info'
alias dhist='docker history'
alias dinsp='docker inspect'
alias dimag='docker images'
alias dps='docker ps'
alias docker-stop='docker stop $(docker ps -a -q)'
alias docker-clean='docker rm $(docker ps -a -q -f status=exited)'
alias docker-purge='docker rmi $(docker images -q -f dangling=true)'
