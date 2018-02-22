package org.kata.stringcalculator;

public class NegativesNotAllowedException extends Exception {
    public NegativesNotAllowedException() { super(); }
    public NegativesNotAllowedException(String message) { super(message); }
    public NegativesNotAllowedException(String message, Throwable cause) { super(message, cause); }
    public NegativesNotAllowedException(Throwable cause) { super(cause); }

}
