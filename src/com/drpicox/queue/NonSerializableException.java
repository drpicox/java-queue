package com.drpicox.queue;

import java.io.IOException;

public class NonSerializableException extends RuntimeException {

    public NonSerializableException(IOException cause) {
        super(cause);
    }

}
