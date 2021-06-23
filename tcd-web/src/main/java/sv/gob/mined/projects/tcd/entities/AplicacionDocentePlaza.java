package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the aplicacion_docente_plaza database table.
 * 
 */
@Entity
@Table(name="aplicacion_docente_plaza")
@NamedQuery(name="AplicacionDocentePlaza.findAll", query="SELECT a FROM AplicacionDocentePlaza a")
public class AplicacionDocentePlaza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_aplicacion_plaza")
	private long idAplicacionPlaza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_asignacion_plaza")
	private Date fechaAsignacionPlaza;

	private String observacion;

	//bi-directional many-to-one association to DocenteAplicacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nip_docente")
	private DocenteAplicacion docenteAplicacion;

	//bi-directional many-to-one association to Plaza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_plaza")
	private Plaza plaza;

	//bi-directional many-to-one association to CriteriosAsignacionPlaza
	@OneToMany(mappedBy="aplicacionDocentePlaza")
	private List<CriteriosAsignacionPlaza> criteriosAsignacionPlazas;

	public AplicacionDocentePlaza() {
	}

	public long getIdAplicacionPlaza() {
		return this.idAplicacionPlaza;
	}

	public void setIdAplicacionPlaza(long idAplicacionPlaza) {
		this.idAplicacionPlaza = idAplicacionPlaza;
	}

	public Date getFechaAsignacionPlaza() {
		return this.fechaAsignacionPlaza;
	}

	public void setFechaAsignacionPlaza(Date fechaAsignacionPlaza) {
		this.fechaAsignacionPlaza = fechaAsignacionPlaza;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public DocenteAplicacion getDocenteAplicacion() {
		return this.docenteAplicacion;
	}

	public void setDocenteAplicacion(DocenteAplicacion docenteAplicacion) {
		this.docenteAplicacion = docenteAplicacion;
	}

	public Plaza getPlaza() {
		return this.plaza;
	}

	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}

	public List<CriteriosAsignacionPlaza> getCriteriosAsignacionPlazas() {
		return this.criteriosAsignacionPlazas;
	}

	public void setCriteriosAsignacionPlazas(List<CriteriosAsignacionPlaza> criteriosAsignacionPlazas) {
		this.criteriosAsignacionPlazas = criteriosAsignacionPlazas;
	}

	public CriteriosAsignacionPlaza addCriteriosAsignacionPlaza(CriteriosAsignacionPlaza criteriosAsignacionPlaza) {
		getCriteriosAsignacionPlazas().add(criteriosAsignacionPlaza);
		criteriosAsignacionPlaza.setAplicacionDocentePlaza(this);

		return criteriosAsignacionPlaza;
	}

	public CriteriosAsignacionPlaza removeCriteriosAsignacionPlaza(CriteriosAsignacionPlaza criteriosAsignacionPlaza) {
		getCriteriosAsignacionPlazas().remove(criteriosAsignacionPlaza);
		criteriosAsignacionPlaza.setAplicacionDocentePlaza(null);

		return criteriosAsignacionPlaza;
	}

}