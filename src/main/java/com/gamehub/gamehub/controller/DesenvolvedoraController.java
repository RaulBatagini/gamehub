package com.gamehub.gamehub.controller;

import com.gamehub.gamehub.model.Desenvolvedora;
import com.gamehub.gamehub.model.DadosCadastroDesenvolvedora;
import com.gamehub.gamehub.repository.DesenvolvedoraRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller// Indica que essa classe é um Controller do Spring
@RequestMapping("/desenvolvedoras")// Define o caminho base das requisições
public class DesenvolvedoraController {

    // Declara o Repository, que sera usado para acessar o banco de dados
    private final DesenvolvedoraRepository repository;

    // Construtor usado para receber o Repository
    // O Spring fornece automaticamente uma instância de DesenvolvedoraRepository
    public DesenvolvedoraController(DesenvolvedoraRepository repository) {

        this.repository = repository;
    }

    // Indica que esse metodo será executado quando receber uma requisição POST
    @PostMapping
    public String cadastrarDesenvolvedora(DadosCadastroDesenvolvedora dados){
        // Cria um objeto Desenvolvedora usando os dados recebidos do formulário
        Desenvolvedora desenvolvedora = new Desenvolvedora(dados);

        // Salva a Desenvolvedora no banco de dados através do Repository
        repository.save(desenvolvedora);

        // Depois de salvar, redireciona para a pagina de listagem
        return "redirect:/desenvolvedoras/listagem";
    }

    // Quando acessamos /formulario, o Spring chama esse metodo
    // e retorna o nome/caminho do template que será exibido.
    @GetMapping("/formulario")
    public String carregaFormulario() {

        return "desenvolvedoras/formulario";
    }

    // Quando acessamos /listagem, o Spring chama esse metodo.
    // repository.findAll() busca todas as desenvolvedoras no banco.
    // model.addAttribute("lista", ...) coloca os dados no Model
    // com o nome "lista", para o HTML poder utilizá-los.
    // Por fim, retorna a página desenvolvedoras/listagem.
    @GetMapping("/listagem")
    public String carregaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "desenvolvedoras/listagem";
    }
}
