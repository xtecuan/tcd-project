package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the plazas database table.
 * 
 */
@Entity
@Table(name="plazas")
@NamedQuery(name="Plaza.findAll", query="SELECT p FROM Plaza p")
public class Plaza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_plaza")
	private long idPlaza;

	@Column(name="descripcion_plaza")
	private String descripcionPlaza;

	@Column(name="estado_plaza")
	private BigDecimal estadoPlaza;

	@Column(name="id_depto")
	private String idDepto;

	@Column(name="id_munic")
	private String idMunic;

	//bi-directional many-to-one association to AplicacionDocentePlaza
	@OneToMany(mappedBy="plaza")
	private List<AplicacionDocentePlaza> aplicacionDocentePlazas;

	//bi-directional many-to-one association to CentroEducativo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo_ce")
	private CentroEducativo centroEducativo;

	//bi-directional many-to-one association to Especialidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_espec")
	private Especialidad especialidad;

	//bi-directional many-to-one association to NivelEducativo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_nivel")
	private NivelEducativo nivelEducativo;

	//bi-directional many-to-one association to Turno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_turno")
	private Turno turno;

	public Plaza() {
	}

	public long getIdPlaza() {
		return this.idPlaza;
	}

	public void setIdPlaza(long idPlaza) {
		this.idPlaza = idPlaza;
	}

	public String getDescripcionPlaza() {
		return this.descripcionPlaza;
	}

	public void setDescripcionPlaza(String descripcionPlaza) {
		this.descripcionPlaza = descripcionPlaza;
	}

	public BigDecimal getEstadoPlaza() {
		return this.estadoPlaza;
	}

	public void setEstadoPlaza(BigDecimal estadoPlaza) {
		this.estadoPlaza = estadoPlaza;
	}

	public String getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(String idDepto) {
		this.idDepto = idDepto;
	}

	public String getIdMunic() {
		return this.idMunic;
	}

	public void setIdMunic(String idMunic) {
		this.idMunic = idMunic;
	}

	public List<AplicacionDocentePlaza> getAplicacionDocentePlazas() {
		return this.aplicacionDocentePlazas;
	}

	public void setAplicacionDocentePlazas(List<AplicacionDocentePlaza> aplicacionDocentePlazas) {
		this.aplicacionDocentePlazas = aplicacionDocentePlazas;
	}

	public AplicacionDocentePlaza addAplicacionDocentePlaza(AplicacionDocentePlaza aplicacionDocentePlaza) {
		getAplicacionDocentePlazas().add(aplicacionDocentePlaza);
		aplicacionDocentePlaza.setPlaza(this);

		return aplicacionDocentePlaza;
	}

	public AplicacionDocentePlaza removeAplicacionDocentePlaza(AplicacionDocentePlaza aplicacionDocentePlaza) {
		getAplicacionDocentePlazas().remove(aplicacionDocentePlaza);
		aplicacionDocentePlaza.setPlaza(null);

		return aplicacionDocentePlaza;
	}

	public CentroEducativo getCentroEducativo() {
		return this.centroEducativo;
	}

	public void setCentroEducativo(CentroEducativo centroEducativo) {
		this.centroEducativo = centroEducativo;
	}

	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public NivelEducativo getNivelEducativo() {
		return this.nivelEducativo;
	}

	public void setNivelEducativo(NivelEducativo nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}