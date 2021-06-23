package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the docente_especialidad database table.
 * 
 */
@Entity
@Table(name="docente_especialidad")
@NamedQuery(name="DocenteEspecialidad.findAll", query="SELECT d FROM DocenteEspecialidad d")
public class DocenteEspecialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_docente_especialidad")
	private long idDocenteEspecialidad;

	private BigDecimal cum;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_obtencion_grado")
	private Date fechaObtencionGrado;

	@Column(name="nombre_grado")
	private String nombreGrado;

	//bi-directional many-to-one association to DocenteAplicacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nip_docente")
	private DocenteAplicacion docenteAplicacion;

	//bi-directional many-to-one association to Especialidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_espec")
	private Especialidad especialidad;

	//bi-directional many-to-one association to GradoAcademico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_grado_academico")
	private GradoAcademico gradoAcademico;

	public DocenteEspecialidad() {
	}

	public long getIdDocenteEspecialidad() {
		return this.idDocenteEspecialidad;
	}

	public void setIdDocenteEspecialidad(long idDocenteEspecialidad) {
		this.idDocenteEspecialidad = idDocenteEspecialidad;
	}

	public BigDecimal getCum() {
		return this.cum;
	}

	public void setCum(BigDecimal cum) {
		this.cum = cum;
	}

	public Date getFechaObtencionGrado() {
		return this.fechaObtencionGrado;
	}

	public void setFechaObtencionGrado(Date fechaObtencionGrado) {
		this.fechaObtencionGrado = fechaObtencionGrado;
	}

	public String getNombreGrado() {
		return this.nombreGrado;
	}

	public void setNombreGrado(String nombreGrado) {
		this.nombreGrado = nombreGrado;
	}

	public DocenteAplicacion getDocenteAplicacion() {
		return this.docenteAplicacion;
	}

	public void setDocenteAplicacion(DocenteAplicacion docenteAplicacion) {
		this.docenteAplicacion = docenteAplicacion;
	}

	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public GradoAcademico getGradoAcademico() {
		return this.gradoAcademico;
	}

	public void setGradoAcademico(GradoAcademico gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}

}