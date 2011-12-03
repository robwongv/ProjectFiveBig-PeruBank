package bastanteo;

import java.util.List;

public class Bastanteo {
	private String codigoBastanteo;
	private List<Poder> poderes;
	private String grupo;
	private String codigoCliente;
	private String tipoIntervencion;
	private List<Grupo> grupos;
	private double importe;
	private String fechaVencimiento;

	public Bastanteo(String codigoBastanteo,List<Poder> poderes,String grupo, String codigoCliente
			,String tipoIntervencion,List<Grupo> grupos,double importe,String fechaVencimiento) {
		super();  
		this.codigoBastanteo=codigoBastanteo;
		this.poderes = poderes;
		this.grupo=grupo;
		this.codigoCliente=codigoCliente;
		this.tipoIntervencion=tipoIntervencion;
		this.grupos=grupos;
		this.importe=importe;
		this.fechaVencimiento=fechaVencimiento;
	}

	public String getCodigoBastanteo() {
		return codigoBastanteo;
	}

	public List<Poder> getPoderes() {
		return poderes;
	}

	public String getGrupo() {
		return grupo;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public String getTipoIntervencion() {
		return tipoIntervencion;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public double getImporte() {
		return importe;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	

}
