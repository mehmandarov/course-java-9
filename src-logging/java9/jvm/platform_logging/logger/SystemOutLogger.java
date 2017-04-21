package java9.jvm.platform_logging.logger;

import java.lang.System.Logger;
import java.util.ResourceBundle;

import static java.text.MessageFormat.format;

// TODO:
// create a module that provides `java.lang.System.LoggerFinder` as a service

public class SystemOutLogger implements Logger {

	@Override
	public String getName() {
		return "SystemOut";
	}

	@Override
	public boolean isLoggable(Level level) {
		switch (level) {
			case OFF:
			case TRACE:
			case DEBUG:
			case INFO:
			case WARNING:
			case ERROR:
			case ALL:
			default:
				return true;
		}
	}

	@Override
	public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
		System.out.printf("SystemOut logger says on %s: \"%s\" with \"%s\"%n", level, msg, thrown);
	}

	@Override
	public void log(Level level, ResourceBundle bundle, String format, Object... params) {
		System.out.printf("SystemOut logger says on %s: \"%s\"%n", level, format(format, params));
	}
}
