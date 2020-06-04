import java.util.Objects;
import java.util.function.Function;

public class Box<T> {
    final private T _value;

    public Box(T value) {
        _value = value;
    }

    public static <T> Box<T> pure(T v) {
        return new Box<>(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box<?> box = (Box<?>) o;

        return Objects.equals(_value, box._value);
    }

    @Override
    public int hashCode() {
        return _value != null ? _value.hashCode() : 0;
    }

    public <U> Box<U> fmap(Function<T, U> f) {
        return new Box<>(f.apply(_value));
    }

    public <U,V> Box<V> app(Box<U> v) {
        @SuppressWarnings("unchecked")
        Function<U,V> fn = (Function<U,V>) _value;
        return new Box<>(fn.apply(v._value));
    }

    public <U> Box<U> bind(Function<T, Box<U>> fn) {
        return fn.apply(_value);
    }

    public <U> Box<U> fmapMonad(Function<T, U> f) {
        return bind(t -> pure(f.apply(t)));
    }

    public <U,V> Box<V> appMonad(Box<U> bu) {
        return bind(f -> {
            @SuppressWarnings("unchecked")
            Function<U,V> fn = (Function<U,V>) f;
            return bu.bind(u -> pure(fn.apply(u)));
        });
    }
}
