package demo.impl;

import com.google.common.base.Objects;

public class GuavaPojo extends Pojo {

    public GuavaPojo(Pojo pojo) {
        super(pojo);
    }

    @Override
    public boolean equals(Object o) {
        return (o == this)
                || (o instanceof GuavaPojo && equals((GuavaPojo) o));
    }

    private boolean equals(GuavaPojo pojo) {
        return (id == pojo.id)
                && Objects.equal(data, pojo.data)
                && Objects.equal(time, pojo.time)
                && count == pojo.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, data, time, count);
    }
}
