package br.com.dio.exception;

public class AccountUseException extends RuntimeException {
    public AccountUseException(String message) {
        super(message);
    }

}
