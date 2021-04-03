package edu.fatec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepositorio extends JpaRepository<Pet, Long>{

}