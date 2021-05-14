package ec.edu.ups.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.TelefonoDao;
import ec.edu.ups.DAO.UsuarioDao;
import ec.edu.ups.modelo.Telefono;

/**
 * Servlet implementation class controladorAgenda
 */
@WebServlet("/controladorAgenda")
public class controladorAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorAgenda() {
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
		TelefonoDao telefonoDao=DAOFactory.getFactory().getTelefonoDao();
		UsuarioDao usuarioDao=DAOFactory.getFactory().getUsuarioDao();
		
		int codigo= telefonoDao.contadorTelefono()+1;
		String correo=(String) request.getSession().getAttribute("usercorreo");
		String cedula=usuarioDao.buscarCedula(correo);
		
		try {
			String act = request.getParameter("act");
			if(act.equals("guardar")) {
				Telefono telefono=new Telefono(codigo, request.getParameter("numero"), request.getParameter("tipo"), request.getParameter("operadora"), cedula);
				telefonoDao.create(telefono);
				response.sendRedirect("agendaVista.jsp");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
