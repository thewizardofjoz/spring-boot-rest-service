
package com.api.hr.domain.common;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE"),
    NOT_APPLICABLE("NOT_APPLICABLE"),
    NOT_KNOWN("NOT_KNOWN");
    private final String value;
    private final static Map<String, Gender> CONSTANTS = new HashMap<String, Gender>();

    static {
        for (Gender c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private Gender(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static Gender fromValue(String value) {
        Gender constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
