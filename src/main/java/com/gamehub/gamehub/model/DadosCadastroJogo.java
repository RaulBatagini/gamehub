package com.gamehub.gamehub.model;

//Esse record vai receber os dados vindo do formulario
public record DadosCadastroJogo(String nome, String genero, Integer ano, Double preco, Long desenvolvedoraId) {
}
