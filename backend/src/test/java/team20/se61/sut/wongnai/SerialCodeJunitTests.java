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

import team20.se61.sut.wongnai.Entity.CodeCondition;
import team20.se61.sut.wongnai.Entity.SerialCode;
import team20.se61.sut.wongnai.Entity.Store;

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
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        SerialCode code = new SerialCode();
        code.setSerialCode(null);
        code.setDetail("รายละเอียดรายละเอียดรายละเอียดรายละเอียด");
        code.setCodeCondition(condition);

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
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        SerialCode code = new SerialCode();
        code.setSerialCode("หzหLดBSIC41t");
        code.setDetail("AOJSFOJSFOOPJPOSAJFP");
        code.setCodeCondition(condition);

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
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        SerialCode code = new SerialCode();
        code.setSerialCode("DE3vI8uarnCi651");
        code.setDetail("เอียดAJDGOEOGJDFASFSFASFJ");
        code.setCodeCondition(condition);

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
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        SerialCode code = new SerialCode();
        code.setSerialCode("arnCi651");
        code.setDetail("เอียดAJDGOEOGJDFASFSFASFJ");
        code.setCodeCondition(condition);

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
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        CodeCondition condition2 = new CodeCondition();
        condition2.setName("AAAAAAAAAAAAABBBB");
        condition2.setDetail("XXXXXXXXXXXXXXXXXXYYYY");
        entityManager.persist(condition2);
        entityManager.flush();

        SerialCode code1 = new SerialCode();
        code1.setSerialCode("BWCHOTV60qaK");
        code1.setDetail("เอียดAJDGOEOGJDFASFSFASFJ");
        code1.setCodeCondition(condition);

        SerialCode code2 = new SerialCode();
        code2.setSerialCode("BWCHOTV60qaK");
        code2.setDetail("เอียดAJDGOEOGJDFASFSFASFJ");
        code2.setCodeCondition(condition2);

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
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        SerialCode code = new SerialCode();
        code.setSerialCode("HuftUY78Rytz");
        code.setDetail(null);
        code.setCodeCondition(condition);

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
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        SerialCode code = new SerialCode();
        code.setSerialCode("HuftUY78Rytz");
        code.setDetail("เอียด");
        code.setCodeCondition(condition);

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
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        SerialCode code = new SerialCode();
        code.setSerialCode("HuftUY78Rytz");
        code.setDetail(
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        code.setCodeCondition(condition);

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

    // Serialcode condition not null
    @Test
    public void serialCodeConditionNotNull() {
        SerialCode code = new SerialCode();
        code.setSerialCode("HuftUY78Rytz");
        code.setDetail("AMGPOJDPOGAJPOSJPO:SJMGPOSJMG");
        code.setCodeCondition(null);

        try {
            entityManager.persist(code);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====serialCodeConditionNotNull====" + violations + "\n\n");
        }

    }

    // Correct
    @Test
    public void serialCodeCorrect() {
        CodeCondition condition = new CodeCondition();
        condition.setName("AAAAAAAAAAAAAAAAA");
        condition.setDetail("XXXXXXXXXXXXXXXXXXXXXX");
        entityManager.persist(condition);
        entityManager.flush();

        SerialCode code = new SerialCode();
        code.setSerialCode("ZU8YTboR69CO");
        code.setDetail("รายละเอียดของรหัส");
        code.setCodeCondition(condition);

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

    // CodeCondition Name Not null
    @Test
    public void codeConditionNameNotNull() {
        CodeCondition condition = new CodeCondition();
        condition.setName(null);
        condition.setDetail("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        try {
            entityManager.persist(condition);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====CodeConditionNameNotNull====" + violations + "\n\n");
        }

    }

    // CodeCondition Name Not Pattern
    @Test
    public void codeConditionNameNotPattern() {
        CodeCondition condition = new CodeCondition();
        condition.setName("!$#^$ASDGPIDSGHPIO");
        condition.setDetail("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        try {
            entityManager.persist(condition);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====CodeConditionNameNotPattern====" + violations + "\n\n");
        }

    }

    // CodeCondition Detail Not null
    @Test
    public void codeConditionDetailNotNull() {
        CodeCondition condition = new CodeCondition();
        condition.setName("บัตรส่วนลด 50 บาท");
        condition.setDetail(null);

        try {
            entityManager.persist(condition);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====CodeConditionDetailNotNull====" + violations + "\n\n");
        }

    }

    // CodeCondition Detail Not Pattern
    @Test
    public void codeConditionDetailNotPattern() {
        CodeCondition condition = new CodeCondition();
        condition.setName("บัตรส่วนลด 50 บาท");
        condition.setDetail("!$#^$ASDGPIDSGHPIO");

        try {
            entityManager.persist(condition);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n=====CodeConditionDetailNotPattern====" + violations + "\n\n");
        }

    }

    // Code condition Correct
    @Test
    public void codeConditionCorrect() {
        CodeCondition condition = new CodeCondition();
        condition.setName("บัตรส่วนลด 50 บาท");
        condition.setDetail("JGPOQJEPGOJDPOJ");

        try {
            entityManager.persist(condition);
            entityManager.flush();

            System.out.println("\n\n====CodeConditionCorrect====\n\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }
}