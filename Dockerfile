FROM tomcat:8.5.30-jre8
COPY /target/messagesender-web.war /usr/local/tomcat/webapps/ms.war
