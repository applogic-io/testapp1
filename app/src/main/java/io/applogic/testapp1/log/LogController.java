package io.applogic.testapp1.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/simple")
	public void generateSimpleLog() {
		logger.info("Hello, this is a simple log statement");
	}
	
	@GetMapping("/stacktrace")
	public void generateStacktrace() {
		try {
			throwException();
		} catch (Exception e) {
			logger.error("Check how fluentd is coping with stacktraces", e);
		}
	}

	private void throwException() {
		throw new RuntimeException("Long live exceptions !");
	}

}
