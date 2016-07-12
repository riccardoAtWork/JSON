package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SFIDA database table.
 * 
 */
@Entity
@NamedQuery(name="Sfida.findAll", query="SELECT s FROM Sfida s")
public class Sfida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="COMMENTI_SFIDANTE")
	private String commentiSfidante;

	@Column(name="COMMENTI_SFIDATO")
	private String commentiSfidato;

	private String score;

	//bi-directional many-to-one association to Prenotazione
	@ManyToOne
	@JoinColumn(name="ID_PRENOTAZIONE")
	private Prenotazione prenotazione;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="ID_SFIDANTE")
	private Socio socio1;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="WINNER")
	private Socio socio2;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="ID_SFIDATO")
	private Socio socio3;

	public Sfida() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentiSfidante() {
		return this.commentiSfidante;
	}

	public void setCommentiSfidante(String commentiSfidante) {
		this.commentiSfidante = commentiSfidante;
	}

	public String getCommentiSfidato() {
		return this.commentiSfidato;
	}

	public void setCommentiSfidato(String commentiSfidato) {
		this.commentiSfidato = commentiSfidato;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Prenotazione getPrenotazione() {
		return this.prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Socio getSocio1() {
		return this.socio1;
	}

	public void setSocio1(Socio socio1) {
		this.socio1 = socio1;
	}

	public Socio getSocio2() {
		return this.socio2;
	}

	public void setSocio2(Socio socio2) {
		this.socio2 = socio2;
	}

	public Socio getSocio3() {
		return this.socio3;
	}

	public void setSocio3(Socio socio3) {
		this.socio3 = socio3;
	}

}