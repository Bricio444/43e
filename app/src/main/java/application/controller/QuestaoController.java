package application.controller;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.saver.ResponseStatusException;

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
        if(!categoriaRepo.existsById(questao.getCategoria().getId())){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,"Categoria vinculada não encontrada"
            );
        }
        return questoesRepo.save(questao);
    }
    @PutMapping ("/{id}")
    public Questao put (@RequestBody Questao questao, @PathVariable long id){
        Option<Questao> result = questoesRepo.findbyidI(id);
        if (result.isEmtpy()){
            throw new ResponseStatusException(
                HttpStatus. NOT_FOUD, "Qustão não encontrada"
            );
        } 
    }

}
