package com.siit.hospital_manager.exception;

public class CustomErrorResponse {
    private String prettyMessage;

    private String errorCode;

    public String getPrettyMessage() {
        return prettyMessage;
    }

    public void setPrettyMessage(String prettyMessage) {
        this.prettyMessage = prettyMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
