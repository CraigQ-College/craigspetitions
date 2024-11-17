FROM tomcat:latest
RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps
ADD target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]