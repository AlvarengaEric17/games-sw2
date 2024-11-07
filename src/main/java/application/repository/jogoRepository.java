package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Jogo;

public interface jogoRepository extends JpaRepository<Jogo, Long> {

}
