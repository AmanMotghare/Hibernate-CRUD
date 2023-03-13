package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerDAO {
	Configuration cfg;
	SessionFactory factory;
	Session session;
	Transaction tx;
	
	public CustomerDAO() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		session =factory.openSession();
		tx = session.beginTransaction();	
	}
	
	public void CustomerSave(Customer customer){
		session.save(customer);
		closeAll();
	}

	private void closeAll() {
		// TODO Auto-generated method stub
		tx.commit();
		session.close();
		factory.close();
	}

}
