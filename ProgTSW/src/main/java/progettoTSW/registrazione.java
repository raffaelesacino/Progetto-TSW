package progettoTSW;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class registrazione
 */
@WebServlet("/registrazione")
public class registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out=response.getWriter();
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
			String n=request.getParameter("firstname");
			String c=request.getParameter("lastname");
			PreparedStatement ps1=con.prepareStatement("select username from login where username=?");
			ps1.setString(1, e);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				out.println("<font color=red size=15>Email connessa ad un account già esistente!<br>");
				out.println("<a href=index.jsp>Riprova!<br>");
				
			}
			else {
				PreparedStatement ps=con.prepareStatement("INSERT INTO login (USERNAME, PASSWORD, COGNOME, NOME) VALUES (?, ?, ?, ?)");
			    ps.setString(1,e);
			    ps.setString(2,p);
			    ps.setString(3,c);
			    ps.setString(4,n);
			    HttpSession oldSession=request.getSession(false);
			    if(oldSession != null) {
			    	oldSession.invalidate();
			    }
			    HttpSession currentSession =request.getSession();
			    currentSession.setAttribute(username, e);
			    currentSession.setMaxInactiveInterval(5*60);
			    response.sendRedirect("home.jsp");
			    ps.executeUpdate();
				con.commit();
				
				
			}
			}
		
		catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}
	


