package team20.se61.sut.wongnai;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import team20.se61.sut.wongnai.Entity.*;

import javax.validation.*;

import java.util.Set;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewFoodJunitTests {

    @Autowired
    private TestEntityManager testEntityManager;

    private Validator validator;

    @Before
    public void setUp() throws Exception {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง1");
        restaurant.setTelephonenumber("0123456789");
        restaurant.setIdentity("กินฟรีวันหวยออก");
        foodForReview.setPointFood(pointFood);
        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);


        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(pointFood);
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();
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
        catch (javax.validation.ConstraintViolationException e){
            ex=e;
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

            fail("cannot pass to this line for regularinsertReview");
        }

        assertEquals(ex,null);
    }


    @Test
    public void restaurantNameMustBeNotNull(){

       // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);


        restaurant.setRestaurant(null);
        restaurant.setTelephonenumber("0123456789");
        restaurant.setIdentity("กินฟรีวันหวยออก");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for restaurant null");
        }
        catch (javax.validation.ConstraintViolationException e){

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
    public void restaurantNameMustNotHaveSpecialSting(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง....???11");
        restaurant.setTelephonenumber("0123456789");
        restaurant.setIdentity("กินฟรีวันหวยออก");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for restaurantNameMustNotHaveSpecialSting");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }

    @Test
    public void restaurantTelephoneNumberNotNull(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber(null);
        restaurant.setIdentity("กินฟรีวันหวยออก");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for restaurantTelephoneNumberNotNull");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }

    @Test
    public void restaurantTelephoneNumberMustBeDigitOnly(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("012345678X");
        restaurant.setIdentity("กินฟรีวันหวยออก");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for restaurantTelephoneNumberMustBeDigitOnly");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }

    @Test
    public void restaurantTelephoneNumberMustBe9To10Charecter(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("01234567");
        restaurant.setIdentity("กินฟรีวันหวยออก");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for restaurantTelephoneNumberMustBe9To10Charecter");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }

    @Test
    public void restaurantTelephoneNumberStartWithZeroOnly(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("9876543210");
        restaurant.setIdentity("กินฟรีวันหวยออก");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for restaurantTelephoneNumberStertWithSeroOnly");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }

    @Test
    public void restaurantIdentifyNotNull(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity(null);

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for restaurantIdentifyNotNull");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }


    @Test
    public void restaurantIdentifyMustBeSpecialString(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("0987654321");
        restaurant.setIdentity("กินฟรี?????/");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

            System.out.println("^");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println("save Unsuccess");
            System.out.println("=====================================================================");
            System.out.println("=====================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            fail("cannot pass to this line for restaurantIdentifyMustBeSpecialString");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }


    @Test//(expected = javax.persistence.PersistenceException.class)
    public void restaurantIdentifyMustBeUniqu() {

        // Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity = new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity = new ProfilesEntity();

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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("0987654321");
        restaurant.setIdentity("กินฟรีวันหวยออก");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");


        Restaurant restaurant1 = new Restaurant();
        FoodForReviewEntity foodForReview1 = new FoodForReviewEntity();
        PointFoodEntity pointFood1 = new PointFoodEntity();
        pointFood1.setPointfood(3);

        restaurant1.setRestaurant("ยายดำ");
        restaurant1.setTelephonenumber("0987654321");
        restaurant1.setIdentity("กินฟรีวันหวยออก");

        foodForReview1.setProfilesEntity(profilesEntity);
        foodForReview1.setRestaurant(restaurant);
        foodForReview1.setFood("ข้าวผัด");
        foodForReview1.setPrice(99);
        foodForReview1.setPointFood(pointFood1);
        foodForReview1.setReview("อร่อย very Good");

try{
        testEntityManager.persist(sexEntity);
        testEntityManager.flush();
        testEntityManager.persist(prefixEntity);
        testEntityManager.flush();
        testEntityManager.persist(contactEntity);
        testEntityManager.flush();
        testEntityManager.persist(profilesEntity);
        testEntityManager.flush();

        testEntityManager.persist(pointFood);
        testEntityManager.flush();

        testEntityManager.persist(pointFood1);
        testEntityManager.flush();

        testEntityManager.persist(restaurant);
        testEntityManager.flush();
        testEntityManager.persist(foodForReview);
        testEntityManager.flush();

   // try{


        testEntityManager.persist(restaurant1);
        testEntityManager.flush();
        testEntityManager.persist(foodForReview1);
        testEntityManager.flush();

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
        fail("connot pass to line");
    }
catch (javax.persistence.PersistenceException e){

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

}


    }



   @Test//(expected = javax.persistence.PersistenceException.class)
    public void foodpointMustBeUniqu(){

        // Exception ex=null;
        PrefixEntity prefixEntity = new PrefixEntity();
        SexEntity sexEntity =new SexEntity();
        ContactEntity contactEntity = new ContactEntity();
        ProfilesEntity profilesEntity =new ProfilesEntity();

        sexEntity.setSex("ชาย");
        prefixEntity.setPrefix("นาย");
        contactEntity.setTelephonenumber("0987654322");
        contactEntity.setAddress("96 หมู่ 14 ต.เมืองพาน จ.อุดรธานี Thailand 95/14");
        profilesEntity.setContact(contactEntity);
        profilesEntity.setSex(sexEntity);
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setPassword("12345678");
        profilesEntity.setName("สุริยา เสียงใส");
        profilesEntity.setEmail("Suriya1305@gmail.com");


        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("0987654321");
        restaurant.setIdentity("กินฟรีวันหวยไม่ออก");

        
        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");



        Restaurant restaurant1 = new Restaurant();
        FoodForReviewEntity foodForReview1 = new FoodForReviewEntity();
        PointFoodEntity pointFood1 = new PointFoodEntity();
        pointFood1.setPointfood(2);

        restaurant1.setRestaurant("ยายดำ");
        restaurant1.setTelephonenumber("0987654321");
        restaurant1.setIdentity("กินฟรีวันหวยออก");

        foodForReview1.setProfilesEntity(profilesEntity);
        foodForReview1.setRestaurant(restaurant);
        foodForReview1.setFood("ข้าวผัด");
        foodForReview1.setPrice(99);
        foodForReview1.setPointFood(pointFood1);
        foodForReview1.setReview("อร่อย very Good");

try {
    testEntityManager.persist(sexEntity);
    testEntityManager.flush();
    testEntityManager.persist(prefixEntity);
    testEntityManager.flush();
    testEntityManager.persist(contactEntity);
    testEntityManager.flush();
    testEntityManager.persist(profilesEntity);
    testEntityManager.flush();

    testEntityManager.persist(pointFood);
    testEntityManager.flush();

    testEntityManager.persist(pointFood1);
    testEntityManager.flush();

    testEntityManager.persist(restaurant);
    testEntityManager.flush();
    testEntityManager.persist(foodForReview);
    testEntityManager.flush();


    testEntityManager.persist(restaurant1);
    testEntityManager.flush();
    testEntityManager.persist(foodForReview1);
    testEntityManager.flush();

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
    fail("connot pass to line");
}
catch (javax.persistence.PersistenceException e){

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

}




   }


    @Test
    public void foodNameNotNull(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity("eatfreeValitine");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood(null);
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for foodNameNotNull");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }

    @Test
    public void foodNameMustBeSpecialString(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity("eatfreeValitine");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด????");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for foodNameMustBeSpecialString");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }



    @Test
    public void foodpriceNotBeNagetive(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity("eatfreeValitine");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(-99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for foodpriceNotBeNagetive");
        }
        catch (javax.validation.ConstraintViolationException e){
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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }


    @Test
    public void foodpointMustBe0To5Only(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(100);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity("eatfreeValitine");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("อร่อย very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for foodpointMustBe0To5Only");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }


    @Test
    public void reviewMustBeNotNull(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity("eatfreeValitine");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview(null);

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for reviewMustBeNotNull");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }

    @Test
    public void UserMustBeNotNull(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity("eatfreeValitine");

        foodForReview.setProfilesEntity(null);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for UserNotNull");
        }
        catch (javax.validation.ConstraintViolationException e){
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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }


    @Test
    public void restuarantMustBeNotNull(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity("eatfreeValitine");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(null);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(pointFood);
        foodForReview.setReview("very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for UserNotNull");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }

    @Test
    public void pointfoodrestuarantMustBeNotNull(){

        // Exception ex=null;
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

        Restaurant restaurant = new Restaurant();
        FoodForReviewEntity foodForReview = new FoodForReviewEntity();
        PointFoodEntity pointFood = new PointFoodEntity();
        pointFood.setPointfood(2);

        restaurant.setRestaurant("ยายแดง");
        restaurant.setTelephonenumber("098765432");
        restaurant.setIdentity("eatfreeValitine");

        foodForReview.setProfilesEntity(profilesEntity);
        foodForReview.setRestaurant(restaurant);
        foodForReview.setFood("ข้าวผัด");
        foodForReview.setPrice(99);
        foodForReview.setPointFood(null);
        foodForReview.setReview("very Good");

        try{
            testEntityManager.persist(sexEntity);
            testEntityManager.flush();
            testEntityManager.persist(prefixEntity);
            testEntityManager.flush();
            testEntityManager.persist(contactEntity);
            testEntityManager.flush();
            testEntityManager.persist(profilesEntity);
            testEntityManager.flush();

            testEntityManager.persist(pointFood);
            testEntityManager.flush();
            testEntityManager.persist(restaurant);
            testEntityManager.flush();
            testEntityManager.persist(foodForReview);
            testEntityManager.flush();

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
            fail("cannot pass to this line for UserNotNull");
        }
        catch (javax.validation.ConstraintViolationException e){

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
            Set<ConstraintViolation <?>> violation = e.getConstraintViolations();
            assertEquals(violation.isEmpty(),false);
            assertEquals(violation.size(),1);

        }

    }


}