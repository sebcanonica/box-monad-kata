import java.util.Objects;
import java.util.function.Function;

public class Box<T> {
    private T _value;

    public Box(T value) {
        _value = value;
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

    public <U> Box<U> fmap(Function<T,U> fn) {
        return new Box<U>(fn.apply(_value));
    }

    public static <T> Box<T> pure(T value) {
        return new Box<T>(value);
    }

    public <U,V> Box<V> app(Box<U> box) {
        @SuppressWarnings("unchecked")
        Function<U, V> fn = (Function<U, V>) _value;
        return new Box<V>(fn.apply(box._value));
    }

    public <U> Box<U> bind(Function<T, Box<U>> aIncrementToBox) {
        return aIncrementToBox.apply(_value);
    }

    public <U> Box<U> fmapMonad(Function<T,U> fn) {
        return bind(v -> // bind gives us the raw value of this as input
                pure(fn.apply(v)) // so we can apply the raw function and put the result back in the box
        );
    }

    public <U,V> Box<V> appMonad(Box<U> box) {
        return bind(f -> { // bind gives us the raw function in this as input
            @SuppressWarnings("unchecked")
            Function<U, V> fn = (Function<U, V>) f;
            return box.bind(u -> // now we can ask bind to unpack the value
                    pure(fn.apply(u))); // apply and put back in the box
        });
    }
}
