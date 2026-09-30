package com.gamehub.gamehub.repository;

import com.gamehub.gamehub.model.Desenvolvedora;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


//Esse repository vai trabalhar com a entidade(tabela/model) Desenvolvedora, cujo ID é do tipo Long
public interface DesenvolvedoraRepository extends JpaRepository<Desenvolvedora, Long> {

    Optional<Desenvolvedora> findByNome(String nome);

}
