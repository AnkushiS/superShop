

import java.io.IOException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Sold;

/**
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//check if payment details present
		List<model.Pay> present = DBtrans.getPayDet((int)session.getAttribute("user_id"));
		String line ="";
		String form_sub ="";
		System.out.println("in get");
		if(present == null ){
			getServletContext().getRequestDispatcher("/AcceptPayment.jsp").forward(request, response);
			//doPost(request,response);
			
			}else{
				
				line += "<h3> Payment details present in the system <h3>";
				
				
				line += "<style>" + ".bs-example{" + "margin-top:20%"
						+ "margin-left:20%" + "margin-bottom:20%" + "}"

						+ "table { " + " table-layout: fixed;"
						+ " word-wrap: break-word;" + "}" + "</style>";

				line += "<table class=" + "\"table table-striped\""
						+ "style=width:50%>";

				line += "<tr>" + "<th>" + "Full Name" + "</th><br>" 
						+ "<th>"+ "Card Num" + "</th><br>"
						+ "<th>"+ "Ship address" + "</th><br>"
						+ "<th>"+ "Billing address" + "</th><br>"
						+ "<th>"+ "                        " + "</th><br>"
						+ "</tr>"
						;
				String Use="post";
				for(model.Pay pres_val : present){
					line += "<tr>" 
							+ "<td>" + pres_val.getFullName() +"</td>"
							+ "<td>" + pres_val.getCardname() +"</td>"
							+ "<td>" + pres_val.getShipadr1() + "<br/>" + pres_val.getShipadr2() +"</td>"
							+ "<td>" + pres_val.getBilladr1() + "<br/>" + pres_val.getBilladr2()+"</td>"
							+ "</tr>";
				}	
				request.setAttribute("message", line);
				form_sub =  "<form action=PayDisp.jsp method=Post>"
						+"<div>"
						+ "<input class='btn btn-primary' type=submit value='Use same Address' name='use' style=margin-left:20% style=width:30%>"
						+"</div>"
						+"</form>"
						;
				request.setAttribute("form_sub", form_sub);
				getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// add to payment 
		HttpSession session = request.getSession();
		
			
		model.Pay pay = new model.Pay();
		pay.setUserId((int)session.getAttribute("user_id"));
		pay.setCardname(request.getParameter("cardnum"));
		pay.setFullName(request.getParameter("cardname"));
		pay.setShipadr1(request.getParameter("shipadr1"));
		pay.setShipadr2(request.getParameter("shipadr2"));
		pay.setShipcode(request.getParameter("shipcode"));
		
		
		pay.setShipcode("00000");
		pay.setBilladr1(request.getParameter("billadr1"));
		pay.setBilladr2(request.getParameter("billadr2"));
		pay.setBillcode(request.getParameter("billcode"));
		
		pay.setPayAmount((double) session.getAttribute("total_pay"));
		
		DBtrans.insertPay(pay);
		// put it into new table for final_sold_items
		model.Sold sold = new model.Sold();
		sold.setCheckId((int)request.getSession().getAttribute("user_id"));
		
		// read cart DB
		
		List<Cart> cart_data = DBtrans.selectCartAll();
		for(Cart cart_db : cart_data){
			sold.setOrderId((int) cart_db.getOrderId());
			sold.setProdId(cart_db.getProdId());
			sold.setQuantity(cart_db.getQuantity());
			sold.setTotalprice(cart_db.getTotalprice());
		}
		
		DBtrans.insertSold(sold);
		//delete from cart all items for this user name
		DBtrans.EmptyCart((int)request.getSession().getAttribute("user_id"));
		
		
        request.setAttribute("message", "payment added to system");

		getServletContext().getRequestDispatcher("/PayDisp.jsp").forward(request, response);	
		
	}

}
