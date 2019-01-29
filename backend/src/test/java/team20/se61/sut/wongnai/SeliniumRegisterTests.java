package team20.se61.sut.wongnai;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import team20.se61.sut.wongnai.Controller.RegisterController;

public class  SeliniumRegisterTests{
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

@Before
public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

@Test
public void testCanInsert() throws Exception {
        driver.get("http://localhost:4200/welcome");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='I'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/following::span[1]")).click();
        driver.findElement(By.id("mat-input-2")).click();
        driver.findElement(By.id("mat-input-2")).clear();
        driver.findElement(By.id("mat-input-2")).sendKeys("suriya130534@gmail.com");
        driver.findElement(By.id("mat-input-3")).click();
        driver.findElement(By.id("mat-input-3")).clear();
        driver.findElement(By.id("mat-input-3")).sendKeys("11111111");
        driver.findElement(By.xpath("//mat-select[@id='mat-select-0']/div/div/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='หน้าแรก'])[1]/following::span[1]")).click();
        driver.findElement(By.id("mat-input-4")).click();
        driver.findElement(By.id("mat-input-4")).clear();
        driver.findElement(By.id("mat-input-4")).sendKeys("suriya siangsai");
        driver.findElement(By.xpath("//mat-select[@id='mat-select-1']/div/div/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='หน้าแรก'])[1]/following::span[1]")).click();
        driver.findElement(By.id("mat-input-5")).click();
        driver.findElement(By.id("mat-input-5")).clear();
        driver.findElement(By.id("mat-input-5")).sendKeys("01234567835");
        driver.findElement(By.id("mat-input-6")).click();
        driver.findElement(By.id("mat-input-6")).clear();
        driver.findElement(By.id("mat-input-6")).sendKeys("96 yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/preceding::span[1]")).click();
        assertFalse(isAlertPresent());
        }


    @Test
    public void testConnotInsert() throws Exception {

            driver.get("http://localhost:4200/welcome");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='I'])[1]/following::span[1]")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/following::span[1]")).click();
            driver.findElement(By.id("mat-input-2")).click();
            driver.findElement(By.id("mat-input-2")).clear();
            driver.findElement(By.id("mat-input-2")).sendKeys("suriya3@gmail.com");
            driver.findElement(By.id("mat-input-3")).click();
            driver.findElement(By.id("mat-input-3")).clear();
            driver.findElement(By.id("mat-input-3")).sendKeys("1111");
            driver.findElement(By.xpath("//mat-select[@id='mat-select-0']/div/div/span")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='หน้าแรก'])[1]/following::span[1]")).click();
            driver.findElement(By.id("mat-input-4")).click();
            driver.findElement(By.id("mat-input-4")).clear();
            driver.findElement(By.id("mat-input-4")).sendKeys("suriya siangsai");
            driver.findElement(By.xpath("//mat-select[@id='mat-select-1']/div/div/span")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='หน้าแรก'])[1]/following::span[1]")).click();
            driver.findElement(By.id("mat-input-5")).click();
            driver.findElement(By.id("mat-input-5")).clear();
            driver.findElement(By.id("mat-input-5")).sendKeys("0123456788");
            driver.findElement(By.id("mat-input-6")).click();
            driver.findElement(By.id("mat-input-6")).clear();
            driver.findElement(By.id("mat-input-6")).sendKeys("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/preceding::span[1]")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/preceding::span[1]")).click();
            assertFalse(isAlertPresent());
        }
@After
public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
        }
        }

private boolean isElementPresent(By by) {
        try {
        driver.findElement(by);
        return true;
        } catch (NoSuchElementException e) {
        return false;
        }
        }

private boolean isAlertPresent() {
        try {
        driver.switchTo().alert();
        return true;
        } catch (NoAlertPresentException e) {
        return false;
        }
        }

private String closeAlertAndGetItsText() {
        try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
        alert.accept();
        } else {
        alert.dismiss();
        }
        return alertText;
        } finally {
        acceptNextAlert = true;
        }
        }
        }
