package foobarqix;
import java.util.stream.IntStream;

public class Program {

	public static void main(String[] args) {
		IntStream.range(1,100).mapToObj(FooBarQix::transform).forEach(System.out::println);
	}

}
