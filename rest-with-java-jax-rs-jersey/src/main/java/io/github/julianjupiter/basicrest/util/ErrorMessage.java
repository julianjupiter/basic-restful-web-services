package io.github.julianjupiter.basicrest.util;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ErrorMessage implements Serializable {
    private static final long serialVersionUID = 1442698378687760355L;
    private String code;
    private String message;
    private LocalDateTime timestamp;

    public ErrorMessage() {

    }

    public ErrorMessage(ApplicationException exception) {
        this.code = exception.getCode();
        this.message = exception.getMessage();
        this.timestamp = exception.getTimestamp();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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
