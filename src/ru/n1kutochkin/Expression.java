package ru.n1kutochkin;

import java.util.Optional;

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

    public void setFstNumberIsRoman(boolean fstNumberisRoman) {
        this.fstNumberIsRoman = fstNumberisRoman;
    }

    public void setSndNumberisRoman() {
        setFstNumberIsRoman(true);
    }

    public void setSndNumberIsRoman(boolean sndNumberIsRoman) {
        this.sndNumberIsRoman = sndNumberIsRoman;
    }

    public void setSndNumberIsRoman() {
        setSndNumberIsRoman(true);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setSndMember(Integer sndMember) {
        this.sndMember = sndMember;
    }

    public Integer getResult() {
        switch (operation) {
            case Addition:
                result = fstMember + sndMember;
                break;
            case Division:
                result = fstMember / sndMember;
                break;
            case Substraction:
                result = fstMember - sndMember;
                break;
            case Multiplication:
                result = fstMember * sndMember;
                break;
        }

        return result;
    }
}


