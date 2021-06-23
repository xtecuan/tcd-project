package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the centro_educativo database table.
 * 
 */
@Entity
@Table(name="centro_educativo")
@NamedQuery(name="CentroEducativo.findAll", query="SELECT c FROM CentroEducativo c")
public class CentroEducativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_ce")
	private long codigoCe;

	@Column(name="nombre_ce")
	private String nombreCe;

	//bi-directional many-to-one association to Departamento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_depto")
	private Departamento departamento;

	//bi-directional many-to-one association to Municipio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_munic")
	private Municipio municipio;

	//bi-directional many-to-one association to Plaza
	@OneToMany(mappedBy="centroEducativo")
	private List<Plaza> plazas;

	public CentroEducativo() {
	}

	public long getCodigoCe() {
		return this.codigoCe;
	}

	public void setCodigoCe(long codigoCe) {
		this.codigoCe = codigoCe;
	}

	public String getNombreCe() {
		return this.nombreCe;
	}

	public void setNombreCe(String nombreCe) {
		this.nombreCe = nombreCe;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Plaza> getPlazas() {
		return this.plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	public Plaza addPlaza(Plaza plaza) {
		getPlazas().add(plaza);
		plaza.setCentroEducativo(this);

		return plaza;
	}

	public Plaza removePlaza(Plaza plaza) {
		getPlazas().remove(plaza);
		plaza.setCentroEducativo(null);

		return plaza;
	}

}