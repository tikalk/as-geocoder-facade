
FROM java:8




EXPOSE 7080

# Copy your fat jar to the container
ADD build/distributions/ft-geocoder-facade.tar.gz /ft-geocoder-facade

# Launch the verticle
ENV WORKDIR /ft-geocoder-facade/run-bin
ENTRYPOINT ["sh", "-c"]
CMD ["cd $WORKDIR ; ./geocoder-facade.sh"]
