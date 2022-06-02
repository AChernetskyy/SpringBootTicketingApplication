package com.ticketingapplication.enums;

public enum Gender {

    MALE("Male"), FEMALE("Female");

    Gender(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue(){
        return value;
    }
}
