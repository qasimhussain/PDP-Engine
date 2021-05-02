package io.tub.pdp.pdpengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
		"io.tub.pdp.pdpengine.config",
		"io.tub.pdp.pdpengine.controller",
		"io.tub.pdp.pdpengine.model",
		"io.tub.pdp.pdpengine.repository",
		"io.tub.pdp.pdpengine.service"
})
@EnableJpaRepositories("io.tub.pdp.pdpengine.repository")
public class PdpEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdpEngineApplication.class, args);
	}

}
