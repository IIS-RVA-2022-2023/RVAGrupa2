package rva.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rva.model.Dobavljac;
import rva.repository.DobavljacRepository;

@Service
public class DobavljacService {

	@Autowired
	private DobavljacRepository dobavljacRepository;
	
	public List<Dobavljac> getAll(){
		return dobavljacRepository.findAll();
	}
	
	public Optional<Dobavljac> findById(long id) {
		return dobavljacRepository.findById(id);
	}
	
	public List<Dobavljac> findByNazivContainingIgnoreCase(String naziv) {
        return dobavljacRepository.findByNazivContainingIgnoreCase(naziv);
    }
	
	public Dobavljac save(Dobavljac dobavljac) {
		return dobavljacRepository.save(dobavljac);
	}
	
	public boolean existsById(long id) {
		if(!dobavljacRepository.findById(id).isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void deleteById(long id) {
		dobavljacRepository.deleteById(id);
	}
	
}
