package client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RainbirdInteractor {

    String url;
    String username;
    String password;

    WebDriver driver;

    //Locators
    private static final String LOGIN_USERNAME = "identifier";
    private static final String LOGIN_PASSWORD = "password";
    private static final String LOGIN_BUTTON = "//*[@id=\"root\"]/div/section/div/div[1]/div[3]/form/div[4]/button";


    public RainbirdInteractor(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void login() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.id(LOGIN_USERNAME)).sendKeys(username);
        driver.findElement(By.id(LOGIN_PASSWORD)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    public void closeBrowser() {
        driver.close();
    }

}
