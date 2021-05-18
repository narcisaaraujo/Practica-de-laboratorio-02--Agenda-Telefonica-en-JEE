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
import modelo.Telefono;
import modelo.Usuario;

/**
 * Servlet implementation class TelefonoController
 */
@WebServlet("/TelefonoController")
public class TelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelefonoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Telefono telefono = new Telefono();
			Usuario usuario=(Usuario) request.getSession().getAttribute("sesion");
		PrintWriter out = response.getWriter();
		telefono.setCodigo(0);
		telefono.setNumero(request.getParameter("tel_numero"));
		telefono.setTipo(request.getParameter("comboT"));
		telefono.setOperadora(request.getParameter("comboO"));
		telefono.setUsuario(usuario);
		
		//telefono.setUsuario(request.getParameter("usu_usuario"));
		
		DAOFactory factory = new JDBCDAOFactory();
		factory.getTelefonoDAO().create(telefono);
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
