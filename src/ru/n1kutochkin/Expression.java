package ru.n1kutochkin;

public class Expression {

    private Integer fstMember = null;
    private Integer sndMember = null;
    private Operation operation = null;
    private boolean fstNumberIsRoman = false;
    private boolean sndNumberIsRoman = false;
    private Integer result = null;

    public void setFstMember(Integer fstMember) {
        this.fstMember = fstMember;
    }

    public void setFstNumberIsRoman(boolean fstNumberIsRoman) {
        this.fstNumberIsRoman = fstNumberIsRoman;
    }

    public void setFstNumberIsRoman() {
        this.setFstNumberIsRoman(true);
    }

    public void setSndNumberIsRoman() {
        this.setSndNumberIsRoman(true);
    }

    public void setSndNumberIsRoman(boolean sndNumberIsRoman) {
        this.sndNumberIsRoman = sndNumberIsRoman;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setSndMember(Integer sndMember) {
        this.sndMember = sndMember;
    }

    public boolean isFstNumberIsRoman() {
        return fstNumberIsRoman;
    }

    public boolean isSndNumberIsRoman() {
        return sndNumberIsRoman;
    }

    public boolean isBothIsRoman() {
        return Boolean.logicalAnd(fstNumberIsRoman, sndNumberIsRoman);
    }

    public Integer getResult() {
        switch (operation) {
            case Addition:
                result = fstMember + sndMember;
                break;
            case Division:
                result = fstMember / sndMember;
                break;
            case Subtraction:
                result = fstMember - sndMember;
                break;
            case Multiplication:
                result = fstMember * sndMember;
                break;
        }

        return result;
    }

    // TODO: 14.07.2020 move to RomanNumerals class
    public String getResultInRoman() {
        // TODO: 14.07.2020 make implementations for this method 
        return null;
    }
}


