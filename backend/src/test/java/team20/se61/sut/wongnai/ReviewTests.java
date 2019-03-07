package team20.se61.sut.wongnai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
    public void reviewCorrect() {
        Review review = new Review();
        review.setTitle("สุดยอดเลยครับ");
        review.setDetail("อร่อยจังเลยครับอิอิ");

        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));
        
        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("reviewCorrect\n" + "IsCorrect");
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("\n\n\n\n\n\n\n\n\n\n\n\n\nreviewCorrect\n " + violations + "\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewPricePerHeadMustBeNotNull() {
        Review review = new Review();
        review.setTitle("Test");
        review.setDetail("อร่อยจังเลยครับอิอิ");
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(null);
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewDetialMustBeNotNull\n" + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewRatingMustBeNotNull() {
        Review review = new Review();
        review.setTitle("Test");
        review.setDetail("อร่อยจังเลยครับอิอิ");
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(null);

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewDetialMustBeNotNull\n" + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewStoreMustBeNotNull() {
        Review review = new Review();
        review.setTitle("Test");
        review.setDetail("อร่อยจังเลยครับอิอิ");

        review.setStore(null);

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewDetialMustBeNotNull\n" + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }


    @Test
    public void ReviewDetialMustBeNotNull() {
        Review review = new Review();
        review.setTitle("Test");
        review.setDetail(null);
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewDetialMustBeNotNull\n" + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewDetailSizeLessthan10() {
        Review review = new Review();
        review.setTitle("Title");
        review.setDetail("te");
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewDetailSizeLessthan10\n" + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewDetailSizeMorethan120() {
        Review review = new Review();
        String detail = "";
        for (int i = 0; i < 121; i++)
            detail += "a";
        review.setTitle("Title");
        review.setDetail(detail);
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewDetailSizeMorethan120\n" + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewTitleNotPattern() {
        Review review = new Review();
        review.setTitle("1อร่อยจังเลยครับ");
        review.setDetail("อร่อยจังเลยครับอิอิ");
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);
        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewTitleNotPattern\n" + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void ReviewTitleMustBeUnique() {
        Review review1 = new Review();
        review1.setTitle("Title");
        review1.setDetail("abcdefghijk");
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review1.setStore(entityManager.persist(s));
        review1.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review1.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review1);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review1.setImageReview(imageReviews);

        entityManager.persist(review1);
        entityManager.flush();

        Review review2 = new Review();
        review2.setTitle("Title");
        review2.setDetail("lmnopqrstuvxyz");
        Store s2 = new Store();
        s2.setName("myStore");
        s2.setAdddress("ABCDE");

        s2.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s2.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        review2.setStore(entityManager.persist(s));
        review2.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review2.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir2 = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir2.setReviews(review2);

        List<ImageReview> imageReviews2 = new ArrayList<>();
        imageReviews2.add(ir);
        review2.setImageReview(imageReviews);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("----------------------------------------");
        System.out.println("ReviewTitleMustBeUnique\n");
        System.out.println("----------------------------------------");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        entityManager.persist(review2);
        entityManager.flush();

        fail("Should not pass to this line");
    }

    @Test
    public void ReviewTitleSizeLessthan3() {
        Review review = new Review();
        review.setTitle("ts");
        review.setDetail("sasdffdggdfgdfgdf");
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewTitleSizeLessthan3\n"  + violations );
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewTitleSizeMorethan120() {
        Review review = new Review();
        String title = "";
        for (int i = 0; i < 121; i++)
            title += "a";
        review.setTitle(title);
        review.setDetail("dfdsfdsfdsfdsfdsfsdfdsf");
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));

        ImageReview ir = new ImageReview("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        ir.setReviews(review);

        List<ImageReview> imageReviews = new ArrayList<>();
        imageReviews.add(ir);
        review.setImageReview(imageReviews);

        try {
            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ReviewTitleSizeMorethan120\n"  + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("PricePerHeadMustBeNotNull\n"  + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("RatingMustBeNotNull\n"  + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ImageImageReviewMustBeNotNull() {
        ImageReview imageReview = new ImageReview();
        imageReview.setImage(null);

        Review review = new Review();
        review.setTitle("อร่อยจังเลยครับ");
        review.setDetail("อร่อยจังเลยครับอิอิ");
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        review.setStore(entityManager.persist(s));

        review.setPricePerHead(entityManager.persist(new PricePerHead("มากกว่า 1000 บาท")));
        review.setRating(entityManager.persist(new Rating("5")));
        
        imageReview.setReviews(entityManager.persist(review));

        try {
            entityManager.persist(imageReview);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ImageReviewMustBeNotNull\n"  + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void ReviewsImageReviewMustBeNotNull() {
        ImageReview imageReview = new ImageReview();
        imageReview.setImage("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");
        
        imageReview.setReviews(null);

        try {
            entityManager.persist(imageReview);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("ImageReviewMustBeNotNull\n"  + violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
}