package foobarqix;

import java.util.List;
import java.util.function.Consumer;

public class FooBarQix {

    private static final String FOO = "Foo";
    private static final String BAR = "Bar";
    private static final String QIX = "Qix";
    private static final String THREE = "3";
    private static final String FIVE = "5";
    private static final String SEVEN = "7";

    public void toFooBarQix(List<Integer> numbers, Consumer<String> printer) {
        if(numbers.isEmpty()  || numbers.size() > 100) {
            throw new IllegalArgumentException("invalid input");
        }
      
        numbers.stream()
                .map(number->toFooBarQix(number))
                .forEach(printer);
    }

    public String toFooBarQix(int number) {
        if(number < 1 || number>100) {
            throw new IllegalArgumentException("invalid input");
        }
        
        StringBuilder result = new StringBuilder();
        
        if(number%3==0) {
            result.append(FOO);
        }
        if(number%5==0) {
            result.append(BAR);
        }
        
        result.append(toFooBarQix(String.valueOf(number)));

        if(result.length() == 0) {
            result.append(number);
        }
        
        return result.toString();
    }

    private String toFooBarQix(String number) {
        StringBuilder result = new StringBuilder();
        for(int j=0; j<number.length(); j++) {
            final char character = number.charAt(j);
            if(THREE.equals(String.valueOf(character))){
                result.append(FOO);
            }
            if(FIVE.equals(String.valueOf(character))){
                result.append(BAR);
            }
            if(SEVEN.equals(String.valueOf(character))){
                result.append(QIX);
            }
        }
        
        return result.toString();
    }


}
