package com.loginlogoutproject.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loginlogoutproject.Model.DAOService;
import com.loginlogoutproject.Model.DAOServiceImpl;


@WebServlet("/delete")
public class deleteregController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public deleteregController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email")!=null) {

		String email = request.getParameter("email");
		
		DAOService service = new DAOServiceImpl();
		service.ConnectDB();
		service.deleteregistration(email);
		ResultSet registrations = service.listAll();
		request.setAttribute("registrations", registrations);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listreg.jsp");
		rd.forward(request, response);
	}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
