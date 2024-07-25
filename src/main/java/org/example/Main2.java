package org.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Main2 {
    public static void main(String[] args) {
        Config config = ConfigFactory.parseResources("application2.conf");
        ActorSystem system = ActorSystem.create("SenderSystem", config);
        ActorRef sender = system.actorOf(Props.create(Actor2.class), "actor2");
        System.out.println("----------------------------------------------------------------------------------------------");
        sender.tell("Hi from Actor 1", ActorRef.noSender());
    }
}
