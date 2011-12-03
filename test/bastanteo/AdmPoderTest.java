package bastanteo;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class AdmPoderTest {

	@Test
	public void siIngresoDatosDeberiaRegistrarPoder() throws PoderException {
		String codigo = "CHCO";
		String nombre = "Cobro de cheques";
		String tipoProducto = "Activo";

		AdmPoderes adm = new AdmPoderes();
		adm.registrarPoder(codigo, nombre, tipoProducto);
		Poder poder = adm.buscarPoder(codigo);
		assertNotNull(poder);
	}

	@Test(expected = PoderException.class)
	public void deberiaValidarDatosRequeridos() throws PoderException {

		String codigo = "";
		String nombre = "";
		String tipoProducto = "";
		AdmPoderes adm = new AdmPoderes();
		adm.registrarPoder(codigo, nombre, tipoProducto);
	}

	@Test(expected = PoderException.class)
	public void noDeberiaRegistrarPoderesDuplicados() throws PoderException {

		String codigo = "CHCO";
		String nombre = "Cobro de cheques";
		String tipoProducto = "Activo";

		AdmPoderes adm = new AdmPoderes();
		adm.registrarPoder(codigo, nombre, tipoProducto);
		adm.registrarPoder(codigo, nombre, tipoProducto);
	}

}
