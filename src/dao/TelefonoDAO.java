package dao;

import java.util.List;

import modelo.Telefono;
import modelo.Usuario;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
		
	
	public List<Telefono> buscarPorIdTelfono(String entity);
}
