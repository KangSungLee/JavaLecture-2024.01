package ch12_Interface.sec04_dao;

import java.util.List;

public class mainWithoutInterface {

	public static void main (String[] args) {
		
		// MySQL DB를 사용하려면
		CustomerDaoMySQLImpl customerDaoMySQLImpl = new CustomerDaoMySQLImpl();
		Customer customer = customerDaoMySQLImpl.getCustomer(34);
		List<Customer> list = customerDaoMySQLImpl.getCustomerList();
		customerDaoMySQLImpl.insertCustomer(customer);
		customerDaoMySQLImpl.updateCustomer(customer);
		customerDaoMySQLImpl.deleteCustomer(34);
		
		// Oracle DB를 사용하려면 의존적
		CustomerDaoOracleImpl customerDaoOracleImpl = new CustomerDaoOracleImpl();
		customer = customerDaoMySQLImpl.getCustomer(34);
		list = customerDaoMySQLImpl.getCustomerList();
		customerDaoMySQLImpl.insertCustomer(customer);
		customerDaoMySQLImpl.updateCustomer(customer);
		customerDaoMySQLImpl.deleteCustomer(34);
		
	}
}
