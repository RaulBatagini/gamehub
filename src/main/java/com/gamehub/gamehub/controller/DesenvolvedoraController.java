package com.gamehub.gamehub.controller;

import com.gamehub.gamehub.model.DadosCadastroDesenvolvedora;
import com.gamehub.gamehub.model.Desenvolvedora;
import com.gamehub.gamehub.repository.DesenvolvedoraRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/desenvolvedoras")
public class DesenvolvedoraController {

    private final DesenvolvedoraRepository repository;

    public DesenvolvedoraController(
            DesenvolvedoraRepository repository) {

        this.repository = repository;
    }

    // CREATE
    @PostMapping
    public String cadastrarDesenvolvedora(
            DadosCadastroDesenvolvedora dados) {

        Desenvolvedora desenvolvedora =
                new Desenvolvedora(dados);

        repository.save(desenvolvedora);

        return "redirect:/desenvolvedoras/listagem";
    }

    // FORMULÁRIO DE CADASTRO
    @GetMapping("/formulario")
    public String carregaFormulario() {
        return "desenvolvedoras/formulario";
    }

    // READ
    @GetMapping("/listagem")
    public String carregaListagem(Model model) {

        model.addAttribute(
                "lista",
                repository.findAll()
        );

        return "desenvolvedoras/listagem";
    }

    // FORMULÁRIO DE EDIÇÃO
    @GetMapping("/editar/{id}")
    public String carregarFormularioEdicao(
            @PathVariable Long id,
            Model model) {

        Desenvolvedora desenvolvedora =
                repository.findById(id).orElseThrow();

        model.addAttribute(
                "desenvolvedora",
                desenvolvedora
        );

        return "desenvolvedoras/editar";
    }

    // UPDATE
    @PostMapping("/editar/{id}")
    public String editarDesenvolvedora(
            @PathVariable Long id,
            DadosCadastroDesenvolvedora dados) {

        Desenvolvedora desenvolvedora =
                repository.findById(id).orElseThrow();

        desenvolvedora.setNome(dados.nome());
        desenvolvedora.setPais(dados.pais());

        repository.save(desenvolvedora);

        return "redirect:/desenvolvedoras/listagem";
    }

    // DELETE
    @GetMapping("/excluir/{id}")
    public String excluirDesenvolvedora(
            @PathVariable Long id) {

        repository.deleteById(id);

        return "redirect:/desenvolvedoras/listagem";
    }
}