

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

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
		session.setAttribute("credit", request.getParameter("credit"));
		
		String form_sub = "Sent it to Admin for approval";
		//ask for amount and submit 
		
		// check if DB has it, then sent the updated credit to update user table
		List<User> usr = DBtrans.selectUsr(session.getAttribute("user_name").toString());
		
		if(usr != null){
			double credit = usr.get(0).getStorecredit();
			credit =  Double.valueOf(request.getParameter("credit")) + credit;
			System.out.println(credit);
			DBtrans.UpdateUser(session.getAttribute("user_name").toString(), Double.valueOf(request.getParameter("credit")));
		}else{
			// put into DB. 
			DBtrans.UpdateUser(session.getAttribute("user_name").toString(), Double.valueOf(request.getParameter("credit")));
		}
		
		request.setAttribute("form_sub", form_sub);
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
