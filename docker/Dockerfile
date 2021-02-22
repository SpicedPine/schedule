FROM jboss/wildfly:22.0.0.Final

MAINTAINER spicedpine

ENV REHA_EVENTS_URL=localhost:8081/scheduler/events
ENV ACTIVE_MQ_USERNAME=admin
ENV ACTIVE_MQ_PASSWOED=admin
ENV ACTIVE_MQ_TOPIC_NAME=eventsTopic

COPY ./web-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
COPY ./activemq-rar-5.16.1.rar /opt/jboss/wildfly/standalone/deployments/
COPY ./standalone-my.xml /opt/jboss/wildfly/standalone/configuration/

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent



EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-my.xml"]
