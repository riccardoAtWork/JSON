package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name="MAESTRO")
@NamedQuery(name="Maestro.findAll", query="SELECT m FROM Maestro m")
public class Maestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAESTRO_ID_GENERATOR", sequenceName="MAESTRO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAESTRO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_CONSEGUIMENTO")
	private Date dataConseguimento;

	@Column(precision=1)
	private int livello;

	@Column(length=20)
	private String qualifica;

	//bi-directional many-to-one association to Socio
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ID_SOCIO")
	@JsonBackReference
	private Socio asSocio;

	//bi-directional many-to-one association to Prenotazione
	@JsonManagedReference
	@OneToMany(mappedBy="maestro", fetch=FetchType.EAGER)
	private List<Prenotazione> prenotazioni;

	public Maestro() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataConseguimento() {
		return this.dataConseguimento;
	}

	public void setDataConseguimento(Date dataConseguimento) {
		this.dataConseguimento = dataConseguimento;
	}

	public int getLivello() {
		return this.livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public String getQualifica() {
		return this.qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	public Socio getAsSocio() {
		return this.asSocio;
	}

	public void setSocio(Socio socio) {
		this.asSocio = socio;
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Prenotazione addPrenotazioni(Prenotazione prenotazioni) {
		getPrenotazioni().add(prenotazioni);
		prenotazioni.setMaestro(this);

		return prenotazioni;
	}

	public Prenotazione removePrenotazioni(Prenotazione prenotazioni) {
		getPrenotazioni().remove(prenotazioni);
		prenotazioni.setMaestro(null);

		return prenotazioni;
	}

}