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
public class NutritionJunitTests {

    @Autowired private FoodpropertiesRepository fprop;
    @Autowired private NutritivevalueRepository Nv;

	@Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}

	@Test
	public void foodpropNull() {
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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();

        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();

        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();

			Foodproperties coolfood = new Foodproperties();
            coolfood.setFoodproperties(null);
            coolfood.setRecipe(rc);	
		try {
            entityManager.persist(coolfood);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 1.Test Not Null Foodproperties : \n"+e+"\n\n");
        }
	}

	@Test
	public void foodpropTooShort() {
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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();

        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();

        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();

			Foodproperties coolfood = new Foodproperties();
            coolfood.setFoodproperties("F");
            coolfood.setRecipe(rc);	
		try {
            entityManager.persist(coolfood);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 2.Test Too short Foodproperties : \n"+e+"\n\n");
        }
	}

	@Test
	public void foodpropTooLong() {
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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();

        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();

        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
		String prop ="";
		for(int i = 0 ; i< 51 ; i++  ) prop+="FFFFF";

			Foodproperties coolfood = new Foodproperties();
            coolfood.setFoodproperties(prop);	
            coolfood.setRecipe(rc);
		try {
            entityManager.persist(coolfood);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 3.Test Too Long Foodproperties : \n"+e+"\n\n");
        }
	}

	@Test
	public void foodpropNotPertern() {
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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();

        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();

        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
        
        
			Foodproperties coolfood = new Foodproperties();
            coolfood.setFoodproperties("สุดยอดครับ\n\tลุงโทนี่");	
            coolfood.setRecipe(rc);
		try {
            entityManager.persist(coolfood);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 4.Test Not Pertern Foodproperties : \n"+e+"\n\n");
        }
	}

	@Test
	public void foodpropNoTunique() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();

        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();

        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
        


			Foodproperties coolfood = new Foodproperties();
            coolfood.setFoodproperties("สุดยอดครับ");
            coolfood.setRecipe(rc);	
			Foodproperties coolfood1 = new Foodproperties();
            coolfood1.setFoodproperties("สุดยอดครับ");
            coolfood1.setRecipe(rc);	


		try {
            entityManager.persist(coolfood);
			entityManager.flush();
			entityManager.persist(coolfood1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException  e) {

            System.out.println("\n\n\n\n 5.Test NoT Unique Foodproperties : \n"+e+"\n\n");

            // Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            // assertEquals(violations.isEmpty(), false);
            // assertEquals(violations.size(), 1);
		}
		


	}

	@Test
	public void foodpropCorrect() {
		
			Foodproperties coolfood = new Foodproperties();
			coolfood.setFoodproperties("สุดยอดครับ");	

		try {
            entityManager.persist(coolfood);
			entityManager.flush();
            System.out.println("\n\n\n\n 6.Test Correct Foodproperties \n\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            
		}
		

		
    }
    
    @Test
	public void AmountToolate() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();


           
            Nutritive_value nv = new Nutritive_value();
            nv.setAmount(-1);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 7.Test Too Late Amount : \n"+e+"\n\n");
        }
    }
    
    @Test
	public void AmountToomuch() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setAmount(501);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 8.Test Too Much Amount : \n"+e+"\n\n");
        }
    }
    
    @Test
	public void ToomuchEnergy() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setEnergy((float)2000.5);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 9.Test Too Much Energy : \n"+e+"\n\n");
        }
    }
    
    @Test
	public void TooLateEnergy() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setEnergy((float)-0.5);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 10.Test Too late Energy : \n"+e+"\n\n");
        }
	}

    @Test
	public void TooLateFat() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setFat((float)-0.5);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 11.Test Too Late Fat : \n"+e+"\n\n");
        }
    }
    @Test
	public void ToomuchFat() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setFat(100);
            nv.setRecipe(rc);
            nv.setAmount(1);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 12.Test Too Much Fat : \n"+e+"\n\n");
        }
    }
    
    @Test
	public void ToomuchSodium() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setSodium((float)7000);
            nv.setRecipe(rc);
            nv.setAmount(1);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 13.Test Too Much Sodium : \n"+e+"\n\n");
        }
    }
    
    @Test
	public void ToolateSouim() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setFat((float)-0.7);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 14.Test Too Late Sodium : \n"+e+"\n\n");
        }
    }
    
    @Test
	public void ToomuchSugar() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setSugar((float)500.7);
            nv.setAmount(1);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 15.Test Too Much Sugar : \n"+e+"\n\n");
        }
	}

    @Test
	public void ToolateSugar() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setSugar((float)-0.7);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 16.Test Too Late Sugar : \n"+e+"\n\n");
        }


    }
    
    @Test
	public void ToolateSaturate() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setSaturates((float)-0.7);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 17.Test Too Late Saturate : \n"+e+"\n\n");
        }



        
    }
    
    @Test
	public void TooMuchSaturate() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setSaturates((float)100);
            nv.setAmount(1);
            nv.setRecipe(rc);
			
		try {
            entityManager.persist(nv);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 18.Test Too Much Saturate : \n"+e+"\n\n");
        }

        

        
    }
    
    @Test
	public void NutritionCorrect() {

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
        entityManager.persist(sexEntity);
        entityManager.flush();
        entityManager.persist(prefixEntity);
        entityManager.flush();
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.persist(profilesEntity);
        entityManager.flush();
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();

        Recipe rc = new Recipe();
        rc.setCookingmethod(cm);
        rc.setFoodtype(ft);
        rc.setMainingred(mi);
        rc.setProfilles(profilesEntity);
        rc.setHowto("hhgsd");
        rc.setName("ddd");
        rc.setUrlPhoto("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(rc);
        entityManager.flush();
            Nutritive_value nv = new Nutritive_value();
            nv.setAmount(1);
            nv.setSaturates((float)0);
            nv.setRecipe(rc);
            nv.setFat(0);
            nv.setEnergy(100);
            nv.setSodium(0);
            nv.setSugar(0);
           
        

			
		try {
            entityManager.persist(nv);
            entityManager.flush();
            System.out.println("\n\n\n\n 19.Nutrition Test Correct  :\n\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
           
        }

        

        
    }
    
    @Test
	public void NutritionNullRecipe() {

            Nutritive_value nv = new Nutritive_value();
            nv.setAmount(1);
            nv.setSaturates((float)0);
            nv.setRecipe(null);
            nv.setFat(0);
            nv.setEnergy(100);
            nv.setSodium(0);
            nv.setSugar(0);
           
        

			
		try {
            entityManager.persist(nv);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 20.Nutrition Test Null Recipe  :\n\n");
           
        }
    }
    
    @Test
    public void foodpropNullRecipe() {
        
            Foodproperties coolfood = new Foodproperties();
            coolfood.setFoodproperties("สุดยอดครับ");	
            coolfood.setRecipe(null);
        try {
            entityManager.persist(coolfood);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 6.Test Foodproperties Null Recipe :\n"+e+"\n\n");
            
        }
        

        
    }
    











}

