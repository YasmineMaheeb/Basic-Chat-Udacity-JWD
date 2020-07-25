package com.udacity.jwdnd.c1.review.tests;


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
class LoginTest {
    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private SignupPage signupPage;
    private LoginPage loginPage;
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
        driver.get("http://localhost:" + port + "/login");
        signupPage = new SignupPage(driver);
        signupPage.setFirstNameField(fname);
        signupPage.setLastNameField(lname);
        signupPage.setUsername(username);
        signupPage.setPasswordField(password);
    }

    @Test
    public void testLogin() throws InterruptedException {
        signupPage.submit();
        assertTrue(signupPage.getResult().contains("You successfully signed up!"));
        Thread.sleep(1000);
        signupPage.setFirstNameField(fname);
        signupPage.setLastNameField(lname);
        signupPage.setUsername(username);
        signupPage.setPasswordField(password);
        signupPage.submit();
        assertTrue(signupPage.getResult().contains("username is not available"));
    }

    public void signup (){
        driver.get("http://localhost:" + port + "/signup");
        signupPage = new SignupPage(driver);
        signupPage.setFirstNameField(fname);
        signupPage.setLastNameField(lname);
        signupPage.setUsername(username);
        signupPage.setPasswordField(password);
        signupPage.submit();
        driver.get("http://localhost:" + port + "/login");
    }

}