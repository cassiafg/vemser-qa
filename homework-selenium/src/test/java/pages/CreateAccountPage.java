package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import util.BaseTest;

public class CreateAccountPage {

    Faker faker = new Faker();
    String emailAddress = faker.internet().emailAddress();
    String fakeName = faker.name().firstName();
    String fakeLastName = faker.name().lastName();
    String fakeCompany = faker.company().name();
    String fakeAddress = faker.address().streetAddress();
    String fakeCity = faker.address().city();
    String fakeMobile = faker.phoneNumber().cellPhone();


    public static final By email = By.cssSelector("#email_create");
    public static final By btnCreate = By.cssSelector("#SubmitCreate");

    public static final By genderTitle = By.cssSelector("#id_gender2");
    public static final By firstName = By.cssSelector("#customer_firstname");
    public static final By lastName = By.cssSelector("#customer_lastname");
    public static final By password = By.cssSelector("#passwd");
    public static final By selectDays = By.cssSelector("#days");
    public static final By selectMonth = By.cssSelector("#months");
    public static final By selectYear = By.cssSelector("#years");
    public static final By company = By.cssSelector("#company");
    public static final By address = By.cssSelector("#address1");
    public static final By city = By.cssSelector("#city");
    public static final By state = By.cssSelector("#id_state");
    public static final By postalCode = By.cssSelector("#postcode");
    public static final By mobilePhone = By.cssSelector("#phone_mobile");
    public static final By btnRegister = By.cssSelector("#submitAccount");
    public static final By msgMyAccount = By.cssSelector("#columns > div.breadcrumb.clearfix > span.navigation_page");
    public void preencherEmail() {
        BaseTest.sendKeys(email, emailAddress);
    }
    public void clicarBtnCreate() {
        BaseTest.click(btnCreate);
    }
    public void clicarGenderTitle() {
        BaseTest.click(genderTitle);
    }
    public void preencherFirstName() {
        BaseTest.sendKeys(firstName, fakeName);
    }
    public void preencherLastName() {
        BaseTest.sendKeys(lastName, fakeLastName);
    }
    public void preencherPassword() {
        BaseTest.sendKeys(password, "12345");
    }
    public void clicarSelectDays() {
        BaseTest.click(selectDays);
        BaseTest.sendKeys(selectDays,"10");
    }
    public void clicarSelectMonth() {
        BaseTest.click(selectMonth);
        BaseTest.sendKeys(selectMonth,"d");
    }
    public void clicarSelectYear() {
        BaseTest.click(selectYear);
        BaseTest.sendKeys(selectYear,"19");
    }
    public void preencherCompany() {
        BaseTest.sendKeys(company, fakeCompany);
    }
    public void preencherAddress() {
        BaseTest.sendKeys(address, fakeAddress);
    }
    public void preencherCity() {
        BaseTest.sendKeys(city, fakeCity);
    }
    public void clicarSelectState() {
        BaseTest.click(state);
        BaseTest.sendKeys(state,"f");
    }
    public void preencherPostalCode() {
        BaseTest.sendKeys(postalCode, "96523");
    }
    public void preencherMobile() {
        BaseTest.sendKeys(mobilePhone, fakeMobile);
    }
    public void clicarRegister() {
        BaseTest.click(btnRegister);
    }
    public String validarMsg() {
        return BaseTest.getText(msgMyAccount);
    }
}
