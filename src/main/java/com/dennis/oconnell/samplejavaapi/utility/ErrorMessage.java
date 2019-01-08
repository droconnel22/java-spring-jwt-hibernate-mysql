package com.dennis.oconnell.samplejavaapi.utility;

public class ErrorMessage {

    private String message;
    private String status;

    public ErrorMessage(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
