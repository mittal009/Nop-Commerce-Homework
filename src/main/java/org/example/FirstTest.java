package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

import static java.time.Duration.*;


public class FirstTest
{    protected static WebDriver driver;

    public static void waitForClickable(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }
//    public static void

    public static void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    public static void typeText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }



    public static String timeStamp()
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }

    public static void main(String[] args)
    {
      //open the Chrome browser
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");            //navigate to the url
//        driver.findElement(By.linkText("Register")).click();//open registration page
        clickOnElement(By.linkText("Register"));
//        driver.findElement(By.id("FirstName")).sendKeys("Alia");       //type the first name
        typeText(By.id("FirstName"),"Alia");
//        driver.findElement(By.id("LastName")).sendKeys("Ali");//to type the last name
        typeText(By.id("LastName"),"Ali");

        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByVisibleText("8");

        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByIndex(5);

        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByVisibleText("2019");

//        driver.findElement(By.id("Email")).sendKeys("Ali234alia"+timeStamp()+"@yahoo.com");         //to type email address
       typeText(By.id("Email"),("Ali234alia"+timeStamp()+"@yahoo.com"));
//        driver.findElement(By.id("Company")).sendKeys("AA Ltd");                         //to add company name
        typeText(By.id("Company"),("AA Ltd"));
//        driver.findElement(By.id("Password")).sendKeys("Aali2012@A");          // to type password
        typeText(By.id("Password"),("Aali2012@A"));
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("Aali2012@A");         //to type password again
        typeText(By.id("ConfirmPassword"),("Aali2012@A"));
//       driver.findElement(By.linkText("register-button")).click();
        waitForClickable(By.id("register-button"),(10));
       clickOnElement(By.id("register-button"));

//       String registerSuccessText = driver.findElement(By.className("result")).getText();
        System.out.println("registerSuccessText");
        System.out.println(getTextFromElement(By.className("result")));

       driver.quit();                                 //to close  the register page

}
 }