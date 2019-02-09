package team20.se61.sut.wongnai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import team20.se61.sut.wongnai.Entity.SerialCode;

import java.util.Date;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
// @SpringBootTest
@DataJpaTest
public class SerialCodeJunitTests {

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // Serialcode not null
    @Test
    public void serialCodeNotNull() {
        SerialCode code = new SerialCode();
        code.setSerialCode(null);
        code.setDetail("รายละเอียดรายละเอียดรายละเอียดรายละเอียด");

        try {
            entityManager.persist(code);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====SerialCodeNotnull====" + violations + "\n\n");
        }

    }

    // Serialcode not Pattern
    @Test
    public void serialCodeNotPattern() {
        SerialCode code = new SerialCode();
        code.setSerialCode("หzหLดBSIC41t");
        code.setDetail("AOJSFOJSFOOPJPOSAJFP");

        try {
            entityManager.persist(code);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====serialCodeNotPattern====" + violations + "\n\n");
        }

    }

    // Serialcode > 12
    @Test
    public void serialCodeSizeMoreThan12() {
        SerialCode code = new SerialCode();
        code.setSerialCode("DE3vI8uarnCi651");
        code.setDetail("เอียดAJDGOEOGJDFASFSFASFJ");

        try {
            entityManager.persist(code);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====serialCodeSizeMoreThan12====" + violations + "\n\n");
        }
    }

    // Serialcode < 12
    @Test
    public void serialCodeSizeLessThan12() {
        SerialCode code = new SerialCode();
        code.setSerialCode("arnCi651");
        code.setDetail("เอียดAJDGOEOGJDFASFSFASFJ");

        try {
            entityManager.persist(code);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====serialCodeSizeLessThan12====" + violations + "\n\n");
        }
    }

    // // Serialcode Unique
    // @Test(expected=javax.persistence.PersistenceException.class)
    @Test
    public void serialCodeMustBeUnique() {
        SerialCode code1 = new SerialCode();
        code1.setSerialCode("BWCHOTV60qaK");
        code1.setDetail("เอียดAJDGOEOGJDFASFSFASFJ");

        SerialCode code2 = new SerialCode();
        code2.setSerialCode("BWCHOTV60qaK");
        code2.setDetail("เอียดAJDGOEOGJDFASFSFASFJ");

        try {
            entityManager.persist(code1);
            entityManager.flush();
            entityManager.persist(code2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException e) {
            System.out.println("\n\n=====SerialCodeMustBeUnique====" + e.getMessage() + "\n\n");
        }
    }

    // Detail not null
    @Test
    public void serialCodeDetailNotNull() {
        SerialCode code = new SerialCode();
        code.setSerialCode("HuftUY78Rytz");
        code.setDetail(null);
        try {
            entityManager.persist(code);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====serialCodeDetailNotNull====" + violations + "\n\n");
        }

    }

    // Detail < 10
    @Test
    public void serialCodeDetailSizeLessThan10() {
        SerialCode code = new SerialCode();
        code.setSerialCode("HuftUY78Rytz");
        code.setDetail("เอียด");
        try {
            entityManager.persist(code);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====serialCodeDetailSizeLessThan10====" + violations + "\n\n");
        }

    }

    // Detail > 300
    @Test
    public void serialCodeDetailSizeMoreThan300() {
        SerialCode code = new SerialCode();
        code.setSerialCode("HuftUY78Rytz");
        code.setDetail(
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        try {
            entityManager.persist(code);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====serialCodeDetailSizeMoreThan300====" + violations + "\n\n");
        }

    }

    // Correct
    @Test
    public void serialCodeCorrect() {
        SerialCode code = new SerialCode();
        code.setSerialCode("ZU8YTboR69CO");
        code.setDetail("รายละเอียดของรหัส");

        try {
            entityManager.persist(code);
            entityManager.flush();

            System.out.println("\n\n====serialCodeCorrect====\n\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

}