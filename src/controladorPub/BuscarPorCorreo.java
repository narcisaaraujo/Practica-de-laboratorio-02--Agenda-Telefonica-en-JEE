package controladorPub;

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
 * Servlet implementation class BuscarPorCorreo
 */
@WebServlet("/BuscarPorCorreo")
public class BuscarPorCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPorCorreo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String url=null;
				PrintWriter out= response.getWriter();
				Usuario user = new Usuario();
				Usuario userexistente= new Usuario();
				user.setCorreo(request.getParameter("usuario"));
				UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
				TelefonoDAO telefonoDAO=DAOFactory.getFactory().getTelefonoDAO();
				List<Telefono> telefonos= new ArrayList<Telefono>();
				userexistente=usuarioDAO.buscarCorreo(user);
				if(userexistente!= null) {
					telefonos=telefonoDAO.buscarPorIdTelfono(userexistente.getCedula());

					try {
						request.setAttribute("userexistente", userexistente);
						request.setAttribute("telefonos", telefonos);
						url="/JSPs/buscarCorreo.jsp";
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println("algo salio mal");
					}
			
					getServletContext().getRequestDispatcher(url).forward(request, response);
				}else {
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
