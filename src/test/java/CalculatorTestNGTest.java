import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;

public class CalculatorTestNGTest {
    public Calculator calculator;
    @BeforeMethod
    public void setup(){
        calculator = new Calculator();
    }

    @Test(dataProvider = "additionData")
    public void additionTest(double operand1,double operand2, String operator,double expected,double delta ,String errorMessage){
        Assert.assertEquals(calculator.compute(operand1,operand2,operator),expected,delta,errorMessage);
    }

    @Test(dataProvider = "subtractionData")
    public void subtractionTest(double operand1,double operand2, String operator,double expected,double delta ,String errorMessage){
        Assert.assertEquals(calculator.compute(operand1,operand2,operator),expected,delta,errorMessage);
    }

   @Test(dataProvider = "multiplyData")
    public void multiplyTest(double operand1,double operand2, String operator,double expected,double delta ,String errorMessage){
        Assert.assertEquals(calculator.compute(operand1,operand2,operator),expected,delta,errorMessage);
    }

    @Test(dataProvider = "divideData")
    public void divideTest(double operand1, double operand2, String operator, double expected, double delta, String errorMessage) {
        Assert.assertEquals(calculator.compute(operand1, operand2, operator), expected, delta, errorMessage);
    }

    @Test
    public void divideByZeroTest() {
        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class, () -> {
            calculator.compute(5, 0, "/");
        });
        Assert.assertEquals(exception.getMessage(), "Divide by ZERO");
    }
    @Test(dataProvider = "sqrtData")
    public void sqrtTest(double operand1, double operand2, String operator, double expected, double delta, String errorMessage) {
        Assert.assertEquals(calculator.compute(operand1, operand2, operator), expected, delta, errorMessage);
    }


    @DataProvider
    public Object[][] additionData(){
        return new Object[][] {
                { 12, 31.5, "+", 43.5,0, "Addition with positive operands failed" },
                { -234.5, -567.9, "+", -802.4, 0, "Addition with negative operands failed"},
                { -27, 42, "+", 15, 0, "Addition with a negative operand failed" },
                { 66e-10, 31e-10, "+", 97e-10, 1e-15, "Addition with two small values failed" },
                { 0, 34.56, "+",34.56, 0, "Addition with 0 failed." },
                { Double.MAX_VALUE, 20, "+", Double.MAX_VALUE, 0, "Addition with DOUBLE MAX VALUE failed"},
                { 1.0, Double.MIN_VALUE, "+", 1.0000000000000002, 1e-15, "Addition with DOUBLE MIN VALUE failed" }

        };
    }

    @DataProvider
    public Object[][] subtractionData() {
        return new Object[][] {
                { 56, 20, "-", 36, 0, "Subtraction with positive operands failed" },
                { -76.4, -63.1, "-", -13.300000000000004, 0, "Subtraction with negative operands failed" },
                { -875.4, 324.5, "-", -1199.9, 0, "Subtraction failed when the first operand is negative" },
                { 324.5, -875.4, "-", 1199.9, 0, "Subtraction failed when the second operand is negative" },
                { 0, 345, "-", -345, 0, "Subtraction with zero as the first operand failed" },
                { 345, 0, "-", 345, 0, "Subtraction with zero as the second operand failed" },
                { Double.MAX_VALUE, 20, "-", Double.MAX_VALUE - 20, 0, "Subtraction with DOUBLE MAX VALUE failed" },
                { 1.0, Double.MIN_VALUE, "-", 1.0 - Double.MIN_VALUE, 1e-15, "Subtraction with DOUBLE MIN VALUE failed" }
        };
    }

    @DataProvider
    public Object[][] multiplyData() {
        return new Object[][] {
                { 15.34, 10, "*", 153.4, 0, "Multiply by positive operands failed" },
                { -10.65, -6.78, "*",72.207 , 1e-3, "Multiply by negative operands failed" },
                { 15, -2, "*", -30, 0, "Multiply by a negative operand failed" },
                { 178.45, 1e-5, "*", 0.0017845, 1e-6, "Multiply by a small number failed" },
                { 0, 10, "*", 0, 0, "Multiply by 0 failed" },
                { Double.MAX_VALUE, 14, "*", POSITIVE_INFINITY,0 , "Multiply by DOUBLE MAX VALUE failed"},
        };
    }

    @DataProvider
    public Object[][] divideData() {
        return new Object[][] {
                { 754.23, 23.5, "/", 32.09489361702128, 0, "Division by positive operands failed" },
                { -10.65, -6.78, "/", 1.570796460176991, 0, "Division by negative operands failed" },
                { 7, -2, "/", -3.5, 0, "Division by a negative operand failed" },
                { 15.34, 1e-5, "/", 1533999.9999999998, 0.000001, "Division by a small number failed" },

        };
    }


    @DataProvider(name = "sqrtData")
    public Object[][] sqrtData() {
        return new Object[][] {
                { 64, 0, "SQRT", Math.sqrt(64), 0, "Square root of a perfect square failed" },
                { 10.45, 0, "SQRT", Math.sqrt(10.45), 0.000001, "Square root of a non-perfect square failed" },
                { -64, 0, "SQRT", NaN, 0, "Square root of a negative number failed" }
        };
    }


}
