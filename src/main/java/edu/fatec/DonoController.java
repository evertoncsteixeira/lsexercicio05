package edu.fatec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonoController {
	
	@Autowired
	PetRepositorio petRepository;
	
	@Autowired
	DonoRepositorio donoRepository;
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/donos")
	public ResponseEntity<List<Dono>> listarDonos() { 
		List<Dono> donos = donoRepository.findAll();
		
		return ResponseEntity.ok(donos);
	}

	@RequestMapping(method = RequestMethod.POST,
			path = "/dono/add")
	public String adicionarDono(@RequestBody Dono dono) { 
		donoRepository.save(dono);
		return "Dono adicionado com sucesso";
		
	
	}
	
	@RequestMapping(method = RequestMethod.POST,
			path = "/dono/{nomeDono}/{nomePet}")
	public String vincularDonoPet(	@PathVariable("nomeDono") String nomeDono, 
										@PathVariable("nomePet") String nomePet) { 
		Dono dono = donoRepository.findByNome(nomeDono);
		Pet pet = petRepository.findByNome(nomePet);

		List<Pet> lista = new ArrayList<>();
		lista.add(pet);
		dono.setPets(lista);

		donoRepository.save(dono);
		return "Dono e Pet vinculados com sucesso";
	}
}