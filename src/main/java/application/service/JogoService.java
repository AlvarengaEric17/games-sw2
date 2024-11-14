package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Jogo;
import application.record.JogoDTO;
import application.repository.jogoRepository;

@Service
public class JogoService {

    @Autowired
    private jogoRepository JogoRepo;

    public Iterable<JogoDTO> getAll() {
        return JogoRepo.findAll().stream().map(JogoDTO::new).toList();
    }

    public JogoDTO add(JogoDTO jogo) {
        return new JogoDTO((JogoRepo.save(new Jogo(jogo))));
    }
}
