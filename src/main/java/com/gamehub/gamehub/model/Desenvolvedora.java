package com.gamehub.gamehub.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Desenvolvedora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String pais;

    @OneToMany(mappedBy = "desenvolvedora")
    private List<Jogo> jogos;

    public Desenvolvedora() {
    }

    public Desenvolvedora(DadosCadastroDesenvolvedora dados) {
        this.nome = dados.nome();
        this.pais = dados.pais();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    // SETTERS

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}