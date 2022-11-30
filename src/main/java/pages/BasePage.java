package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }
    public void mouseOver(By locator) {
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    public void click(By locator) {
        find(locator).click();
    }
    public void type(By locator, String text) {
        find(locator).sendKeys(text);
    }
    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    protected void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement helper = find(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", helper);
    }

    public boolean isUrlCorrect(String text) {
        boolean flag = false;
        String websitePageTitle = driver.getCurrentUrl();
        if (websitePageTitle.contains(text)) { //The reason I use the contains method is in case there can be spaces at the beginning and end of the title on the site.
            flag = true;
        }
        return flag;
    }
    public void moveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        actions.perform();
    }
    public void wait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));
        driver.findElement(By.id("Shop Now")).click();
    }
    public void loading(By locator) {
        By loadingImage = By.id("loading image ID");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
    }
    public boolean isEmpty() {
        return false;
    }
}
