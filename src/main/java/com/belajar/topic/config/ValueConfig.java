package com.belajar.topic.config;

public final class ValueConfig {
    private ValueConfig() {

    }
    public static final String value = "${value.from.file}";
    public static final String priotity = "${priority}";
    public static final String listOfValues = "${listOfValues}";

}
