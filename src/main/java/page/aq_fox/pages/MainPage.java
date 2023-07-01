package page.aq_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15),this);
    }
    @FindBy(xpath = "//a[.='Desktops']")
    WebElement desktopButton;
    @FindBy(xpath = "//a[.='Show AllDesktops']")
    WebElement seeAllButton;

}
