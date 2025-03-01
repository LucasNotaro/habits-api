package com.habits.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Habits API",
				version = "1.0",
				description = "API para gerenciamento de hábitos dos usuários"
		)
)
@SpringBootApplication
public class HabitsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitsApiApplication.class, args);
	}

}
