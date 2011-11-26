package bastanteo;

public class Poder {
	private String codigo;
	private String nombre;
	private String tipoProducto;

	public Poder(String codigo, String nombre, String tipoProducto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoProducto = tipoProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

}
