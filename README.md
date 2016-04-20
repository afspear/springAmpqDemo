# springAmpqDemo
Spring Boot application to demo Request Reply messaging. At this point, it's not using Spring AMQP, but just Apache Camel.

More on Apache Camel Request/Reply here: http://camel.apache.org/request-reply.html

To Run:

first start docker
docker run -d -p 5672:5672 -p 15672:15672 --hostname my-rabbit --name some-rabbit rabbitmq:3

then run the app twice with environment variable spring.profiles.active set to "consumer" on one and "producer" on the other.

TODO: write docker stuff (compose, etc.)
