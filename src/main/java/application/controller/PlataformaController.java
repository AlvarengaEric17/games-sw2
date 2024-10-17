package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Plataforma;
import application.record.PlataformaDTO;
import application.repository.PlataformaRepository;

@RestController
@RequestMapping("/plataformas")
public class PlataformaController {
    @Autowired
    private PlataformaRepository plataformaRepo;

    @GetMapping
    public Iterable<PlataformaDTO> list(){
        return plataformaRepo.findAll().stream().map(PlataformaDTO::new).toList();

    }

    @PostMapping
    public PlataformaDTO insert(@RequestBody PlataformaDTO plataforma){
        return new PlataformaDTO(plataformaRepo.save(new Plataforma(plataforma)));
    }
}
