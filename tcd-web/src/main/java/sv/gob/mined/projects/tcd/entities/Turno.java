package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_turno")
	private Integer idTurno;

	@Column(name="nombre_turno")
	private String nombreTurno;

	//bi-directional many-to-one association to Plaza
	@OneToMany(mappedBy="turno")
	private List<Plaza> plazas;

	public Turno() {
	}

	public Integer getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public String getNombreTurno() {
		return this.nombreTurno;
	}

	public void setNombreTurno(String nombreTurno) {
		this.nombreTurno = nombreTurno;
	}

	public List<Plaza> getPlazas() {
		return this.plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	public Plaza addPlaza(Plaza plaza) {
		getPlazas().add(plaza);
		plaza.setTurno(this);

		return plaza;
	}

	public Plaza removePlaza(Plaza plaza) {
		getPlazas().remove(plaza);
		plaza.setTurno(null);

		return plaza;
	}

}