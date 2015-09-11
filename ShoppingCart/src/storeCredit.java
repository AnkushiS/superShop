

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class storeCredit
 */
@WebServlet("/storeCredit")
public class storeCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public storeCredit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String form_sub = "";
		
		//ask for amount and submit 
		
		form_sub =  "<form action=storeCredit method=Post>"
				+"<div>"
				+ "<input class='btn btn-primary' type=submit value='Add credit' name='use' style=margin-left:20% style=width:30%>"
				+"</div>"
				+"</form>"
				;
		request.setAttribute("form_sub", form_sub);
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
		
		//check if DB has credit or not, add it to new credit if available else insert store credit
		 
		
		
		
	
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
