package com.example.app.common.exception;

public class AssertException extends IllegalArgumentException{
    private static final long serialVersionUID = -4018837389302151752L;
    private AssertException.Type type;

    public AssertException(AssertException.Type type) {
        this.type = type;
    }

    public AssertException(AssertException.Type type, String message) {
        super(message);
        this.type = type;
    }

    public AssertException(AssertException.Type type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    public AssertException(AssertException.Type type, Throwable cause) {
        super(cause);
        this.type = type;
    }

    public String toString() {
        return super.toString() + " : " + this.type.name();
    }

    public AssertException.Type getType() {
        return this.type;
    }

    public static enum Type {
        IS_TRUE,
        IS_FALSE,
        IS_NULL,
        NOT_NULL,
        NOT_EMPTY,
        NOT_BLANK,
        STATUS,
        IS_MATCH,
        FORCE,
        NOT_SUPPORT;

        private Type() {
        }
    }
}
