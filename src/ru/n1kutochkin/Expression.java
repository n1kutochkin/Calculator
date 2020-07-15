package ru.n1kutochkin;

public class Expression {

    private Number fstMember = null;
    private Number sndMember = null;
    private Operation operation = null;
    private Integer result = null;

    public void setFstMember(Number fstMember) throws Exception {
        if (fstMember.intValue() >= 1 && fstMember.intValue() <= 10) {
            this.fstMember = fstMember;
        } else {
            throw new Exception("Первое число не удовлетворяет условию задачи");
        }

    }

    public void setSndMember(Number sndMember) throws Exception {
        if (sndMember.intValue() >= 1 && sndMember.intValue() <= 10) {
            this.sndMember = sndMember;
        } else {
            throw new Exception("Второе число не удовлетворяет условию задачи");
        }
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public boolean isFstNumberIsRoman() {
        return fstMember instanceof RomanNumber;
    }

    public boolean isSndNumberIsRoman() {
        return sndMember instanceof RomanNumber;
    }

    public boolean isBothIsRoman() {
        return Boolean.logicalAnd(fstMember instanceof RomanNumber, sndMember instanceof RomanNumber);
    }
    public Integer getResult() {
        switch (operation) {
            case Addition:
                result = fstMember.intValue() + sndMember.intValue();
                break;
            case Division:
                result = fstMember.intValue() / sndMember.intValue();
                break;
            case Subtraction:
                result = fstMember.intValue() - sndMember.intValue();
                break;
            case Multiplication:
                result = fstMember.intValue() * sndMember.intValue();
                break;
        }

        return result;
    }
}


