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

import dao.DAOFactory;
import dao.TelefonoDAO;
import dao.UsuarioDAO;
import modelo.Telefono;
import modelo.Usuario;

/**
 * Servlet implementation class BuscarUsuario
 */
@WebServlet("/BuscarUsuario")
public class BuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url=null;
		PrintWriter out= response.getWriter();
		Usuario user = new Usuario();
		Usuario userexistente= new Usuario();
		
		String search=request.getParameter("usuario");
		
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telefonoDAO=DAOFactory.getFactory().getTelefonoDAO();
		List<Telefono> telefonos= new ArrayList<Telefono>();
		
		if(search.length()==10 & search!= null) {
			user.setCedula(search);
			userexistente=usuarioDAO.buscar(user);
			telefonos=telefonoDAO.buscarPorIdTelfono(userexistente.getCedula());
		}else if(search.length()>10) {
			user.setCorreo(search);
			userexistente=usuarioDAO.buscarCorreo(user);
			telefonos=telefonoDAO.buscarPorIdTelfono(userexistente.getCedula());
			
		}
		
		
		if(userexistente!= null) {
			

			try {
				request.setAttribute("userexistente", userexistente);
				request.setAttribute("telefonos", telefonos);
				url="/JSPs/buscar.jsp";
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("algo salio mal");
			}
	
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		
		
		else {
			response.sendRedirect("/PracticaServlets/JSPs/error.jsp");
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
