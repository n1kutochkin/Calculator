package ru.n1kutochkin;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    static final byte FIRST_MEMBER = 1;
    static final byte SECOND_MEMBER = 6;
    static final byte OPERATION = 5;
    //TODO Проверяй регулярное выражение - не работает с римскими цифрами
    static String pattern = "((?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})|\\d{1,2})(\\+|\\-|\\/|\\*)((?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})|\\d{1,2})";
    static Pattern universalPattern = Pattern.compile(pattern);
    private String expression;
    private Optional<Expression> result = Optional.empty();

    public Parser(String expression) {
        this.expression = expression;
        this.makeExpression();
    }

    public Optional<Expression> getResult() {
        return result;
    }

    private void makeExpression() {
        StringBuffer buffer = new StringBuffer(expression);
        Matcher matcher = universalPattern.matcher(buffer);

        matcher.find();

        result = Optional.of(new Expression());

        try {
            result.get().setFstMember(Integer.parseInt(matcher.group(FIRST_MEMBER)));
        } catch (NumberFormatException e) {
            try {
                result.get().setFstMember(romanToArabic(matcher.group(FIRST_MEMBER)));

            } catch (IllegalArgumentException ex) {
                throw ex;
            }
        }

        try {
            result.get().setSndMember(Integer.parseInt(matcher.group(SECOND_MEMBER)));
        } catch (NumberFormatException e) {
            try {
                result.get().setSndMember(romanToArabic(matcher.group(SECOND_MEMBER)));
            } catch (IllegalArgumentException ex) {
                throw ex;
            }
        }

        switch (matcher.group(OPERATION)) {
            case "+":
                result.get().setOperation(Operation.Addition);
                break;
            case "-":
                result.get().setOperation(Operation.Substraction);
                break;
            case "*":
                result.get().setOperation(Operation.Multiplication);
                break;
            case "\\":
                result.get().setOperation(Operation.Division);
                break;
            default:
                throw new InputMismatchException("Нет знака в выражении");
        }
    }

    private static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public Expression get() {
        return null;
    }

}
