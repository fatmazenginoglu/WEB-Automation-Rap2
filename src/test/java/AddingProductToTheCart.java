import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.*;

public class AddingProductToTheCart extends BaseTest {

    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    PaymentPage paymentPage;

    @Test
    @Order(1)
    public void home_page() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickClosedButton();
        Assertions.assertTrue(homePage.isUrlCorrect("https://rapsodo.com/"));// 1- The user goes to the "https://rapsodo.com" address and verifies that they went to this address.
        homePage.clickCartButton(); //2-The user clicks on the “Cart” icon at the top right area
        cartPage = new CartPage(driver);
        Thread.sleep(2000);
        Assertions.assertEquals(cartPage.checkCartEmpty() , "Your cart is currently empty."); //2-a-The user verifies that shopping cart empty at that moment.
        cartPage.clickBaseballButton(); //3- The user clicks on the "Baseball" button and chooses the "Pro 3.0" option.
        Thread.sleep(2000);
        productPage = new ProductPage(driver);
        productPage.clickPitching2Button(); //3- The user clicks on the "Baseball" button and chooses the "Pro 3.0" option.
        Thread.sleep(3000);
        Assertions.assertEquals(productPage.checkPageTitle2(),"Design The Perfect Pitch"); //3-a-. The user asserts / verifies that the page's title is " Pro-Level Hitting and Pitching Data in One Device ".
        productPage.clickShopNowButton(); //4--The user clicks on the "Shop Now" button
        productDetailPage = new ProductDetailPage(driver);
        Assertions.assertTrue(productDetailPage.isUrlCorrect("rapsodo-pitching-monitor"), "Not a correct url!");//4-a-The user verifies that in the current URL, it contains " rapsodo-pro-3" text.
        productDetailPage.addToCart(); //5--The user adds Pro 3.0 product to their cart . ( choosing “For New Customers” )
        Assertions.assertTrue(productDetailPage.isUrlCorrect("cart"), "Not a correct url!");//5-a-The user verifies that they are directed to the "cart" URL.
        cartPage = new CartPage(driver);
        cartPage.clickPlusButton(); //6-The user increases quantity ( quantity = 2 ) of product on the"cart" .
        Thread.sleep(3000);
        Assertions.assertEquals(cartPage.checkCost(),"$5,500.00");
        //Assertions.assertTrue(cartPage.checkIfProductAdded("2","3,000"),"Product was not added to cart!"); //6-a-The user verifies that there are two items in their "My Chart" part and that it costs $26,500.00.
        Thread.sleep(2000);
        cartPage.clickOrganizationType(); //7-The user chooses “Organization Type” and check “I agree with the terms and conditions”. Then clicks “Checkout” button.
        cartPage.selectOrganizationType(); //7
        cartPage.clickTermsButton(); //7-a
        cartPage.clickcheckout(); //7-a
        paymentPage = new PaymentPage(driver);
        Thread.sleep(2000);
        paymentPage.setInformation("fatmanur1@gmail.com","fatmanur","zenginoglu","5750 sokak yunusemre","natura evleri","Manisa","45000","+905523443080");
        paymentPage.applyDiscount("BASEBALLBEST"); //8-- The user enters " BASEBALLBEST " text in the Coupon Code text box that is under the page and clicks on the Apply Coupon button
        Thread.sleep(2000);
        Assertions.assertEquals(paymentPage.displayErrorMessage(),"Enter a valid discount code"); //9-a-The user verifies that they receive the "Coupon " BASEBALLBEST " does not exist!" warning message
        paymentPage.clickContinueToShipping();//7-a-User fills in the blanks random and invalid data in “Information” part and come to the “Payment” part.
    }

    /*@Test
    @Order(5)
    public void view_cart() throws InterruptedException {
        cartPage.viewCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded("2", "999.98"), "Product was not added to cart!");
        Thread.sleep(5000);
    }*/

}
