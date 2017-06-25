search-engine REST service
=====================

- [Configuration] (#configuration)
- [Installation] (#install)
- [Run] (#run)

# Configuration
At ./server/src/main/resources folder there is application.properties file.
In this file you can choose which port the service will operate on.
The default is 8093. You can pick up anything you want, except reserved or already used.

# Install
mvn clean install

# Run
java -jar ./server/target/search-engine-server-0.0.1-SNAPSHOT.jar