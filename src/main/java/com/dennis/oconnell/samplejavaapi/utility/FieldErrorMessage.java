package com.dennis.oconnell.samplejavaapi.utility;

public class FieldErrorMessage {
    private String field;
    private String status;

    public FieldErrorMessage(String field, String status) {
        this.field = field;
        this.status = status;
    }

    public String getField() {
        return field;
    }

    public String getStatus() {
        return status;
    }
}
