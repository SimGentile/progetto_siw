package it.uniroma3.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ArchivioClinica {
	
	@OneToMany
	Map<Long, Paziente> elencoPazienti;
	
	@OneToMany
	Map<Long, Medico> elencoMedici;
	
	@OneToMany
	Map<Long, TipologiaDiEsame> elencoTipologie;

	public ArchivioClinica() {}

	public Map<Long, Paziente> getElencoPazienti() {
		return elencoPazienti;
	}

	public void setElencoPazienti(Map<Long, Paziente> elencoPazienti) {
		this.elencoPazienti = elencoPazienti;
	}

	public Map<Long, Medico> getElencoMedici() {
		return elencoMedici;
	}

	public void setElencoMedici(Map<Long, Medico> elencoMedici) {
		this.elencoMedici = elencoMedici;
	}

	public Map<Long, TipologiaDiEsame> getElencoTipologie() {
		return elencoTipologie;
	}

	public void setElencoTipologie(Map<Long, TipologiaDiEsame> elencoTipologie) {
		this.elencoTipologie = elencoTipologie;
	}
	
	
	
	
	
	
}
