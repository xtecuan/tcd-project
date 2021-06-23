package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_depto")
	private String idDepto;

	@Column(name="nombre_depto")
	private String nombreDepto;

	//bi-directional many-to-one association to CentroEducativo
	@OneToMany(mappedBy="departamento")
	private List<CentroEducativo> centroEducativos;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="departamento")
	private List<Municipio> municipios;

	public Departamento() {
	}

	public String getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(String idDepto) {
		this.idDepto = idDepto;
	}

	public String getNombreDepto() {
		return this.nombreDepto;
	}

	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}

	public List<CentroEducativo> getCentroEducativos() {
		return this.centroEducativos;
	}

	public void setCentroEducativos(List<CentroEducativo> centroEducativos) {
		this.centroEducativos = centroEducativos;
	}

	public CentroEducativo addCentroEducativo(CentroEducativo centroEducativo) {
		getCentroEducativos().add(centroEducativo);
		centroEducativo.setDepartamento(this);

		return centroEducativo;
	}

	public CentroEducativo removeCentroEducativo(CentroEducativo centroEducativo) {
		getCentroEducativos().remove(centroEducativo);
		centroEducativo.setDepartamento(null);

		return centroEducativo;
	}

	public List<Municipio> getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Municipio addMunicipio(Municipio municipio) {
		getMunicipios().add(municipio);
		municipio.setDepartamento(this);

		return municipio;
	}

	public Municipio removeMunicipio(Municipio municipio) {
		getMunicipios().remove(municipio);
		municipio.setDepartamento(null);

		return municipio;
	}

}