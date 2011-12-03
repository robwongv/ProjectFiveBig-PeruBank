package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmBastanteo {

	List<Bastanteo> bastanteos;
	

	public AdmBastanteo(){
		bastanteos = new ArrayList<Bastanteo>();
	}
	
	
	public void registrarBastanteo(String codigoBastanteo,List<Poder> poderes,String grupo, String codigoCliente
			,String tipoIntervencion,List<Grupo> grupos,double importe,String fechaVencimiento) 
			throws ClienteException 
			{
		
		
		//validar datos	
	   // validarDatos(codigo, ruc, razonSocial, fechaInicio, tipoEmpresa);	
	    
	    
	    //validar que no haya duplicados
	    //validarDuplicado(codigo, ruc);
	    
		
		//Creamos un nuevo bastanteo
		Bastanteo nuevoBastanteo = new Bastanteo(codigoBastanteo,poderes, grupo,  codigoCliente
				, tipoIntervencion, grupos, importe, fechaVencimiento);
		//añaden a la lista
        bastanteos.add(nuevoBastanteo);
		
	}


	/*private void validarDuplicado(String codigo, String ruc)
			throws ClienteException {		
	    
        if(clienteExiste(codigo, ruc)) 
        	throw new ClienteException("Cliente Duplicado");
	}


	private boolean clienteExiste(String codigo, String ruc) {
		boolean existe = false;
	    
	    //   and &&   , || or
        for(Cliente cliente : clientes)
            if (cliente.getCodigo().equals(codigo) ||
                cliente.getRuc().equals(ruc))
                existe = true;
		return existe;
	}


	private void validarDatos(String codigo, String ruc, String razonSocial,
			String fechaInicio, String tipoEmpresa) throws ClienteException {
		String mensaje = "";
	    if (codigo.equals(""))
	        mensaje += "Codigo no puede ser vacio";
	    if (ruc.equals(""))
	        mensaje += "\nRuc no puede ser vacio";
	    if (razonSocial.equals(""))
	        mensaje += "\nRazon social no puede ser vacio";
	    if (fechaInicio.equals(""))
	        mensaje += "\nFecha de inicio no puede ser vacio";
	    if (tipoEmpresa.equals(""))
	        mensaje += "\nTipo de empresa no puede ser vacio";
	    if (! mensaje.equals(""))
	        throw  new ClienteException(mensaje);
	}*/

	public Bastanteo buscarBastanteo(String codigoBastanteo) {
        for(Bastanteo bastanteo : bastanteos)
            if (bastanteo.getCodigoBastanteo().equals(codigoBastanteo))
                return bastanteo;
        return null;
	}
}
