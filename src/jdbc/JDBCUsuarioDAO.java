package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import modelo.Usuario;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, String> implements UsuarioDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Usuario usuario) {
		// TODO Auto-generated method stub
		conexionUno.update("INSERT Usuario VALUES ('"+usuario.getCedula()+"', '"+ usuario.getNombre()+"','"+usuario.getApellido()+"','"+usuario.getCorreo()+"','"+usuario.getContrasena()+"')");
		
	}

	@Override
	public Usuario read(String id) {
		Usuario usuario=null;
		ResultSet rs = conexionDos.query("SELECT * FROM Usuario WHERE usu_cedula ='"+id+"'");
		try {
			if(rs != null & rs.next()) {
				usuario = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"),rs.getString("usu_apellido"),rs.getString("usu_correo"),rs.getString("usu_contrasena"));
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
		}
		// TODO Auto-generated method stub
		
		return usuario;
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		conexionUno.update("UPDATE Usuario SET usu_nombre = '"+ usuario.getNombre()+"', usu_apellido= '"+ usuario.getApellido()+ "', usu_correo='"+usuario.getCorreo()+"'. usu_contrasena='"+usuario.getContrasena()+"' WHERE usu_cedula='"+usuario.getCedula()+"'");
		
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		conexionUno.update("DELETE FROM Usuario WHERE usu_cedula ='"+ usuario.getCedula()+"'");
		
	}

	@Override
	public List<Usuario> find() {
		// TODO Auto-generated method stub
		List<Usuario>list = new ArrayList<Usuario>();
		ResultSet rs = conexionUno.query("SELECT * FROM Usuario");
		try {
			while(rs.next()) {
				list.add(new Usuario(rs.getString("usu_cedula"),rs.getString("usu_nombre"),rs.getString("usu_apellido"),rs.getString("usu_correo"),rs.getString("usu_contrasena")));
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (JDBCCategoryDAO:find): " + e.getMessage());
		}
		return list;
	}
	

	@Override
	public Usuario logIn(Usuario us) {
		// TODO Auto-generated method stub
		String correo= us.getCorreo();
		String contrasena= us.getContrasena();
		Usuario usuario=null;
		ResultSet rs = conexionUno.query("SELECT * FROM Usuario WHERE usu_correo ='"+correo+"' and usu_contrasena= '"+contrasena+"'");
		
		try {
			if(rs != null & rs.next()) {
				usuario = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"),rs.getString("usu_apellido"),rs.getString("usu_correo"),rs.getString("usu_contrasena"));
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
			System.out.println(">>ESTE ES UN MENSAJE DEL METODO LOGIN>>");
		}
		// TODO Auto-generated method stub
		
		return usuario;
		
	}

	@Override
	public Usuario buscar(Usuario us) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String cedula= us.getCedula();
				System.out.println("esta es la cedula jdbc "+ cedula);
				Usuario usuario=null;
				ResultSet rs = conexionUno.query("SELECT * FROM Usuario WHERE usu_cedula ='"+cedula+"'");
				
				try {
					if(rs != null & rs.next()) {
						usuario = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"),rs.getString("usu_apellido"),rs.getString("usu_correo"),rs.getString("usu_contrasena"));
					}
				}catch (SQLException e) {
					System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
					System.out.println(">>ESTE ES UN MENSAJE DEL METODO LOGIN>>");
				}
				// TODO Auto-generated method stub
				
				return usuario;
	}

	@Override
	public Usuario buscarCorreo(Usuario us) {
		// TODO Auto-generated method stub
		String correo= us.getCorreo();
		System.out.println("esta es la cedula jdbc "+ correo);
		Usuario usuario=null;
		ResultSet rs = conexionUno.query("SELECT * FROM Usuario WHERE usu_correo ='"+correo+"'");
		
		try {
			if(rs != null & rs.next()) {
				usuario = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"),rs.getString("usu_apellido"),rs.getString("usu_correo"),rs.getString("usu_contrasena"));
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
			System.out.println(">>ESTE ES UN MENSAJE DEL METODO LOGIN>>");
		}
		// TODO Auto-generated method stub
		
		return usuario;
	}
	

}
