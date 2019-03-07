package team20.se61.sut.wongnai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import team20.se61.sut.wongnai.Entity.OrderFood;
import team20.se61.sut.wongnai.Entity.Food;
import team20.se61.sut.wongnai.Entity.Store;

import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderFoodJunitTests {

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // CountItem > 20
    @Test
    public void countItemMoreThan20() {
        OrderFood order = new OrderFood();
        order.setCountItem(50);
        order.setTotalPrice(50000);
        order.setDeliverAddress("AOJSFOJSFOOPJPOSAJFPAVSVSVASVASVASVSV");

        try {
            entityManager.persist(order);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====CountItemMoreThan20====" + violations + "\n\n");
        }

    }

    @Test
    // CountItem < 1
    public void countItemLessThan1() {
        OrderFood order = new OrderFood();
        order.setCountItem(0);
        order.setTotalPrice(50000);
        order.setDeliverAddress("AOJSFOJSFOOPJPOSAJFPAVSVSVASVASVASVSV");

        try {
            entityManager.persist(order);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====CountItemLessThan1====" + violations + "\n\n");
        }

    }

    // TotalPrice > 1000000
    @Test
    public void totalPriceMoreThan1000000() {
        OrderFood order = new OrderFood();
        order.setCountItem(5);
        order.setTotalPrice(1100000);
        order.setDeliverAddress("AOJSFOJSFOOPJPOSAJFPAVSVSVASVASVASVSV");

        try {
            entityManager.persist(order);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====TotalPriceMoreThan1000000====" + violations + "\n\n");
        }

    }

    @Test
    // TotalPrice < 1
    public void totalPriceLessThan1() {
        OrderFood order = new OrderFood();
        order.setCountItem(5);
        order.setTotalPrice(0);
        order.setDeliverAddress("AOJSFOJSFOOPJPOSAJFPAVSVSVASVASVASVSV");

        try {
            entityManager.persist(order);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====TotalPriceLessThan1====" + violations + "\n\n");
        }

    }

    @Test
    // Deliver Not Null
    public void deliverAddressNotNull() {
        OrderFood order = new OrderFood();
        order.setCountItem(5);
        order.setTotalPrice(500);
        order.setDeliverAddress(null);

        try {
            entityManager.persist(order);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====DeliverAddressNotNull====" + violations + "\n\n");
        }

    }

    @Test
    // Deliver Size < 20
    public void deliverAddressSizeLessThan20() {
        OrderFood order = new OrderFood();
        order.setCountItem(5);
        order.setTotalPrice(500);
        order.setDeliverAddress("null");

        try {
            entityManager.persist(order);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====DeliverAddressSizeLessThan20====" + violations + "\n\n");
        }

    }

    @Test
    // Deliver Size > 300
    public void deliverAddressSizeMoreThan300() {
        OrderFood order = new OrderFood();
        order.setCountItem(5);
        order.setTotalPrice(500);

        String str = "";
        for (int i = 1; i <= 70; i++)
            str += "FFFFF";

        order.setDeliverAddress(str);

        try {
            entityManager.persist(order);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====DeliverAddressSizeLessThan20====" + violations + "\n\n");
        }

    }

    @Test
    // Deliver Not Pattern
    public void deliverAddressNotPattern() {
        OrderFood order = new OrderFood();
        order.setCountItem(5);
        order.setTotalPrice(500);
        order.setDeliverAddress("*_$@^*_#$(^**_$@^*_#$(^**_$@^*_#$(^**_$@^*_#$(^**_$@^*_#$(^*");

        try {
            entityManager.persist(order);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====serialCodeNotPattern====" + violations + "\n\n");
        }

    }

    // Correct
    @Test
    public void orderFoodCorrect() {
        OrderFood order = new OrderFood();
        order.setCountItem(5);
        order.setTotalPrice(500);
        order.setDeliverAddress("Mountain View, California, United States");

        try {
            entityManager.persist(order);
            entityManager.flush();

            System.out.println("\n\n====OrderFoodCorrect====\n\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    // Food Name Not Null
    public void foodNameNotNull() {
        Food food = new Food();
        food.setName(null);
        food.setPrice(500);
        food.setImage("https://img.wongnai.com/p/1920x0/2018/02/26/2839690805404c148a33c971a99c23f6.jpg");

        try {
            entityManager.persist(food);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====FoodNameNotNull====" + violations + "\n\n");
        }

    }

    @Test
    // Food Name Not Pattern
    public void foodNameNotPattern() {
        Food food = new Food();
        food.setName("@_^*AFggเกห้กด");
        food.setPrice(500);
        food.setImage("https://img.wongnai.com/p/1920x0/2018/02/26/2839690805404c148a33c971a99c23f6.jpg");

        try {
            entityManager.persist(food);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====FoodNameNotPattern====" + violations + "\n\n");
        }

    }

    @Test
    // Food Price > 10000
    public void foodPriceMoreThan10000() {
        Food food = new Food();
        food.setName("ยำหอยแครง");
        food.setPrice(15000);
        food.setImage("https://img.wongnai.com/p/1920x0/2018/02/26/2839690805404c148a33c971a99c23f6.jpg");

        try {
            entityManager.persist(food);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====FoodPriceMoreThan10000====" + violations + "\n\n");
        }

    }

    @Test
    // Food Price < 1
    public void foodPriceLessThan1() {
        Food food = new Food();
        food.setName("ยำหอยแครง");
        food.setPrice(0);
        food.setImage("https://img.wongnai.com/p/1920x0/2018/02/26/2839690805404c148a33c971a99c23f6.jpg");

        try {
            entityManager.persist(food);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====FoodNameMoreThan10000====" + violations + "\n\n");
        }

    }

    @Test
    // Food Image Not Null
    public void foodImgageNotNull() {
        Food food = new Food();
        food.setName("ยำหอยแครง");
        food.setPrice(500);
        food.setImage(null);

        try {
            entityManager.persist(food);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====FoodImgageNotNull====" + violations + "\n\n");
        }

    }

    @Test
    // Food Image Not Pattern
    public void foodImgageNotPattern() {
        Food food = new Food();
        food.setName("ยำหอยแครง");
        food.setPrice(500);
        food.setImage(
                "//firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");

        try {
            entityManager.persist(food);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====FoodImgageNotPattern====" + violations + "\n\n");
        }

    }

    // Correct
    @Test
    public void foodCorrect() {
        Store store = new Store();
        store.setName("XXXXXXXXXXXXXXXXXX");
        store.setAdddress("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        entityManager.persist(store);
        entityManager.flush();

        Food food = new Food();
        food.setName("ยำหอยแครง");
        food.setPrice(500);
        food.setImage("https://img.wongnai.com/p/1920x0/2018/02/26/2839690805404c148a33c971a99c23f6.jpg");
        food.setStore(store);

        try {
            entityManager.persist(food);
            entityManager.flush();

            System.out.println("\n\n====FoodCorrect====\n\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

}