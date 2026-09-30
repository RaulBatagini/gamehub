package com.gamehub.gamehub.repository;

import com.gamehub.gamehub.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Esse repository vai trabalhar com a entidade(tabela/model) Jogo, cujo ID é do tipo Long
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    //Derived Querry
    //Metodo do repositorio eu que o framework gera um querry a partir do nome do metodo
    //ent aqui ao inves de procurar por nome assim SELECT * FROM jogo WHERE nome ......
    //vc usa somente essa linha abaixo
    List<Jogo> findByNomeContainingIgnoreCase(String nome);

}
