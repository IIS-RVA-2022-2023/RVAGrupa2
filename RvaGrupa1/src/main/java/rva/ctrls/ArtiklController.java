package rva.ctrls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Artikl;
import rva.services.ArtiklService;

@RestController
public class ArtiklController {

	@Autowired
	private ArtiklService artiklService;
	
	@GetMapping("artikl")
	public List<Artikl> getAllArtikl(){
		return artiklService.getAllArtikl();
	}
	
	@GetMapping("artikl/{id}")
	public Optional<Artikl> getArtiklById(@PathVariable("id")long idArtikl) {
		return artiklService.getArtiklById(idArtikl);
	}
	
	@GetMapping("artiklNaziv/{name}")
	public List<Artikl> getAllArtiklByName(@PathVariable("name")String name){
		return artiklService.getAllArtiklByName(name);
	}
	
	@GetMapping("artiklNazivSlovo/{slovo}")
	public List<Artikl> getAllArtiklBySlovo(@PathVariable("slovo")String slovo){
		return artiklService.getAllArtiklBySlovo(slovo);
	}
}
