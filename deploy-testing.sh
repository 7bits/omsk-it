#!/bin/bash

# you need first generate a rsa keypair for ssh connect without password:
# ssh-keygen
# ssh-copy-id hostname
# ssh hostname

echo "Deleting old files from server..."
ssh root@192.168.1.228 '
    echo "stop tomcat";
    /etc/init.d/tomcat7 stop;
    echo "remove omsk-it.war";
    rm omsk-it.war;
    echo "remove $CATALINA_HOME/webapps/ROOT";
    rm -r $CATALINA_HOME/webapps/ROOT;
    echo "remove $CATALINA_HOME/webapps/ROOT.war";
    rm $CATALINA_HOME/webapps/ROOT.war;
'

echo "Create war..."
mvn clean package -P test

echo "Copy war to the testing server..."
scp target/omsk-it.war root@192.168.1.228:/root

echo "Deploy war to the CATALINA_HOME/webapps/ROOT.war..."
ssh root@192.168.1.228 '
    echo "copy war";
    cp omsk-it.war $CATALINA_HOME/webapps/ROOT.war;
    echo "start tomcat";
    /etc/init.d/tomcat7 start;
'

echo "Deploy rails_admin"
pwd
cd rails-admin/
cap deploy