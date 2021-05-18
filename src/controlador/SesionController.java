package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.JDBCDAOFactory;
import dao.TelefonoDAO;
import modelo.Telefono;
import modelo.Usuario;



/**
 * Servlet implementation class SesionController
 */
@WebServlet("/SesionController")
public class SesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SesionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Usuario usuario = new Usuario();
		Telefono telefon = new Telefono();
		PrintWriter out = response.getWriter();
		String url = null;

		usuario.setCorreo(request.getParameter("correo"));
		usuario.setContrasena(request.getParameter("contrasena"));
		request.setAttribute("Usuario", usuario);
		DAOFactory factory = new JDBCDAOFactory();
		usuario = factory.getUsuarioDAO().logIn(usuario);
		HttpSession session = request.getSession();
		List<Telefono> telefonos = new ArrayList<Telefono>();
		List<Telefono> telfs = new ArrayList<Telefono>();
			
		
	
		if (usuario != null) {
			try {
				Usuario us = telefon.getUsuario();
				telefon.setUsuario(us);
				
				TelefonoDAO t= DAOFactory.getFactory().getTelefonoDAO();
				telefonos=t.buscarPorIdTelfono(usuario.getCedula());
				for(Telefono telefono : telefonos) {
					telfs.add(telefono);
				}

				session = request.getSession(true);
				session.setAttribute("sesion", usuario);
				out.println("USUARIO:  " + session.getAttribute("sesion"));

				request.setAttribute("usuario", usuario);
				request.setAttribute("telefono", telfs);

				url = "/JSPs/usuario.jsp";
			} catch (Exception e) {
				System.out.println("ingreso aqui 11111");
				// TODO: handle exception
				url = "/PracticaServlets/index.html";
			}
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {
			session.setAttribute("sesion", "invalido");
			out.println("lorem innjdnvajskncdjksno te ");
			response.sendRedirect("/PracticaServlets/JSPs/logIn.jsp");
		
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
