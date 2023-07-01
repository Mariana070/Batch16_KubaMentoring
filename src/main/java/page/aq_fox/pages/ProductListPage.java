package page.aq_fox.pages;

import Utils.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
    public ProductListPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#input-sort")
    WebElement sortDropDown;
    @FindBy(xpath = "//div//a[contains(text(),'HP LP3065')]")
    WebElement HPLaptop;
    @FindBy(xpath = "//p[contains(.,'Stop')]//..//following-sibling::div")
    WebElement addedLaptop;
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    public void chooseLowHigh(WebDriver driver){
        BrowsersUtils.selectBy(sortDropDown,"Price (Low > High)","text");

    }
}
