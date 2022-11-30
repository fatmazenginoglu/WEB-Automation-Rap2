package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By closedButton = By.xpath("//*[@class=\"close R-BlackFridayClose\"]");
    By cartButton = By.xpath("//*[@class=\"cart-link\"]");
    public static final By mlmButton = By.xpath("//span[text()=\"MLM\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickClosedButton() { click(closedButton);}
    public void clickCartButton() { click(cartButton);}

}
