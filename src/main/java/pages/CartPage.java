package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By costText = By.xpath("//*[contains(text(),\"$5,500.00\")]");
    By amountText = By.xpath("//*[@value=\"2\"]");
    By cartEmptyText = By.xpath("(//*[contains(text(),\"Your cart is currently empty.\")])[2]");
    By BaseballButton = By.xpath("(//*[@class='site-nav__link site-nav__link--underline site-nav__link--has-dropdown'])[2]");
    By plusButton = By.xpath("(//*[@class=\"js-qty__adjust js-qty__adjust--plus\"])[2]");
    By cartTermsButton = By.xpath("//*[@id=\"CartTerms\"]");
    By organizationType = By.xpath("//*[@id=\"organization-type\"]");
    By randomOrganizationType = By.xpath("//*[@value=\"College Baseball\"]");
    By checkout = By.xpath("//*[@class=\"btn cart__checkout\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

   /*
    public String checkAmount() {
        String checkAmount = find(amountText).getText();
        return checkAmount;
    }*/
    public String checkCost() {
        String checkCost = find(costText).getText();
        return checkCost;
    }

    public String checkCartEmpty() {
        String checkCartEmpty = find(cartEmptyText).getText();
        return checkCartEmpty;
    }
    public void clickTermsButton() { click(cartTermsButton);}
    public void clickOrganizationType() { click(organizationType);}
    public void selectOrganizationType() {
        click(randomOrganizationType);
    }
    public void clickcheckout() { click(checkout);}
    public void clickBaseballButton() { click(BaseballButton);}
    public void clickPlusButton() { click(plusButton);}
}
