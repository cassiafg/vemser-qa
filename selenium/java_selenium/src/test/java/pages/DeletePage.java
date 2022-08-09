package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class DeletePage {

    public static final By deleteBtn = By.cssSelector("body > div > div > form > div > input");

    public void clicarDeleteBtn(){
        BaseTest.click(deleteBtn);
    }
}
