import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;

public class CalculatorJUNITTest {
    public Calculator calculator;

    @BeforeEach()
    public void setup(){
        calculator = new Calculator();
    }

    //addition

    @Test
    public void additionWithPositiveOperandsTest(){
        Assertions.assertEquals(43.5,calculator.compute(12,31.5,"+"),"Addition with positive operands failed");
    }
    @Test
    public void additionWithNegativeOperandsTest(){
        Assertions.assertEquals(-802.4,calculator.compute(-234.5,-567.9,"+"),"Addition with negative operands failed.");
    }

    @Test
    public void additionWithOneNegativeOperandTest(){
        Assertions.assertEquals(15,calculator.compute(-27,42,"+"),"Addition with one negative operand failed.");
    }

    @Test
    public void additionWithSmallValuesTest() {
        Assertions.assertEquals(97e-10, calculator.compute(66e-10, 31e-10, "+"), 1e-15, "Addition with two small values failed.");
    }
    @Test
    public void additionWithZeroTest(){
        Assertions.assertEquals(34.56,calculator.compute(0,34.56,"+"),"Addition with 0 failed.");
    }

    @Test
    public void additionWithDoubleMaxValueTest(){
        Assertions.assertEquals(Double.MAX_VALUE,calculator.compute(Double.MAX_VALUE,20,"+"),"Addition with DOUBLE MAX VALUE failed.");
    }

    @Test
    public void additionWithDoubleMinValueTest() {
        Assertions.assertEquals(1.0000000000000002, calculator.compute(1.0, Double.MIN_VALUE, "+"), 1e-15, "Addition with DOUBLE MIN VALUE failed.");
    }

    //subtraction

    @Test
    public void subtractionWithPositiveOperandsTest(){
        Assertions.assertEquals(36,calculator.compute(56,20,"-"),"Subtraction with positive operands failed.");

    }
    @Test
    public void subtractionWithNegativeOperandsTest(){
        Assertions.assertEquals(-13.300000000000004,calculator.compute(-76.4,-63.1,"-"),"Subtraction with negative operands failed");

    }

    @Test
    public void subtractionWithFirstNegativeOperand(){
        Assertions.assertEquals(-1199.9,calculator.compute(-875.4,324.5,"-"),"Subtraction failed when the first operand is negative.");

    }

    @Test
    public void subtractionWithSecondNegativeOperand(){
        Assertions.assertEquals(1199.9,calculator.compute(324.5,-875.4,"-"),"Subtraction failed when the second operand is negative.");

    }

    @Test
    public void subtractionWithZeroAsFirstOperand() {
        Assertions.assertEquals(-345, calculator.compute(0, 345, "-"), "Subtraction with zero as the first operand failed.");
    }

    @Test
    public void subtractionWithZeroAsSecondOperand() {
        Assertions.assertEquals(345, calculator.compute(345, 0, "-"), "Subtraction with zero as the second operand failed.");
    }

    @Test
    public void subtractionWithDoubleMaxValueTest() {
        Assertions.assertEquals(Double.MAX_VALUE - 20, calculator.compute(Double.MAX_VALUE, 20, "-"), "Subtraction with DOUBLE MAX VALUE failed.");
    }

    @Test
    public void subtractionWithDoubleMinValueTest() {
        Assertions.assertEquals(1.0 - Double.MIN_VALUE, calculator.compute(1.0, Double.MIN_VALUE, "-"), 1e-15, "Subtraction with DOUBLE MIN VALUE failed.");
    }

    //multiply
    @Test
    public void multiplyByPositiveOperandsTest(){
        Assertions.assertEquals(153.4,calculator.compute(15.34,10,"*"),"Multiply by positive operands failed");
    }

    @Test
    public void multiplyByNegativeOperandsFailedTest(){
        Assertions.assertEquals(72.207,calculator.compute(-10.65,-6.78,"*"),1e-3,"Multiply by negative operands failed");
    }

    @Test
    public void multiplyByANegativeOperandTest(){
        Assertions.assertEquals(-30,calculator.compute(15,-2,"*"),"Multiply by a negative operand failed");

    }

    @Test
    public void multiplyByASmallNumberTest(){
        Assertions.assertEquals(0.0017845,calculator.compute(178.45,1e-5,"*"),1e-6,"Multiply by a small number failed");
    }

    @Test
    public void multiplyByZeroTest(){
        Assertions.assertEquals(0,calculator.compute(0,10,"*"),"Multiply by 0 failed");
    }

    @Test
    public void multiplyByDoubleMaxValueTest(){
        Assertions.assertEquals(POSITIVE_INFINITY,calculator.compute(Double.MAX_VALUE,14,"*"),"Multiply by DOUBLE MAX VALUE failed");
    }

    //division
    @Test
    public void divisionByPositiveOperandsTest(){
        Assertions.assertEquals(32.09489361702128,calculator.compute(754.23,23.5,"/"),"Division by positive operands failed.");
    }

    @Test
    public void divisionByNegativeOperandsTest(){
        Assertions.assertEquals(1.570796460176991,calculator.compute(-10.65,-6.78,"/"),"Division by negative operands failed.");
    }

    @Test
    public void divisionByOneNegativeOperandTest(){
        Assertions.assertEquals(-3.5,calculator.compute(7,-2,"/"),"Division by negative operand failed.");
    }
    @Test
    public void divisionBySmallNumberTest(){
        Assertions.assertEquals(1533999.9999999998,calculator.compute(15.34,1e-5,"/"),0.000001);
    }

    @Test
    public void divisionByZeroTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.compute(5, 0, "/");
        });
        Assertions.assertEquals("Divide by ZERO", exception.getMessage());
    }


    //square root
    @Test
    public void sqrtOfPerfectSquareTest(){
        Assertions.assertEquals(Math.sqrt(64),calculator.compute(64,0,"SQRT"),"Square root of a perfect square failed");
    }

    @Test
    public void sqrtOfNonPerfectSquareTest() {
        Assertions.assertEquals(Math.sqrt(10.45), calculator.compute(10.45, 0, "SQRT"), 0.000001,"Square root of a non-perfect square failed");
    }

    @Test
    public void sqrtOfNegativeNumber(){
        Assertions.assertEquals(NaN,calculator.compute(-64,0,"SQRT"),"Expected NaN for square root of a negative number.");
    }


}
