package com.drpicox.queue;

public interface QueueReceiver<T> {

    void receive(T s);
}
