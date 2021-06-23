package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the parametros database table.
 * 
 */
@Entity
@Table(name="parametros")
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_parametro")
	private long idParametro;

	@Column(name="nombre_parametro")
	private String nombreParametro;

	@Column(name="valor_cadena")
	private String valorCadena;

	@Temporal(TemporalType.DATE)
	@Column(name="valor_fecha")
	private Date valorFecha;

	@Column(name="valor_numerico")
	private BigDecimal valorNumerico;

	public Parametro() {
	}

	public long getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(long idParametro) {
		this.idParametro = idParametro;
	}

	public String getNombreParametro() {
		return this.nombreParametro;
	}

	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}

	public String getValorCadena() {
		return this.valorCadena;
	}

	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	public Date getValorFecha() {
		return this.valorFecha;
	}

	public void setValorFecha(Date valorFecha) {
		this.valorFecha = valorFecha;
	}

	public BigDecimal getValorNumerico() {
		return this.valorNumerico;
	}

	public void setValorNumerico(BigDecimal valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

}