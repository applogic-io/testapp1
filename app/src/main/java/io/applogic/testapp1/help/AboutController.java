package io.applogic.testapp1.help;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/help/about")
public class AboutController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${app.title}")
	private String appTitle;
	
	@Value("${app.environment}")
	private String appEnvironment;
	
	@Value("${spring.application.name}")
	private String springApplicationName;	

	@GetMapping
	public Map<String, String> showInfo() {
		Map<String, String> infoMap = new HashMap<>();
		infoMap.put("app.title", appTitle);
		infoMap.put("app.environment", appEnvironment);
		infoMap.put("spring.application.name", springApplicationName);
		infoMap.put("version", getVersion());
		return infoMap;
	}

	private String getVersion() {
		return getClass().getPackage().getImplementationVersion();
	}
	
}
