package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the criterios database table.
 * 
 */
@Entity
@Table(name="criterios")
@NamedQuery(name="Criterio.findAll", query="SELECT c FROM Criterio c")
public class Criterio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_criterio")
	private long idCriterio;

	@Column(name="descripcion_criterio")
	private String descripcionCriterio;

	//bi-directional many-to-one association to CriteriosAsignacionPlaza
	@OneToMany(mappedBy="criterio")
	private List<CriteriosAsignacionPlaza> criteriosAsignacionPlazas;

	public Criterio() {
	}

	public long getIdCriterio() {
		return this.idCriterio;
	}

	public void setIdCriterio(long idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getDescripcionCriterio() {
		return this.descripcionCriterio;
	}

	public void setDescripcionCriterio(String descripcionCriterio) {
		this.descripcionCriterio = descripcionCriterio;
	}

	public List<CriteriosAsignacionPlaza> getCriteriosAsignacionPlazas() {
		return this.criteriosAsignacionPlazas;
	}

	public void setCriteriosAsignacionPlazas(List<CriteriosAsignacionPlaza> criteriosAsignacionPlazas) {
		this.criteriosAsignacionPlazas = criteriosAsignacionPlazas;
	}

	public CriteriosAsignacionPlaza addCriteriosAsignacionPlaza(CriteriosAsignacionPlaza criteriosAsignacionPlaza) {
		getCriteriosAsignacionPlazas().add(criteriosAsignacionPlaza);
		criteriosAsignacionPlaza.setCriterio(this);

		return criteriosAsignacionPlaza;
	}

	public CriteriosAsignacionPlaza removeCriteriosAsignacionPlaza(CriteriosAsignacionPlaza criteriosAsignacionPlaza) {
		getCriteriosAsignacionPlazas().remove(criteriosAsignacionPlaza);
		criteriosAsignacionPlaza.setCriterio(null);

		return criteriosAsignacionPlaza;
	}

}