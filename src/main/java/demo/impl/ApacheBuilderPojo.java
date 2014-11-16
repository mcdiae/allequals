package demo.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ApacheBuilderPojo extends Pojo {

    public ApacheBuilderPojo(Pojo pojo) {
        super(pojo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApacheBuilderPojo)) return false;

        ApacheBuilderPojo pojo = (ApacheBuilderPojo) o;

        return new EqualsBuilder()
                .append(id, pojo.id)
                .append(data, pojo.data)
                .append(time, pojo.time)
                .append(count, pojo.count)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(data)
                .append(time)
                .append(count)
                .toHashCode();
    }
}
