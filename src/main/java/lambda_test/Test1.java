package lambda_test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    @Test()
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement formSubmit = driver.findElement(By.xpath("//a[.='Input Form Submit']"));
         formSubmit.click();
         Thread.sleep(2000);

        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Mariana");

        WebElement eMail = driver.findElement(By.cssSelector("#inputEmail4"));
        eMail.sendKeys("mariana@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
        password.sendKeys("mariana123");

        WebElement company = driver.findElement(By.cssSelector("#company"));
        company.sendKeys("CodeFish");

        WebElement website = driver.findElement(By.cssSelector("#websitename"));
        website.sendKeys("CodeFish.com");

        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        country.sendKeys("Albania");

        WebElement city = driver.findElement(By.cssSelector("#inputCity"));
        city.sendKeys("Chicago");

        WebElement address1 = driver.findElement(By.cssSelector("#inputAddress1"));
        address1.sendKeys("122 Ballantrae");


        WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("122 Linkenshare");

        WebElement state = driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("IL");

        WebElement zip = driver.findElement(By.cssSelector("#inputZip"));
        zip.sendKeys("6000");

        WebElement submit = driver.findElement(By.xpath("//button[.='Submit']"));
        submit.click();

        WebElement massage = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));
        String actualMassage = massage.getText().trim();
        String expected = "Thanks for contacting us, we will get back to you shortly.";
        Assert.assertEquals(actualMassage,expected);






    }
}
