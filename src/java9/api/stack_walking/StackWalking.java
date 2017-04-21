package java9.api.stack_walking;

// For more details have a look at
//  - https://www.sitepoint.com/deep-dive-into-java-9s-stack-walking-api/
//  - https://github.com/arnaudroger/site-point-01_stackwalker

import java.util.Arrays;

class StackWalking {

	public static void main(String[] args) throws Exception {
		System.out.println("OLD WALK");
		delegateViaReflection(StackWalking::oldWalk);
		System.out.println();

		System.out.println("NEW WALK");
		delegateViaReflection(StackWalking::newWalkFrames);
		System.out.println();

		System.out.println("NEW BINGO");
		delegateViaReflection(StackWalking::newWalkBingo);
		System.out.println();
	}

	static void delegateViaReflection(Runnable task) throws Exception {
		StackWalking
				.class
				.getDeclaredMethod("one", Runnable.class)
				.invoke(null, task);
	}

	static void one(Runnable task) {
		two(task);
	}

	static void two(Runnable task) {
		three(task);
	}

	static void three(Runnable task) {
		runTask(task);
	}

	static void runTask(Runnable task) {
		task.run();
	}

	static void oldWalk() {
		// TODO:
		// familiarize yourself with the code and see how the old API behaves
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		Arrays.stream(stackTrace).forEach(System.out::println);
	}

	static void newWalkFrames() {
		// TODO:
		// use `StackWalker` to print frames; experiment with different `StackWalker.Option`s
	}

	static void newWalkBingo() {
		// TODO:
		// use `StackWalker` to print:
		// "<line-number>: <method-name>" followed by "Bingo!" if the method is named `one`
	}

}
