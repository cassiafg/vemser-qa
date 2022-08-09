package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class DashboardPage {
    public static final By btnCreateNew = By.cssSelector("body > div > div > p:nth-child(4) > a");
    public static final By searchNameOrEmail = By.cssSelector("#searching");
    public static final By btnSearch = By.cssSelector("body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0");
    public static final By btnEdit = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary");
    public static final By btnDelete = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger");
    public static final By msgDetails = By.cssSelector("body > div > div > h2");



    public void clicarBtnCreateNew() {
        BaseTest.click(btnCreateNew);
    }
    public void preencherSearchName() {
        BaseTest.sendKeys(searchNameOrEmail, "teste");
    }
    public void clicarBtnSearch() {
        BaseTest.click(btnSearch);
    }
    public void clicarBtnEdit() {
        BaseTest.click(btnEdit);
    }
    public void clicarBtnDelete(){
        BaseTest.click(btnDelete);
    }
    public String validarMsg() {
        return BaseTest.getText(msgDetails);
    }
}
