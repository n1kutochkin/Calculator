package ru.n1kutochkin;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    static final byte FIRST_MEMBER = 1;
    static final byte SECOND_MEMBER = 7;
    static final byte OPERATION = 6;
    // TODO: 15.07.2020 исправить обработку дробей 
    static String pattern = "((?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})|([0-9]+[.[0-9]+]?))\\s(\\+|\\-|\\/|\\*)\\s((?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})|([0-9]+[.[0-9]+]?))";
    static Pattern universalPattern = Pattern.compile(pattern);
    private String expression;
    private Optional<Expression> result = Optional.empty();

    public Parser(String expression) throws Exception{
        this.expression = expression;
        this.makeExpression();
    }

    public Optional<Expression> getResult() {
        return result;
    }

    private void makeExpression() throws Exception {
        StringBuffer buffer = new StringBuffer(expression);
        Matcher matcher = universalPattern.matcher(buffer);

        matcher.find();

        result = Optional.of(new Expression());

        try {
            result.get().setFstMember(Integer.parseInt(matcher.group(FIRST_MEMBER)));
        } catch (NumberFormatException | IllegalStateException e) {
            try {
                result.get().setFstMember(new RomanNumber(matcher.group(FIRST_MEMBER)));
            } catch (IllegalArgumentException | IllegalStateException ex) {
                throw ex;
            }
        }

        try {
            result.get().setSndMember(Integer.parseInt(matcher.group(SECOND_MEMBER)));
        } catch (NumberFormatException | IllegalStateException e) {
            try {
                result.get().setSndMember(new RomanNumber(matcher.group(SECOND_MEMBER)));
            } catch (IllegalArgumentException | IllegalStateException ex) {
                throw ex;
            }
        }

        if (!Boolean.logicalXor(result.get().isFstNumberIsRoman(), result.get().isSndNumberIsRoman())) {
            switch (matcher.group(OPERATION)) {
                case "+":
                    result.get().setOperation(Operation.Addition);
                    break;
                case "-":
                    result.get().setOperation(Operation.Subtraction);
                    break;
                case "*":
                    result.get().setOperation(Operation.Multiplication);
                    break;
                case "/":
                    result.get().setOperation(Operation.Division);
                    break;
                default:
                    throw new InputMismatchException("Нет знака в выражении");
            }
        } else {
            throw new Exception("Нельзя использовать однговременно и арабские, и римские цифры");
        }


    }

    public Expression get() {
        return null;
    }

}
