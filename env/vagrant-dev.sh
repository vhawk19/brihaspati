#!/bin/bash
curl -fsSL https://get.docker.com -o get-docker.sh
sh get-docker.sh
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
yes | sudo apt-get install openjdk-8-jre
wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
chmod +x lein
sudo mv lein /usr/local/bin
lein
sudo /vagrant/docker-compose up -d
export port=8080
export DB_TYPE=postgresql
export DB_NAME=postgres
export DB_USER=brihaspati_db
export HOST=localhost
export DB_PASSWORD=tara
export DB_PORT=7001
export DB_NAME_TEST=postgres
export DB_USER_TEST=brihaspati_db
export DB_PORT_TEST=7001
