package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class InventoryPage {
    public static final By btnAddBackpackToCart = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    public static final By btnRemoveBackpackFromCart = By.cssSelector("#remove-sauce-labs-backpack");
    public static final By btnAddBikeLightToCart = By.cssSelector("#add-to-cart-sauce-labs-bike-light");
    public static final By btnFilter = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select");
    public static final By btnGoToCart = By.cssSelector("#shopping_cart_container > a");
    public static final By msgContinueShopping = By.cssSelector("#continue-shopping");
    public static final By msgPriceLowToHigh = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > span");
    public static final By msgCartBikeLight = By.cssSelector("#item_0_title_link > div");
    public static final By msgCartBackpack = By.cssSelector("#item_4_title_link > div");

    public void clicarBtnAddBackpackToCart(){
        BaseTest.click(btnAddBackpackToCart);}
    public void clicarBtnRemoveBackpackFromCart(){BaseTest.click(btnRemoveBackpackFromCart);}
    public void clicarBtnAddBikeLightToCart(){BaseTest.click(btnAddBikeLightToCart);}
    public void filtrarPorMenorPreco(){
        BaseTest.click(btnFilter);
        BaseTest.sendKeys(btnFilter,"p");
        BaseTest.click(btnFilter);
    }
    public void clicarGoToCart(){
        BaseTest.click(btnGoToCart);
    }
    public String validarMsgContinueShopping(){
        return BaseTest.getText(msgContinueShopping);
    }
    public String validarMsgPriceLowToHigh(){
        return BaseTest.getText(msgPriceLowToHigh);
    }
    public String validarMsgCartBikeLight(){
        return BaseTest.getText(msgCartBikeLight);
    }
    public String validarMsgCartBackpack(){
        return BaseTest.getText(msgCartBackpack);
    }
}
