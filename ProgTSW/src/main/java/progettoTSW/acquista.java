package progettoTSW;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class acquista
 */
@WebServlet("/acquista")
public class acquista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acquista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String insertSQL = "INSERT INTO acquisti (CODICE, NOME, DESCRIZIONE, PREZZO) VALUES (?, ?, ?, ?)";
			HttpSession session=request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			
            List<ProductBean> lista=cart.getProducts();
          
            PreparedStatement preparedStatement = null;
			 for (ProductBean element : lista) {
				   out.println("sessione:" + element.getCode());
						preparedStatement = con.prepareStatement(insertSQL);
						preparedStatement.setInt(1, element.getCode());
						preparedStatement.setString(2, element.getName());
						preparedStatement.setString(3, element.getDescription());
						preparedStatement.setInt(4, element.getPrice());

						preparedStatement.executeUpdate();

						con.commit();
					 
                    
					
		        
					
			 

			
			 }}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}}
