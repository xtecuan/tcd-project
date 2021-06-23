package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grado_academico database table.
 * 
 */
@Entity
@Table(name="grado_academico")
@NamedQuery(name="GradoAcademico.findAll", query="SELECT g FROM GradoAcademico g")
public class GradoAcademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_grado_academico")
	private long idGradoAcademico;

	@Column(name="grado_academico")
	private String gradoAcademico;

	//bi-directional many-to-one association to DocenteEspecialidad
	@OneToMany(mappedBy="gradoAcademico")
	private List<DocenteEspecialidad> docenteEspecialidads;

	public GradoAcademico() {
	}

	public long getIdGradoAcademico() {
		return this.idGradoAcademico;
	}

	public void setIdGradoAcademico(long idGradoAcademico) {
		this.idGradoAcademico = idGradoAcademico;
	}

	public String getGradoAcademico() {
		return this.gradoAcademico;
	}

	public void setGradoAcademico(String gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}

	public List<DocenteEspecialidad> getDocenteEspecialidads() {
		return this.docenteEspecialidads;
	}

	public void setDocenteEspecialidads(List<DocenteEspecialidad> docenteEspecialidads) {
		this.docenteEspecialidads = docenteEspecialidads;
	}

	public DocenteEspecialidad addDocenteEspecialidad(DocenteEspecialidad docenteEspecialidad) {
		getDocenteEspecialidads().add(docenteEspecialidad);
		docenteEspecialidad.setGradoAcademico(this);

		return docenteEspecialidad;
	}

	public DocenteEspecialidad removeDocenteEspecialidad(DocenteEspecialidad docenteEspecialidad) {
		getDocenteEspecialidads().remove(docenteEspecialidad);
		docenteEspecialidad.setGradoAcademico(null);

		return docenteEspecialidad;
	}

}