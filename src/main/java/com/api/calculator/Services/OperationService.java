package com.api.calculator.Services;

import com.api.calculator.Models.Operation;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    public Double calc_result(Operation operation) throws Exception {

        Double result;

        String operator = operation.getOperator();
        Double first_operand = operation.getOperands()[0];
        Double second_operand = operation.getOperands()[1];

        switch (operator) {
            case "sum" -> result = add(first_operand, second_operand);
            case "sub" -> result = sub(first_operand, second_operand);
            case "div" -> result = div(first_operand, second_operand);
            case "multi" -> result = multi(first_operand, second_operand);
            default -> throw new IllegalArgumentException("Unsupported operator: " + operator);
        }

        return result;
    }

    public Double add (Double x, Double y) {
        return x + y;
    }

    public Double sub (Double x, Double y) {
        return x - y;
    }

    public Double div (Double x, Double y) throws Exception {
        try {
            return x/y;
        }
        catch (ArithmeticException e) {
            throw (new Exception("Cannot divide by 0"));
        }
    }

    public Double multi (Double x, Double y) {
        return x * y;
    }
}
