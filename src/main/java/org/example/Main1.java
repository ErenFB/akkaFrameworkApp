package org.example;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Main1 {
    public static void main(String[] args) {
        Config config = ConfigFactory.parseResources("application1.conf");
        ActorSystem system = ActorSystem.create("ReceiverSystem", config);
        system.actorOf(Props.create(Actor1.class), "actor1");
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
