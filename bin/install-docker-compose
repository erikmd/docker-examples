#!/usr/bin/env bash

set -e

version=$(curl -fsS https://api.github.com/repos/docker/compose/releases/latest \
  | grep '"tag_name":' | cut -d : -f 2 | tr -d \ ,\")
binary="docker-compose-$(uname -s)-$(uname -m)"
sudo curl \
  -L https://github.com/docker/compose/releases/download/${version}/${binary} \
  -o /usr/local/bin/docker-compose
sudo chmod a+x /usr/local/bin/docker-compose
docker-compose --version
