#Base OS for docker container

#setup group and user, initialise home
#RUN addgroup 

COPY demo-student.jar /app
RUN chown -R demo-student /app
EXPOSE demo-student
WORKDIR app
ENTRYPOINT exec java $JAVA_OPTS -jar ./demo-student.jar