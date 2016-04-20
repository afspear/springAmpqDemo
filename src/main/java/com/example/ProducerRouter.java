package com.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by aspear on 4/15/16.
 */
@Profile("producer")
@Component
public class ProducerRouter extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("timer://foo?fixedRate=true&period=3s")
          .process(exchange1 -> exchange1.getIn().setBody("test"))
          .inOut("rabbitmq://localhost/B")
          .process(exchange -> {
              byte[] body = (byte[])exchange.getIn().getBody();
              System.out.println(new String(body));
          });
    }
}
