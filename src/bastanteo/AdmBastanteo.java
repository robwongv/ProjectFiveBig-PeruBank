package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmBastanteo {

	List<Bastanteo> bastanteos;

	public AdmBastanteo() {
		bastanteos = new ArrayList<Bastanteo>();
	}

	public void registrarBastanteo(String codigoBastanteo, List<Poder> poderes,
			String grupo, String codigoCliente, String tipoIntervencion,
			List<Grupo> grupos, double importe, String fechaVencimiento)
			throws BastanteoException {

		// validar datos
		validarDatos(codigoBastanteo, poderes, grupo, codigoCliente,
				tipoIntervencion, grupos, importe, fechaVencimiento);

		// validar que no haya duplicados
		validarDuplicado(codigoBastanteo, poderes, grupo, codigoCliente,
				tipoIntervencion, grupos, importe, fechaVencimiento);

		// Creamos un nuevo bastanteo
		Bastanteo nuevoBastanteo = new Bastanteo(codigoBastanteo, poderes,
				grupo, codigoCliente, tipoIntervencion, grupos, importe,
				fechaVencimiento);
		// añaden a la lista
		bastanteos.add(nuevoBastanteo);

	}

	private void validarDuplicado(String codigoBastanteo, List<Poder> poderes,
			String grupo, String codigoCliente, String tipoIntervencion,
			List<Grupo> grupos, double importe, String fechaVencimiento)
			throws BastanteoException {

		if (bastanteoExiste(codigoBastanteo, poderes, grupo, codigoCliente,
				tipoIntervencion, grupos, importe, fechaVencimiento))
			throw new BastanteoException("Bastanteo Duplicado");
	}

	private boolean bastanteoExiste(String codigoBastanteo,
			List<Poder> poderes, String grupo, String codigoCliente,
			String tipoIntervencion, List<Grupo> grupos, double importe,
			String fechaVencimiento) {
		boolean existe = false;
		boolean existeDatoAdicionales = false;
		boolean existePoder = false;
		boolean existeCombinacionGrupo = false;
		int nroEncontrados = 0;

		// Valido poderes existentes
		for (Bastanteo bastanteo : bastanteos) {
			for (Poder poderBastanteo : bastanteo.getPoderes()) {
				for (Poder poder : poderes) {
					if (poder.getCodigo().equals(poderBastanteo.getCodigo())) {
						existePoder = true;
						break;
					}
				}

			}
		}

		// Si hay datos de combinacion de grupos
		if (!grupos.isEmpty()) {

			// Valido combinacion de grupos
			for (Bastanteo bastanteo : bastanteos) {
				for (Grupo grupoBastanteo : bastanteo.getGrupos()) {
					for (Grupo grupoI : grupos) {
						if (grupoI.getCodigo().equals(
								grupoBastanteo.getCodigo())) {
							nroEncontrados++;
						}
					}

				}
			}

			if (nroEncontrados == grupos.size())
				existeCombinacionGrupo = true;

		}

		// Valido datos adicionales
		for (Bastanteo bastanteo : bastanteos)
			if (bastanteo.getCodigoBastanteo().equals(codigoBastanteo)
					&& bastanteo.getGrupo().equals(grupo)
					&& bastanteo.getCodigoCliente().equals(codigoCliente)
					&& bastanteo.getTipoIntervencion().equals(tipoIntervencion))
				existeDatoAdicionales = true;

		// Verifico el resultado de todos los datos
		if (existeDatoAdicionales == true && existePoder == true
				&& existeCombinacionGrupo == true)
			existe = true;

		return existe;
	}

	private void validarDatos(String codigoBastanteo, List<Poder> poderes,
			String grupo, String codigoCliente, String tipoIntervencion,
			List<Grupo> grupos, double importe, String fechaVencimiento)
			throws BastanteoException {
		String mensaje = "";
		if (codigoBastanteo.equals(""))
			mensaje += "Codigo no puede ser vacio";
		if (poderes.size() == 0)
			mensaje += "\nListado de poderes no puede ser vacio";
		if (grupo.equals(""))
			mensaje += "\nGrupo no puede ser vacio";
		if (codigoCliente.equals(""))
			mensaje += "\nCliente no puede ser vacio";
		if (tipoIntervencion.equals(""))
			mensaje += "\nTipo de intervención no puede ser vacio";
		if (Double.toString(importe).equals("") || importe < 0.0)
			mensaje += "\nTipo de intervención no puede ser vacio";
		if (fechaVencimiento.equals(""))
			mensaje += "\nTipo de intervención no puede ser vacio o menor/igual a cero";
		if (!mensaje.equals(""))
			throw new BastanteoException(mensaje);

	}

	public Bastanteo buscarBastanteo(String codigoBastanteo) {
		for (Bastanteo bastanteo : bastanteos)
			if (bastanteo.getCodigoBastanteo().equals(codigoBastanteo))
				return bastanteo;
		return null;
	}
}
