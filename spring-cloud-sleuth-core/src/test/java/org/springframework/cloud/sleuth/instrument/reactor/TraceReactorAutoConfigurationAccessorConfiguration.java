package org.springframework.cloud.sleuth.instrument.reactor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import reactor.core.publisher.Hooks;

/**
 * @author Marcin Grzejszczak
 */
public class TraceReactorAutoConfigurationAccessorConfiguration {

	private static final Log log = LogFactory
			.getLog(TraceReactorAutoConfigurationAccessorConfiguration.class);

	public static void close() {
		if (log.isTraceEnabled()) {
			log.trace("Cleaning up hooks");
		}
		new TraceReactorAutoConfiguration.TraceReactorConfiguration().cleanupHooks();
		Hooks.resetOnEachOperator();
		Hooks.resetOnLastOperator();
	}

}