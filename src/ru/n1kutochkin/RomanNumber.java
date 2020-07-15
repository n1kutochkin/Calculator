package ru.n1kutochkin;

import java.util.List;

public class RomanNumber extends Number {

    private String numberInStr;
    private int intValue;

    RomanNumber(String number) throws Exception {
        numberInStr = number;
        intValue = parseToInt();
    }

    private int parseToInt() throws Exception {
        String romanNumeral = numberInStr.toUpperCase();
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
            throw new IllegalArgumentException(numberInStr + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    @Override
    public int intValue() {
        return intValue;
    }

    public String romanValue() {
        int number = intValue;

        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    @Override
    public long longValue() {
        return Long.parseLong(Integer.toString(intValue()));
    }

    @Override
    public float floatValue() {
        return Float.parseFloat(Integer.toString(intValue()));
    }

    @Override
    public double doubleValue() {
        return Double.parseDouble(Integer.toString(intValue()));
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
