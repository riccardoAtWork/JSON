package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="PRENOTAZIONE")
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;
//PROVA GIT
	@Id
	@SequenceGenerator(name="PRENOTAZIONE_ID_GENERATOR", sequenceName="PRENOTAZIONE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRENOTAZIONE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="ID_CAMPO", nullable=false)
	private BigDecimal idCampo;

	@Column(name="ID_CORSO", precision=38)
	private long idCorso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date inizio;

	@Column(name="NOME_OSPITE", length=32)
	private String nomeOspite;


	@ManyToOne
	@JoinColumn(name="ID_MAESTRO")
	@JsonBackReference
	private Maestro maestro;

	
	@ManyToOne
	@JoinColumn(name="ID_SOCIO")
	@JsonBackReference
	private Socio socio;

	public Prenotazione() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getIdCampo() {
		return this.idCampo;
	}

	public void setIdCampo(BigDecimal idCampo) {
		this.idCampo = idCampo;
	}

	public long getIdCorso() {
		return this.idCorso;
	}

	public void setIdCorso(long idCorso) {
		this.idCorso = idCorso;
	}

	public Date getInizio() {
		return this.inizio;
	}

	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}

	public String getNomeOspite() {
		return this.nomeOspite;
	}

	public void setNomeOspite(String nomeOspite) {
		this.nomeOspite = nomeOspite;
	}

	public Maestro getMaestro() {
		return this.maestro;
	}

	public void setMaestro(Maestro maestro) {
		this.maestro = maestro;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}