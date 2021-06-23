package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel_educativo database table.
 * 
 */
@Entity
@Table(name="nivel_educativo")
@NamedQuery(name="NivelEducativo.findAll", query="SELECT n FROM NivelEducativo n")
public class NivelEducativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_nivel")
	private Integer idNivel;

	@Column(name="nombre_nivel")
	private String nombreNivel;

	//bi-directional many-to-one association to Plaza
	@OneToMany(mappedBy="nivelEducativo")
	private List<Plaza> plazas;

	public NivelEducativo() {
	}

	public Integer getIdNivel() {
		return this.idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public String getNombreNivel() {
		return this.nombreNivel;
	}

	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}

	public List<Plaza> getPlazas() {
		return this.plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	public Plaza addPlaza(Plaza plaza) {
		getPlazas().add(plaza);
		plaza.setNivelEducativo(this);

		return plaza;
	}

	public Plaza removePlaza(Plaza plaza) {
		getPlazas().remove(plaza);
		plaza.setNivelEducativo(null);

		return plaza;
	}

}