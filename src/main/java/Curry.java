import java.util.function.BiFunction;
import java.util.function.Function;

public class Curry<T, U, R> {
    static <T, U, R> Function<T, Function<U, R>> fi(BiFunction<T, U, R> f) {
        return t -> u -> f.apply(t, u);
    }
}
