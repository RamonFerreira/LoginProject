package com.LoginProject.control.user;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.LoginProject.model.system.LoginBean;
import com.LoginProject.model.user.UserBean;
import com.LoginProject.persistence.system.LoginDAO;
import com.LoginProject.persistence.user.UserDao;
import com.LoginProject.validator.system.FieldValidator;

/**
 *
 * @author Ramon
 */
public class UserController extends HttpServlet {
   
	private static final long serialVersionUID = -1645487368314088469L;
	private static final Logger LOG =  Logger.getLogger(UserController.class); 

	/** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String url = "registration.jsp";
        String msg = "successfully";
        try {
    	    String firstName     = request.getParameter("firstName");
    	    String lastName      = request.getParameter("lastName");
    	    String userMail      = request.getParameter("userMail");
    	    String userName      = request.getParameter("userName");
    	    String password      = request.getParameter("password");
    	    String rePassword    = request.getParameter("rePassword");
    	    
    	    if(FieldValidator.getInstance().isFilledFields(request.getParameterMap())){
    	    	if(password.equals(rePassword)){
    	    		LoginBean login = new LoginBean(userName, userMail, password);
        	    	UserBean user = new UserBean(firstName, lastName, userMail);	
        	    	LoginDAO loginDAO = new LoginDAO();
        	    	try{
        	    		user.setLogin(new LoginBean());
        	    		LoginBean newLogin = (LoginBean)loginDAO.insertByObject(login);
        	    		if(!newLogin.equals(null)){
        	    			user.setLogin(newLogin);
            	    		UserDao userDao = new UserDao();
            	    		user = (UserBean) userDao.insertByObject(user);
        	    		}
        	    
        	    	}catch(Exception e){
        	    		   LOG.warn("****ERROR****\n"+e);
        	    		   msg="Error"; 
        	    	}
    	    	}
    	   }else{
    		    LOG.warn("****TODOS OS CAMPOS SAO OBRIGATORIOS****");
    		    msg="Todos os campos devem ser preenchidos";  
            }
    	    
    	    
            
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
    	   request.setAttribute("mensagem", msg);
    	   request.getRequestDispatcher(url).forward(request, response); 
           out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="Métodos HttpServlet. Clique no sinal de + à esquerda para editar o código.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
