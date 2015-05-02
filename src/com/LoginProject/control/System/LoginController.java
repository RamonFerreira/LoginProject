package com.LoginProject.control.System;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	 protected void service(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();
			        HttpSession session = request.getSession(true);
			      try {
			    	  out.println("Servelet estou aqui");
			    	   


			    	  

			            /* TODO output your page here
			            out.println("<html>");
			            out.println("<head>");
			            out.println("<title>Servlet Apoiar</title>");  
			            out.println("</head>");
			            out.println("<body>");
			            out.println("<h1>Servlet Apoiar at " + request.getContextPath () + "</h1>");
			            out.println("</body>");
			            out.println("</html>");
			            */
			       } finally {
			            out.close();
			        }
			   
	}
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
       
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
