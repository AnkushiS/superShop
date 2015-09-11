
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comment;
import model.Product;
import model.User;


/**
 * Servlet implementation class productList
 */
@WebServlet("/productList")
public class productList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String line = "";
		HttpSession session = request.getSession();
		List<Product> prod_list = DBtrans.selectProdOne(request.getParameter("name"));
		
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
	     			+"<th>" + "Name" + "</th><br>"
	     			+"<th>" + "Description" + "</th><br>"
	     			+"<th>" + "Price" + "</th><br>"
	     			+ "</tr>"
	     			;
	        
		for (int i = 0; i < prod_list.size(); i++){
			line += "<tr>" 
					+ "<td>" + prod_list.get(i).getProdName() + "</td>"
					+ "<td>" + prod_list.get(i).getDescription() + "</td>"
					+ "<td>" + prod_list.get(i).getPrice() + "</td>"
					+ "<td>" + "<img src=" + "\'" + prod_list.get(i).getProdPic() +"\'" +"</img>"+  "</td>"
					+"</tr>"
					;
			
			session.setAttribute("prod_id" , prod_list.get(i).getProdId());
			session.setAttribute("prod_name", prod_list.get(i).getProdName());
			}
		
		line += "</table>";
		
		line +=  "<form action=cart method=post>"
				+"<div>"
				+ "<input type=text name=quan placeholder=quantity style=margin-left:20% style=width:30%>"
				+ "<input class='btn btn-primary btn-lg' type=submit value='add to Cart' name=sub style=margin-left:20% style=width:30%>"
				+"</div>"
				+"</form>"
				;
		
		System.out.println(URLDecoder.decode(request.getParameter("name")));
		List<Comment> cmts = DBtrans.selectCommentsAll(request.getParameter("name"));
		for(Comment cmnts : cmts){
			
		}
		
		
		
		
		request.setAttribute("message", line);
		 getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Cookie c = new Cookie("usernamecookie", request.getParameter("user_name"));
			c.setMaxAge(60*60); //set its age to 1 hour
			c.setPath("/"); //allow the entire application to access it
			
			HttpSession session = request.getSession();
			
			// check if existing user
			List<User> ulist = DBtrans.selectUsr(request.getParameter("user_name"));
			
			if(ulist == null){
				request.setAttribute("message", "Register to proceed ahead");
				getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);	
				for (int i = 0; i < ulist.size(); i++){
					if(ulist.get(i).getUserName().equalsIgnoreCase(request.getParameter("user_name"))){
						session.setAttribute("user_id", ulist.get(i).getUserId());
					}
				}
								
			}else {
			// set cookie attributes
			
			session.setAttribute("user_name", request.getParameter("user_name"));
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
		     			+"<th>" + "products" + "</th><br>"
		     			+"<th>" + "Price" + "</th><br>"		     					
		     			+ "</tr>"
		     			;

				for (int i = 0; i < prod_list.size(); i++){
						line += "<tr>"  
								+ "<td><a href= " + "\'" + "productList?name="+ URLEncoder.encode(prod_list.get(i).getProdName())
								+ "\'" + ">"+ prod_list.get(i).getProdName() + "</a>"
								+ "<td>" + prod_list.get(i).getPrice() + "</td>"
								+"</tr>"
								;
						}
				
				line += "</table>";		
				
				for (User u_list : ulist){
					if(u_list.getUserName().equalsIgnoreCase(request.getParameter("user_name"))){
						session.setAttribute("user_id", u_list.getUserId());
					}
				}
				
		        request.setAttribute("message", line);
		    	response.addCookie(c);
		        getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);	
			}
		        
			}catch (Exception e){
				e.printStackTrace();
			}	
		
	}

}
