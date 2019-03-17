package eu.justtheengineer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
Tests provide:
    - documentation of code -> by looking at tests you can easily figure out what some method is supposed to do
    - catching of future errors -> if you test for every eventuality, you won't be surprised when one of those happens
    - long-term time savings -> because we catch errors before we deploy
    - a way to write good code -> you can't easily write a test for bad code, so by writing the test first...
    - ...
*/

public class CalculatorTest {
    Calculator calculator;

    // As you probably guesses, anything that happens in this method happens
    // before the tests are actually carried out, thanks to the @Before annotation.
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    // The @Test annotation marks this method as a test method.
    @Test
    public void add() {
        // calculate the result, then give the same numbers to the function
        int result = 2 + (-3) + 5 + (-7) + 11; // result of addition is: 8
        // Compare that to what the add method gives us...
        assertEquals(result, calculator.add(2, -3, 5, -7, 11));

        result = 100 - 100;
        assertEquals(result, calculator.add(100, -100));

        result = 0;
        assertEquals(result, calculator.add(0));
    }

    @Test
    public void subtract() {
        int result = 2 - (-3) - 5 - (-7) - 11; // result of subtraction is: -4

        // Compare that to what the add method gives us...
        assertEquals(result, calculator.subtract(2, -3, 5, -7, 11));

        result = 100 - 100;
        assertEquals(result, calculator.subtract(100, 100));

        result = 0;
        assertEquals(result, calculator.subtract(0));
    }

    @Test
    public void multiply() {
        int result = 2 * (-3) * 5 * (-7) * 11; // result of multiplication is: 2310

        // Compare that to what the add method gives us...
        assertEquals(result, calculator.multiply(2, -3, 5, -7, 11));

        result = 100 * 100;
        assertEquals(result, calculator.multiply(100, 100));

        result = 0;
        assertEquals(result, calculator.multiply(0));
    }

    @Test
    public void divide() {
        double result = 2.0 / (-3.0) / 5.0  / (-7.0) / 11.0; // result of division is: 0.0017316017316017314

        /*
        For doubles, and floating point numbers in general, we have the following assert:

            assertEquals(expected value, returned value, delta value);

        The delta value is the "error" or "uncertainty" allowed in the comparison.
        Comparing floating point numbers is tricky, exact equality is hard to come by in many cases.
        It's quite common for the delta to be much smaller than the actual values!

        Delta is the maximum allowed absolute difference between actual and expected value.
        So the test is basically:

            if (Math.absolute(expected - actual) > delta) { fail }
        */

        // Compare that to what the add method gives us...
        assertEquals(result, calculator.divide(2, -3, 5, -7, 11), 0.0000001);

        result = 0;
        assertEquals(result, calculator.divide(0), 0.0000001);

        result = 0;
        assertEquals(result, calculator.divide(0, 2, -3, 5, -7, 11), 0.0000001);
    }

    // The method should throw an IllegalArgumentException if we try to divide by zero!
    // So we add that to the @Test annotation by stating that what we expect is an IllegalArgumentException.
    @Test(expected = IllegalArgumentException.class)
    public void divideByZero() {
        calculator.divide(100, 0);
    }
}
