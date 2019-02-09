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

import team20.se61.sut.wongnai.Entity.AdvertisePackage;
import team20.se61.sut.wongnai.Entity.ShopAdvertise;

import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
// @SpringBootTest
@DataJpaTest
public class ShopAdvertiseJunitTests {

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void adverticeNameNotNull() {
        ShopAdvertise advertise = new ShopAdvertise();
        advertise.setDetail(
                "กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        advertise.setName(null);
        advertise.setImgUrl(
                "https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        advertise.setAdvertisePackage(entityManager.persist(new AdvertisePackage("cccc", 555D)));
        try {
            entityManager.persist(advertise);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nadverticeNameNotnull\n" + violations);
        }
    }

    @Test
    public void adverticeDetailSizeLessthan10() {
        ShopAdvertise advertise = new ShopAdvertise();
        advertise.setDetail("กก");
        advertise.setName("ร้านอร่อยแถวข้างมทส.");
        advertise.setImgUrl(
                "https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        advertise.setAdvertisePackage(entityManager.persist(new AdvertisePackage("cccc", 555D)));
        try {
            entityManager.persist(advertise);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ndetail size<10 \n" + violations);
        }
    }

    @Test
    public void adverticeDetailSizeMorethan100() {
        ShopAdvertise advertise = new ShopAdvertise();
        String detail = "";
        for (int i = 0; i < 200; i++)
            detail += "ก";
        advertise.setDetail(detail);
        advertise.setName("ร้านอร่อยแถวข้างมทส.");
        advertise.setImgUrl(
                "https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        advertise.setAdvertisePackage(entityManager.persist(new AdvertisePackage("cccc", 555D)));
        try {
            entityManager.persist(advertise);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\ndetail size>100\n" + violations);
        }
    }

    @Test
    public void adverticeImgUrlNotPattern() {
        ShopAdvertise advertise = new ShopAdvertise();
        advertise.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        advertise.setName("ร้านอร่อยแถวข้างมทส.");
        advertise.setImgUrl(
                "firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        advertise.setAdvertisePackage(entityManager.persist(new AdvertisePackage("cccc", 555D)));
        try {
            entityManager.persist(advertise);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nNotPatternImgUrl\n" + violations);
        }
    }

    @Test
    public void AdvertiseCorrect() {
        ShopAdvertise advertise = new ShopAdvertise();
        advertise.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        advertise.setName("ร้านอร่อยแถวข้างมทส.");
        advertise.setImgUrl(
                "https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        advertise.setAdvertisePackage(entityManager.persist(new AdvertisePackage("cccc", 555D)));
        try {
            entityManager.persist(advertise);
            entityManager.flush();
            System.out.println("\n\n\n\nCorrect");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    public void adverticeNameMustBeUnique() {
        ShopAdvertise advertise1 = new ShopAdvertise();
        advertise1.setName("ร้านอร่อยแถวข้างมทส.");
        advertise1.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        advertise1.setImgUrl(
                "https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        advertise1.setAdvertisePackage(entityManager.persist(new AdvertisePackage("dddd", 123D)));
        entityManager.persist(advertise1);
        entityManager.flush();

        ShopAdvertise advertise2 = new ShopAdvertise();
        advertise2.setName("ร้านอร่อยแถวข้างมทส.");
        advertise2.setDetail(
                "ขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขข");
        advertise2.setImgUrl(
                "https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1549691319284_45719062_1973101272737218_7465896570660061184_n.jpg?alt=media&token=b85b0f7e-248c-4bdd-8def-2299e7a15bbb");
        advertise2.setAdvertisePackage(entityManager.persist(new AdvertisePackage("cccc", 555D)));
        try {
            entityManager.persist(advertise2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("\n\n\n\nadverticeNameMustBeUnique\n" + e);
        }
    }

    @Test
    public void advertisePackageNull() {
        ShopAdvertise advertise = new ShopAdvertise();
        advertise.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        advertise.setName("ร้านอร่อยแถวข้างมทส.");
        advertise.setImgUrl(
                "https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        advertise.setAdvertisePackage(null);
        try {
            entityManager.persist(advertise);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\npackagesNull\n" + violations);
        }
    }

    @Test
    public void packageNameNull() {
        AdvertisePackage p1 = new AdvertisePackage(null, 154D);
        try {
            entityManager.persist(p1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nAdvertisePackageNameNull\n" + violations);
        }
    }

    @Test
    public void packagePriceNull() {
        AdvertisePackage p1 = new AdvertisePackage("กกกกก",null); 
        try {
            entityManager.persist(p1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nAdvertisePackagePriceNull\n" + violations);
        }
    }

    @Test
    public void AdvertisePackageMustBeUnique() {
        AdvertisePackage p1 = new AdvertisePackage("กกกกก",125D); 
        entityManager.persist(p1);
        entityManager.flush();

        AdvertisePackage p2 = new AdvertisePackage("กกกกก",550D); 
        try {
            entityManager.persist(p2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("\n\n\n\n\nAdvertisePackageNameMustBeUnique\n" + e);
        }
    }

    @Test
    public void packageCorrect() {
        AdvertisePackage p1 = new AdvertisePackage("กกกก",154D); 
        try {
            entityManager.persist(p1);
            entityManager.flush();
            System.out.println("\n\n\n\npackageCorrect\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    public void adverticeNameNotPattern() {
        ShopAdvertise advertise = new ShopAdvertise();
        advertise.setDetail(
                "กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        advertise.setName("@#$SSGDGBX");
        advertise.setImgUrl(
                "https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        advertise.setAdvertisePackage(entityManager.persist(new AdvertisePackage("cccc", 555D)));
        try {
            entityManager.persist(advertise);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\nadverticeNameNotPattern\n" + violations);
        }
    }

}