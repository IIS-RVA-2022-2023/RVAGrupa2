package rva.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@JsonIgnoreProperties({"hiberanateLazyInitializer", "handler"})
@Entity
public class Porudzbina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PORUDZBINA_SEQ_GENERATOR", sequenceName = "PORUDZBINA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PORUDZBINA_SEQ_GENERATOR")
	private int id;

	private Date datum;

	private Date isporuceno;
	private double iznos;
	private boolean placeno;
	
	@ManyToOne
	@JoinColumn(name = "dobavljac")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Dobavljac dobavljac;
	
	@JsonIgnore
	@OneToMany(mappedBy = "porudzbina")
	private List<StavkaPorudzbine> stavke;

	public Porudzbina() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getIsporuceno() {
		return isporuceno;
	}

	public void setIsporuceno(Date isporuceno) {
		this.isporuceno = isporuceno;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public boolean isPlaceno() {
		return placeno;
	}

	public void setPlaceno(boolean placeno) {
		this.placeno = placeno;
	}

	public Dobavljac getDobavljac() {
		return dobavljac;
	}

	public void setDobavljac(Dobavljac dobavljac) {
		this.dobavljac = dobavljac;
	}

	public List<StavkaPorudzbine> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaPorudzbine> stavke) {
		this.stavke = stavke;
	}

	
	
}
