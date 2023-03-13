package service.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Customer;
import Model.CustomerDAO;

@WebServlet("/regCustomer")
public class RegCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("cname");
		String address = request.getParameter("cadd");
		String phone = request.getParameter("cphone");
		
		Customer customer =new Customer(name, address, phone);
		
		CustomerDAO dao =  new CustomerDAO();
		
		
		try{
			dao.CustomerSave(customer);
			System.out.println("Data Inserted.");
			}
		catch(Exception e){
				
				System.out.println("Exception Occurred "+ e);
				
			}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
