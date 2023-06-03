package mentoring_3;

import Utils.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class tumblr {
    @Test
    public void tumblrPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.tumblr.com/");

        /*
        Navigate to webapp
click login button
click continue with email button
provide email, and password (wrong credentials)
and validate the error message
driver quit
         */

        WebElement logInButton= driver.findElement(By.linkText("Log in"));
        logInButton.click();
        WebElement continueWithEmail= driver.findElement(By.xpath("//button[contains(@aria-label,'with email')]"));
        continueWithEmail.click();
        WebElement emailButton= driver.findElement(By.xpath("//input[@name='email']"));
        emailButton.sendKeys("mariana@gmail.com");
        WebElement nextButton = driver.findElement(By.xpath("//form/div[1]/div[1]/button/span"));
        nextButton.click();
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("mariana123");

        WebElement logIn= driver.findElement(By.xpath("//span[.='Log in']"));
       logIn.click();
        WebElement errorMassage=driver.findElement(By.xpath("//div[@class='a0A37 hAkP2']"));
        Thread.sleep(2000);
        Assert.assertEquals(BrowsersUtils.getTex(errorMassage),"Your email or password were incorrect.");


    }
}
