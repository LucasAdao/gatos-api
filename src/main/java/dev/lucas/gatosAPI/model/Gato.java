package dev.lucas.gatosAPI.model;


import jakarta.persistence.*;

@Entity
@Table(name = "gatos")
public class Gato {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Gato")
    private Short id;

    @Column( nullable = false , name = "nome", length = 50)
    private String nome;

    @Column( nullable = false , name = "raca", length = 50)
    private String raca;

    @Column( nullable = false , name = "idade")
    private byte idade;

    public Gato() {
    }

    public Gato(Short id, String nome, String raca, byte idade) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }
}
