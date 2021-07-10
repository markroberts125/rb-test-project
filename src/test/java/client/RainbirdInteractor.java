package client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static client.FileTableField.LastModified;

public class RainbirdInteractor {

    private static final String STUDIO_RESOURCE = "/files";

    //Locators
    private static final String LOGIN_USERNAME = "identifier";
    private static final String LOGIN_PASSWORD = "password";
    private static final String LOGIN_BUTTON = "//*[@id=\"root\"]/div/section/div/div[1]/div[3]/form/div[4]/button";
    private static final String TABLE = "//*[@id=\"root\"]/div/table/tbody";
    private static final String NAME_HEADER = "//*[@id=\"root\"]/div/table/thead/tr/td[1]/div/span";
    private static final String NAME_COLUMN = ".//tr/td[1]";
    private static final String DESCRIPTION_HEADER = "//*[@id=\"root\"]/div/table/thead/tr/td[2]/div/div[1]";
    private static final String DESCRIPTION_COLUMN = ".//tr/td[2]";
    private static final String LAST_MODIFIED_HEADER = "//*[@id=\"root\"]/div/table/thead/tr/td[3]/div/div[1]";
    private static final String LAST_MODIFIED_COLUMN = ".//tr/td[3]";


    String url;
    String username;
    String password;

    WebDriver driver;
    WebDriverWait wait;


    public RainbirdInteractor(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void login() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get(url);
        driver.findElement(By.id(LOGIN_USERNAME)).sendKeys(username);
        driver.findElement(By.id(LOGIN_PASSWORD)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TABLE)));
    }

    public void goToStudioPage() {
        driver.navigate().to(url + STUDIO_RESOURCE);
    }

    public void setAscending(FileTableField fileTableField) {
        String fieldPath = getHeaderPath(fileTableField);
        driver.findElement(By.xpath(fieldPath)).click();
    }

    public void setDescending(FileTableField fileTableField) {
        String fieldPath = getHeaderPath(fileTableField);
        driver.findElement(By.xpath(fieldPath)).click();
        driver.findElement(By.xpath(fieldPath)).click();
    }

    public List<String> getFilesColumnContents(FileTableField fileTableField) {
        String columnPath = switch (fileTableField) {
            case Name -> NAME_COLUMN;
            case Description -> DESCRIPTION_COLUMN;
            case LastModified -> LAST_MODIFIED_COLUMN;
        };
        WebElement table = driver.findElement(By.xpath(TABLE));
        List<WebElement> column = table.findElements(By.xpath(columnPath));
        List<String> columnStrings = new ArrayList<>();
        column.forEach(cell -> columnStrings.add(cell.getText()));
        return columnStrings;
    }

    public void closeBrowser() {
        driver.close();
    }

    private String getHeaderPath(FileTableField fileTableField) {
        String fieldPath;
        switch (fileTableField) {
            case Name -> {
                driver.findElement(By.xpath(DESCRIPTION_HEADER)).click();
                fieldPath = NAME_HEADER;
            }
            case Description -> {
                driver.findElement(By.xpath(LAST_MODIFIED_HEADER)).click();
                fieldPath = DESCRIPTION_HEADER;
            }
            case LastModified -> {
                driver.findElement(By.xpath(NAME_HEADER)).click();
                fieldPath = LAST_MODIFIED_HEADER;
            }
            default -> throw new IllegalStateException("Unexpected value: " + fileTableField);
        }
        return fieldPath;
    }

}
