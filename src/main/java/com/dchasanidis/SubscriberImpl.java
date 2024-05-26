package com.dchasanidis;

public class SubscriberImpl implements Subscriber {
    private final String name;

    public SubscriberImpl(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(final Message message, final String topicName) {
        System.out.println("Subscriber " + name + " received message: " + message.getContent() + " from topic: " + topicName);
    }
}