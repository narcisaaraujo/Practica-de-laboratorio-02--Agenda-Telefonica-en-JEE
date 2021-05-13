package ec.edu.ups.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ec.edu.ups.modelo.Usuario;

public interface UsuarioDao extends GenericDAO<Usuario, Integer> {
	//metodos que son aparte
	public Usuario readLogin(String correo, String password);
	public int contadorUsuario();
}
