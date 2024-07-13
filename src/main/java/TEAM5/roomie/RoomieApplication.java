package TEAM5.roomie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "TEAM5.roomie.Repository")
@EntityScan(basePackages = "TEAM5.roomie.Model")
public class RoomieApplication {

	public static void main(String[] args) {

		SpringApplication.run(RoomieApplication.class, args);
	}

}
