import java.util.Objects;
import java.util.function.Function;

public class Box<T> {
    final private T _value;

    public Box(T value) {
        _value = value;
    }

    public static <T> Box<T> pure(T _value) {
        return new Box<>(_value);
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
        return Objects.hash(_value);
    }

    public <S> Box<S> fmap(Function<T,S> fun) {
        return new Box<S>(fun.apply(_value));
    }

    @Override
    public String toString() {
        return "Box{" +
                "_value=" + _value +
                '}';
    }

    public <U, V> Box<U> app(Box<V> box) {
        //noinspection unchecked
        return box.fmap((Function<V, U>) _value);
    }

    // (T -> m U) -> m U
    public <U> Box<U> bind(Function<T, Box<U>> boxedFunction) {

        return boxedFunction.apply(_value);

    }

    public <S> Box<S> fmapMonad(Function<T,S> fun) {
        return bind(value -> pure(fun.apply(value)));
    }
}
