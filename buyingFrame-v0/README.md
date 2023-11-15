# How to run docker compose ELK

bin\windows\zookeeper-server-start.bat config\zookeeper.properties
bin\windows\kafka-server-start.bat config\server.properties
spring.kafka.producer.bootstrap-servers=localhost

0- download offeset explorer: https://offsetexplorer.com/download.html
Video :::
1- producer ::: https://www.youtube.com/watch?v=rVqAoUIPO7I&t=308s
2- consumer ::: https://www.youtube.com/watch?v=d0T9g0_G_3U&t=426s

1- telecharger kafka : https://kafka.apache.org/
2- click en haut button download
3- dezipper le fichier et le nommer kafka --machi kafka2.3.9 hiiii kafka barakaaa ---
4- rentrer dans dossier kafka et lancer un cmd --- mode admin ---
5- dans cmd dans le dossier kafka taper: bin\windows\zookeeper-server-start.bat config\zookeeper.properties
6- dans un autre cmd --- mode admin --- dans le dossier kafka taper: bin\windows\kafka-server-start.bat config\server.properties
