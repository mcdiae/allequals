package demo.impl;

import java.time.Instant;

public class ControlPojo extends Pojo {

    public ControlPojo(Pojo pojo) {
        super(pojo);
    }

    public ControlPojo(long id, String data, Instant time, int count) {
        super(id, data, time, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlPojo pojo = (ControlPojo) o;

        if (count != pojo.count) return false;
        if (id != pojo.id) return false;
        if (data != null ? !data.equals(pojo.data) : pojo.data != null) return false;
        if (time != null ? !time.equals(pojo.time) : pojo.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }
}
