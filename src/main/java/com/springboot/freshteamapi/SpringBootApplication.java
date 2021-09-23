package com.springboot.freshteamapi;
import com.springboot.freshteamapi.service.FreshteamService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {
	@Value("${freshteam.token}")
	private String accessToken;
	@Value("${freshteam.accountId}")
	private String accountId;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(accessToken);
		FreshteamService freshteamService = new FreshteamService(accessToken, accountId);
		String jsonData = freshteamService.getEmployeesList();
		System.out.println(jsonData);

	}
}
