#!/bin/sh

echo "Restarting the tomcat"
sudo /etc/init.d/tomcat7 restart
echo "Deploing"
mvn clean tomcat:redeploy -P local
echo "Deploing completed!"
#beeeeep! Need to install beep
beep