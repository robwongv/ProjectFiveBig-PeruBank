package bastanteo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdmAbogadosTest {
	@Test
	public void siIngresoDatosDeberiaRepresentate() throws RepresentanteException{
	String tipoDocumento="DNI";
	String numeroDocumento="41888704";
	String nombres="Robert Eduardo";
	String apellidos="Wong Villar";
	String cargoEmpresa="Analista Sistema";
	String grupoBastanteo="A";	
		
	AdmAbogados oAdmAbogados=new AdmAbogados();
	
	oAdmAbogados.inscribirRepresentate(tipoDocumento,numeroDocumento,nombres,apellidos,cargoEmpresa,grupoBastanteo);
	
	Representate oRepresentate = oAdmAbogados.buscarRepresentante(numeroDocumento);
	
	assertNotNull(oRepresentate);	 
	}
	
	@Test(expected=RepresentanteException.class)
	public void deberiaValidarDatosRequeridosRepresentante() throws RepresentanteException{
	String tipoDocumento="";
	String numeroDocumento="";
	String nombres="Robert Eduardo";
	String apellidos="Wong Villar";
	String cargoEmpresa="Analista Sistema";
	String grupoBastanteo="A";
		
	AdmAbogados oAdmAbogados=new AdmAbogados();
	
	oAdmAbogados.inscribirRepresentate(tipoDocumento,numeroDocumento,nombres,apellidos,cargoEmpresa,grupoBastanteo);
	
	}
	@Test(expected=RepresentanteException.class)
	public void noDeberiaRegistrarRepresentanteDuplicados() throws RepresentanteException{
	String tipoDocumento="DNI";
	String numeroDocumento="41888704";
	String nombres="Robert Eduardo";
	String apellidos="Wong Villar";
	String cargoEmpresa="Analista Sistema";
	String grupoBastanteo="A";
		
	AdmAbogados oAdmAbogados=new AdmAbogados();
	
	oAdmAbogados.inscribirRepresentate(tipoDocumento,numeroDocumento,nombres,apellidos,cargoEmpresa,grupoBastanteo);
	
	oAdmAbogados.inscribirRepresentate(tipoDocumento,numeroDocumento,nombres,apellidos,cargoEmpresa,grupoBastanteo);	
		 
	}
}
