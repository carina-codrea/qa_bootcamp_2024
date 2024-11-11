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

    //assignment tests

    @Test
    public void additionWithNegativeOperandTest(){
        Assertions.assertEquals(15,calculator.compute(-27,42,"+"),"Addition with negative operand failed.");
    }

    @Test
    public void additionWithNegativeOperandsTest(){
        Assertions.assertEquals(-802.4,calculator.compute(-234.5,-567.9,"+"),"Addition with negative operands failed.");
    }

    @Test
    public void additionWithDoubleMaxValueTest(){
        Assertions.assertEquals(Double.MAX_VALUE,calculator.compute(Double.MAX_VALUE,20,"+"),"Addition with DOUBLE MAX VALUE failed.");
    }

    @Test
    public void subtractionWithNegativeOperandsTest(){
        Assertions.assertEquals(-13.300000000000004,calculator.compute(-76.4,-63.1,"-"),"Subtraction with negative operands failed");

    }

    @Test
    public void subtractionWithPositiveOperandsTest(){
        Assertions.assertEquals(36,calculator.compute(56,20,"-"),"Subtraction with positive operands failed.");

    }

    @Test
    public void divisionByNegativeOperandTest(){
        Assertions.assertEquals(-3.5,calculator.compute(7,-2,"/"),"Division by negative operand failed.");
    }

    @Test
    public void divisionByNegativeOperandsTest(){
        Assertions.assertEquals(1.570796460176991,calculator.compute(-10.65,-6.78,"/"),"Division by negative operands failed.");
    }

    @Test
    public void divisionByPositiveOperandsTest(){
        Assertions.assertEquals(32.09489361702128,calculator.compute(754.23,23.5,"/"),"Division by positive operands failed.");
    }

    @Test
    public void divisionBySmallNumberTest(){
        Assertions.assertEquals(1533999.9999999998,calculator.compute(15.34,1e-5,"/"));
    }

    @Test
    public void sqrtOfNegativeNumber(){
        Assertions.assertEquals(NaN,calculator.compute(-64,0,"SQRT"));
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
