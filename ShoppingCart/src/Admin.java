

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.Product;
import model.Sold;
import model.User;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//see all the orders ever placed
		List<Sold> admin_cart = DBtrans.selectSoldAll();
		
		double CheckoutTotal=0;
		
		String line = "";
	      line += "<style>"
							+ ".bs-example{" + "margin-top:20%" + "margin-left:20%"
							+  "margin-bottom:20%" + "}"

							+ "table { " + " table-layout: fixed;"
							+ " word-wrap: break-word;" + "}"
							+ "</style>";
			        
			        line += "<table class=" 
			        		+ "\"table table-striped\"" 
			        		+ "style=width:100%>";
			        
			        line += 
			     			"<tr>" 
			     			+"<th>" + "product list" + "</th><br>"
			     			+"<th>" + "User Name" + "</th><br>"
			     			+"<th>" + "Total price" + "</th><br>"
			     			+ "</tr>"
			     			;

		for (int i = 0; i < admin_cart.size(); i++) {

			List<Product> prod_list = DBtrans.selectProdOneID(admin_cart.get(i).getProdId());
			CheckoutTotal += admin_cart.get(i).getTotalprice();
			
			List<User> usr_list = DBtrans.selectUsrAll();
			String user_name ="";
			for(int j = 0; j<usr_list.size(); j++){
				if (admin_cart.get(i).getCheckId()==usr_list.get(j).getUserId()){
					user_name = usr_list.get(j).getUserName();
				}
			}

			line += "<tr>" + "<td>" + prod_list.get(0).getProdName() + "</td>"
					+ "<td>" + user_name + "</td>"
					+ "<td>" + admin_cart.get(i).getTotalprice() + "</td>"
					+ "</tr>";
		}

		line += "</table>";

		request.setAttribute("message", line);
        getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);	
	
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
