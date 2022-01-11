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
public class LoginPage {

//    @Autowired
//    WebDriver webDriver;

    @PostConstruct
    public void InitLoginPage() {
        log.info("In Login page");
//        PageFactory.initElements(webDriver,this);
    }

    @FindBy(how = How.LINK_TEXT, using ="UserName")
    public WebElement txtUserName;

    @FindBy(how = How.LINK_TEXT, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.LINK_TEXT, using = "btn-default")
    public WebElement btnLogin;

    public void Login(String userName, String pasword){
//        txtUserName.sendKeys(userName);
//        txtPassword.sendKeys(pasword);
        log.info("Username and Password " + userName + "-----" + pasword);
    }

    public HomePage ClickLogin()
    {
        log.info("Click login from login page");
        return new HomePage();
    }
}

