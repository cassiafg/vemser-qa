package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class HomePage {

    public static final By btnSignIn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");

    public void clicarBtnSignIn() {
        BaseTest.click(btnSignIn);
    }
}
