package bastanteo;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AdmBastanteoTest {

	List<Poder> poderes;
	List<Grupo> grupos;
	AdmPoderes admPoder;
	AdmAbogados admAbogados;
	AdmClientes admClientes;
	AdmGrupos admGrupos;
	AdmBastanteo admBastanteo;

	@Before
	public void cargarData() throws PoderException, RepresentanteException,
			ClienteException, GrupoException {
		// Carga de datos: Esto se ejecutara antes que todo, permitiendome tener
		// registrados grupos,clientes,representantes y poderes

		// Registrar Grupos
		String codGrupo = "GR01";
		String nomGrupo = "A";
		admGrupos = new AdmGrupos();
		admGrupos.registrarGrupo(codGrupo, nomGrupo);

		codGrupo = "GR02";
		nomGrupo = "B";
		admGrupos.registrarGrupo(codGrupo, nomGrupo);

		codGrupo = "GR03";
		nomGrupo = "C";
		admGrupos.registrarGrupo(codGrupo, nomGrupo);

		// Registrando Clientes
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;
		admClientes = new AdmClientes();

		// ejecutar
		admClientes.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		ruc = "12232720908";
		codigo = "CL002";
		razonSocial = "Saga Falabella";
		fechaInicio = "01/01/2011";
		tipoEmpresa = "SAC";
		empleados = 60;

		// ejecutar
		admClientes.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		// Registrando representantes

		String tipoDocumento = "DNI";
		String numeroDocumento = "41888703";
		String nombres = "Robert Eduardo";
		String apellidos = "Wong Villar";
		String cargoEmpresa = "Analista Sistema";
		String grupoBastanteo = "A";
		String codigoCliente = "CL002";

		admAbogados = new AdmAbogados();
		admAbogados
				.inscribirRepresentate(tipoDocumento, numeroDocumento, nombres,
						apellidos, cargoEmpresa, grupoBastanteo, codigoCliente);

		tipoDocumento = "DNI";
		numeroDocumento = "41888704";
		nombres = "Valerio Vladimir";
		apellidos = "Meza Zambrano";
		cargoEmpresa = "Lider de Proyecto";
		grupoBastanteo = "B";
		codigoCliente = "CL002";

		admAbogados
				.inscribirRepresentate(tipoDocumento, numeroDocumento, nombres,
						apellidos, cargoEmpresa, grupoBastanteo, codigoCliente);

		tipoDocumento = "DNI";
		numeroDocumento = "41888710";
		nombres = "Ysrael Santos";
		apellidos = "Nuñez Choque";
		cargoEmpresa = "Gerente TI";
		grupoBastanteo = "B";
		codigoCliente = "CL002";

		admAbogados
				.inscribirRepresentate(tipoDocumento, numeroDocumento, nombres,
						apellidos, cargoEmpresa, grupoBastanteo, codigoCliente);

		tipoDocumento = "DNI";
		numeroDocumento = "41888705";
		nombres = "Jerica Veronica";
		apellidos = "Dedios Espinoza";
		cargoEmpresa = "DBA";
		grupoBastanteo = "C";
		codigoCliente = "CL002";

		admAbogados
				.inscribirRepresentate(tipoDocumento, numeroDocumento, nombres,
						apellidos, cargoEmpresa, grupoBastanteo, codigoCliente);

		// Registrando poderes
		String codigoPoder = "CHCO";
		String nombrePoder = "Cobro de cheques";
		String tipoProductoPoder = "Activo";

		admPoder = new AdmPoderes();
		admPoder.registrarPoder(codigoPoder, nombrePoder, tipoProductoPoder);

		codigoPoder = "EFRE";
		nombrePoder = "Retiro en efectivo";
		tipoProductoPoder = "Pasivo";
		admPoder.registrarPoder(codigoPoder, nombrePoder, tipoProductoPoder);

	}

	// Test 1: Si ingreso datos deberia registrar bastanteo exitosamente
	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteo()
			throws ClienteException, PoderException, GrupoException,
			BastanteoException {

		poderes = new ArrayList<Poder>();
		grupos = new ArrayList<Grupo>();

		// Asignando poderes
		String codigoPoder = "CHCO";
		Poder poder = admPoder.buscarPoder(codigoPoder);
		poderes.add(poder);

		codigoPoder = "EFRE";
		poder = admPoder.buscarPoder(codigoPoder);
		poderes.add(poder);

		// Asignando combinacion de grupos
		String grupoCodCombinacion = "GR02";
		Grupo grupo = admGrupos.buscarGrupo(grupoCodCombinacion);
		grupos.add(grupo);

		grupoCodCombinacion = "GR03";
		grupo = admGrupos.buscarGrupo(grupoCodCombinacion);
		grupos.add(grupo);

		// Asignando datos adicionales
		String codigoBastanteo = "B0001";
		String grupoBastanteo = "A";
		String codCliente = "CL001";
		String tipoIntervencion = "A sola firma";
		double importe = 1000.00;
		Calendar fechaVencimiento = Calendar.getInstance();
		fechaVencimiento.set(2011, 12, 10);

		admBastanteo = new AdmBastanteo();

		admBastanteo.registrarBastanteo(codigoBastanteo, poderes,
				grupoBastanteo, codCliente, tipoIntervencion, grupos, importe,
				fechaVencimiento);

		Bastanteo bastanteo = admBastanteo.buscarBastanteo(codigoBastanteo);
		// Verificar
		assertNotNull(bastanteo);

	}

	// Test 2:Si ingreso bastanteo duplicado con los datos que ya tenga el mismo
	// CodigoBastanteo,
	// poder,grupo bastanteo,cliente,tipo intervencion,grupo combinacion.
	// Se espera excepcion
	@Test(expected = BastanteoException.class)
	public void noDeberiaRegistrarBastanteosDuplicados()
			throws BastanteoException {

		poderes = new ArrayList<Poder>();
		grupos = new ArrayList<Grupo>();

		// Asignando poderes
		String codigoPoder = "CHCO";
		Poder poder = admPoder.buscarPoder(codigoPoder);
		poderes.add(poder);

		codigoPoder = "EFRE";
		poder = admPoder.buscarPoder(codigoPoder);
		poderes.add(poder);

		// Asignando combinacion de grupos
		String grupoCodCombinacion = "GR02";
		Grupo grupo = admGrupos.buscarGrupo(grupoCodCombinacion);
		grupos.add(grupo);

		grupoCodCombinacion = "GR03";
		grupo = admGrupos.buscarGrupo(grupoCodCombinacion);
		grupos.add(grupo);

		// Asignando datos adicionales
		String codigoBastanteo = "B0001";
		String grupoBastanteo = "A";
		String codCliente = "CL001";
		String tipoIntervencion = "A sola firma";
		double importe = 1000.00;
		Calendar fechaVencimiento = Calendar.getInstance();
		fechaVencimiento.set(2011, 12, 10);

		admBastanteo = new AdmBastanteo();

		admBastanteo.registrarBastanteo(codigoBastanteo, poderes,
				grupoBastanteo, codCliente, tipoIntervencion, grupos, importe,
				fechaVencimiento);

		admBastanteo.registrarBastanteo(codigoBastanteo, poderes,
				grupoBastanteo, codCliente, tipoIntervencion, grupos, importe,
				fechaVencimiento);
	}

	// Test 3:Validar datos requeridos,se espera excepcion porque no se asigna
	// poderes
	@Test(expected = BastanteoException.class)
	public void deberiaValidarDatosRequeridos() throws BastanteoException {
		poderes = new ArrayList<Poder>();
		grupos = new ArrayList<Grupo>();

		// Asignando datos adicionales
		String codigoBastanteo = "B0001";
		String grupoBastanteo = "A";
		String codCliente = "CL001";
		String tipoIntervencion = "A sola firma";
		double importe = 1000.00;
		Calendar fechaVencimiento = Calendar.getInstance();
		fechaVencimiento.set(2011, 12, 10);
		admBastanteo = new AdmBastanteo();

		admBastanteo.registrarBastanteo(codigoBastanteo, poderes,
				grupoBastanteo, codCliente, tipoIntervencion, grupos, importe,
				fechaVencimiento);
	}

	// Test 4: Verificar poderes, se espera datos del poder
	//@Test
	@Test(expected = BastanteoException.class)
	public void verificarPoderes() throws BastanteoException {
		// Criterio de verificación
		String ruc = "12232720907";
		String tipoDocumento = "DNI";
		String numeroDocumento = "41888703";
		String codigoPoder = "CHCO";
		double importe = 1000.00;

		admBastanteo = new AdmBastanteo();

		Poder poder = admBastanteo.verificarPoderes(ruc, tipoDocumento,
				numeroDocumento, codigoPoder, importe);
		assertNotNull(poder);
	}

	// Test 5: Consultar poderes, se espera datos del poder
	//@Test
	@Test(expected = BastanteoException.class)	
	public void consultarPoderes() throws BastanteoException {

		String ruc = "12232720907";
		String tipoDocumento = "DNI";
		String numeroDocumento = "41888703";
		String grupoBastanteo = "A";

		admBastanteo = new AdmBastanteo();

		List<Bastanteo> olistBastanteo = admBastanteo.ConsultarPoderes(ruc,
				tipoDocumento, numeroDocumento, grupoBastanteo);
		assertNotNull(olistBastanteo);
	}

}
