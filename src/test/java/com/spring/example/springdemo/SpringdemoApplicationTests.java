package com.spring.example.springdemo;

import com.jcraft.jsch.JSch;
import com.spring.example.springdemo.builders.PersonBuilder;
import com.spring.example.springdemo.libraries.WebDriver;
import com.spring.example.springdemo.pages.MainPage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class SpringdemoApplicationTests {

	@Autowired
	private MainPage mainPage;

	@Autowired
	private WebDriver webDriver;

	@Autowired
	private PersonBuilder personBuilder;

	@Value("This will be assigned to the variable myString")
	private String myString;

	@Value("${app.url}")
	private String thisUrl;

	@Value("${pr.name}")
	private String prname;

	@Value("chrome,firefox,edge")
	private List<String> listOfBrowsers;

	@Test
	@SneakyThrows
	void contextLoads()  {
		log.info("[INFO] Test run started for URL " + thisUrl);
		log.info("[INFO] pr name " + prname);

		Map<String,String> personMap = new HashMap<>();
		personMap.put("name","test");

		personBuilder.Build(personMap);

		webDriver.getFFdrive().get(thisUrl);

		String title = webDriver.getFFdrive().getTitle();

		Thread.sleep(5000);
		assertThat(title).contains("Google");

		log.info(thisUrl);
		listOfBrowsers.forEach(log::info);
		mainPage.PerformLogin();
	}
	@Test @SneakyThrows
	void sftpTest()
	{
		JSch jSch = new JSch();
		var session = jSch.getSession("foo","localhost",2222);
		session.setPassword("pass");
	}


}