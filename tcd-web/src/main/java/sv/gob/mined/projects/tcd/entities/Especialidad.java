package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especialidad database table.
 * 
 */
@Entity
@NamedQuery(name="Especialidad.findAll", query="SELECT e FROM Especialidad e")
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_espec")
	private Integer idEspec;

	@Column(name="nombre_espec")
	private String nombreEspec;

	//bi-directional many-to-one association to DocenteEspecialidad
	@OneToMany(mappedBy="especialidad")
	private List<DocenteEspecialidad> docenteEspecialidads;

	//bi-directional many-to-one association to Plaza
	@OneToMany(mappedBy="especialidad")
	private List<Plaza> plazas;

	public Especialidad() {
	}

	public Integer getIdEspec() {
		return this.idEspec;
	}

	public void setIdEspec(Integer idEspec) {
		this.idEspec = idEspec;
	}

	public String getNombreEspec() {
		return this.nombreEspec;
	}

	public void setNombreEspec(String nombreEspec) {
		this.nombreEspec = nombreEspec;
	}

	public List<DocenteEspecialidad> getDocenteEspecialidads() {
		return this.docenteEspecialidads;
	}

	public void setDocenteEspecialidads(List<DocenteEspecialidad> docenteEspecialidads) {
		this.docenteEspecialidads = docenteEspecialidads;
	}

	public DocenteEspecialidad addDocenteEspecialidad(DocenteEspecialidad docenteEspecialidad) {
		getDocenteEspecialidads().add(docenteEspecialidad);
		docenteEspecialidad.setEspecialidad(this);

		return docenteEspecialidad;
	}

	public DocenteEspecialidad removeDocenteEspecialidad(DocenteEspecialidad docenteEspecialidad) {
		getDocenteEspecialidads().remove(docenteEspecialidad);
		docenteEspecialidad.setEspecialidad(null);

		return docenteEspecialidad;
	}

	public List<Plaza> getPlazas() {
		return this.plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	public Plaza addPlaza(Plaza plaza) {
		getPlazas().add(plaza);
		plaza.setEspecialidad(this);

		return plaza;
	}

	public Plaza removePlaza(Plaza plaza) {
		getPlazas().remove(plaza);
		plaza.setEspecialidad(null);

		return plaza;
	}

}