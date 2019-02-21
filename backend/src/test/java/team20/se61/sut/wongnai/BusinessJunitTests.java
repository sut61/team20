package team20.se61.sut.wongnai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class BusinessJunitTests {
    @Autowired ProvinceRepository provinceRepository;

	@Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}

	@Test
	public void shopNameNotPattern(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName("@#123yoyoRest");
        b.setEmail("yoyoland@gmail.com");
        b.setDistrict("ในเมือง");
        b.setProvince(entityManager.persist(p));
        b.setTel("0123456789");
        b.setType(entityManager.persist(bt));
        //b.setProfile();
        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 1.Test Pattern shopname : \n"+e+"\n\n");
        }
    }


    @Test
	public void emailFormat(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName("yoyoRest");
        b.setEmail("yoyoland+email.com");
        b.setDistrict("ในเมือง");
        b.setProvince(entityManager.persist(p));
        b.setTel("0123456789");
        b.setType(entityManager.persist(bt));
        //b.setProfile();
        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 2.Test email  : \n"+e+"\n\n");
        }
    }

    
    @Test
    public void districtSizelessthan5(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName("yoyoRest");
        b.setEmail("yoyoland@email.com");
        b.setDistrict("กก");
        b.setProvince(entityManager.persist(p));
        b.setTel("0123456789");
        b.setType(entityManager.persist(bt));
        //b.setProfile();
        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 3.Test size<5 district  : \n"+e+"\n\n");
        }
    }

    
    @Test
    public void districtSizemorethan20(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName("yoyoRest");
        b.setEmail("yoyoland@email.com");
        b.setDistrict("กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        b.setProvince(entityManager.persist(p));
        b.setTel("0123456789");
        b.setType(entityManager.persist(bt));
        //b.setProfile();
        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 4.Test size>20 district  : \n"+e+"\n\n");
        }
    }

    @Test
	public void shopNameNotNull(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName(null);
        b.setEmail("yoyoland@gmail.com");
        b.setDistrict("ในเมือง");
        b.setProvince(entityManager.persist(p));
        b.setTel("0123456789");
        b.setType(entityManager.persist(bt));
        //b.setProfile();
        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 5.Test shopname NotNUll: \n"+e+"\n\n");
        }
    }

    @Test
	public void TelPattern(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName("yoyoRest");
        b.setEmail("yoyoland@gmail.com");
        b.setDistrict("ในเมือง");
        b.setProvince(entityManager.persist(p));
        b.setTel("012345678a");
        b.setType(entityManager.persist(bt));
        //b.setProfile();
        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 6.Test tel NotPattern: \n"+e+"\n\n");
        }
    }
    

    @Test
	public void provinceNotNull(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName("yoyoRest");
        b.setEmail("yoyoland@gmail.com");
        b.setDistrict("ในเมือง");
        b.setProvince(null);
        b.setTel("0123456789");
        b.setType(entityManager.persist(bt));
        //b.setProfile();
        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 7.Test Provonce NotNull: \n"+e+"\n\n");
        }
    }

    @Test
	public void shopNameunique(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName("yoyoRest");
        b.setEmail("yoyoland@gmail.com");
        b.setDistrict("ในเมือง");
        b.setProvince(entityManager.persist(p));
        b.setTel("0123456789");
        b.setType(entityManager.persist(bt));
        entityManager.persist(b);
        entityManager.flush();


        Province p2 = new Province();
        p2.setName("สุรินทร์");

        BusinessType bt2 = new BusinessType();
        bt2.setName("ที่พัก");

        Business b2 = new Business();
        b2.setShopName("yoyoRest");
        b2.setEmail("eiei@gmail.com");
        b2.setDistrict("ในเมือง");
        b2.setProvince(entityManager.persist(p2));
        b2.setTel("9999999999");
        b2.setType(entityManager.persist(bt2));
        try {
            entityManager.persist(b2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("\n\n\n\n 8.Test shopNameunique: \n"+e+"\n\n");
        }
    }


    @Test
	public void Correct(){
        Province p = new Province();
        p.setName("กรุงเทพ");

        BusinessType bt = new BusinessType();
        bt.setName("สถานที่ท่องเที่ยว");

        Business b = new Business();
        b.setShopName("yoyoRest");
        b.setEmail("yoyoland@gmail.com");
        b.setDistrict("ในเมือง");
        b.setProvince(entityManager.persist(p));
        b.setTel("0123456789");
        b.setType(entityManager.persist(bt));
        //b.setProfile();
        try {
            entityManager.persist(b);
            entityManager.flush();

            System.out.println("\n\n\n\n 9.Test All Correct\n\n\n\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }
}