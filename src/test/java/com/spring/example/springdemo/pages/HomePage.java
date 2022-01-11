package com.spring.example.springdemo.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class HomePage {
//    @Autowired
//    WebDriver webDriver;

    @PostConstruct
    public void InitHomePage() {
        log.info("In homepage");
//        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.LINK_TEXT, using ="Login")
    public WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement linkEmployeeList;

    public LoginPage ClickLogin(){
//        lnkLogin.click();
        System.out.println("Click the home page login");
        return new LoginPage();
    }

    public void ClickEmployeeList()
    {
//        linkEmployeeList.click();
        System.out.println("Click Employee list");
    }
}

