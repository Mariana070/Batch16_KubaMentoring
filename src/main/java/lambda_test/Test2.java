package lambda_test;

import Utils.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.sql.rowset.BaseRowSet;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test2 {
    @Test
    public void getNameAndEmail(){
        /*
print out names and emails as a key - value pair
use map interface, try to use cssSelectors
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
WebElement tablePagination = driver.findElement(By.xpath("//a[.='Table Pagination']"));
tablePagination.click();
 WebElement maxRows = driver.findElement(By.cssSelector("#maxRows"));
        Select rows = new Select(maxRows);
        rows.selectByVisibleText("Show ALL Rows");
        List<WebElement> allNames=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement>allEmails = driver.findElements(By.xpath("//tr//td[3]"));
        TreeMap<String,String> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
            map.put(allNames.get(i).getText(),allEmails.get(i).getText());

        }
        System.out.println(map);

    }
    @Test
    public void TC_2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement tablePagination = driver.findElement(By.xpath("//a[.='Table Pagination']"));
        tablePagination.click();
        WebElement maxRows = driver.findElement(By.cssSelector("#maxRows"));
        Select rows = new Select(maxRows);
        rows.selectByVisibleText("Show ALL Rows");
        List<WebElement> allNames=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allNumPhones=driver.findElements(By.xpath("//tr//td[4]"));
        TreeMap<String,Long> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
          map.put(allNames.get(i).getText(),Long.parseLong(BrowsersUtils.getTex(allNumPhones.get(i)).replace("-","")));

        }
        System.out.println(map);



    }
}
