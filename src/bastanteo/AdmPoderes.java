package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmPoderes {

	List<Poder> poderes;

	public AdmPoderes() {
		poderes = new ArrayList<Poder>();
	}

	public void registrarPoder(String codigo, String nombre, String tipoProducto)
			throws PoderException {

		validarDatos(codigo, nombre, tipoProducto);

		validarDuplicado(codigo);

		Poder nuevoPoder = new Poder(codigo, nombre, tipoProducto);

		poderes.add(nuevoPoder);

	}

	private void validarDuplicado(String codigo) throws PoderException {

		if (poderExiste(codigo))
			throw new PoderException("Poder Duplicado");
	}

	private boolean poderExiste(String codigo) {
		boolean existe = false;
		for (Poder poder : poderes)
			if (poder.getCodigo().equals(codigo))
				existe = true;
		return existe;
	}

	private void validarDatos(String codigo, String nombre, String tipoProducto)
			throws PoderException {
		String mensaje = "";
		if (codigo.equals(""))
			mensaje += "Codigo no puede ser vacio";
		if (nombre.equals(""))
			mensaje += "\nNombre no puede ser vacio";
		if (tipoProducto.equals(""))
			mensaje += "\nTipo de Producto no puede ser vacio";
		if (!mensaje.equals(""))
			throw new PoderException(mensaje);
	}

	public Poder buscarPoder(String codigo) {
		for (Poder poder : poderes)
			if (poder.getCodigo().equals(codigo))
				return poder;
		return null;
	}

}
