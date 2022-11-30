package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends BasePage {

    By couponCode = By.id("checkout_reduction_code");
    By applyButton = By.xpath("(//*[@class=\"icon-svg icon-svg--size-18 btn__spinner icon-svg--spinner-button\"])[2]");
    By discountErrorMessage = By.id("error-for-reduction_code");
    By email = By.id("checkout_email");
    By firstName = By.xpath("//*[@placeholder=\"First name\"]");
    By lastName = By.xpath("//*[@placeholder=\"Last name\"]");
    By address = By.xpath("//*[@placeholder=\"Address\"]");
    By apartment = By.xpath("//*[@placeholder=\"Apartment, suite, etc. (optional)\"]");
    By city = By.xpath("//*[@placeholder=\"City\"]");
    By zipCode = By.xpath("//*[@placeholder=\"ZIP code\"]");
    By phone =By.xpath("(//*[@placeholder=\"Phone\"])[1]");
    By continueToShipping = By.xpath("(//*[@class=\"icon-svg icon-svg--size-18 btn__spinner icon-svg--spinner-button\"])[1]");
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void applyDiscount(String couponText){
        WebElement couponSpace = driver.findElement(couponCode);
        couponSpace.click();
        couponSpace.sendKeys(couponText);
        click(applyButton);
    }
    public String displayErrorMessage() {
        String displayErrorMessage = find(discountErrorMessage).getText();
        return displayErrorMessage;
    }
    public void setInformation(String emailText,String firstNameText,
                               String lastNameText,String addressText,
                               String apartmentText,String cityText,String zipCodeText, String phoneText){
        WebElement emailSpace = driver.findElement(email);
        emailSpace.click();
        emailSpace.sendKeys(emailText);
        WebElement firstNameSpace = driver.findElement(firstName);
        firstNameSpace.click();
        firstNameSpace.sendKeys(firstNameText);
        WebElement lastNameSpace = driver.findElement(lastName);
        lastNameSpace.click();
        lastNameSpace.sendKeys(lastNameText);
        WebElement addressSpace = driver.findElement(address);
        addressSpace.click();
        addressSpace.sendKeys(addressText);
        WebElement apartmentSpace = driver.findElement(apartment);
        apartmentSpace.click();
        apartmentSpace.sendKeys(apartmentText);
        WebElement citySpace = driver.findElement(city);
        citySpace.click();
        citySpace.sendKeys(cityText);
        WebElement zipCodeSpace = driver.findElement(zipCode);
        zipCodeSpace.click();
        zipCodeSpace.sendKeys(zipCodeText);
        WebElement phoneSpace = driver.findElement(phone);
        phoneSpace.click();
        phoneSpace.sendKeys(phoneText);
    }
        public void clickContinueToShipping() { click(continueToShipping);}
}
