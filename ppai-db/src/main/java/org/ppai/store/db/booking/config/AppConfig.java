package org.ppai.store.db.booking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="org.ppai.store.db.booking.**")
@Import(value={
		DataAccessConfig.class,
		WebMvcConfig.class,
		WebFlowConfig.class
	})
public class AppConfig {

}
