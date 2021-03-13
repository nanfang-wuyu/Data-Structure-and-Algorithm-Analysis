import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;



public class A5Test {
	
	@Test
	void checkClasses() throws Exception {
			Class.forName("BankAccount");
			Class.forName("BankService");
			Class.forName("Customer");
			Class.forName("Gender");
	}
	
	@Test
	void checkCustomerClass() throws Exception {
		Class<?> customer = Class.forName("Customer");
		customer.getDeclaredField("firstName");
		customer.getDeclaredField("lastName");
		customer.getDeclaredField("gender");
		customer.getDeclaredField("socialSecurityNumber");
		Class<?>[] args = new Class[0];
		customer.getMethod("getFirstName", args);
		customer.getMethod("getLastName", args);
		customer.getMethod("getGender", args);
		customer.getMethod("getSocialSecurityNumber", args);
		args = new Class[1];
		args[0] = String.class;
		customer.getMethod("setFirstName", args);
		customer.getMethod("setLastName", args);
		args[0] = Class.forName("Gender");
		customer.getMethod("setGender", args);
		args[0] = String.class;
		customer.getMethod("setSocialSecurityNumber", args);
		customer.getMethod("checkName", args);
		customer.getMethod("checkSSN", args);
		customer.getMethod("formatName", args);
	}
	
	@Test
	void checkAccountClass() throws Exception {
		Class<?> account = Class.forName("BankAccount");
		account.getDeclaredField("owner");
		account.getDeclaredField("balance");
		Class<?>[] args = new Class[0];
		account.getMethod("getOwner", args);
		account.getMethod("getBalance", args);
		args = new Class[1];
		Class<?> customer = Class.forName("Customer");
		args[0] = customer;
		account.getMethod("setOwner", args);
		args[0] = double.class;
		account.getMethod("setBalance", args);

	}
	
	@Test
	void checkBankServiceClass() throws Exception {
		Class<?> bankService = Class.forName("BankService");
		bankService.getDeclaredField("availableCash");
		bankService.getDeclaredField("accounts");
		Class<?>[] args = new Class[1];
		args[0] = Class.forName("Customer");
		bankService.getMethod("getAccount", args);
		args[0] = String.class;
		bankService.getMethod("checkAccountBalance", args);
		args = new Class[4];
		args[0] = String.class;
		args[1] = String.class;
		args[2] = char.class;
		args[3] = String.class;
		bankService.getMethod("createAccount", args);
		args = new Class[2];
		args[0] = String.class;
		args[1] = double.class;
		bankService.getMethod("makeDeposit", args);
		bankService.getMethod("withdraw", args);
		args[0] = double.class;
		args[1] = int.class;
		bankService.getMethod("calculateMonthlyPayment", args);
	}

