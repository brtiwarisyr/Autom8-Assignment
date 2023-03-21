package com.ram.entity;

public enum VMs {
    OS,
    RAM,
    HARD_DISK,
    CPU;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    @Override
    public String toString(){
        return value;
    }

}
