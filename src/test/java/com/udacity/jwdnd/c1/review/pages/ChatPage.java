package com.udacity.jwdnd.c1.review.pages;


import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement textField;

    private WebDriver driver;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setTextField(String text) {
        textField.sendKeys(text);
    }

    public void setType(int val) {
        Select drp = new Select(driver.findElement(By.id("messageType")));
        drp.selectByValue(""+val);
    }


    public void submit(){
        textField.submit();
    }

    public String firstMessage(){
        try{
            WebElement e = driver.findElement(By.tagName("h1"));
            String msg = e.getText();
            return msg;
        } catch (Exception e) {
            return null;
        }
    }

}