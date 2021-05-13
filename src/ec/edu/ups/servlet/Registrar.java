package ec.edu.ups.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.UsuarioDao;
import ec.edu.ups.conexion.ContextJDBC;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class Registrar
 */
@WebServlet("/Registrar")
public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		UsuarioDao usuarioDao = DAOFactory.getFactory().getUsuarioDao();
		int codigo= usuarioDao.contadorUsuario()+1;
		
		try {
			Usuario usuario= new Usuario(codigo, 
					request.getParameter("cedula"), 
					request.getParameter("nombres"), 
					request.getParameter("apellidos"), 
					request.getParameter("correo"), 
					request.getParameter("password"));
			usuarioDao.create(usuario);
			response.sendRedirect("login.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
