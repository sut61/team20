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
import javax.persistence.*;

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
public class RecipeJuintTests{

	@Autowired private RecipeRespository recipeRespository;
	@Autowired private CookingMethodRespository cookingMethodRespository;
	@Autowired private FoodTypeRespository foodTypeRespository;
	@Autowired private MainIngredRespository mainIngredRespository;
	@Autowired private ProfilesRepository profilesRepository;

	@Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
	/*@Test Recipe /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	@Test   
	public void NameNull() {
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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(mi);
		testmenu.setName(null);
        testmenu.setHowto("howto");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 1.Test Null Name : \n"+e+"\n\n");
        }
    }

    @Test   
	public void HowtoNull() {
	
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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(mi);
		testmenu.setName("กระเพา");
        testmenu.setHowto(null);
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 2.Test Null Howto : \n"+e+"\n\n");
        }
	}
	
	@Test   
	public void ToolongHowto() {
		String howto = new String();
		for(int i=0 ;i<1502;i++){
			howto = howto+"X";
		}

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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(mi);
		testmenu.setName("กระเพา");
        testmenu.setHowto(howto);
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 3.Test Too Long Howto : \n"+e+"\n\n");
        }
	}
	
	@Test   
	public void NotpettrenURL() {
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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(mi);
		testmenu.setName("กระเพา");
        testmenu.setHowto("ผัด");
       	testmenu.setUrlPhoto ("ttps://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 4.Test NoT Pattern UrlPhoto : \n"+e+"\n\n");
        }
    }

    @Test   
	public void UrlPhotoNotUniqe() {

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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(mi);
		testmenu.setName("กระเพา");
        testmenu.setHowto("ผัด");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
            entityManager.persist(testmenu);
            entityManager.flush();

        Recipe testmenu1 = new Recipe();
        testmenu1.setProfilles(profilesEntity);
        testmenu1.setCookingmethod(cm);
        testmenu1.setFoodtype(ft);
        testmenu1.setMainingred(mi);
		testmenu1.setName("กระเพา");
        testmenu1.setHowto("ผัด");
       	testmenu1.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
          
        try{
            entityManager.persist(testmenu1);
            entityManager.flush();
            fail("Should not pass to this line");       

        }catch(javax.persistence.PersistenceException e){
            System.out.println("\n\n\n\n 5.Test NoT Unique UrlPhoto : \n"+e+"\n\n");
        }   
           

    }
	
    @Test   
    public void Correct() {

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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(mi);
		testmenu.setName("กระเพา");
        testmenu.setHowto("ผัด");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
       
            entityManager.persist(testmenu);
            entityManager.flush();
            System.out.println("\n\n\n\n 6.Test Correct!!!! : \n\n\n");

    }

    @Test   
	public void ProfillesNull() {
       
        FoodType ft = new FoodType("j");
        entityManager.persist(ft);
        entityManager.flush();
        MainIngredients mi = new MainIngredients("K");
        entityManager.persist(mi);
        entityManager.flush();
        CookingMethod cm = new CookingMethod("P");
        entityManager.persist(cm);
        entityManager.flush();
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(null);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(mi);
		testmenu.setName("กระเพรา");
        testmenu.setHowto("howto");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 7.Test Null Profilles : \n"+e+"\n\n");
        }
    }

    @Test   
	public void CookingmethodNull() {
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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(null);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(mi);
		testmenu.setName("กระเพา");
        testmenu.setHowto("howto");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 8.Test Null Cookingmethod : \n"+e+"\n\n");
        }
    }

    @Test   
	public void FoodtypeNull() {
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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(null);
        testmenu.setMainingred(mi);
		testmenu.setName("กระเพา");
        testmenu.setHowto("howto");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 9.Test Null Foodtype : \n"+e+"\n\n");
        }
    }

    @Test   
	public void MainingredNull() {
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
        
        Recipe testmenu = new Recipe();
        testmenu.setProfilles(profilesEntity);
        testmenu.setCookingmethod(cm);
        testmenu.setFoodtype(ft);
        testmenu.setMainingred(null);
		testmenu.setName("กระเพา");
        testmenu.setHowto("howto");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n 10.Test Null Mainingred : \n"+e+"\n\n");
        }
    }



}