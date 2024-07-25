package org.example;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;

public class Actor2 extends AbstractActor {
    private final ActorSelection selection;
    private boolean canSentMessage=true;
    public Actor2() {
        ActorSystem system = getContext().getSystem();
        this.selection = system.actorSelection("akka://ReceiverSystem@localhost:17056/user/actor1");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    if (canSentMessage){
                        System.out.println("Actor2 received message: " + message);
                        selection.tell("Hi from Actor 2", getSelf());
                        canSentMessage=false;
                    }
                })
                .build();
    }
}
