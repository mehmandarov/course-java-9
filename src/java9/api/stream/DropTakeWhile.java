package java9.api.stream;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java9.api.stream.DropTakeWhile.LogMessage.error;
import static java9.api.stream.DropTakeWhile.LogMessage.info;
import static java9.api.stream.DropTakeWhile.LogMessage.warning;
import static java9.api.stream.DropTakeWhile.Priority.ERROR;
import static java9.api.stream.DropTakeWhile.Priority.INFO;
import static java9.api.stream.DropTakeWhile.Priority.WARNING;

public class DropTakeWhile {

	final List<LogMessage> messages;

	public DropTakeWhile(List<LogMessage> messages) {
		this.messages = requireNonNull(messages);
	}

	public static void main(String[] args) {
		DropTakeWhile messages = new DropTakeWhile(List.of(
				info("Starting"),
				info("Started"),
				warning("High Temperature Detected"),
				error("Overheated"),
				info("Shutdown initiated")));

		System.out.println("FROM FIRST WARNING:");
		messages.fromFirstWarning().forEach(System.out::println);
		System.out.println();

		System.out.println("UNTIL BEFORE FIRST ERROR:");
		messages.untilBeforeFirstError().forEach(System.out::println);
		System.out.println();

		System.out.println("UNTIL FIRST ERROR:");
		messages.untilFirstError().forEach(System.out::println);
		System.out.println();

		System.out.println("FROM FIRST WARNING TO FOLLOWING ERROR:");
		messages.fromFirstWarningToFollowingError().forEach(System.out::println);
		System.out.println();
	}

	public Stream<LogMessage> fromFirstWarning() {
		// TODO:
		// return the stream of messages that begins with the first warning
		return messages.stream();
	}

	public Stream<LogMessage> untilBeforeFirstError() {
		// TODO:
		// return the stream of messages that ends _before_ the first error
		return messages.stream();
	}

	public Stream<LogMessage> untilFirstError() {
		// TODO:
		// return the stream of messages that ends _with_ the first error
		return messages.stream();
	}

	public Stream<LogMessage> fromFirstWarningToFollowingError() {
		// TODO:
		// return the stream of messages that starts with the first warning
		// and ends with the first following error
		return messages.stream();
	}

	static class LogMessage {

		final String message;
		final Priority priority;

		private LogMessage(String message, Priority priority) {
			this.message = requireNonNull(message);
			this.priority = priority;
		}

		public static LogMessage info(String message) {
			return new LogMessage(message, INFO);
		}

		public static LogMessage warning(String message) {
			return new LogMessage(message, WARNING);
		}

		public static LogMessage error(String message) {
			return new LogMessage(message, ERROR);
		}

		@Override
		public String toString() {
			return "{" + message + ", " + priority + "}";
		}
	}

	enum Priority {
		INFO,
		WARNING,
		ERROR;

		boolean lessThan(Priority other) {
			return other.compareTo(this) > 0;
		}

		boolean atMost(Priority other) {
			return other.compareTo(this) >= 0;
		}

		boolean atLeast(Priority other) {
			return other.compareTo(this) <= 0;
		}

		boolean moreThan(Priority other) {
			return other.compareTo(this) < 0;
		}

	}

}
