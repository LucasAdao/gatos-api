package dev.lucas.gatosAPI.model;

public enum Sexo {
    M("Macho"),
    F("Fêmea");

    public final String nome;

    Sexo(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
