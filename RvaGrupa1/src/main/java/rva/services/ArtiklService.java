package rva.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Artikl;
import rva.repository.ArtiklRepository;

@Service
public class ArtiklService {
	
	@Autowired
	private ArtiklRepository artiklRepository;
	
	public List<Artikl> getAllArtikl(){
		return artiklRepository.findAll();
	}
	
	/*public Artikl getArtiklById(long id) {
		return artiklRepository.getById(id);
	}*/
	public Optional<Artikl> getArtiklById(long id) {
		return artiklRepository.findById(id);
	}

	public List<Artikl> getAllArtiklByName(String naziv){
		return artiklRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	public List<Artikl> getAllArtiklBySlovo(String slovo){
		return artiklRepository.findByPocetnoSlovo(slovo);
	}
}
