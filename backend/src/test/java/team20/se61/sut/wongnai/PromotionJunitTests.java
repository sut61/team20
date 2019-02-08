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
import team20.se61.sut.wongnai.Entity.Promotion;
import team20.se61.sut.wongnai.Entity.PromotionType;
import team20.se61.sut.wongnai.Entity.Percentage;

import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
// @SpringBootTest
@DataJpaTest
public class PromotionJunitTests {

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void PromotionNameNotNull() {
        Promotion p = new Promotion();
        Percentage percent = new Percentage();
        PromotionType ptype = new PromotionType();
        percent.setName(5L);
        ptype.setName("รายวัน");
        p.setName(null);
        p.setPercentage(entityManager.persist(percent));
        p.setPromotionType(entityManager.persist(ptype));
        p.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nTest Name = null \n" + violations);
        }

    }

    @Test
    public void detailSizeLessThan10() {
        Promotion p = new Promotion();
        Percentage percent = new Percentage();
        PromotionType ptype = new PromotionType();
        percent.setName(5L);
        ptype.setName("รายวัน");
        p.setName("Buy1Get1");
        p.setPercentage(entityManager.persist(percent));
        p.setPromotionType(entityManager.persist(ptype));
        p.setDetail("กก");
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nTest detail < 10 \n" + violations);
        }
    }

    @Test
    public void detailSizeMoreThan100() {
        String s = "";
        for (int i = 0; i < 200; i++)
            s += "ก";
        Promotion p = new Promotion();
        Percentage percent = new Percentage();
        PromotionType ptype = new PromotionType();
        percent.setName(5L);
        ptype.setName("รายวัน");
        p.setName("Buy1Get1");
        p.setPercentage(entityManager.persist(percent));
        p.setPromotionType(entityManager.persist(ptype));
        p.setDetail(s);
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nTest detail > 100 \n" + violations);
        }
    }

    @Test
    public void NamePattern() {
        Promotion p = new Promotion();
        Percentage percent = new Percentage();
        PromotionType ptype = new PromotionType();
        percent.setName(5L);
        ptype.setName("รายวัน");
        p.setName("?-;abcdefgh");
        p.setPercentage(entityManager.persist(percent));
        p.setPromotionType(entityManager.persist(ptype));
        p.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกก");
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nTest namePattern \n" + violations);
        }
    }

    @Test
    public void NameUnique() {
        Promotion p = new Promotion();
        Percentage percent = new Percentage();
        PromotionType ptype = new PromotionType();
        percent.setName(5L);
        ptype.setName("รายวัน");
        p.setPercentage(entityManager.persist(percent));
        p.setPromotionType(entityManager.persist(ptype));
        p.setName("Get1Buy1");
        p.setDetail("กกกกกกกกกกกกกกกกกกกก");

        entityManager.persist(p);
        entityManager.flush();

        Promotion p2 = new Promotion();
        Percentage percent2 = new Percentage();
        PromotionType ptype2 = new PromotionType();
        percent2.setName(10L);
        ptype2.setName("รายปี");
        p2.setPercentage(entityManager.persist(percent2));
        p2.setPromotionType(entityManager.persist(ptype2));
        p2.setName("Get1Buy1");
        p2.setDetail("ขขขขขขขขขขขขขขขขขข");
        try {
            entityManager.persist(p2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("\n\n\n\nTest Unique \n" + e);
        }
    }

    @Test
    public void CorrectPromotion() {
        Promotion p = new Promotion();
        Percentage percent = new Percentage();
        PromotionType ptype = new PromotionType();
        percent.setName(5L);
        ptype.setName("รายวัน");
        p.setPercentage(entityManager.persist(percent));
        p.setPromotionType(entityManager.persist(ptype));
        p.setName("Get1Buy1");
        p.setDetail("กกกกกกกกกกกกกกกกกกกก");
        try {
            entityManager.persist(p);
            entityManager.flush();

            System.out.println("\n\n\n\nTest Correct \n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");

        }
    }

    @Test
    public void CorrectPercentage() {
        Percentage percent = new Percentage();
        percent.setName(5L);
        try {
            entityManager.persist(percent);
            entityManager.flush();

            System.out.println("\n\n\n\nPercent Correct \n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");

        }
    }

    @Test
    public void percentageNull() {
        Percentage percent = new Percentage();
        percent.setName(null);
        try {
            entityManager.persist(percent);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nPercent Percenttage NUll \n");

        }
    }

    @Test
    public void CorrectPromotionType() {
        PromotionType ptype = new PromotionType();
        ptype.setName("รายปี");
        try {
            entityManager.persist(ptype);
            entityManager.flush();

            System.out.println("\n\n\n\nPromotionType Correct \n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");

        }
    }

    @Test
    public void PromotionTypeNull() {
        PromotionType ptype = new PromotionType();
        ptype.setName(null);
        try {
            entityManager.persist(ptype);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nPercent PromotionType NUll \n");

        }
    }

}