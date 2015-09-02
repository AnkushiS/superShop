import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtils;
import model.Cart;
import model.Product;
import model.User;

public class DBtrans {

	
	
	public static List<Product> selectProdAll(){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String jpa_sql = "select p from Product p";   
				
		TypedQuery<Product> mq = em.createQuery(jpa_sql, Product.class);
		List<Product> prods;
		
		try{
			prods = mq.getResultList();
			if(prods==null || prods.isEmpty()){
				prods=null;
			}
		}finally {
			em.close();
		}
		return prods;
		}
	
public static List<Product> selectProdOne(String product_name){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String jpa_sql = "select p from Product p where p.prodName = :prod_name";   
				
		TypedQuery<Product> mq = em.createQuery(jpa_sql, Product.class);
		
		mq.setParameter("prod_name", product_name);
		List<Product> prods;
		
		try{
			prods = mq.getResultList();
			if(prods==null || prods.isEmpty()){
				prods=null;
			}
		}finally {
			em.close();
		}
		return prods;
		}

public static List<Product> selectProdOneID(int prodId){
	
	EntityManager em = DBUtils.getEmFactory().createEntityManager();
	
	String jpa_sql = "select p from Product p where p.prodId = :prodId";   
			
	TypedQuery<Product> mq = em.createQuery(jpa_sql, Product.class);
	
	mq.setParameter("prodId", prodId);
	List<Product> prods;
	
	try{
		prods = mq.getResultList();
		if(prods==null || prods.isEmpty()){
			prods=null;
		}
	}finally {
		em.close();
	}
	return prods;
	}


	public static void insertUsr(User user) {
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<User> selectUsr( String uname) {

		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		String sql = "select u from User u where u.userName = :uname";
		TypedQuery<User> mq = em.createQuery(sql, User.class);

		mq.setParameter("uname", uname);
		List<User> users;

		try {
			users = mq.getResultList();
			if (users == null || users.isEmpty()) {
				users = null;
			}
		} finally {
			em.close();
		}
		return users;
	}
	

	public static List<User> selectUsrAll() {

		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		String sql = "select u from User u";
		TypedQuery<User> mq = em.createQuery(sql, User.class);
		List<User> users;

		try {
			users = mq.getResultList();
			if (users == null || users.isEmpty()) {
				users = null;
			}
		} finally {
			em.close();
		}
		return users;
	}
	
	public static void insertCart(Cart cart) {
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(cart);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
public static List<Cart> selectCartOne(int userId){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String jpa_sql = "select c from Cart c where c.checkId = :userId";   
				
		TypedQuery<Cart> mq = em.createQuery(jpa_sql, Cart.class);
		
		mq.setParameter("userId", userId);
		List<Cart> carts;
		
		try{
			carts = mq.getResultList();
			if(carts==null || carts.isEmpty()){
				carts=null;
			}
		}finally {
			em.close();
		}
		return carts;
		}

public static List<Cart> selectCartAll(){
	
	EntityManager em = DBUtils.getEmFactory().createEntityManager();
	
	String jpa_sql = "select c from Cart c";   
			
	TypedQuery<Cart> mq = em.createQuery(jpa_sql, Cart.class);

	List<Cart> carts;
	
	try{
		carts = mq.getResultList();
		if(carts==null || carts.isEmpty()){
			carts=null;
		}
	}finally {
		em.close();
	}
	return carts;
	}



public static void UpdateCart(int userId, int prodId, int quant, double tPrice){
	
	EntityManager em = DBUtils.getEmFactory().createEntityManager();
	
	String jpa_sql = "Update Cart c set c.quantity = :quant, c.totalprice = :tPrice where c.prodId= :prodId and c.checkId = :userId";   
	System.out.println(jpa_sql);	
	TypedQuery<Cart> mq = em.createQuery(jpa_sql, Cart.class);
	
	mq.setParameter("quant", quant);
	mq.setParameter("tPrice", tPrice);
	mq.setParameter("prodId", prodId);
	mq.setParameter("userId", userId);
	EntityTransaction trans = em.getTransaction();
	trans.begin();
	try {
		mq.executeUpdate();
		trans.commit();
	} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
	} finally {
		em.close();
	}
	
	}
}
