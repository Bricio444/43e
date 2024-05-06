package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Questao;
import application.repository.QuestaoRepository;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {
    @Autowired
    private QuestaoRepository questoesRepo;

    @GetMapping
    public Iterable<Questao> getAll() {
        return questoesRepo.findAll();
    }

    @PostMapping
    public Questao post(@RequestBody Questao questao) {
        return questoesRepo.save(questao);
    }
}
