package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class TshirtPage {
    public static final By tshirtBtn = By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a");
    public static final By btnSelecionarTshirt = By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a");
    public static final By addToWishlistBtn = By.cssSelector("#wishlist_button");
    public static final By addToCartBtn = By.cssSelector("#add_to_cart > button");
    public static final By msgAddedToWishlist = By.cssSelector("#product > div.fancybox-overlay.fancybox-overlay-fixed > div > div > div > div > p");
    public static final By proceedToCheckoutBtn = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    public static final By msgShoppingCart = By.cssSelector("#columns > div.breadcrumb.clearfix > span.navigation_page");

    public void clicarTshirt() {
        BaseTest.click(tshirtBtn);
    }
    public void clicarBtnSelecionarTshirt(){
        BaseTest.click(btnSelecionarTshirt);
    }
    public void clicarAddToWishlist() {
        BaseTest.click(addToWishlistBtn);
    }
    public void clicarAddToCart() {
        BaseTest.click(addToCartBtn);
    }
    public String validarMsgWishlist() {
        return BaseTest.getText(msgAddedToWishlist);
    }
    public void clicarProceedToCheckout() {
        BaseTest.click(proceedToCheckoutBtn);
    }
    public String validarMsgCart() {
        return BaseTest.getText(msgShoppingCart);
    }
}
