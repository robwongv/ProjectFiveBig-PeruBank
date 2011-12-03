package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmGrupos {

	List<Grupo> grupos;
	
	
	public AdmGrupos(){
		grupos = new ArrayList<Grupo>();
	}
	
	
	public void registrarGrupo(String codigo,String nombre) 
			throws GrupoException 
			{
		
		
		//validar datos	
	    validarDatos(codigo,nombre);	
	    
	    
	    //validar que no haya duplicados
	    validarDuplicado(codigo);
	    
		
		//Creamos un cliente
		Grupo nuevoGrupo = new Grupo(codigo,nombre);
		//añaden a la lista
        grupos.add(nuevoGrupo);
		
	}


	private void validarDuplicado(String codigo)
			throws GrupoException {		
	    
        if(grupoExiste(codigo)) 
        	throw new GrupoException("Grupo Duplicado");
	}


	private boolean grupoExiste(String codigo) {
		boolean existe = false;
	    
	    //   and &&   , || or
        for(Grupo grupo : grupos)
            if (grupo.getCodigo().equals(codigo))
                existe = true;
		return existe;
	}


	private void validarDatos(String codigo,String nombre) throws GrupoException {
		String mensaje = "";
		 if (codigo.equals(""))
		        mensaje += "Código no puede ser vacio";
	    if (nombre.equals(""))
	        mensaje += "Nombre no puede ser vacio";
	 	    if (! mensaje.equals(""))
	        throw  new GrupoException(mensaje);
	}

	public Grupo buscarGrupo(String codigo) {
        for(Grupo grupo : grupos)
            if (grupo.getCodigo().equals(codigo))
                return grupo;
        return null;
	}
}
