package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the docente_discapacidad database table.
 * 
 */
@Entity
@Table(name="docente_discapacidad")
@NamedQuery(name="DocenteDiscapacidad.findAll", query="SELECT d FROM DocenteDiscapacidad d")
public class DocenteDiscapacidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_discapacidad")
	private long idDiscapacidad;

	@Column(name="descripcion_discapacidad")
	private String descripcionDiscapacidad;

	//bi-directional many-to-one association to DocenteAplicacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nip_docente")
	private DocenteAplicacion docenteAplicacion;

	public DocenteDiscapacidad() {
	}

	public long getIdDiscapacidad() {
		return this.idDiscapacidad;
	}

	public void setIdDiscapacidad(long idDiscapacidad) {
		this.idDiscapacidad = idDiscapacidad;
	}

	public String getDescripcionDiscapacidad() {
		return this.descripcionDiscapacidad;
	}

	public void setDescripcionDiscapacidad(String descripcionDiscapacidad) {
		this.descripcionDiscapacidad = descripcionDiscapacidad;
	}

	public DocenteAplicacion getDocenteAplicacion() {
		return this.docenteAplicacion;
	}

	public void setDocenteAplicacion(DocenteAplicacion docenteAplicacion) {
		this.docenteAplicacion = docenteAplicacion;
	}

}