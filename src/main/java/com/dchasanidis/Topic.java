package com.dchasanidis;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Topic {
    private String name;
    private final Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();
    private final ExecutorService executors = Executors.newFixedThreadPool(10);

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Topic setName(final String name) {
        this.name = name;
        return this;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void addSubscriber(final Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(Message message) {
        for (Subscriber subscriber : subscribers) {
            executors.submit(() -> {
                subscriber.onMessage(message, this.name);
            });
        }
    }

    public void shutDown() {
        executors.shutdown();
    }
}
