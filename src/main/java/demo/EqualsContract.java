package demo;

public class EqualsContract {

    public static boolean test(Object[] arr) {
        boolean result = true;
        for (Object first : arr) {
            result &= notNull(first);
            result &= reflexive(first);
            for (Object second : arr) {
                result &= symmetric(first, second);
                result &= consistent(first, second);
                for (Object third : arr) {
                    result &= transitive(first, second, third);
                }
            }
        }
        return result;
    }

    private static boolean notNull(Object o) {
        return !o.equals(null);
    }

    private static boolean reflexive(Object o) {
        return o.equals(o)
                && (o.hashCode() == o.hashCode());
    }

    private static boolean symmetric(Object o1, Object o2) {
        boolean o1o2 = o1.equals(o2);
        boolean result = (o1o2 == o2.equals(o1));
        if (o1o2) {
            return result && (o1.hashCode() == o2.hashCode());
        }
        return result;
    }

    private static boolean transitive(Object o1, Object o2, Object o3) {
        boolean o1o2 = o1.equals(o2);
        boolean o1o3 = o1.equals(o3);
        boolean o2o3 = o2.equals(o3);
        if (o1o2 && o1o3) {
            return (o2o3);
        }
        return true;
    }

    private static boolean consistent(Object o1, Object o2) {
        return (o1.equals(o2) == o1.equals(o2));
    }
}
