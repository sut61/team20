package team20.se61.sut.wongnai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StoreTests {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private NumberOfSeatRepository numberOfSeatRepository;
    @Autowired
    private PriceRangeRepository priceRangeRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private ProfilesRepository profilesRepository;
    @Autowired
    private DayOfWeekRepository dayOfWeekRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void StoreCorrect(){
        Store s = new Store();
        s.setName("TestStore");
        s.setBranch("Branch");
        s.setAdddress("adddress");
        s.setHint("hint");
        s.setProvince("province");
        s.setDistrict("district");
        s.setSubDistrict("subDistrict");
        s.setBuilding("building");
        s.setPhone("0810508699");
        s.setEmail("miw@gmail.com");
        s.setWebsite("website.com");
        s.setOpenTime(new Date());
        s.setCloseTime(new Date());
        s.setImage("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).jpg?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        try {
            entityManager.persist(s);
            entityManager.flush();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("StoreCorrect\n"+ "IsCorrect");
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
        catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("\n\n\n\n\n\n\n\n\n\n\n\nStoreCorrect\n " + violations + "\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }


    //-------------------------------------Name------------------------------------

    @Test
    public void testStoreNameCannotBeNull() {
        Store s = new Store();
        s.setName(null);
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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreNameCannotBeNull\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void testStoreNameSizeMustMoreThan2() {
        Store s = new Store();
        s.setName("A");
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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreNameSizeMustMoreThan2\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void testStoreNameSizeMustLessThan20() {
        Store s = new Store();
        s.setName("A123456789123456789123456789");
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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreNameSizeMustLessThan20\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-------------------------------------Branch------------------------------------

    @Test
    public void testStoreBranchSizeMustMoreThan2() {
        Store s = new Store();
        s.setName("ABC");
        s.setBranch("A");
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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreBranchSizeMustMoreThan2\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------Adddress-------------------------------------

    @Test
    public void testStoreAdddressCannotBeNull() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress(null);

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreAdddressCannotBeNull\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    @Test
    public void testStoreAdddressSizeMustMoreThan5() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("ASD");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreAdddressSizeMustMoreThan5\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }


    //-----------------------------------Hint-------------------------------------

    
    @Test
    public void testStoreHintSizeMustMoreThan2() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAA");
        s.setHint("S");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreHintSizeMustMoreThan2\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }


    //-----------------------------------Province-------------------------------------

    @Test
    public void testStoreProvinceSizeMustMoreThan2() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAA");
        s.setProvince("S");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreProvinceSizeMustMoreThan2\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------District-------------------------------------

    @Test
    public void testStoreDistrictSizeMustMoreThan2() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAA");
        s.setDistrict("S");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreDistrictSizeMustMoreThan2\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------SubDistrict-------------------------------------

    @Test
    public void testStoreSubDistrictSizeMustMoreThan2() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAA");
        s.setSubDistrict("S");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreSubDistrictSizeMustMoreThan2\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------Building-------------------------------------

    @Test
    public void testStoreBuildingSizeMustMoreThan2() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAA");
        s.setBuilding("S");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreBuildingSizeMustMoreThan2\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------Phone-------------------------------------

    @Test
    public void testStorePhoneSizeMustEqual10() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAA");
        s.setPhone("12346789");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStorePhoneSizeMustMoreThan10\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------Email-------------------------------------

    @Test
    public void testStoreEmailMustBeCorrect() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAA");
        s.setEmail("miw");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreEmailMustBeCorrect\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------Website-------------------------------------

    @Test
    public void testStoreWebsiteSizeMustMoreThan3() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAA");
        s.setWebsite("S");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreWebsiteSizeMustMoreThan3\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------DayOfWeek-------------------------------------
    @Test
    public void testStoreDayOfWeekCannotBeEmpty() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAAAAAAAAAAAAAA");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        s.setDayOfWeeks(null);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreAdddressCannotBeNull\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    
     //-----------------------------------Image-------------------------------------

    @Test
    public void testStoreImagePatternNotCorrect() {
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");
        s.setImage("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548775607617_Mario_(CGW).mp3?alt=media&token=f0dede82-4f84-4650-86b1-3519ef2426e1");

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

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreImagePatternNotCorrect\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------OpenTime-------------------------------------

    @Test
    public void testStoreOpenTimeCannotBeNull() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAAAAAAAAAAAAAA");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(null);
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreAdddressCannotBeNull\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------CloseTime-------------------------------------

    @Test
    public void testStoreCloseTimeCannotBeNull() {
        Store s = new Store();
        s.setName("AAAA");
        s.setAdddress("AAAAAAAAAAAAAAAAAA");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(null);

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreAdddressCannotBeNull\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }


    //-----------------------------------PriceRange in Store-------------------------------------

    @Test
    public void testStorePriceRangeCannotBeNull() {
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(null);
        s.setNumberOfSeat(entityManager.persist(new NumberOfSeat("มากกว่า 150 ที่นั้ง")));

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreImagePatternNotCorrect\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------NumberOfSeat in Store-------------------------------------

    @Test
    public void testStoreNumberOfSeatCannotBeNull() {
        Store s = new Store();
        s.setName("myStore");
        s.setAdddress("ABCDE");

        s.setPriceRange(entityManager.persist(new PriceRange("ต่ำกว่า 100 บาท")));
        s.setNumberOfSeat(null);

        s.setOpenTime(new Date());
        s.setCloseTime(new Date());

        DayOfWeek dof = new DayOfWeek("จันทร์");
        entityManager.persist(dof);
        entityManager.flush();

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        dayOfWeeks.add(dof);
        s.setDayOfWeeks(dayOfWeeks);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreImagePatternNotCorrect\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }


    //-----------------------------------PriceRange-------------------------------------

    @Test
    public void testPriceRangeCannotBeNull() {
        PriceRange p = new PriceRange();
        p.setRange(null);

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStorePriceRangeCannotBeNull\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //-----------------------------------NumberOfSeat-------------------------------------

    @Test
    public void testNumberOfSeatCannotBeNull() {
        NumberOfSeat n = new NumberOfSeat();
        n.setChoices(null);

        try {
            entityManager.persist(n);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------------------------------------");
            System.out.println("testStoreNumberOfSeatCannotBeNull\n"+ violations);
            System.out.println("----------------------------------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

}