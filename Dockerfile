
FROM java:8




EXPOSE 8080

# Copy your fat jar to the container
ADD build/distributions/as-geocoder-facade.tar.gz /as-geocoder-facade

# Launch the verticle
ENV WORKDIR /as-geocoder-facade/run-bin
ENTRYPOINT ["sh", "-c"]
CMD ["cd $WORKDIR ; ./geocoder-facade.sh"]
