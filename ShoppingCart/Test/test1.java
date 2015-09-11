import static org.junit.Assert.*;

import java.util.List;

import model.Cart;
import model.Product;
import model.Sold;
import model.User;

import org.junit.Test;


public class test1 {

	 @Test
	   public void test_products() {
	      System.out.println("Check if this product exists") ;
	      List<Product> prod_list = DBtrans.selectProdOne("Cologne by Paco Rabanne");
	      assertTrue(prod_list.size()!=0);
	      
	   }

	   @Test
	   public void test_emptycart() {
	      System.out.println("Test if the cart is Empty for this user") ;
	      List<User> user_list = DBtrans.selectUsr("new_user");
	      for(User usrs : user_list){
	    	  List<Cart> cart_list = DBtrans.selectCartOne(usrs.getUserId());
	    	  List<model.Pay> paid = DBtrans.getPayDet(usrs.getUserId());
	    	  if(paid.size()==0){
		      assertTrue(cart_list.size()==0);
	    	  }
	      }
	      
	   }

	   @Test
	   public void test_Admin() {
	      System.out.println("Test if the Admin can see correct values for a particular user") ;
	      List<User> user_list = DBtrans.selectUsr("new_user");
	      for(User usrs : user_list){
	    	  List<Sold> admin_list = DBtrans.selectSoldOne(usrs.getUserId());
	    	  List<model.Pay> paid = DBtrans.getPayDet(usrs.getUserId());
	    	  if(paid.size()==0){
		      assertTrue(admin_list.size()!=0);
	    	  }
	      }
	      
	   }


}
