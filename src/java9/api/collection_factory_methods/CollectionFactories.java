package java9.api.collection_factory_methods;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class CollectionFactories {

	private static List<String> list;
	private static Set<String> set;
	private static Map<String, Integer> map;

	public static void main(String[] args) {
		System.out.println("CREATING COLLECTIONS");
		createCollections();
		System.out.println();

		System.out.println("COLLECTIONS CAN NOT BE MUTATED");
		collectionsAreImmutable();
		System.out.println();

		System.out.println("ORDER IS UNSTABLE ACROSS RUNS");
		System.out.println(""
				+ "\t(If you look closely, you will see that the order of the following \n"
				+ "\t three sets is always the same but differs across run. This is so \n"
				+ "\t that you do not accidentally depend on the order.)");
		orderIsUnstableAcrossRuns();
		System.out.println();
	}

	public static void createCollections() {
		// TODO:
		// initialize the static fields with collection factory methods
		// and print the collections
		list = List.of("a", "b", "c");
		set = Set.of("a", "b", "c");
		map = Map.of(
				"one", 1,
				"two", 2,
				"three", 3);
		map = Map.ofEntries(
				entry("one", 1),
				entry("two", 2),
				entry("three", 3));

		Stream.of(list, set, map).forEach(System.out::print);
	}

	public static void collectionsAreImmutable() {
		// TODO:
		// try mutating the collections (but remember to catch the exceptions)
		// and observe that immutability is not expressed in the type system
		// (i.e. mutating methods are still visible)
		addToCollection(list, "d");
		addToCollection(set, "d");
		addToCollection(map.entrySet(), entry("two", 2));
	}

	public static <T> void addToCollection(Collection<T> collection, T item) {
		try {
			collection.add(item);
			throw new IllegalStateException();
		} catch (UnsupportedOperationException ex) {
			System.out.println("Could not mutate " + collection);
		}
	}

	public static void orderIsUnstableAcrossRuns() {
		// TODO:
		// create a couple of sets and convince yourself that iteration order is stable
		// during a program run; run iut several times to see that it changes across runs
		Stream.of(
				Set.of("a", "b", "c"),
				Set.of("a", "b", "c"),
				Set.of("a", "b", "c"))
				.forEach(System.out::println);
	}

}
