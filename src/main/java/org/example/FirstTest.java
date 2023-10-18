package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class FirstTest
{    protected static WebDriver driver;

    public static void main(String[] args)
    {
      //open the Chrome browser
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");            //navigate to the url
        driver.findElement(By.linkText("Register")).click();    //open registration page
        driver.findElement(By.id("FirstName")).sendKeys("Alia");       //type the first name
        driver.findElement(By.id("LastName")).sendKeys("Ali");          //to type the last name
        driver.findElement(By.id("Email")).sendKeys("Ali234alia@yahoo.com");         //to type email address
//        driver.findElement(By.id("CompanyName")).sendKeys("AA Ltd");                         //to add company name
        driver.findElement(By.id("Password")).sendKeys("Aali2012@A");          // to type password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Aali2012@A");         //to type password again
        driver.findElement(By.linkText("REGISTER-button")).click();                                // to click on the register button

        driver.close();                                 //to close  the register page

    }
}
