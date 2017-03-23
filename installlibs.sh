echo "Instalación de librerías"
mvn install:install-file -Dfile=lib/ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.0.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/onebox-rest2-xml-client.jar -DgroupId=es.oneboxtm -DartifactId=oneboxtm -Dversion=1.0.0 -Dpackaging=jar
