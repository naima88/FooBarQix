package foobarqix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FooBarQixTest {

    private static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(51, "FooBar"),
                Arguments.of(53, "BarFoo"),
                Arguments.of(13, "Foo"),
                Arguments.of(27, "FooQix"),
                Arguments.of(33, "FooFooFoo"),
                Arguments.of(1, "1"),
                Arguments.of(77, "QixQix"),
                Arguments.of(7, "Qix"),
                Arguments.of(57, "FooBarQix")
        );
    }

    @ParameterizedTest
    @MethodSource("numbers")
    void it_should_return_matching_string(int number, String expectedResult) {
        final String actualResult = FooBarQix.transform(number);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
