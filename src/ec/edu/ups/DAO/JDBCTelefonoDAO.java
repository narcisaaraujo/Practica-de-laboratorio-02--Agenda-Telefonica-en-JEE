package ec.edu.ups.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDao {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Telefono telefono) {
		// TODO Auto-generated method stub
		jdbc.update("INSERT telefono VALUES("
				+telefono.getId()+",'"+telefono.getNumero()+"','"+telefono.getTipo()+"','"+telefono.getOperadora()+"','"+telefono.getUsu_cedula()+"')");
		
	}

	@Override
	public Telefono read(Integer id) {
		Telefono telefono=null;
		ResultSet rs=jdbc.query("SELECT * FROM telefono where id="+id);
		try {
			if(rs != null && rs.next()) {
				telefono=new Telefono(rs.getInt("id"), rs.getString("numero"), rs.getString("tipo"), rs.getString("operadora"), rs.getString("usu_cedula"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (Telefono:read): " + e.getMessage());
		}
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		jdbc.update("UPDATE telefono SET numero='"+telefono.getNumero()+"', tipo='"+telefono.getTipo()+"', operadora='"+telefono.getOperadora()+"'");
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		jdbc.update("DELETE FROM telefono WHERE id="+telefono.getId());
	}

	@Override
	public List<Telefono> find() {
		// TODO Auto-generated method stub
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = jdbc.query("SELECT * FROM telefono");
		
		try {
			while (rs.next()) {
				list.add(new Telefono(rs.getInt("id"), rs.getString("numero"), rs.getString("tipo"), rs.getString("operadora"), rs.getString("usu_cedula")));				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public int contadorTelefono() {
		// TODO Auto-generated method stub
		return find().size();
	}

}
