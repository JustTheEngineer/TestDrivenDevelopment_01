package eu.justtheengineer;

/*
You need to write your tests first!
The reason for that is that you need to see that your tests can fail. If you make a mistake, and your test always
passes, then you'll never catch any errors with it. So write minimal code, then write the test for it,
run it so it fails, then write your code, run the test again to see it pass.
*/

public class Calculator {
    public int add(int ... operands){
        // returns operands[0] + operands[1] + operands[2] + ... + operands[n]
        int result = 0;

        for(int number : operands){
            result += number;
        }

        return result;
    }
    
    public int subtract(int ... operands){
        // returns operands[0] - operands[1] - operands[2] - ... - operands[n]
        int result = operands[0];

        for(int i= 1; i < operands.length; i++){
            result -= operands[i];
        }

        return result;
    }
    
    public int multiply(int ... operands){
        // returns operands[0] * operands[1] * operands[2] * ... * operands[n]
        int result = 1;

        for(int number : operands){
            result *= number;
        }

        return result;
    }
    
    public double divide(int ... operands){
        // returns ((...((operands[0] / operands[1]) / operands[2]) /) ... )/ operands[n])
        // or the same result without the brackets :-)
        double result = (double)operands[0];

        for(int i= 1; i < operands.length; i++){
            if(operands[i] == 0){
                throw new IllegalArgumentException("Can't divide by zero!");
            }
            result /= (double)operands[i];
        }

        return result;
    }
}
