package com.gamehub.gamehub.model;

import jakarta.persistence.*;

@Entity // Indica que essa classe representa uma entidade/tabela no banco
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String genero;
    private Integer ano;
    private Double preco;

    // Muitos jogos podem pertencer a uma desenvolvedora
    @ManyToOne
    private Desenvolvedora desenvolvedora;

    // Construtor vazio necessário para o JPA
    public Jogo() {}

    // Construtor utilizado para cadastrar um jogo
    public Jogo(DadosCadastroJogo dados, Desenvolvedora desenvolvedora) {

        this.nome = dados.nome();
        this.genero = dados.genero();
        this.ano = dados.ano();
        this.preco = dados.preco();
        this.desenvolvedora = desenvolvedora;
    }

// GETTERS

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getAno() {
        return ano;
    }

    public Double getPreco() {
        return preco;
    }

    public Desenvolvedora getDesenvolvedora() {
        return desenvolvedora;
    }

// SETTERS
// Usados para alterar os dados no UPDATE

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }
}
