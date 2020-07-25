package com.udacity.jwdnd.c1.review.tests;


import com.udacity.jwdnd.c1.review.pages.ChatPage;
import com.udacity.jwdnd.c1.review.pages.LoginPage;
import com.udacity.jwdnd.c1.review.pages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class chatMessageTest {
    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private SignupPage signupPage;
    private LoginPage loginPage;
    private ChatPage chatPage;
    private static String fname;
    private static String lname;
    private static String username;
    private static String password;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        fname = "yasmine";
        lname = "moh";
        username = "ymoh";
        password = "123";
    }

    @AfterAll
    public static void afterAll() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/signup");
        signupPage = new SignupPage(driver);
        signupPage.setFirstNameField(fname);
        signupPage.setLastNameField(lname);
        signupPage.setUsername(username);
        signupPage.setPasswordField(password);
    }

    @Test
    public void testSignupCases() throws InterruptedException {
        //signup
        signupPage.submit();
        assertTrue(signupPage.getResult().contains("You successfully signed up!"));
        Thread.sleep(1000);
        signupPage.setFirstNameField(fname);
        signupPage.setLastNameField(lname);
        signupPage.setUsername(username);
        signupPage.setPasswordField(password);
        signupPage.submit();
        assertTrue(signupPage.getResult().contains("username is not available"));

        //login
        driver.get("http://localhost:" + port + "/login");
        loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPasswordField(password);
        loginPage.submit();
        Thread.sleep(100);
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("/chat"));

        //chat
        chatPage = new ChatPage(driver);
//        chatPage.setTextField("Hi");
//        chatPage.setType(0); //wrong
//        chatPage.submit();
//        boolean eq = chatPage.firstMessage().equals(username+": "+"Hi");
//        assertTrue(eq);
//
        chatPage.setTextField("Hi");
        chatPage.setType(1);
        chatPage.submit();
        boolean eq = chatPage.firstMessage().equals(username+": "+"HI");
        assertTrue(eq);
    }

}