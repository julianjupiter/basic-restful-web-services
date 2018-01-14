package io.github.julianjupiter.basicrest.util;

import java.time.LocalDateTime;

public class ApplicationException extends Exception {
    private static final long serialVersionUID = -1648938675996267848L;
    private int status;
    private String code;
    private String message;
    private LocalDateTime timestamp;

    public ApplicationException(int status, String code, String message, LocalDateTime timestamp) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ApplicationException() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
