package bastanteo;

public class Representate {

	private String tipoDocumento;
	private String numeroDocumento;
	private String nombres;
	private String apellidos;
	private String cargoEmpresa;
	private String grupoBastanteo;

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombres() {
		return nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setCargoEmpresa(String cargoEmpresa) {
		this.cargoEmpresa = cargoEmpresa;
	}

	public String getCargoEmpresa() {
		return cargoEmpresa;
	}

	public void setGrupoBastanteo(String grupoBastanteo) {
		this.grupoBastanteo = grupoBastanteo;
	}

	public String getGrupoBastanteo() {
		return grupoBastanteo;
	}

	public Representate(String tipoDocumento, String numeroDocumento,
			String nombres, String apellidos, String cargoEmpresa,
			String grupoBastanteo) {
		// TODO Auto-generated constructor stub
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cargoEmpresa = cargoEmpresa;
		this.grupoBastanteo = grupoBastanteo;
	}

	public Representate() {
		// TODO Auto-generated constructor stub
	}
}
