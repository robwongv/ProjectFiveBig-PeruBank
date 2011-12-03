package bastanteo;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AdmBastanteoTest {

	List<Poder> poderes;
	List<Grupo> gruposR;
	AdmPoderes admPoder;
	AdmAbogados admAbogados;
	AdmClientes admClientes;
	AdmGrupos admGrupos;
	AdmBastanteo admBastanteo;

	@Before
	public void cargarData() throws PoderException, RepresentanteException,
			ClienteException, GrupoException {
		
	
		//Registrar Grupos
		String codGrupo="GR01";
		String nomGrupo="A";
		AdmGrupos admGrupos = new AdmGrupos();
		admGrupos.registrarGrupo(codGrupo,nomGrupo);
		
		codGrupo="GR02";
		nomGrupo="B";
		admGrupos.registrarGrupo(codGrupo,nomGrupo);
		
		codGrupo="GR03";
		nomGrupo="C";
		admGrupos.registrarGrupo(codGrupo,nomGrupo);
		

		// Registrando Clientes
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;
		AdmClientes admClientes = new AdmClientes();

		// ejecutar
		admClientes.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		// Registrando Clientes
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

		admAbogados = new AdmAbogados();
		admAbogados.inscribirRepresentate(tipoDocumento, numeroDocumento,
				nombres, apellidos, cargoEmpresa, grupoBastanteo);

		tipoDocumento = "DNI";
		numeroDocumento = "41888704";
		nombres = "Valerio Vladimir";
		apellidos = "Meza Zambrano";
		cargoEmpresa = "Lider de Proyecto";
		grupoBastanteo = "B";

		admAbogados.inscribirRepresentate(tipoDocumento, numeroDocumento,
				nombres, apellidos, cargoEmpresa, grupoBastanteo);

		tipoDocumento = "DNI";
		numeroDocumento = "41888710";
		nombres = "Ysrael Santos";
		apellidos = "Nuñez Choque";
		cargoEmpresa = "Gerente TI";
		grupoBastanteo = "B";

		admAbogados.inscribirRepresentate(tipoDocumento, numeroDocumento,
				nombres, apellidos, cargoEmpresa, grupoBastanteo);

		tipoDocumento = "DNI";
		numeroDocumento = "41888705";
		nombres = "Jerica Veronica";
		apellidos = "Dedios Espinoza";
		cargoEmpresa = "DBA";
		grupoBastanteo = "C";

		admAbogados.inscribirRepresentate(tipoDocumento, numeroDocumento,
				nombres, apellidos, cargoEmpresa, grupoBastanteo);

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
		System.out.println("CARGO DATA");

	}

	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteo()
			throws ClienteException, PoderException, GrupoException {
		
			
		poderes = new ArrayList<Poder>();
		//gruposR=new ArrayList<Grupo>();
		
		
		//Asignando poderes
		String codigoPoder = "CHCO";
		Poder poder = admPoder.buscarPoder(codigoPoder);
		poderes.add(poder);

		codigoPoder = "EFRE";
		poder = admPoder.buscarPoder(codigoPoder);
		poderes.add(poder);
		
			
		//Asignando combinacion de grupos 
		String grupoCodCombinacion = "GR02";
		Grupo grupo5 = admGrupos.buscarGrupo(grupoCodCombinacion);
		//gruposR.add(grupo);
		
			
		grupoCodCombinacion = "GR03";
		grupo5 = admGrupos.buscarGrupo(grupoCodCombinacion);
		//gruposR.add(grupo);
		
	
		
		//Asignando datos adicionales
		String codigoBastanteo="B0001";
		String grupoBastanteo = "A";
		String codCliente = "CL001";
		String tipoIntervencion="A sola firma";
		double importe=1000.00;
		String fechaVencimiento="28/11/2011";
		
		admBastanteo=new AdmBastanteo();
		
		admBastanteo.registrarBastanteo(codigoBastanteo,poderes, grupoBastanteo, codCliente, tipoIntervencion, gruposR, importe, fechaVencimiento);
		
		Bastanteo bastanteo = admBastanteo.buscarBastanteo(codigoBastanteo);
	    // Verificar
	   // assertNotNull(bastanteo);
		
		
	}

}
