package demo.impl;

import java.util.Objects;

public class UtilPojo extends Pojo {

    public UtilPojo(Pojo data) {
        super(data);
    }

    @Override
    public boolean equals(Object o) {
        return (o == this)
                || (o instanceof UtilPojo && equals((UtilPojo) o));
    }

    private boolean equals(UtilPojo pojo) {
        return (id == pojo.id)
                && count == pojo.count
                && Objects.equals(data, pojo.data)
                && Objects.equals(time, pojo.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, time, count);
    }
}
