package ec.edu.ups.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.modelo.Usuario;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, Integer> implements UsuarioDao {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		jdbc.update("DROP TABLE IF EXISTS usuarios");
		jdbc.update("CREATE TABLE usuario ("
				+ "id Int NOT NULL,"
				+ "cedula varchar(10),"
				+ "nombres varchar(100),"
				+ "apellidos varchar(100),"
				+ "correo varchar(100),"
				+ "password varchar(100),"
				+ " PRIMARY KEY (id))");	
		
	}

	@Override
	public void create(Usuario usuario) {
		// TODO Auto-generated method stub
		jdbc.update("INSERT usuarios VALUES("
		+usuario.getId()+",'"+usuario.getCedula()+"','"+usuario.getNombres()+"','"+usuario.getApellidos()
		+"','"+usuario.getCorreo()+"','"+usuario.getPassword()+"')");
		
		
	}

	@Override
	public Usuario read(Integer id) {
		// TODO Auto-generated method stub
		Usuario usuario=null;
		ResultSet rs=jdbc.query("SELECT * FROM usuarios where id="+id);
		try {
			if(rs != null && rs.next()) {
				usuario=new Usuario(rs.getInt("id"), rs.getString("cedula"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("correo"), rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (Usuario:read): " + e.getMessage());
		}
		return usuario;
	}
	
	@Override
	public Usuario readLogin(String correo, String password) {
		Usuario usuario=null;
		ResultSet rs=jdbc.query("Select * from usuarios where correo='"+correo+"' and password='"+password+"'");
		try {
			if(rs != null && rs.next()) {
				usuario=new Usuario(rs.getInt("id"), rs.getString("cedula"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("correo"), rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (Usuario:read): " + e.getMessage());
		}
		
		return usuario;
	
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		jdbc.update("UPDATE usuarios SET correo='"+usuario.getCorreo()+"', password='"+usuario.getPassword()+"'");
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		jdbc.update("DELETE FROM usuarios WHERE id="+usuario.getId());
	}

	@Override
	public List<Usuario> find() {
		// TODO Auto-generated method stub
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = jdbc.query("SELECT * FROM usuarios");
		
		try {
			while (rs.next()) {
				list.add(new Usuario(rs.getInt("id"), rs.getString("cedula"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("correo"), rs.getString("password")));				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (JDBCUsuarioDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public int contadorUsuario() {
		// TODO Auto-generated method stub
		return find().size();
	}

	@Override
	public String buscarCedula(String correo) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
