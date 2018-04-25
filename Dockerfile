FROM tomcat:8.5.30-jre8
COPY /target/friendspammer-web.war /usr/local/tomcat/webapps/friendspammer-web.war
