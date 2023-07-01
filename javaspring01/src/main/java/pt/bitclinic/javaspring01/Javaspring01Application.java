package pt.bitclinic.javaspring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Javaspring01Application {

	public static void main(String[] args) {
		SpringApplication.run(Javaspring01Application.class, args);
	}

}
