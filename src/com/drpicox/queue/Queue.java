package com.drpicox.queue;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Queue {

    List<Object> messages;
    List<QueueReceiver> receivers;

    public Queue() {
        messages = new LinkedList<>();
        receivers = new LinkedList<>();
    }

    public void send(Serializable message) {
        messages.add(message);
    }

    public <T> void receive(Class<T> messageClass, QueueReceiver<T> receiver) {
        receivers.add((Object message) -> {
            if (messageClass.isInstance(message)) {
                receiver.receive((T) message);
            }
        });
    }

    public void deliverMessages() {
        messages.forEach(
                (Object message) -> receivers.forEach(
                        (QueueReceiver receiver) -> receiver.receive(message)
                )
        );
    }
}
