package com.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by aspear on 4/19/16.
 */
@Profile("consumer")
@Component
public class ConsumerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("rabbitmq://localhost/B")
          .convertBodyTo(String.class)
          .process(exchange -> {
              String body = (String)exchange.getIn().getBody();
              String modifiedBody = body.toUpperCase();
              exchange.getIn().setBody(modifiedBody);
              System.out.println("Modified " + body + " to " + modifiedBody);
          });
    }
}
