mvn clean package -DskipTests=true
scp target/ticketws-0.9.5.war ubuntu@doraemon.com:/home/ubuntu/Java
