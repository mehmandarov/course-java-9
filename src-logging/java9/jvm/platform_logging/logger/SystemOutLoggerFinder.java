package java9.jvm.platform_logging.logger;

import java.lang.System.Logger;
import java.lang.System.LoggerFinder;

public class SystemOutLoggerFinder extends LoggerFinder {

	// (To use this class in your IDE make sure `src-logging` is marked as a source directory.
	//  Since you will end up with module declarations in the wrong place, unmark it after solving the tasks.
	//  Use platform-logging.sh to compile and launch the resulting modules.)

	// TODO:
	// extend `java.lang.System.LoggerFinder` and provide a `System.Logger`
	// that logs everything to System.out, prefixing it so it is easily identifiable

	@Override
	public Logger getLogger(String name, Module module) {
		return new SystemOutLogger();
	}

}
