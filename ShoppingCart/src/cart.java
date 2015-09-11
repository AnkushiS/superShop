

import java.util.List;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Product;
import model.User;

@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//cartList list = new cartList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String line = "<h3> Order confirmation</h3>";
		line += "<style>" + ".bs-example{" + "margin-top:20%"
				+ "margin-left:20%" + "margin-bottom:20%" + "}"

				+ "table { " + " table-layout: fixed;"
				+ " word-wrap: break-word;" + "}" + "</style>";

		line += "<table class=" + "\"table table-striped\""
				+ "style=width:100%>";

		line += "<tr>" + "<th>" + "product list" + "</th><br>" 
				+ "<th>"+ "total Price" + "</th><br>" 
				+ "</tr>"
				;
		

		// get values from the cart table -- all with user_id = session user_id,
		// get all those values and display
		
		List<Cart> cart_val = DBtrans.selectCartOne((int) session
				.getAttribute("user_id"));
		double CheckoutTotal = 0;
		if(cart_val == null){
			request.setAttribute("form_sub", "<h3>cart is Empty</h3>");
			getServletContext().getRequestDispatcher("/output.jsp").forward(
					request, response);
		}
		for (int i = 0; i < cart_val.size(); i++) {

			List<Product> prod_list = DBtrans.selectProdOneID(cart_val.get(i)
					.getProdId());
			CheckoutTotal += cart_val.get(i).getTotalprice();

			line += "<tr>" 
					+ "<td>" + prod_list.get(0).getProdName() +"</td>"
					+ "<td>" + cart_val.get(i).getTotalprice()+ "<a style=margin-left:20% style=width:30% href= " + "\'" + "DeleteItem?prodId="+ prod_list.get(0).getProdId()
					+ "\'" + ">"+"Delete Item" + "</a>" + "</td>"
					+ "</tr>";
		}

		double tax = 0.06;
		line += "<tr>"
				+ "<td>" + "" + "</td>"
				+ "<td><strong>" + "Tax @ 6%: " + (tax * CheckoutTotal) + "</strong></td>"
				+"<tr>"
				;
		
		double PayTotal = (tax * CheckoutTotal) + CheckoutTotal;
		
		double storeCredit = 0;
		List<User> usr_list = DBtrans.selectUsr(session.getAttribute("user_name").toString());
		for(User usr : usr_list){
			storeCredit = usr.getStorecredit();
		}
		
		System.out.println("$$$$$$$$$$" + storeCredit);
		
	
		line += "<tr>"
			+ "<td>" + "" + "</td>"
			+ "<td><strong>" + "Item TotalPay: " + PayTotal + "</strong></td>"
			+"<tr>"
			;
		
		PayTotal = PayTotal - storeCredit;
		
		line += "<tr>"
				+ "<td>" + "" + "</td>"
				+ "<td><strong>" + "Store Credit: " + storeCredit + "</strong></td>"
				+"<tr>"
				;
		
		line += "<tr>"
				+ "<td>" + "" + "</td>"
				+ "<td><strong>" + "Total Pay: " + PayTotal + "</strong></td>"
				+"<tr>"
				;
		
		line += "</table>";
		
		session.setAttribute("total_pay", PayTotal);
		request.setAttribute("message", line);
		String form_sub =  "<form action=Pay method=Get>"
				+"<div>"
				+ "<input class='btn btn-primary' type=submit value='Pay' style=margin-left:20% style=width:30%>"
				+"</div>"
				+"</form>"
				;
		
		request.setAttribute("form_sub", form_sub);
		getServletContext().getRequestDispatcher("/output.jsp").forward(
				request, response);
    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		double total = 0;
		double totalPrice =0;
		HttpSession session = request.getSession();
    	model.Cart cart = new model.Cart();
    	model.User User = new model.User();
    	model.Product prod = new model.Product();
    	
		int quan = Integer.parseInt(request.getParameter("quan"));
		
		String line= "<h3> Cart Items</h3>";
        line += "<style>"
				+ ".bs-example{" + "margin-top:20%" + "margin-left:20%"
				+  "margin-bottom:20%" + "}"

				+ "table { " + " table-layout: fixed;"
				+ " word-wrap: break-word;" + "}" + "</style>";
        
        
        line += "<table class=" 
        		+ "\"table table-striped\"" 
        		+ "style=width:100%>";
        
        line += 
     			"<tr>" 
     			+"<th>" + "product list" + "</th><br>"
     			+"<th>" + "quantity" + "</th><br>"
     			+"<th>" + "total Price" + "</th><br>"
     			+ "</tr>"
     			;

        List<Product> prod_list = DBtrans.selectProdOne(session.getAttribute("prod_name").toString());
        for(int i=0; i<prod_list.size(); i++){
        	totalPrice = prod_list.get(i).getPrice() * quan;
        }
        
        cart.setProdId((int) session.getAttribute("prod_id"));
        cart.setQuantity(quan);
        cart.setTotalprice(totalPrice);
        cart.setCheckId((int) session.getAttribute("user_id"));
    
        //check if the prod and user present, if yes then update, else dont do it. 
        
        List<Cart> prodUsrExists = DBtrans.getCartProdUsr((int) session.getAttribute("user_id"), cart.getProdId());
        if(prodUsrExists == null){
        	DBtrans.insertCart(cart);
        }else{
        		for(int i =0; i<prodUsrExists.size(); i++){
                	int quant = prodUsrExists.get(i).getQuantity() + cart.getQuantity();
            		double tPrice = prodUsrExists.get(i).getTotalprice() + cart.getTotalprice();
            		int user_id = prodUsrExists.get(0).getCheckId();
            		DBtrans.UpdateCart(user_id, cart.getProdId(),quant, tPrice);
        		}
        	}
    		       
        line += "<tr>" 
				+ "<td>" +session.getAttribute("prod_name")+ "</td>"
				+ "<td>" + quan + "</td>"
				+ "<td>" + totalPrice + "</td>"
				+"</tr>"
				;
        
		line += "</table>";
		request.setAttribute("message", line);
		
		String form_sub =  "<form action=cart method=get style=margin-left:40% style=width:30%>"
					+"<div>"
					+ "<input class='btn btn-primary' type=submit value='CheckOut' name=sub >"
					+"</div>"
					+"</form>"
					;
			
		request.setAttribute("form_sub", form_sub);

        getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);	
 		
	}


}
