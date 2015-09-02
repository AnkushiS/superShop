

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

/**
 * Servlet implementation class MoreItems
 */
@WebServlet("/MoreItems")
public class MoreItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoreItems() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> prod_list = DBtrans.selectProdAll();
	    String line= "";
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
	     			+ "</tr>"
	     			;

			for (int i = 0; i < prod_list.size(); i++){
					line += "<tr>"  
							+ "<td><a href= " + "\'" + "productList?name="+ URLEncoder.encode(prod_list.get(i).getProdName())
							+ "\'" + ">"+ prod_list.get(i).getProdName() + "</a>"
							+"</td>"
							+"</tr>"
							;
					}
			
			line += "</table>";		
			request.setAttribute("message", line);
		    getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);	
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
	}

}
