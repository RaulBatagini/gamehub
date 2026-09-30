package com.gamehub.gamehub.controller;

import com.gamehub.gamehub.model.DadosCadastroJogo;
import com.gamehub.gamehub.model.Desenvolvedora;
import com.gamehub.gamehub.model.Jogo;
import com.gamehub.gamehub.repository.DesenvolvedoraRepository;
import com.gamehub.gamehub.repository.JogoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jogos")
public class JogoController {

    private final JogoRepository repository;
    private final DesenvolvedoraRepository desenvolvedoraRepository;

    public JogoController(
            JogoRepository repository,
            DesenvolvedoraRepository desenvolvedoraRepository) {

        this.repository = repository;
        this.desenvolvedoraRepository = desenvolvedoraRepository;
    }

    // CADASTRAR
    @PostMapping
    public String cadastrarJogo(DadosCadastroJogo dados) {

        Desenvolvedora desenvolvedora =
                desenvolvedoraRepository
                        .findByNome(dados.desenvolvedoraNome())
                        .orElseThrow();

        Jogo jogo = new Jogo(dados, desenvolvedora);

        repository.save(jogo);

        return "redirect:/jogos/listagem";
    }

    // FORMULÁRIO DE CADASTRO
    @GetMapping("/formulario")
    public String carregarFormulario(Model model) {

        model.addAttribute(
                "desenvolvedoras",
                desenvolvedoraRepository.findAll()
        );

        return "jogos/formulario";
    }

    // LISTAGEM
    @GetMapping("/listagem")
    public String carregaListagem(Model model) {

        model.addAttribute(
                "lista",
                repository.findAll()
        );

        return "jogos/listagem";
    }

    // FORMULÁRIO DE EDIÇÃO
    @GetMapping("/editar/{id}")
    public String carregarFormularioEdicao(
            @PathVariable Long id,
            Model model) {

        Jogo jogo = repository
                .findById(id)
                .orElseThrow();

        model.addAttribute("jogo", jogo);

        model.addAttribute(
                "desenvolvedoras",
                desenvolvedoraRepository.findAll()
        );

        return "jogos/editar";
    }

    // ATUALIZAR
    @PostMapping("/editar/{id}")
    public String editarJogo(
            @PathVariable Long id,
            DadosCadastroJogo dados) {

        Jogo jogo = repository
                .findById(id)
                .orElseThrow();

        Desenvolvedora desenvolvedora =
                desenvolvedoraRepository
                        .findByNome(dados.desenvolvedoraNome())
                        .orElseThrow();

        jogo.setNome(dados.nome());
        jogo.setGenero(dados.genero());
        jogo.setAno(dados.ano());
        jogo.setPreco(dados.preco());
        jogo.setDesenvolvedora(desenvolvedora);

        repository.save(jogo);

        return "redirect:/jogos/listagem";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluirJogo(@PathVariable Long id) {

        repository.deleteById(id);

        return "redirect:/jogos/listagem";
    }

    // PESQUISA - DERIVED QUERY
    @GetMapping("/buscar")
    public String buscar(String nome, Model model) {

        model.addAttribute(
                "lista",
                repository.findByNomeContainingIgnoreCase(nome)
        );

        return "jogos/listagem";
    }
}