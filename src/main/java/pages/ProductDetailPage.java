package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By addToCartButton = By.xpath("//*[@id=\"AddToCartNormal\"]");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public void addToCart() throws InterruptedException {
        scrollToElement(addToCartButton);
        Thread.sleep(5000);
        click(addToCartButton);
    }
}