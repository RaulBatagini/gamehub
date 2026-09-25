package com.gamehub.gamehub.repository;

import com.gamehub.gamehub.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

//Esse repository vai trabalhar com a entidade(tabela/model) Jogo, cujo ID é do tipo Long
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
