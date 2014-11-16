package demo;

import demo.impl.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.time.Instant;
import java.util.function.Function;

public class EqualsBenchmark {

    private static final long[] IDS = {Integer.MAX_VALUE, Long.MAX_VALUE};
    private static final String[] DATA = {"foo", "bar", null};
    private static final Pojo[] INIT = new Pojo[IDS.length * DATA.length];


    private static Pojo[] create(Function<Pojo, Pojo> supplier) {
        Pojo[] ret = new Pojo[INIT.length + 1];
        int idx = 0;
        for (Pojo instance : INIT) {
            ret[idx++] = supplier.apply(instance);
        }
        ret[ret.length - 1] = new Pojo(Long.MAX_VALUE, "abc", null, Integer.MAX_VALUE) {
        };
        for (int r = 0; r < ret.length; r++) {
            if (ret[r] == null) {
                throw new Error();
            }
        }
        return ret;
    }

    static {
        int idx = 0;
        for (long id : IDS) {
            for (String data : DATA) {
                INIT[idx++] = new ControlPojo(id, data, Instant.now(), Integer.MIN_VALUE + idx);
            }
        }
    }

    @State(Scope.Benchmark)
    public static class Control {
        private final Pojo[] CONTROL = create(ControlPojo::new);
        private final Pojo[] UTIL = create(UtilPojo::new);
        private final Pojo[] KLUDJE = create(KludjePojo::new);
        private final Pojo[] GUAVA = create(GuavaPojo::new);
        private final Pojo[] APACHE = create(ApacheBuilderPojo::new);
    }

    @Benchmark
    public boolean control(Control state) {
        return EqualsContract.test(state.CONTROL);
    }

    @Benchmark
    public boolean util(Control state) {
        return EqualsContract.test(state.UTIL);
    }

    @Benchmark
    public boolean kludje(Control state) {
        return EqualsContract.test(state.KLUDJE);
    }

    //@Benchmark
    public boolean guava(Control state) {
        return EqualsContract.test(state.GUAVA);
    }

    @Benchmark
    public boolean apache(Control state) {
        return EqualsContract.test(state.APACHE);
    }
}
