package com.gamehub.gamehub.model;

import jakarta.persistence.*;

@Entity // Indica que essa classe representa uma entidade/tabela no banco
public class Jogo {
    @Id  // Indica que o atributo id é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz o banco gerar o ID automaticamente
    private Long id;

    private String nome;
    private String genero;
    private Integer ano;
    private Double preco;

    //Muitos objts do tipo jogo, relacionado com um do tipo desenvolvedora
    @ManyToOne
    private Desenvolvedora desenvolvedora;

    //O construtor vazio é necessário porque o JPA utiliza um construtor sem argumentos
    // para criar as instâncias da entidade.
    public Jogo() {}

    // Construtor utilizado para criar um jogo
    // a partir dos dados recebidos do formulario (vindos do Record DadosCadastroJogo)
    public Jogo(DadosCadastroJogo dados, Desenvolvedora desenvolvedora) {
        this.nome = dados.nome();
        this.genero = dados.genero();
        this.ano = dados.ano();
        this.preco = dados.preco();

        // Construtor que recebe os dados do formulário
        // e a desenvolvedora associada ao jogo.
        this.desenvolvedora = desenvolvedora;
    }

    public String getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAno() {
        return ano;
    }

    public Double getPreco() {
        return preco;
    }

}
