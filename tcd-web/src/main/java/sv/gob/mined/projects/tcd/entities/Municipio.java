package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_munic")
	private String idMunic;

	@Column(name="nombre_munic")
	private String nombreMunic;

	//bi-directional many-to-one association to CentroEducativo
	@OneToMany(mappedBy="municipio")
	private List<CentroEducativo> centroEducativos;

	//bi-directional many-to-one association to DocenteAplicacion
	@OneToMany(mappedBy="municipio")
	private List<DocenteAplicacion> docenteAplicacions;

	//bi-directional many-to-one association to Departamento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_depto")
	private Departamento departamento;

	public Municipio() {
	}

	public String getIdMunic() {
		return this.idMunic;
	}

	public void setIdMunic(String idMunic) {
		this.idMunic = idMunic;
	}

	public String getNombreMunic() {
		return this.nombreMunic;
	}

	public void setNombreMunic(String nombreMunic) {
		this.nombreMunic = nombreMunic;
	}

	public List<CentroEducativo> getCentroEducativos() {
		return this.centroEducativos;
	}

	public void setCentroEducativos(List<CentroEducativo> centroEducativos) {
		this.centroEducativos = centroEducativos;
	}

	public CentroEducativo addCentroEducativo(CentroEducativo centroEducativo) {
		getCentroEducativos().add(centroEducativo);
		centroEducativo.setMunicipio(this);

		return centroEducativo;
	}

	public CentroEducativo removeCentroEducativo(CentroEducativo centroEducativo) {
		getCentroEducativos().remove(centroEducativo);
		centroEducativo.setMunicipio(null);

		return centroEducativo;
	}

	public List<DocenteAplicacion> getDocenteAplicacions() {
		return this.docenteAplicacions;
	}

	public void setDocenteAplicacions(List<DocenteAplicacion> docenteAplicacions) {
		this.docenteAplicacions = docenteAplicacions;
	}

	public DocenteAplicacion addDocenteAplicacion(DocenteAplicacion docenteAplicacion) {
		getDocenteAplicacions().add(docenteAplicacion);
		docenteAplicacion.setMunicipio(this);

		return docenteAplicacion;
	}

	public DocenteAplicacion removeDocenteAplicacion(DocenteAplicacion docenteAplicacion) {
		getDocenteAplicacions().remove(docenteAplicacion);
		docenteAplicacion.setMunicipio(null);

		return docenteAplicacion;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}