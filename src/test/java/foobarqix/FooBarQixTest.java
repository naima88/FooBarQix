package foobarqix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FooBarQixTest {

    Consumer<String> printer = (value) -> {};
    static FooBarQix fooBarQix;
    
    @BeforeAll
    static void setUp() {
    	fooBarQix = new FooBarQix();
	}

    private static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(51, "FooBar"),
                Arguments.of(53, "BarFoo"),
                Arguments.of(13, "Foo"),
                Arguments.of(5, "BarBar"),
                Arguments.of(27, "FooQix"),
                Arguments.of(33, "FooFooFoo"),
                Arguments.of(1, "1")
        );
    }
    
    private static Stream<Arguments> invalidNumbers() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(101)
        );
    }
    
    private static Stream<Arguments> invalidListNumberSize() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(Arrays.asList(new Integer[101]))
        );
    }
    
    @ParameterizedTest(name = "Return {1} when input is {0}")
    @MethodSource("numbers")
    void it_should_return_matching_string(int number, String expectedResult) {
        final String actualResult = fooBarQix.toFooBarQix(number);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "Throw IllegalArgumentException when input is {0}")
    @MethodSource("invalidNumbers")
    void it_should_throw_exception_when_invalid_number(int number) {
    	assertThrows(IllegalArgumentException.class, () -> fooBarQix.toFooBarQix(number));
    }

    @ParameterizedTest
    @MethodSource("invalidListNumberSize")
    void it_should_throw_exception_when_invalid_list_number_size(List<Integer> numbers) {
        assertThrows(IllegalArgumentException.class, () -> fooBarQix.toFooBarQix(numbers, printer));
    }

    @Test
    void printElementPerLineTest() {
        String expected = String.join("\n", "1", "2", "FooFoo");
        List<String> actual = new ArrayList<>();
        Consumer<String> printer = actual::add;
        fooBarQix.toFooBarQix(Arrays.asList(1,2,3), printer);
        assertEquals(expected, String.join("\n", actual));
    }
    
    @BeforeAll
    static void tearDown() {
    	fooBarQix = null;
	}
}
