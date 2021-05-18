

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.JDBCDAOFactory;
import modelo.Usuario;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
				Usuario usuario = new Usuario();
				PrintWriter out= response.getWriter();
				String url= null;
					usuario.setCedula(request.getParameter("cedula"));
					usuario.setNombre(request.getParameter("nombre"));
					usuario.setApellido(request.getParameter("apellido"));
					usuario.setCorreo(request.getParameter("correo"));
					usuario.setContrasena(request.getParameter("contrasena"));
					request.setAttribute("Usuario", usuario);
					out.println("<h1> Ha ingreso correctamente .... </h1>"+ usuario.getApellido());
					DAOFactory factory= new JDBCDAOFactory();
					factory.getUsuarioDAO().create(usuario);
					response.sendRedirect("SesionController?correo="+ usuario.getCorreo()+"&contrasena="+usuario.getContrasena());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
