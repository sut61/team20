package team20.se61.sut.wongnai;

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
@DataJpaTest
public class ReviewTests {

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void reviewCorrect(){
        Review review = new Review();
        review.setTitle("สุดยอดเลยครับ");
        review.setDetail("อร่อยจังเลยครับอิอิ");

        try {
            entityManager.persist(review);
            entityManager.flush();
            System.out.println("\n\n\n\n\n====Correct====\n\n\n\n\n");
        }
        catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line " + violations + "\n\n\n\n");
        }
    }

    @Test
    public void ReviewDetialMustBeNotNull() {
        Review review = new Review();
        review.setTitle("Test");
        review.setDetail(null);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n=====Must Be NotNull====" + violations + "\n\n\n\n");
        }
    }

    @Test
    public void ReviewDetailSizeLessthan10() {
        Review review = new Review();
        review.setTitle("Title");
        review.setDetail("te");

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n=====size<10====" + violations + "\n\n\n\n");
        }
    }

    @Test
    public void ReviewDetailSizeMorethan120(){
        Review review = new Review();
        String detail = "";
        for(int i = 0;i<121;i++)
            detail += "a";
            review.setTitle("Title");
            review.setDetail(detail);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n=====size>120===="+violations+"\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewTitleNotPattern(){
        Review review = new Review();
        review.setTitle("1อร่อยจังเลยครับ");
        review.setDetail("อร่อยจังเลยครับอิอิ");
        try {
            entityManager.persist(review);
        entityManager.flush();
    
                fail("Should not pass to this line");
        }
        catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n====NotPatternTitle===="+violations+"\n\n\n\n\n");
        }
    }
    

    @Test(expected=javax.persistence.PersistenceException.class)
    public void ReviewTitleMustBeUnique(){
        Review review1 = new Review();
        review1.setTitle("Title");
        review1.setDetail("abcdefghijk");
        entityManager.persist(review1);
        entityManager.flush();

        Review review2 = new Review();
        review2.setTitle("Title");
        review2.setDetail("lmnopqrstuvxyz");
        System.out.println("\n\n\n====ReviewTitleMustBeUnique====\n\n\n\n\n");
        entityManager.persist(review2);
        entityManager.flush();

        fail("Should not pass to this line");
    }

    @Test
    public void ReviewTitleSizeLessthan3() {
        Review review = new Review();
        review.setTitle("ts");
        review.setDetail("sasdffdggdfgdfgdf");

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n=====size<3====" + violations + "\n\n\n\n");
        }
    }

    @Test
    public void ReviewTitleSizeMorethan120(){
        Review review = new Review();
        String title = "";
        for(int i = 0;i<121;i++)
            title += "a";
            review.setTitle(title);
            review.setDetail("dfdsfdsfdsfdsfdsfsdfdsf");

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n=====size>120===="+violations+"\n\n\n\n\n");
        }
    }

    @Test
    public void PricePerHeadMustBeNotNull() {
        PricePerHead pricePerHead = new PricePerHead();
        pricePerHead.setPricePerHead(null);

        try {
            entityManager.persist(pricePerHead);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n=====Must Be NotNull====" + violations + "\n\n\n\n");
        }
    }

    @Test
    public void RatingMustBeNotNull() {
        Rating rating = new Rating();
        rating.setRating(null);

        try {
            entityManager.persist(rating);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n=====Must Be NotNull====" + violations + "\n\n\n\n");
        }
    }

    @Test
    public void ImageReviewMustBeNotNull() {
        ImageReview imageReview = new ImageReview();
        imageReview.setImage(null);

        try {
            entityManager.persist(imageReview);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n=====Must Be NotNull====" + violations + "\n\n\n\n");
        }
    }
}