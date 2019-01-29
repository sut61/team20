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
//@SpringBootTest
@DataJpaTest
public class WongnaiApplicationTests {

	@Autowired private RecipeRespository recipeRespository;
	@Autowired private CookingMethodRespository cookingMethodRespository;
	@Autowired private FoodTypeRespository foodTypeRespository;
	@Autowired private MainIngredRespository mainIngredRespository;
	@Autowired private ProfilesRepository profilesRepository;

	@Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	/*@Test Recipe /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	@Test   
	public void NameNull() {
       	Recipe testmenu = new 	Recipe();
		testmenu.setName(null);
        testmenu.setHowto("howto");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}
	
	@Test   
	public void ToolongHowto() {
		String howto = new String();
		for(int i=0 ;i<1502;i++){
			howto = howto+"X";
		}

       	Recipe testmenu = new 	Recipe();
		testmenu.setName("กระเพา");
        testmenu.setHowto(howto);
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}
	
	@Test   
	public void NotpettrenURL() {
		

       	Recipe testmenu = new 	Recipe();
		testmenu.setName("กระเพา");
        testmenu.setHowto("ผัด");
       	testmenu.setUrlPhoto ("ttps://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(testmenu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}
	
	@Test   
	public void Correct() {
		
       	Recipe testmenu = new Recipe();
		testmenu.setName("กระเพา");
        testmenu.setHowto("ผัด");
       	testmenu.setUrlPhoto ("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
       
            entityManager.persist(testmenu);
            entityManager.flush();

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// test ReportProblem
	@Test
    public void titleNull() {
        ReportProblem report = new ReportProblem();
        report.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        report.setTitle(null);
        report.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(report);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void imgUrlnotPattern() {
        ReportProblem report = new ReportProblem();
        report.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        report.setTitle("ต้องการสร้างเมนู ใน LINEMAN ทำอย่างไรครับ");
        report.setImgUrl("firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(report);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void detailSize() {
        ReportProblem report = new ReportProblem();
        report.setDetail("กก");
        report.setTitle("ต้องการสร้างเมนู ใน LINEMAN ทำอย่างไรครับ");
        report.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        try {
            entityManager.persist(report);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void reportCorrect() {
        ReportProblem report = new ReportProblem();
        report.setDetail("กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        report.setTitle("ต้องการสร้างเมนู ใน LINEMAN ทำอย่างไรครับ");
        report.setImgUrl("https://firebasestorage.googleapis.com/v0/b/uppictest.appspot.com/o/test%2F1548763100004_690650.jpg?alt=media&token=61e2258f-479a-43d1-b5f");
        entityManager.persist(report);
        entityManager.flush();
	}
	//-----------------------------------------------------------------------------------
}

