package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


//prova
@Entity
@Table(name="CAMPO")
@NamedQuery(name="Campo.findAll", query="SELECT c FROM Campo c")
public class Campo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAMPO_ID_GENERATOR", sequenceName="CAMPO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAMPO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=19)
	private long id;

	
	private int coperto;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_RIFACIMENTO")
	private Date dataRifacimento;

	@Column(length=255)
	private String nome;

	@Column(length=255)
	private String stato;

	@Column(length=255)
	private String tipo;

	public Campo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCoperto() {
		return this.coperto;
	}

	public void setCoperto(int coperto) {
		this.coperto = coperto;
	}

	public Date getDataRifacimento() {
		return this.dataRifacimento;
	}

	public void setDataRifacimento(Date dataRifacimento) {
		this.dataRifacimento = dataRifacimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}