# Tiny example of Docker image to show it has root perms by default

To test it (assuming you have GNU/Linux):

```sh
sudo touch test.txt
sudo docker build -t chmod-test .
sudo docker run --rm -v "$PWD":"$PWD" -w "$PWD" chmod-test
sudo docker run --rm -v "$PWD":"$PWD" -w "$PWD" -u `id -u`:`id -g` chmod-test
```
