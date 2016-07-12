package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "SOCIO")
@NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SOCIO_ID_GENERATOR", sequenceName = "SOCIO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOCIO_ID_GENERATOR")
	@Column(unique = true, nullable = false, precision = 38)
	private long id;
	
	@OneToOne(mappedBy="socio", cascade={CascadeType.ALL})
	@JsonManagedReference
	private CategoriaFit categoria;

	@Column(nullable = false, length = 32)
	private String address;

	@Column(nullable = false, length = 32)
	private String city;

	@Column(name = "FIRST_NAME", nullable = false, length = 32)
	private String firstName;

	@Column(name = "HOME_PHONE_NUMBER", length = 16)
	private String homePhoneNumber;

	@Column(name = "LAST_NAME", nullable = false, length = 32)
	private String lastName;

	@Column(name = "MOBILE_NUMBER", length = 16)
	private String mobileNumber;

	@Column(nullable = false, length = 1)
	private String sex;

	@JsonManagedReference
	@OneToOne(mappedBy = "asSocio", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Maestro asMaestro;

	@JsonManagedReference
	@OneToMany(mappedBy = "socio", fetch = FetchType.EAGER)
	private List<Prenotazione> prenotazioni;

	public Socio() {
	}

	public Socio(String address, String city, String firstName, String homePhoneNumber, String lastName,
			String mobileNumber, String sex) {
		this.address = address;
		this.city = city;
		this.firstName = firstName;
		this.homePhoneNumber = homePhoneNumber;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.sex = sex;

	}

	public CategoriaFit getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaFit categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHomePhoneNumber() {
		return this.homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Maestro getMaestroi() {
		return this.asMaestro;
	}

	public void setAsMaestro(Maestro maestro) {
		this.asMaestro = maestro;
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Prenotazione addPrenotazioni(Prenotazione prenotazioni) {
		getPrenotazioni().add(prenotazioni);
		prenotazioni.setSocio(this);

		return prenotazioni;
	}

	public Prenotazione removePrenotazioni(Prenotazione prenotazioni) {
		getPrenotazioni().remove(prenotazioni);
		prenotazioni.setSocio(null);

		return prenotazioni;
	}

}