package dev.lucas.gatosAPI.exceptions;

public class GatoNotFoundException extends RuntimeException {

    public GatoNotFoundException(Short id){
        super("O gato com ID:" + id + " não está cadastrado");
    }
    public GatoNotFoundException(String message) {
        super(message);
    }
}
