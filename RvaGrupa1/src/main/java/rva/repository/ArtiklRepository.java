package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.Artikl;

public interface ArtiklRepository extends JpaRepository<Artikl, Long>{

	List<Artikl> findByNazivContainingIgnoreCase(String naziv);
	
	//1. nacin
	/*@Query(value="select * from artikl a where lower(naziv) like ?1%", nativeQuery = true)
	List<Artikl> findByPocetnoSlovo(String slovo);*/
	
	//2. nacin
	@Query(value="select * from artikl a where lower(naziv) like :slovo%", nativeQuery = true)
	List<Artikl> findByPocetnoSlovo(@Param("slovo")String slovo);
}
