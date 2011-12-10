package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmAbogados {

	List<Representate> listRepresentate;

	public AdmAbogados() {
		// TODO Auto-generated method stub
		listRepresentate = new ArrayList<Representate>();
	}

	public void inscribirRepresentate(String tipoDocumento,
			String numeroDocumento, String nombres, String apellidos,
			String cargoEmpresa, String grupoBastanteo,String codigoCliente)
			throws RepresentanteException {
		// TODO Auto-generated method stub		
		// validar datos

		 validarDatos(tipoDocumento, numeroDocumento, nombres, apellidos,
				cargoEmpresa, grupoBastanteo,codigoCliente);

		// validar que no haya duplicados
		validarDuplicado(tipoDocumento, numeroDocumento,codigoCliente);

		// Creamos un Representate
		Representate oRepresentate = new Representate(tipoDocumento,
				numeroDocumento, nombres, apellidos, cargoEmpresa,
				grupoBastanteo,codigoCliente);
		// añaden a la lista
		listRepresentate.add(oRepresentate);
	}

	private Boolean validarDatos(String tipoDocumento, String numeroDocumento,
			String nombres, String apellidos, String cargoEmpresa,
			String grupoBastanteo, String codigoCliente) throws RepresentanteException {
		// TODO Auto-generated method stub
		Boolean ret = false;

		String mensaje = "";
		if (tipoDocumento.equals(""))
			mensaje += "TipoDocumento no puede ser vacio";
		if (numeroDocumento.equals(""))
			mensaje += "\nNumero Documento no puede ser vacio";
		if (nombres.equals(""))
			mensaje += "\nNombres no puede ser vacio";
		if (apellidos.equals(""))
			mensaje += "\nApellidos de inicio no puede ser vacio";
		if (cargoEmpresa.equals(""))
			mensaje += "\nCargoEmpresa de empresa no puede ser vacio";
		if (grupoBastanteo.equals(""))
			mensaje += "\nGrupo Bastanteo de empresa no puede ser vacio";

		if (codigoCliente.equals(""))
			mensaje += "\nCódigo de Cliente no puede ser vacio";

		if (!mensaje.equals(""))
			throw new RepresentanteException(mensaje);
		else
			ret = true;

		return ret;
	}

	private Boolean validarDuplicado(String tipoDocumento,
			String numeroDocumento,String codigoCliente) throws RepresentanteException {
		// TODO Auto-generated method stub
		Boolean ret = false;
		if (RepresentanteExiste(tipoDocumento, numeroDocumento,codigoCliente))
			throw new RepresentanteException("Representante Duplicado");
		else
			ret = true;

		return ret;
	}

	private boolean RepresentanteExiste(final String tipoDocumento,
			final String numeroDocumento,final String codigoCliente) {
		// TODO Auto-generated method stub
		boolean existe = false;
		for (Representate representate : listRepresentate)
			if (representate.getTipoDocumento().equals(tipoDocumento)
					&& representate.getNumeroDocumento()
							.equals(numeroDocumento)
					&& representate.getCodigoCliente()
					.equals(codigoCliente))
				
				existe = true;
		return existe;
	}

	public Representate buscarRepresentante(String tipoDocumento,String numeroDocumento,
			String codigoCliente) {
		// TODO Auto-generated method stub
        for(Representate representante : listRepresentate)
			if (representante.getTipoDocumento().equals(tipoDocumento)
					&& representante.getNumeroDocumento()
							.equals(numeroDocumento)
					&& representante.getCodigoCliente()
					.equals(codigoCliente))
                return representante;
        return null;
	}

}
