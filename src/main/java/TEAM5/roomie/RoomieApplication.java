package TEAM5.roomie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RoomieApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomieApplication.class, args);
	}

}
