package mentoring_3;

import Utils.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPractice {
    @Test
    public void alertPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement alertsButton = driver.findElement(By.xpath("//li[.='Javascript Alerts']"));
        alertsButton.click();
        WebElement firstButton = driver.findElement(By.xpath("//p[contains(text(),'JS Alert')]//button"));
        firstButton.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText().trim();
        String expectedMessage = "Alert box!";
        Assert.assertEquals(actualMessage,expectedMessage);
        alert.accept();

        WebElement secondButton = driver.findElement(By.xpath("//p[contains(text(),'Confirm box:')]//button"));
        secondButton.click();
        String actualMessage1 = alert.getText().trim();
        String expectedMessage1 = "Press a button!";
        Assert.assertEquals(actualMessage1,expectedMessage1);
        alert.dismiss();
        WebElement thirdButton = driver.findElement(By.xpath("//p[contains(text(),'Prompt box:')]//button"));
        thirdButton.click();
        alert.sendKeys("Mariana");
        alert.accept();
        WebElement outputThird = driver.findElement(By.xpath("#prompt-demo"));
        Assert.assertEquals(BrowsersUtils.getTex(thirdButton),"You have entered 'Mariana' !");
    }
}
