package rva.ctrls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Artikl;
import rva.services.ArtiklService;

@CrossOrigin
@RestController
public class ArtiklController {

	@Autowired
	private ArtiklService artiklService;
	
	@GetMapping("artikl")
	public ResponseEntity<?> getAllArtikl(){
		List<Artikl> artikli = artiklService.getAllArtikl();
		if(artikli.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No artikls");
		return ResponseEntity.status(HttpStatus.OK).body(artikli);
	}
	
	@GetMapping("artikl/{id}")
	public ResponseEntity<?> getArtiklById(@PathVariable("id")long idArtikl) {
		Optional<Artikl> artikl = artiklService.getArtiklById(idArtikl);
		if(artikl.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Articl with requested ID not found");
		return ResponseEntity.ok(artikl);
	}
	
	@GetMapping("artiklNaziv/{name}")
	public ResponseEntity<?> getAllArtiklByName(@PathVariable("name")String name){
		List<Artikl> artikli = artiklService.getAllArtiklByName(name);
		if(artikli.isEmpty())
			return new ResponseEntity<>("No artikls by that name", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(artikli, HttpStatus.OK);
	}
	
	@GetMapping("artiklNazivSlovo/{slovo}")
	public ResponseEntity<?> getAllArtiklBySlovo(@PathVariable("slovo")String slovo){
		List<Artikl> artikli = artiklService.getAllArtiklBySlovo(slovo);
		if(artikli.isEmpty())
			return new ResponseEntity<>("No artikls by that name", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(artikli, HttpStatus.OK);
	}
	
	@PostMapping("artikl")
	public ResponseEntity<?> addArtikl(@RequestBody Artikl artikl){		
		if(!artiklService.existsById(artikl.getId())) {
			Artikl savedArtikl = artiklService.addArtikl(artikl);
			return ResponseEntity.status(HttpStatus.OK).body(savedArtikl);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Articl with requested ID already exists");
	}
	
	@PutMapping("artikl/{id}")
	public ResponseEntity<?> updateArtikl(@RequestBody Artikl artikl, @PathVariable("id")long idArtikl){	
		artikl.setId(idArtikl);
		if(!artiklService.existsById(artikl.getId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Articl with requested ID not exists");
		}
		Artikl savedArtikl = artiklService.addArtikl(artikl);
		return ResponseEntity.status(HttpStatus.OK).body(savedArtikl);		
	}
	
	@DeleteMapping("artikl/{id}")
	public ResponseEntity<?> deleteArtikl(@PathVariable("id")long idArtikl){
		if(!artiklService.existsById(idArtikl)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Articl with requested ID not exists");
		}
		artiklService.deleteArtikl(idArtikl);
		return ResponseEntity.status(HttpStatus.OK).body("Articl with id "+idArtikl+"has been deleted");		
	}
}
