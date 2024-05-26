package com.dchasanidis;

public class Main {
    public static void main(String[] args) {
        Topic topic = new Topic("my first topic");
        for (int i = 0; i < 10; i++) {
            topic.addSubscriber(new SubscriberImpl("sub" + i));
        }

        topic.publish(new Message("Message 1"));
        topic.publish(new Message("Message 2"));

        topic.shutDown();
    }
}