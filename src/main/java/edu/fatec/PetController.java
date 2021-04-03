package edu.fatec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
	
	@Autowired
	PetRepositorio petRepository;
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/pets")
	public ResponseEntity<List<Pet>> listarPets() { 
		List<Pet> pets = petRepository.findAll();
		
		return ResponseEntity.ok(pets);
	}

	@RequestMapping(method = RequestMethod.POST,
			path = "/pet/add")
	public String adicionarPet(@RequestBody Pet pet) { 
		petRepository.save(pet);
		return "Pet adicionado com sucesso";
	}

}