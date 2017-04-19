package java9.api.stream;

import java.util.Random;
import java.util.stream.Stream;

public class Iterate {

	public static void main(String[] args) {
		forLoopUpTo(5).forEach(System.out::println);
		stringsUpToLength(5).forEach(System.out::println);
	}

	public static Stream<Integer> forLoopUpTo(int max) {
		// TODO:
		// use Stream::iterate to implement `for (int i = 0; i <= max; i++)
		return Stream.iterate(0, i -> i <= max, i -> i + 1);
	}

	public static Stream<String> stringsUpToLength(int maxLength) {
		// TODO:
		// use Stream::iterate to create a stream of random strings,
		// starting with the empty string and increasing in length by one
		// until `macLength` is reached
		Random r = new Random();
		return Stream.iterate("", s -> s.length() <= maxLength, s -> s + r.nextInt(10));
	}

}
