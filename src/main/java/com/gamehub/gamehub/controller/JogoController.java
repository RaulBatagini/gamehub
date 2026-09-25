package com.gamehub.gamehub.controller;

import com.gamehub.gamehub.model.DadosCadastroJogo;
import com.gamehub.gamehub.model.Desenvolvedora;
import com.gamehub.gamehub.model.Jogo;
import com.gamehub.gamehub.repository.DesenvolvedoraRepository;
import com.gamehub.gamehub.repository.JogoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/jogos")
public class JogoController {

    //Repository responsavel por acessar o banco de dados dos jogos
    private final JogoRepository repository;
    // Repository responsável por acessar as desenvolvedoras
    private final DesenvolvedoraRepository desenvolvedoraRepository;

    //Construtor que recebe JogoRepository
    // O Spring fornece automaticamente esse Repository
    public JogoController(JogoRepository Repository, DesenvolvedoraRepository desenvolvedoraRepository ) {
        this.repository = Repository;
        this.desenvolvedoraRepository = desenvolvedoraRepository;
    }

    //O this.repository é o atributo do controller(linha 15) vai receber o
    // repository que é uma instancia do JogoRepository nesse momento que controller tem acesso ao repository

    //Metodo POST que cadastra o jogo no banco de dados
    @PostMapping
    public String CadastrarJogo(DadosCadastroJogo dados) {

        // Busca no banco a desenvolvedora escolhida pelo usuário
        Desenvolvedora desenvolvedora = desenvolvedoraRepository.findById(dados.desenvolvedoraId()).orElseThrow();

        // Cria o Jogo usando os dados do formulário e a desenvolvedora encontrada
        Jogo jogo = new Jogo(dados, desenvolvedora);

        //Salva o jogo no banco de dados
        repository.save(jogo);

        //Depois de salvar retorna para a listagem dos jogos
        return "redirect:/jogos/listagem";

    }

    @GetMapping("/formulario")
    public String carregarFormulario() {
        return "jogos/formulario";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model) {

        model.addAttribute("lista", repository.findAll());

        return "jogos/listagem";
    }
}
