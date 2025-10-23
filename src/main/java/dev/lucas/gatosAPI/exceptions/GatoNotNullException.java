package dev.lucas.gatosAPI.exceptions;

public class GatoNotNullException extends RuntimeException{
    public GatoNotNullException(){
        super("Você deve preencher os dados do Gato Corretamente");
    }
}
