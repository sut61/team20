package team20.se61.sut.wongnai;

import org.junit.Test;
import org.junit.runner.RunWith;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class RegisterTests {



    @Autowired
    private TestEntityManager entityManager;



    private Validator validator;

    @Before
    public void setup() {
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

}