package team20.se61.sut.wongnai;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import team20.se61.sut.wongnai.Entity.ContactEntity;
import team20.se61.sut.wongnai.Entity.PrefixEntity;
import team20.se61.sut.wongnai.Entity.ProfilesEntity;
import team20.se61.sut.wongnai.Entity.SexEntity;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class RegisterTests {



    @Autowired
    private TestEntityManager entityManager;



    private Validator validator;

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


//    @Test
//    public void contextLoads() {
//    }


    @Test
    public void regularInsert(){
        Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0987654321");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("SURIYA13@GMAIL.COM");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("บันทึกเรียบร้อย");


        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            ex=e;
        }

        assertEquals(ex,null);

    }

    @Test
    public void emailMustBeNotNull(){
        //Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0987654321");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail(null);
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("บันทึกเรียบร้อย");


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void telePhoneNumberLenghtMustBeTenOnly(){
        //Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("098765");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail(null);
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("บันทึกเรียบร้อย");


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void telePhoneNumberMustBeDigitalOnly(){
        //Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("098765XXXX");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail(null);
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("บันทึกเรียบร้อย");


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

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

        assertTrue(isAlertPresent());
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