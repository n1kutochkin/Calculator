package ru.n1kutochkin;

import java.util.Optional;

public class Expression {

    private Byte fstMember = null;
    private Byte sndMember = null;
    private Operation operation = null;

    public void setFstMember(Byte fstMember) {
        this.fstMember = fstMember;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setSndMember(Byte sndMember) {
        this.sndMember = sndMember;
    }
}


