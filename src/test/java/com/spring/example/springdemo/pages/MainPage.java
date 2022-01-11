package com.spring.example.springdemo.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MainPage {

    public MainPage() {
        log.info("In Main page");
    }

//    @Autowired
//    private WebDriver webDriver;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Value("${app.url}")
    private String url;

//    public MainPage(LoginPage loginPage, HomePage homePage) {
//        this.loginPage = loginPage;
//        this.homePage = homePage;
//    }

    public void PerformLogin() {
        log.info("Login " + url);
        //webDriver.navigate().to(url);
        log.info("homePage.ClickLogin()");
        log.info("loginPage.Login(\"admin\",\"password\")");
        log.info("loginPage.ClickLogin();");

    }
}
