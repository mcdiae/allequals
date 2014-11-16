package demo.impl;

import java.time.Instant;

public abstract class Pojo {
    protected final long id;
    protected final String data;
    protected final Instant time;
    protected final int count;

    protected Pojo(long id, String data, Instant time, int count) {
        this.id = id;
        this.data = data;
        this.time = time;
        this.count = count;
    }

    protected Pojo(Pojo copy) {
        this.id = copy.id;
        this.data = copy.data;
        this.time = copy.time;
        this.count = copy.count;
    }
}
