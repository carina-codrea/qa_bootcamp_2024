import org.junit.jupiter.api.*;

import static java.lang.Double.NaN;

public class CalculatorTest {
    public Calculator calculator;

    @BeforeAll
    public static void classSetup(){
        System.out.println("Preparing all the tests");

    }

    @BeforeEach()
    public void setup(){
        calculator = new Calculator();
    }


    @Test
    public void additionTest01(){
        double result = calculator.compute(4,6,"+");

        Assertions.assertEquals(10,result,"Addition failed");
    }
    @Test
    public void additionTest02(){
        Assertions.assertEquals(15,calculator.compute(10,5,"+"),"Addition failed");
    }



    @Test
    public void subtractionTest(){
        Assertions.assertEquals(10,calculator.compute(5,-5,"-"));

    }

    @Test
    public void invalidOperatorTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.compute(5, 7, "abc");
        });
        Assertions.assertEquals("UNSUPPORTED OPERATOR: abc", exception.getMessage());
    }

    @Test
    public void divisionByZeroTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.compute(5, 0, "/");
        });
        Assertions.assertEquals("Divide by ZERO", exception.getMessage());
    }

    @Test
    public void multiplyTest(){
        Assertions.assertEquals(14,calculator.compute(7,2,"*"),"Multiplication failed");
    }

    @Test
    public void sqrtTest01(){
        Assertions.assertEquals(8,calculator.compute(64,0,"SQRT"));
    }
    @Test
    public void sqrtTest02(){
        double result = calculator.compute(2,0,"SQRT");
        Assertions.assertEquals(Math.sqrt(2),calculator.compute(2,0,"SQRT"));
    }



    @AfterEach
    public void cleanTest(){
        System.out.println("cleaning tests...");
    }
    @AfterAll
    public static void cleanClass(){
        System.out.println("clean class");
    }


}
