package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	Account_Balance Acc_Det=new Account_Balance();
	
  @override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  String name1=Acc_Det.getName();
	  request.setAttribute("name",name1);
	  request.setAttribute("accn",Acc_Det.getAccount_Number());
	  try {
			
			request.setAttribute("ACCBAL",Acc_Det.get_Account_balance());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);	
	}
  @override    
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
     response.sendRedirect("/welcomepage.do");
	}
}  
  
	
 
