package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.BaseTest;

public class DressPage {
    private static final By search = By.cssSelector("#search_query_top");
    private static final By btnSubmitSearch = By.cssSelector("#searchbox > button");
    private static final By btnPrintedChifonDress = By.cssSelector("#best-sellers_block_right > div > ul > li:nth-child(1) > a > img");
    public static final By addToCartBtn = By.cssSelector("#add_to_cart > button");
    public static final By btnProceedToCheckOut = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    private static final By msgShoppingCart = By.cssSelector("#columns > div.breadcrumb.clearfix > span.navigation_page");
    private static final By btnAddToWishlist = By.cssSelector("#wishlist_button");
    private static final By msgAddedToWishlist = By.cssSelector("#product > div.fancybox-overlay.fancybox-overlay-fixed > div > div > div > div > p");

    public void searchDress(){
        BaseTest.sendKeys(search, "dress");
    }
    public void btnSubmitSearch(){
        BaseTest.click(btnSubmitSearch);
    }
    public void btnPrintedChifonDress(){
        BaseTest.click(btnPrintedChifonDress);
    }
    public void clicarAddToCart() {
        BaseTest.click(addToCartBtn);
    }
    public void clicarBtnProceedToCheckOut(){
        BaseTest.click(btnProceedToCheckOut);
    }
    public void clicarBtnAddToWishlist(){
        BaseTest.click(btnAddToWishlist);
    }
    public String validarMsgAddedToWishlist(){
        return BaseTest.getText(msgAddedToWishlist);
    }
    public String validarMsgShoppingCart() {
        return BaseTest.getText(msgShoppingCart);
    }
}
