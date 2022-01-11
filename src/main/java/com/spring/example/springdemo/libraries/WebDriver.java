package com.spring.example.springdemo.libraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriver {

    @Bean
    public FirefoxDriver getFFdrive(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
