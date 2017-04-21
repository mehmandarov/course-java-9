module logger {
	provides System.LoggerFinder
		with java9.jvm.platform_logging.logger.SystemOutLoggerFinder;
}
