package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nip;

	@Column(name="apellidos_docente")
	private String apellidosDocente;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso_ce_actual")
	private Date fechaIngresoCeActual;

	@Column(name="nombres_docente")
	private String nombresDocente;

	@Column(name="plaza_asignada")
	private BigDecimal plazaAsignada;

	//bi-directional one-to-one association to DocenteAplicacion
	@OneToOne(mappedBy="docente", fetch=FetchType.LAZY)
	private DocenteAplicacion docenteAplicacion;

	public Docente() {
	}

	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getApellidosDocente() {
		return this.apellidosDocente;
	}

	public void setApellidosDocente(String apellidosDocente) {
		this.apellidosDocente = apellidosDocente;
	}

	public Date getFechaIngresoCeActual() {
		return this.fechaIngresoCeActual;
	}

	public void setFechaIngresoCeActual(Date fechaIngresoCeActual) {
		this.fechaIngresoCeActual = fechaIngresoCeActual;
	}

	public String getNombresDocente() {
		return this.nombresDocente;
	}

	public void setNombresDocente(String nombresDocente) {
		this.nombresDocente = nombresDocente;
	}

	public BigDecimal getPlazaAsignada() {
		return this.plazaAsignada;
	}

	public void setPlazaAsignada(BigDecimal plazaAsignada) {
		this.plazaAsignada = plazaAsignada;
	}

	public DocenteAplicacion getDocenteAplicacion() {
		return this.docenteAplicacion;
	}

	public void setDocenteAplicacion(DocenteAplicacion docenteAplicacion) {
		this.docenteAplicacion = docenteAplicacion;
	}

}