package edu.fatec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepositorio extends JpaRepository<Dono, Long>{
	Dono findByNome(String nome);
}