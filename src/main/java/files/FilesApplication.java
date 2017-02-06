package files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"files"})
@EnableMongoRepositories
public class FilesApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {

		SpringApplication.run(FilesApplication.class, args);
	}

}