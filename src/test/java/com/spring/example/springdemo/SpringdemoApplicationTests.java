package com.spring.example.springdemo;

import com.spring.example.springdemo.libraries.WebDriver;
import com.spring.example.springdemo.pages.MainPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class SpringdemoApplicationTests {

	@Autowired
	private MainPage mainPage;

	@Autowired
	private WebDriver webDriver;

	@Value("This will be assigned to the variable myString")
	private String myString;

	@Value("${app.url}")
	private String thisUrl;

	@Value("chrome,firefox,edge")
	private List<String> listOfBrowsers;

	@Test
	void contextLoads(){
		log.info("Test run");
		webDriver.getFFdrive().get(thisUrl);

		String title = webDriver.getFFdrive().getTitle();

		assertThat(title).contains("Google");

		log.info(thisUrl);
		listOfBrowsers.forEach(log::info);
		mainPage.PerformLogin();
	}

}
