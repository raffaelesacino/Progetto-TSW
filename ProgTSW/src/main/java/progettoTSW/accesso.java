package progettoTSW;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class accesso
 */
@WebServlet("/accesso")
public class accesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accesso() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		response.setContentType("text/html");
		Class.forName("com.mysql.cj.jdbc.Driver");
		String ip = "localhost";
		String port = "3306";
		String db = "scacchi";
		String username = "root";
		String password = "Add-onf1";

		Connection con = DriverManager.getConnection("jdbc:mysql://"+ ip+":"+ port+"/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
		String e=request.getParameter("email");
		String p=request.getParameter("password");
		PreparedStatement ps=con.prepareStatement("select username from login where username=? and password=?");
		ps.setString(1, e);
		ps.setString(2, p);
		ResultSet rs= ps.executeQuery();

		if(rs.next())
			if(e.equals("admin@gmail.com") && p.equals("Admin1")) {
				HttpSession oldSession=request.getSession(false);
			    if(oldSession != null) {
			    	oldSession.invalidate();
			    }
			    HttpSession currentSession =request.getSession();
			    currentSession.setAttribute("user", e);
			    currentSession.setMaxInactiveInterval(5*60);
			    response.sendRedirect("home.jsp");}
			else {
		
			HttpSession oldSession=request.getSession(false);
		    if(oldSession != null) {
		    	oldSession.invalidate();
		    }
		    HttpSession currentSession =request.getSession();
		    currentSession.setAttribute("user", e);
		    currentSession.setMaxInactiveInterval(5*60);
		    response.sendRedirect("home.jsp");}
	
		else {
			response.sendRedirect("home.jsp");
		}}
	
	catch(ClassNotFoundException e){
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}