	@Test
	void testcase1() {
		// create an account
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'm', ssn);
		BankAccount account = bs.getAccount(ssn);
		assertNotNull(account);
		assertEquals("John", account.getOwner().getFirstName());	
	}
	
	@Test
	void testcase2() {
		// create an account with an invalid name
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("123", "Doe", 'm', ssn);
		BankAccount account = bs.getAccount(ssn);
		assertNull(account);
	}
	
	@Test
	void testcase3() {
		// create an account with an invalid gender input
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'x', ssn);
		BankAccount account = bs.getAccount(ssn);
		assertNull(account);
	}
	
	@Test
	void testcase4() {
		// create an account with an invalid social security number
		BankService bs = new BankService();
		String ssn = "12345";
		bs.createAccount("John", "Doe", 'x', ssn);
		BankAccount account = bs.getAccount(ssn);
		assertNull(account);
	}
	
	@Test
	void testcase5() {
		// create an account with an invalid social security number
		BankService bs = new BankService();
		String ssn = "01234567";
		bs.createAccount("John", "Doe", 'x', ssn);
		BankAccount account = bs.getAccount(ssn);
		assertNull(account);
	}
	
	@Test
	void testcase6() throws Exception {
		// create multiple accounts with a social security number
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'M', ssn);
		Field accounts = bs.getClass().getDeclaredField("accounts");
		accounts.setAccessible(true);
		Object obj = accounts.get(bs);
		assertTrue(obj instanceof ArrayList);
		assertEquals(1, ((ArrayList<?>) obj).size());
		bs.createAccount("John", "Doe", 'F', ssn);
		assertEquals(1, ((ArrayList<?>) obj).size());
	}
	
	@Test
	void testcase7() {
		// create an account and check balance
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'M', ssn);
		BankAccount account = bs.getAccount(ssn);
		assertEquals(0.0, account.getBalance(), 10e-5);
	}
	
	@Test
	void testcase8() {
		// check an account that does not exist
		BankService bs = new BankService();
		BankAccount account = bs.getAccount("12345678");
		assertNull(account);
	}
	
	@Test
	void testcase9() {
		// create an account and make a deposit
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'M', ssn);
		BankAccount account = bs.getAccount(ssn);
		assertEquals(0.0, account.getBalance(), 10e-5);
		bs.makeDeposit(ssn, 2000);
		assertEquals(2000, account.getBalance(), 10e-5);
	}
	
	@Test
	void testcase10() throws Exception {
		// make a deposit to an account that does not exist
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.makeDeposit(ssn, 100);
		Field accounts = bs.getClass().getDeclaredField("accounts");
		accounts.setAccessible(true);
		Object obj = accounts.get(bs);
		assertTrue(obj instanceof ArrayList);
		assertEquals(0, ((ArrayList<?>) obj).size());
	}
	
	@Test
	void testcase11() throws Exception {
		// Make a deposit with an invalid social security number
		BankService bs = new BankService();
		String ssn = "a123456";
		bs.makeDeposit(ssn, 100);
		Field accounts = bs.getClass().getDeclaredField("accounts");
		accounts.setAccessible(true);
		Object obj = accounts.get(bs);
		assertTrue(obj instanceof ArrayList);
		assertEquals(0, ((ArrayList<?>) obj).size());
	}
	
	@Test
	void testcase12() {
		// make a deposit with an invalid amount
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'm', ssn);
		bs.makeDeposit(ssn, -88);
		BankAccount account = bs.getAccount(ssn);
		assertEquals(0.0, account.getBalance(), 10e-5);
	}
	
	@Test
	void testcase13() throws Exception {
		// make a deposit and withdraw money
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'm', ssn);
		bs.makeDeposit(ssn, 10000);
		assertEquals(10000, bs.getAccount(ssn).getBalance(), 10e-5);
		Field availableCash = bs.getClass().getDeclaredField("availableCash");
		availableCash.setAccessible(true);
		Object obj = availableCash.get(bs);
		assertTrue(obj instanceof Double);
		Double cash = (Double) obj;
		assertEquals(100000, cash, 10e-5);
		bs.withdraw(ssn, 2000);
		obj = availableCash.get(bs);
		cash = (Double) obj;
		assertEquals(98000, cash, 10e-5);
	}
	
	@Test
	void testcase14() throws Exception {
		// withdraw money from an account that does not exist
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.withdraw(ssn, 10000);
		Field availableCash = bs.getClass().getDeclaredField("availableCash");
		availableCash.setAccessible(true);
		Object obj = availableCash.get(bs);
		assertTrue(obj instanceof Double);
		Double cash = (Double) obj;
		assertEquals(100000, cash, 10e-5);
	}
	
	@Test
	void testcase15() throws Exception {
		// withdraw money from an account that does not have sufficient balance
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'm', ssn);
		bs.makeDeposit(ssn, 10000);
		assertEquals(10000, bs.getAccount(ssn).getBalance(), 10e-5);
		bs.withdraw(ssn, 20000);
		assertEquals(10000, bs.getAccount(ssn).getBalance(), 10e-5);
		Field availableCash = bs.getClass().getDeclaredField("availableCash");
		availableCash.setAccessible(true);
		Object obj = availableCash.get(bs);
		assertTrue(obj instanceof Double);
		Double cash = (Double) obj;
		assertEquals(100000, cash, 10e-5);
	}
	
	@Test
	void testcase16() throws Exception {
		// withdraw money from an account but the bank does not have enough cash
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'm', ssn);
		bs.makeDeposit(ssn, 110000);
		assertEquals(110000, bs.getAccount(ssn).getBalance(), 10e-5);
		bs.withdraw(ssn, 110000);
		assertEquals(110000, bs.getAccount(ssn).getBalance(), 10e-5);
		Field availableCash = bs.getClass().getDeclaredField("availableCash");
		availableCash.setAccessible(true);
		Object obj = availableCash.get(bs);
		assertTrue(obj instanceof Double);
		Double cash = (Double) obj;
		assertEquals(100000, cash, 10e-5);
	}
	
	@Test
	void testcase17() throws Exception {
		// Withdraw money from an account but the amount is invalid
		BankService bs = new BankService();
		String ssn = "12345678";
		bs.createAccount("John", "Doe", 'm', ssn);
		bs.makeDeposit(ssn, 110000);
		assertEquals(110000, bs.getAccount(ssn).getBalance(), 10e-5);
		bs.withdraw(ssn, -10000);
		assertEquals(110000, bs.getAccount(ssn).getBalance(), 10e-5);
		Field availableCash = bs.getClass().getDeclaredField("availableCash");
		availableCash.setAccessible(true);
		Object obj = availableCash.get(bs);
		assertTrue(obj instanceof Double);
		Double cash = (Double) obj;
		assertEquals(100000, cash, 10e-5);
	}
	
	@Test
	void testcase18() {
		BankService.calculateMonthlyPayment(3000000, 30);
	}
	
	@Test
	void testcase19() {
		BankService.calculateMonthlyPayment(30000, 3);
	}
	
	@Test
	void testcase20() {
		BankService.calculateMonthlyPayment(-30000, 3);
	}
	
	@Test
	void testcase21() {
		BankService.calculateMonthlyPayment(300000, 0);
	}
	
	
	@Test 
	void testcase22() {
		// test if lower case names can be transformed to the correct form
		Customer customer = new Customer("john", "Doe", Gender.MALE, "12345678");
		assertTrue("John".equals(customer.getFirstName()));
		assertTrue("Doe".equals(customer.getLastName()));
	}
	
	@Test
	void testcase23() {
		// test checkName
		assertFalse(Customer.checkName("john123"));
	}
	
	@Test
	void testcase24() {
		// test checkSSN
		assertFalse(Customer.checkSSN("123456"));
		assertFalse(Customer.checkSSN("01234567"));
	}
	
	@Test
	void testcase25() {
		// test formatName
		assertTrue(Customer.formatName("johN").equals("John"));
	}
	
	@Test
	void testcase26() {
		// test the constructor of BankAccount
		Customer customer = new Customer("john", "Doe", Gender.MALE, "12345678");
		BankAccount account = new BankAccount(customer, 100);
		assertTrue(account.getOwner().getFirstName().equals("John"));
		assertEquals(100, account.getBalance(), 10e-5);
	}

}
