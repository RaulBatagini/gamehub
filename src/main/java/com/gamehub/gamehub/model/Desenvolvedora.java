package com.gamehub.gamehub.model;
import jakarta.persistence.*;

import java.util.List;

//@Entity fala para o JPA que essa classe representa uma tabela do banco
@Entity
public class Desenvolvedora {
    @Id //@Id indica qual atributo é a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue faz o banco gerar o id automaticamente
    private Long id;

    private String nome;
    private String pais;

    //Uma Desenvolvedora pode possuir vários Jogo, ou seja uma Lista de Jogo chamada jogos
    @OneToMany(mappedBy = "desenvolvedora")// Indica que a chave estrangeira da relação ficará na tabela JOGO.
    private List<Jogo>  jogos;

    // Construtor vazio necessário para o JPA conseguir criar
    // objetos da entidade sem precisar receber parâmetros
    public Desenvolvedora() {}

    // Construtor utilizado para criar uma Desenvolvedora
    // a partir dos dados recebidos do formulario (vindos do Record DadosCadastroDesenvolvedora)
    public Desenvolvedora(DadosCadastroDesenvolvedora dados){
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
}
