package ru.n1kutochkin;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    static final byte FIRST_MEMBER = 1;
    static final byte SECOND_MEMBER = 6;
    static final byte OPERATION = 5;
    static String pattern = "((?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})|\\d{1,2})(\\+|\\-|\\/|\\*)((?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})|\\d{1,2})";
    static Pattern universalPattern = Pattern.compile(pattern);
    private String expression = null;
    private Optional<Expression> result = Optional.empty();

    public Parser(String expression) {

    }

    private void makeExpression() {
        StringBuffer buffer = new StringBuffer(expression);
        Matcher matcher = universalPattern.matcher(buffer);

        matcher.find();

        result = Optional.of(new Expression());

        //TODO Сделать преобразование и запись чисел в объект выражения
    }

    public Expression get() {
        return null;
    }

}
