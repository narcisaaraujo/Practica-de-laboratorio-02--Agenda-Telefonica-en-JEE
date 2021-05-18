package controlador;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import dao.DAOFactory;
import dao.JDBCDAOFactory;
import modelo.Telefono;
import modelo.Usuario;

/**
 * Servlet implementation class VisualizacionController
 */
@WebServlet("/VisualizacionController")
public class VisualizacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizacionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Telefono telefono = new Telefono();
		DAOFactory factory = new JDBCDAOFactory();
		String url= null;
		ArrayList usuarios = new ArrayList();
		for (Usuario usuario : factory.getUsuarioDAO().find()) 
		{ 
		System.out.println(usuario.getApellido());
		   usuarios.add(usuario);
		}

		try {
			
			request.setAttribute("usuarios",usuarios);
			url="/JSPs/agenda.jsp";
		}catch (Exception e) {
			// TODO: handle exception
			url="/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
