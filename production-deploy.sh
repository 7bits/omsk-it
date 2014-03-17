#!/bin/sh

echo "Connecting to production server"
ssh root@162.243.36.248 '
    echo "Stoping tomcat";
    /etc/init.d/tomcat7 stop;
    cd /var/lib/tomcat7/webapps;
    echo "Delete ROOT";
    rm -r ROOT;
    echo "Delete ROOT.war";
    rm ROOT.war;
'
echo "Creting war"
mvn clean package -P production
echo "Copying to production"
scp target/ROOT.war root@162.243.36.248:/var/lib/tomcat7/webapps
echo "Restarting tomcat"
ssh root@162.243.36.248 '
    echo "Staring tomcat";
    /etc/init.d/tomcat7 start;
'
echo "Deploying completed"
#beeeeep! Need to install beep
beep