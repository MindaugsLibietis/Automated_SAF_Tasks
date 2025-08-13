package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BothCasesUnderOneClass extends Main {

    @Test
    public void positiveLoginTest() {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
/*        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html", "Login was not successful");
    }

    @Test
    public void negativeLoginTest() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("error_user");
        driver.findElement(By.id("password")).sendKeys("WrongPassword");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/", "Login with wrong password was successful");
    }
}