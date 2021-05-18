package dao;

import modelo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, String>{

	public Usuario logIn(Usuario entity);
	
	public Usuario buscar(Usuario entity);
	
	public Usuario buscarCorreo(Usuario entity);
}
