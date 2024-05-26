package com.dchasanidis;

public class Main {
    public static void main(String[] args) {
        final int subCount = 10;
        final int messageCount = 10;

        Topic topic = new Topic("my first topic");
        for (int i = 0; i < subCount; i++) {
            topic.addSubscriber(new SubscriberImpl("sub" + i));
        }

        for (int i = 0; i < messageCount; i++) {
            topic.publish(new Message("Message " + i));
        }

        topic.shutDown();
    }
}