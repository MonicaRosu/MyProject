package ro.jademy.presentation.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NavigationController
 */
@WebServlet("/NavigationController")
public class NavigationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		
		System.out.println("path = " + path);
		System.out.println("path = " + path);
		switch (path) {
		case "welcome":
			request.getRequestDispatcher("/welcome.jsp")
					.forward(request, response);
			break;
		case "contExistent":
			request.getRequestDispatcher("/contExistent.jsp").forward(request,
					response);
			break;
		case "inregistrare":
			request.getRequestDispatcher("/inregistrare.jsp").forward(request,
					response);
			break;
		case "schimbareParola":
			request.getRequestDispatcher("/schimbareParola.jsp").forward(request,
					response);
			break;
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
