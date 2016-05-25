package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String username ;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(length = 2000)
	private String descrizione;
	
	@OneToMany
	private List<Esame> esamiEffettuati;
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getDescrizione() {
		return descrizione;
	}



	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



	public Medico(String nome, String cognome, String descrizione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.descrizione = descrizione;
	}



	@Override
	public String toString() {
		return "Medico [nome=" + nome + ", cognome=" + cognome + ", descrizione=" + descrizione + "]";
	}
}
