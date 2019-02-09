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
public class RegisterJunitTests {



    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


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
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน จ.อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


        } catch(Exception e) {
            System.out.println(e.getMessage());
            ex=e;
            fail("cannot pass to this line for regularInsert");
        }

        assertEquals(ex,null);
    }

    @Test
    public void sexMustNotBeNullInDataLoader(){

        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex(null);
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0987654321");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void sexMustHaveTwoTypeOnlyInDataLoader(){

        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("เพศที่สาม");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0987654321");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test//(expected = javax.persistence.PersistenceException.class)
    public void sexMustBeUniquInDataLoader(){


        SexEntity sexEntity =new SexEntity();
        SexEntity sexEntity1 =new SexEntity();


        sexEntity.setSex("ชาย");
        sexEntity1.setSex("ชาย");

    try {

        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(sexEntity1);
        entityManager.flush();

        System.out.println();
        System.out.println("^");
        System.out.println("=====================================================================");
        System.out.println("=====================================================================");
        System.out.println("save success");
        System.out.println("=====================================================================");
        System.out.println("=====================================================================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        fail("Should not pass to this line");
    }
    catch(javax.persistence.PersistenceException e){

        System.out.println();
        System.out.println("^");
        System.out.println("=====================================================================");
        System.out.println("=====================sexMustBeUniquInDataLoader======================");
        System.out.println("=====================================================================");
        System.out.println("save Unsuccess"+e.getMessage());
        System.out.println("=====================================================================");
        System.out.println("=====================================================================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
       // Set<ConstraintViolation<?>> violations = e.();
        //assertEquals(violations.isEmpty(), false);
        //assertEquals(violations.size(), 1);

    }


    }

    @Test
    public void prefixMustNotBeNullInDataLoader(){

        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix(null);
        contactEntity.setTelephonenumber("0987654321");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void prefixMustHaveFiveTypeOnlyInDataLoader(){

        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นายนาง");
        contactEntity.setTelephonenumber("0987654321");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test//(expected = javax.persistence.PersistenceException.class)
    public void prefixMustBeUniquInDataLoader(){


        PrefixEntity prefixEntity = new PrefixEntity();
        PrefixEntity prefixEntity1 = new PrefixEntity();


        prefixEntity.setPrefix("นาย");
        prefixEntity1.setPrefix("นาย");

        try {
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity1);
            entityManager.flush();

            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        }
        catch(javax.persistence.PersistenceException e) {
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================prefixMustBeUniquInDataLoader======================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess" + e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }

    @Test//(expected = javax.persistence.PersistenceException.class)
    public void telephonrNumberNumberMustBeUniqu(){

        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0123456789");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");


        PrefixEntity prefixEntity1 = new PrefixEntity();
        SexEntity sexEntity1 =new SexEntity();
        ContactEntity contactEntity1 = new ContactEntity();
        ProfilesEntity profilesEntity1 =new ProfilesEntity();

        sexEntity1.setSex("หญิง");
        prefixEntity1.setPrefix("นาง");
        contactEntity1.setTelephonenumber("0123456789");
        contactEntity1.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity1.setContact(contactEntity);
        profilesEntity1.setSex(sexEntity);
        profilesEntity1.setPrefix(prefixEntity);
        profilesEntity1.setPassword("12345678");
        profilesEntity1.setName("สุริยา เสียงใส");
        profilesEntity1.setEmail("Suriya13054@gmail.com");

        try {
            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();

            entityManager.persist(sexEntity1);
            entityManager.flush();
            entityManager.persist(prefixEntity1);
            entityManager.flush();
            entityManager.persist(contactEntity1);
            entityManager.flush();
            entityManager.persist(profilesEntity1);
            entityManager.flush();

            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        }
        catch(javax.persistence.PersistenceException e) {
            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================telephoneMustBeUniquInDataLoader======================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess" + e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }

    @Test
    public void telePhoneNumberNotBeNull(){
        //Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber(null);
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
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
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
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
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void addressNotBeNull(){
        //Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0123456789");
        contactEntity.setAddress(null);
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void addressMinSize20(){
        //Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0123456789");
        contactEntity.setAddress("อุดรธานี");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void prefixInProfilesNotBeNull(){
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
        profilesEntity.setPrefix(null);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("suriys1305@gmail.com");
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


            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void sexInProfilesNotBeNull(){
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
        profilesEntity.setSex(null);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("suriys1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void contactInProfilesNotBeNull(){
        //Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0987654321");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity.setContact(null);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("suriys1305@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

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
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void emailMustBeCorrectPattern(){
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
        profilesEntity.setEmail("suriyagmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test//(expected = javax.persistence.PersistenceException.class)
    public void emailMustBeUniqu(){
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
        profilesEntity.setEmail("suriya@gmail.com");





        PrefixEntity prefixEntity1 = new PrefixEntity();
        SexEntity sexEntity1 =new SexEntity();
        ContactEntity contactEntity1 = new ContactEntity();
        ProfilesEntity profilesEntity1 =new ProfilesEntity();

        sexEntity1.setSex("หญิง");
        prefixEntity1.setPrefix("นาง");
        contactEntity1.setTelephonenumber("0123456789");
        contactEntity1.setAddress("96 หมู่ 14 ต.เมืองพาน อุดรธานี Thailand 95/14");
        profilesEntity1.setContact(contactEntity1);
        profilesEntity1.setSex(sexEntity1);
        profilesEntity1.setPrefix(prefixEntity1);
        profilesEntity1.setPassword("12345678");
        profilesEntity1.setName("สุริยา เสียงใส");
        profilesEntity1.setEmail("suriya@gmail.com");
        try {
            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();

            entityManager.persist(sexEntity1);
            entityManager.flush();
            entityManager.persist(prefixEntity1);
            entityManager.flush();
            entityManager.persist(contactEntity1);
            entityManager.flush();
            entityManager.persist(profilesEntity1);
            entityManager.flush();

            System.out.println();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        catch(javax.persistence.PersistenceException e){

                System.out.println();
                System.out.println("^");
                System.out.println("=====================================================================");
                System.out.println("=====================emailMustBeUniqu=========r======================");
                System.out.println("=====================================================================");
                System.out.println("save Unsuccess"+e.getMessage());
                System.out.println("=====================================================================");
                System.out.println("=====================================================================");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
            }


    }


    @Test
    public void passwordMustBeNotNull(){
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
        profilesEntity.setPassword(null);
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("suriya@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void passwordMustBeAtLeastEight8(){
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
        profilesEntity.setPassword("1234567");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("suriya@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }


    @Test
    public void nameMustBeNotNull(){
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
        profilesEntity.setName(null);
        profilesEntity.setEmail("suriya@gmail.com");
        try{

            entityManager.persist(sexEntity);
            entityManager.flush();
            entityManager.persist(prefixEntity);
            entityManager.flush();
            entityManager.persist(contactEntity);
            entityManager.flush();
            entityManager.persist(profilesEntity);
            entityManager.flush();
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save success");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess"+e.getMessage());
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

}