package com.example.taskOne.enums;

public enum SubCategory {
      EATABLE("Eatiçi"),
    NONEATABLE("NonEatiçi");

    private final String value;

    SubCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
