package demo.impl;

import uk.kludje.Meta;

public class KludjePojo extends Pojo {

    public KludjePojo(Pojo pojo) {
        super(pojo);
    }

    private static final Meta<KludjePojo> META = Meta.<KludjePojo>meta().longs($ -> $.id)
            .ints($ -> $.count)
            .objects($ -> $.data, $ -> $.time);

    @Override
    public boolean equals(Object o) {
        return META.equals(this, o);
    }

    @Override
    public int hashCode() {
        return META.hashCode(this);
    }
}
