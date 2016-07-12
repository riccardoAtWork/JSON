package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="CATEGORIA_FIT")
//@NamedQuery(name="CategoriaFit.findAll", query="SELECT c FROM CategoriaFit c")
@NamedQuery(name="CategoriaFit.findFromId", query="SELECT c.nTessera FROM CategoriaFit c where c.socio.id = :idsocio")
public class CategoriaFit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="N_TESSERA")
	private String nTessera;

	private String classifica;
//PROVA
	@OneToOne
	@JoinColumn(name="ID_SOCIO")
	@JsonBackReference
	private Socio socio;

	public CategoriaFit() {
	}

	
	
	public CategoriaFit(String nTessera, String classifica, Socio socio) {
		this.nTessera = nTessera;
		this.classifica = classifica;
		this.socio = socio;
	}



	public String getNTessera() {
		return this.nTessera;
	}

	public void setNTessera(String nTessera) {
		this.nTessera = nTessera;
	}

	public String getClassifica() {
		return this.classifica;
	}

	public void setClassifica(String classifica) {
		this.classifica = classifica;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}