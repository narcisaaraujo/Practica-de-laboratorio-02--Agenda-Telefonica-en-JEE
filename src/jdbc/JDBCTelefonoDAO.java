package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TelefonoDAO;
import modelo.Telefono;
import modelo.Usuario;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionUno.update("INSERT Telefono VALUES (" + telefono.getCodigo()+",'"+ telefono.getNumero()+"','"+telefono.getTipo()+"','"+telefono.getOperadora()+"','"+ telefono.getUsuario().getCedula()+"')");
		
	}

	@Override
	public Telefono read(Integer id) {
		// TODO Auto-generated method stub
			Telefono telefono= null;
			ResultSet rs= conexionUno.query("SELECT * FROM Telefono where tel_codigo="+id);
			try {
				if(rs != null && rs.next()) {
					JDBCUsuarioDAO ud=new JDBCUsuarioDAO();
					telefono= new Telefono(rs.getInt("tel_codigo"),rs.getString("tel_numero"),rs.getString("tel_tipo"),rs.getString("tel_operadora"),ud.read(rs.getString("usu_cedula")));
					
				}
				}catch (SQLException e) {
					// TODO: handle exception
					System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
				
			}
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionUno.update("UPDATE Telefono SET tel_numero='"+telefono.getNumero()+"', tel_tipo= '"+telefono.getTipo()+"', tel_operadora ='"+telefono.getOperadora()+"' WHERE tel_codigo="+telefono.getCodigo());
		
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionUno.update("DELETE FROM Telefono WHERE tel_codigo ="+telefono.getCodigo());
		
	}

	@Override
	public List<Telefono> find() {
		// TODO Auto-generated method stub
		JDBCUsuarioDAO us=new JDBCUsuarioDAO();
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = conexionUno.query("SELECT * FROM Telefono");
		try {
			while(rs.next()) {
				list.add(new Telefono(rs.getInt("tel_codigo"),rs.getString("tel_numero"),rs.getString("tel_tipo"),rs.getString("tel_operadora"),us.read(rs.getString("usu_cedula"))));
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());

		}
		return list;
	}

	@Override
	public List<Telefono> buscarPorIdTelfono(String telf) {
		// TODO Auto-generated method stub
				List<Telefono> list = new ArrayList<Telefono>();
				Telefono telefono=null;
				JDBCUsuarioDAO us=new JDBCUsuarioDAO();
				ResultSet rs = conexionUno.query("SELECT * FROM Telefono where usu_cedula='"+telf+"'");
				try {
					while(rs.next()) {
						telefono = new Telefono(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),us.read(rs.getString(5)));
						list.add(telefono);
						//list.add(new Telefono(rs.getInt("tel_codigo"),rs.getString("tel_numero"),rs.getString("tel_tipo"),rs.getString("tel_operadora")));
						System.out.println(telefono.toString());
					}
				}catch (SQLException e) {
					// TODO: handle exception
					System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());

				}
				return list;
			}

}
