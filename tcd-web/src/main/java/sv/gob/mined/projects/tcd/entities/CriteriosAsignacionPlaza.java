package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the criterios_asignacion_plaza database table.
 * 
 */
@Entity
@Table(name="criterios_asignacion_plaza")
@NamedQuery(name="CriteriosAsignacionPlaza.findAll", query="SELECT c FROM CriteriosAsignacionPlaza c")
public class CriteriosAsignacionPlaza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_criterio_asignacion")
	private long idCriterioAsignacion;

	//bi-directional many-to-one association to AplicacionDocentePlaza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aplicacion_plaza")
	private AplicacionDocentePlaza aplicacionDocentePlaza;

	//bi-directional many-to-one association to Criterio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_criterio")
	private Criterio criterio;

	public CriteriosAsignacionPlaza() {
	}

	public long getIdCriterioAsignacion() {
		return this.idCriterioAsignacion;
	}

	public void setIdCriterioAsignacion(long idCriterioAsignacion) {
		this.idCriterioAsignacion = idCriterioAsignacion;
	}

	public AplicacionDocentePlaza getAplicacionDocentePlaza() {
		return this.aplicacionDocentePlaza;
	}

	public void setAplicacionDocentePlaza(AplicacionDocentePlaza aplicacionDocentePlaza) {
		this.aplicacionDocentePlaza = aplicacionDocentePlaza;
	}

	public Criterio getCriterio() {
		return this.criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

}