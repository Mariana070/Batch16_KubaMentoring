package mentoring_3;

import Utils.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Sliders {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement dropSliders = driver.findElement(By.linkText("Drag & Drop Sliders"));
        dropSliders.click();

        List<WebElement> consoles= driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement>output = driver.findElements(By.cssSelector("output"));

        for (int i = 0; i <consoles.size(); i++) {
            while(!output.get(i).getText().equals("50")){
                if(output.get(i).getText().equals("50")){
                    break;
                }else{
                    consoles.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }

        }




    }
}
