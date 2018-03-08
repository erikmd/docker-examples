# Tiny example of Docker image to show it has root perms by default

To test it (assuming you have GNU/Linux):

```sh
sudo touch test.txt
sudo docker build -t chmod .
sudo docker run --rm -v `pwd`:`pwd` -w `pwd` chmod
sudo docker run --rm -v `pwd`:`pwd` -w `pwd` -u `id -u`:`id -g` chmod
```
