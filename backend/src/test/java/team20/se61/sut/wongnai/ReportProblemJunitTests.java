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
import java.util.HashSet;
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
public class ReportProblemJunitTests {
	@Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}

	@Test
    public void titleNull() {
        Room room = new Room("เพิ่มร้านค้า");
        entityManager.persist(room);
        entityManager.flush();

        Tag tag1 = new Tag("text ผิด");
        entityManager.persist(tag1);
        entityManager.flush();
        Tag tag2 = new Tag("ค้าง");
        entityManager.persist(tag2);
        entityManager.flush();

        Set<Tag> setTag = new HashSet<>();
        setTag.add(tag1);
        setTag.add(tag2);

        ReportProblem r = new ReportProblem();
        r.setTitle(null);
        r.setDetail("เพิ่มร้านค้าไมได้");
        r.setRoom(room);
        r.setTags(setTag);
        r.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 1 title Null\n"+e);
        }
    }



    @Test
    public void titlePattern() {
        Room room = new Room("เพิ่มร้านค้า");
        entityManager.persist(room);
        entityManager.flush();

        Tag tag1 = new Tag("text ผิด");
        entityManager.persist(tag1);
        entityManager.flush();
        Tag tag2 = new Tag("ค้าง");
        entityManager.persist(tag2);
        entityManager.flush();

        Set<Tag> setTag = new HashSet<>();
        setTag.add(tag1);
        setTag.add(tag2);

        ReportProblem r = new ReportProblem();
        r.setTitle("$#เพิ่มร้านค้าไม่สำเร็จ");
        r.setDetail("เพิ่มร้านค้าไมได้");
        r.setRoom(room);
        r.setTags(setTag);
        r.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 2 title Pattern\n"+e);
        }
    }


    @Test
    public void detailSizeLessThan10() {
        Room room = new Room("เพิ่มร้านค้า");
        entityManager.persist(room);
        entityManager.flush();

        Tag tag1 = new Tag("text ผิด");
        entityManager.persist(tag1);
        entityManager.flush();
        Tag tag2 = new Tag("ค้าง");
        entityManager.persist(tag2);
        entityManager.flush();

        Set<Tag> setTag = new HashSet<>();
        setTag.add(tag1);
        setTag.add(tag2);

        ReportProblem r = new ReportProblem();
        r.setTitle("เพิ่มร้านค้าไม่สำเร็จ");
        r.setDetail("กก");
        r.setRoom(room);
        r.setTags(setTag);
        r.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 3 detail size < 10\n"+e);
        }
    }


    @Test
    public void detailSizeMoreThan100() {
        Room room = new Room("เพิ่มร้านค้า");
        entityManager.persist(room);
        entityManager.flush();

        Tag tag1 = new Tag("text ผิด");
        entityManager.persist(tag1);
        entityManager.flush();
        Tag tag2 = new Tag("ค้าง");
        entityManager.persist(tag2);
        entityManager.flush();

        Set<Tag> setTag = new HashSet<>();
        setTag.add(tag1);
        setTag.add(tag2);

        String detail = "";
        for(int i = 0;i<200;i++)
            detail+="ก";

        ReportProblem r = new ReportProblem();
        r.setTitle("เพิ่มร้านค้าไม่สำเร็จ");
        r.setDetail(detail);
        r.setRoom(room);
        r.setTags(setTag);
        r.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 4 detail size > 100\n"+e);
        }
    }


    @Test
    public void imgUrlPattern() {
        Room room = new Room("เพิ่มร้านค้า");
        entityManager.persist(room);
        entityManager.flush();

        Tag tag1 = new Tag("text ผิด");
        entityManager.persist(tag1);
        entityManager.flush();
        Tag tag2 = new Tag("ค้าง");
        entityManager.persist(tag2);
        entityManager.flush();

        Set<Tag> setTag = new HashSet<>();
        setTag.add(tag1);
        setTag.add(tag2);

        ReportProblem r = new ReportProblem();
        r.setTitle("เพิ่มร้านค้าไม่สำเร็จ");
        r.setDetail("เพิ่มร้านค้าไมได้");
        r.setRoom(room);
        r.setTags(setTag);
        r.setImgUrl("//firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 5 imgUrl Pattern \n"+e);
        }
    }


    @Test
    public void roomNotNull() {
        Tag tag1 = new Tag("text ผิด");
        entityManager.persist(tag1);
        entityManager.flush();
        Tag tag2 = new Tag("ค้าง");
        entityManager.persist(tag2);
        entityManager.flush();

        Set<Tag> setTag = new HashSet<>();
        setTag.add(tag1);
        setTag.add(tag2);

        ReportProblem r = new ReportProblem();
        r.setTitle("เพิ่มร้านค้าไม่สำเร็จ");
        r.setDetail("เพิ่มร้านค้าไมได้");
        r.setRoom(null);
        r.setTags(setTag);
        r.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 6 room null \n"+e);
        }
    }


    @Test
    public void tagNotNull() {
        Room room = new Room("เพิ่มร้านค้า");
        entityManager.persist(room);
        entityManager.flush();

        ReportProblem r = new ReportProblem();
        r.setTitle("เพิ่มร้านค้าไม่สำเร็จ");
        r.setDetail("เพิ่มร้านค้าไมได้");
        r.setRoom(room);
        r.setTags(null);
        r.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 7 tag null \n"+e);
        }
    }

    @Test
    public void roomNameNull() {
        Room room = new Room();
        room.setName(null);

        try {
            entityManager.persist(room);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 8 roomName null \n"+e);
        }
    }


    @Test
    public void roomNameisUnique() {
        Room room1 = new Room("เพิ่มร้านค้า");
        entityManager.persist(room1);
        entityManager.flush();

        Room room2 = new Room("เพิ่มร้านค้า");

        try {
            entityManager.persist(room2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("\n\n\n\ntest 9 roomName  unique\n"+e);
        }
    }

    @Test
    public void roomCorrect() {
        Room room = new Room();
        room.setName("เพิ่มร้านค้า");

        try {
            entityManager.persist(room);
            entityManager.flush();

            System.out.println("\n\n\n\ntest 10 room Correct \n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    public void ReportProblemCorrect() {
        Room room = new Room("เพิ่มร้านค้า");
        entityManager.persist(room);
        entityManager.flush();

        Tag tag1 = new Tag("text ผิด");
        entityManager.persist(tag1);
        entityManager.flush();
        Tag tag2 = new Tag("ค้าง");
        entityManager.persist(tag2);
        entityManager.flush();

        Set<Tag> setTag = new HashSet<>();
        setTag.add(tag1);
        setTag.add(tag2);

        ReportProblem r = new ReportProblem();
        r.setTitle("เพิ่มร้านค้าไม่สำเร็จ");
        r.setDetail("เพิ่มร้านค้าไมได้");
        r.setRoom(room);
        r.setTags(setTag);
        r.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(r);
            entityManager.flush();
            System.out.println("\n\n\n\ntest 11 Report Correct \n");
            
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    public void tagNameNotNull() {
       Tag t  = new Tag();
       t.setName(null);
        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ntest 12 tagName null \n"+e);
        }
    }

    @Test
    public void tagNameUnique() {
       Tag t1  = new Tag();
       t1.setName("text ผิด");
       entityManager.persist(t1);
       entityManager.flush();

       Tag t2  = new Tag();
       t2.setName("text ผิด");
        try {
            entityManager.persist(t2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("\n\n\n\ntest 13 tagName unique \n"+e);
        }
    }

    @Test
    public void tagCorrect() {
        Tag t  = new Tag();
        t.setName("text ผิด");

        try {
            entityManager.persist(t);
            entityManager.flush();

            System.out.println("\n\n\n\ntest 14 tag Correct \n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }
}

