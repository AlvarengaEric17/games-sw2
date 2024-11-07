package application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Plataforma;
import application.record.PlataformaDTO;
import application.repository.PlataformaRepository;

@Service
public class PlataformaService {
    @Autowired
    private PlataformaRepository plataformaRepo;

    public Iterable<PlataformaDTO> getAll() {
        return plataformaRepo.findAll().stream().map(PlataformaDTO::new).toList();
    }

    public PlataformaDTO insertOne(PlataformaDTO plataforma) {
        return new PlataformaDTO(plataformaRepo.save(new Plataforma(plataforma)));
    }

    public void removeById(long id) {
        if (!plataformaRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "PLataforma não Cadastrada");
        }
        plataformaRepo.deleteById(id);
    }

   
    public PlataformaDTO update( long id,  PlataformaDTO plataforma) {
        Optional<Plataforma> resultado = plataformaRepo.findById(id);
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "PLataforma não Cadastrada");
        }
        resultado.get().setNome(plataforma.nome());
        return new PlataformaDTO(plataformaRepo.save(resultado.get()));

    }
}
