import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class Box_should {
    // PRIME DIRECTIVE: NEVER EVER IMPLEMENT AN ACCESSOR !!!
    // This is the *feature* of our box
    // But how can we still do useful things with it ?
    // Rules:
    //      1) make the uncommented tests pass
    //      2) refactor the production code to generics
    //      3) uncomment the next test
    //      4) go to step 1

    @Test
    public void consider_2_boxed_int_with_same_value_to_be_equals() {
        Box<Integer> a2 = new Box<>(2);
        Box<Integer> another2 = new Box<>(2);
        assertEquals(a2, another2);
    }

/*    @Test
    public void implement_functor_fmap() {
        Box<Double> aDouble = new Box<>(5.55);

        Box<Long> actual = aDouble.fmap(Math::round);

        assertEquals(actual, new Box<>((long) 6));
    }*/

/*    @Test
    public void implement_applicative_pure() {
        Box<Integer> actual = Box.pure(3);

        assertEquals(actual, new Box<>(3));
    }*/

/*    @Test
    public void implement_applicative_app() {
        // Hint: might require a very ugly unchecked cast
        Box<Function<Integer, Double>> aBoxedIncrement = Box.pure(x -> x+1.5);
        Box<Integer> a5 = Box.pure(5);

        Box<Double> actual = aBoxedIncrement.app(a5);

        assertEquals(actual, Box.pure(6.5));
    }*/

/*    static class MyMath {
        static Integer add(Integer a, Integer b) {
            return a + b;
        }
        static Function<Integer, Integer> partialAdd(Integer a) {
            return x -> x+a;
        }
        static Integer curryAdd(Integer a, Integer b) {
            return partialAdd(a).apply(b);
        }
    }

    @Test
    public void implement_a_generic_curryfi_for_bifunction() {
        BiFunction<Integer, Short, Double> biFn = (x, y) -> x+2.5*y;

        Function<Integer, Function<Short, Double>> actual = Curry.fi(biFn);

        assertEquals(biFn.apply(1,(short)2), actual.apply(1).apply((short)2));
    }*/

/*    @Test
    public void use_fmap_and_app_with_binary_functions() {
        // Should not need new production code
        BiFunction<Integer, Integer, Integer> minus = (x, y) -> x-y;
        Box<Integer> a2 = Box.pure(2);
        Box<Integer> a5 = Box.pure(5);

        Box<Integer> actual = a2.fmap(Curry.fi(minus)).app(a5);

        assertEquals(actual, Box.pure(-3));
    }*/

/*    @Test
    public void implement_monad_bind() {
        Box<String> securePassword = Box.pure("p@ssw0rd"); // Safely hidden in a box
        Function<String, Box<Integer>> secureHashing =
                clearPassword -> Box.pure(clearPassword.hashCode()); // Results will also be safe in a box

        Box<Integer> actual = securePassword.bind(secureHashing);

        assertEquals(actual, Box.pure("p@ssw0rd".hashCode()));
    }*/

/*    @Test
    public void reimplement_fmap_WITHOUT_USING_THE_RAW_VALUE() {
        // Hint: use bind and pure
        Box<Double> aDouble = new Box<>(5.55);

        Box<Long> actual = aDouble.fmapMonad(Math::round);

        assertEquals(actual, new Box<>((long) 6));
    }*/

/*    @Test
    public void reimplement_app_WITHOUT_USING_THE_RAW_VALUE() {
        // Hint: see above + you'll still need an ugly Function<...> cast
        Box<Function<Integer, Double>> aBoxedIncrement = Box.pure(x -> x+1.5);
        Box<Integer> a5 = Box.pure(5);

        Box<Double> actual = aBoxedIncrement.appMonad(a5);

        assertEquals(actual, Box.pure(6.5));
    }*/
}
