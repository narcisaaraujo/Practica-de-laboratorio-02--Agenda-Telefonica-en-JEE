package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.JDBCDAOFactory;
import dao.TelefonoDAO;
import modelo.Telefono;
import modelo.Usuario;

/**
 * Servlet implementation class ActTelefono
 */
@WebServlet("/ActTelefono")
public class ActTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				Telefono telefono = new Telefono();
				Usuario usuario = new Usuario(); 
				
				Usuario usu1; 
				
				String cedula= request.getParameter("cedu");//usu_usuario quitar
			
				
				usuario.setCedula(cedula); 
				
		        
				
				usuario.setCorreo(request.getParameter("usu_correo"));
				usuario.setContrasena(request.getParameter("usu_contrasena"));
				PrintWriter out = response.getWriter();
				telefono.setCodigo(Integer.valueOf(request.getParameter("tel_codigo")));
				telefono.setNumero(request.getParameter("tel_numero"));
				telefono.setTipo(request.getParameter("comboT"));
				telefono.setOperadora(request.getParameter("comboO"));
				telefono.setUsuario(usuario);
				
				TelefonoDAO t= DAOFactory.getFactory().getTelefonoDAO();
				t.update(telefono);
				System.out.println("se actualizo el numero");
				response.sendRedirect("/PracticaServlets/SesionController?correo="+usuario.getCorreo()+"&contrasena="+usuario.getContrasena());
				
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
