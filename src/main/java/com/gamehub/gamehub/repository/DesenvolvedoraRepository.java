package com.gamehub.gamehub.repository;

import com.gamehub.gamehub.model.Desenvolvedora;
import org.springframework.data.jpa.repository.JpaRepository;

//Esse repository vai trabalhar com a entidade(tabela/model) Desenvolvedora, cujo ID é do tipo Long
public interface DesenvolvedoraRepository extends JpaRepository<Desenvolvedora, Long> {
}
