import java.util.function.BiFunction;
import java.util.function.Function;

public class Curry {
    public static <T,U,V> Function<T, Function<U, V>> fi(BiFunction<T, U, V> biFn) {
        return t -> u -> biFn.apply(t, u);
    }
}
