package ro.jademy.presentation.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.jademy.sixJars.business.service.LoginServiceTrans;

/**
 * Servlet implementation class SchimbareParola
 */
@WebServlet("/SchimbareParola")
public class SchimbareParola extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MINUTE = 60;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchimbareParola() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LoginServiceTrans loginservice=new LoginServiceTrans();
		String password = request.getParameter("password");
		String passwordR = request.getParameter("passwordR");
		String username=request.getParameter("username");
		if ((passwordR.equals(password)&& loginservice.changePassword(username, passwordR)!=null))
		{	
			Cookie userCookie = new Cookie("loggedUser", username);
			userCookie.setMaxAge(5 * MINUTE);
			response.addCookie(userCookie);
			PrintWriter out = response.getWriter();
			out.println("<span style='color: green'>Esti logat cu numele"+username+" </span>");
			request.getRequestDispatcher("Lucru.jsp").include(request, response);
		}
		
	
			
		else

		{
			RequestDispatcher rd = request.getRequestDispatcher("schimbareParola.jsp");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<span style='color: red'>Wrong username and  / or password</span>");
			rd.include(request, response);

		}
		
	}
		
	
		
	}


