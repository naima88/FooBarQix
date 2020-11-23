package foobarqix;

import java.util.HashMap;
import java.util.Map;
import static java.lang.Character.getNumericValue;
import static java.util.stream.Collectors.joining;

public class FooBarQix {
    private static Map<Integer, String> associations = new HashMap<Integer, String>() {{
        put(3, "Foo"); put(5, "Bar"); put(7, "Qix");
    }};

    public static String transform(int number) {
        String numberAsString = String.valueOf(number);
        String result = map(number) + map(numberAsString);
        return result.isEmpty() ? numberAsString : result;
    }

    private static String map(int number) {
        return associations.keySet().stream().filter(key -> key!=7 && number % key == 0)
                .map(associations::get)
                .collect(joining());
    }

    private static String map(String numberAsString) {
        return numberAsString.chars()
                .mapToObj(integerAsChar -> associations.getOrDefault(getNumericValue(integerAsChar), ""))
                .collect(joining());
    }
}
