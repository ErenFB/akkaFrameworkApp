package org.example;

import akka.actor.AbstractActor;

public class Actor1 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    System.out.println("Actor1 received message: " + message);
                    getSender().tell("Hi from Actor 1", getSelf());
                })
                .build();
    }
}
