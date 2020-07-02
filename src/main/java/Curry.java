import java.util.function.BiFunction;
import java.util.function.Function;

public class Curry {
    public static <U,V,W> Function<U, Function<V, W>> fi(BiFunction<U, V, W> biFn) {
        return u -> v-> biFn.apply(u, v);
    }
}
