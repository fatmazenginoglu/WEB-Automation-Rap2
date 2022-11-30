package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    By pitching2Button = By.xpath("(//*[@class=\"site-nav__dropdown_link site-nav__dropdown-link--top-level\"])[2]");
    By pageTitle2 = By.xpath("//*[contains(text(),\"Design the Perfect Pitch\")]");
    By shopNowButton = By.xpath("(//*[contains(text(),\" shop now\")])[1]");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void clickPitching2Button() { click(pitching2Button);}
    public void clickShopNowButton() throws InterruptedException {
        scrollToElement(shopNowButton);
        Thread.sleep(5000);
        click(shopNowButton);}
    public String checkPageTitle2() {
        String checkPageTitle2 = find(pageTitle2).getText();
        return checkPageTitle2;
    }
}

