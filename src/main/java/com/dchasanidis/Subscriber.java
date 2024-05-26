package com.dchasanidis;

public interface Subscriber {
    void onMessage(Message message, String topicName);
}
