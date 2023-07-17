/**
 * 
 */
package com.adobe.prj.entity;

/**
 * This is an business entity class to represent a banking account
 * 
 * @author banuprakash
 * @version 1.0.0
 */
public class Account {
	private String accNo; // instance variable
	private double balance; // instance variable
	private static int count; // class member
	
	/**
	 * constructor for default initialization
	 */
	public Account() {
		count++;
	}
	
	/**
	 *  parameterized constructor to create account instance
	 * @param accNo create account with accNo
	 * @param initAmt initial amount while opening account
	 * 
	 *
	 */
	public Account(String accNo, double initAmt) {
		this.accNo = new String(accNo);
		this.balance = initAmt;
		count++;
	}
	
	/**
	 * amount to be credited into account
	 * @param amt amount to be deposited into account
	 */
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	/**
	 * withdraw from account
	 * @param amt amount to be debited
	 */
	public void withdraw(double amt) {
		this.balance -= amt;
	}
	
	/**
	 * get existing balance
	 * @return current balance in account
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * class member to return no of accounts created
	 * @return account count
	 */
	public static int getCount() {
		return count;
	}
	
	public String getAccNo() {
		return this.accNo;
	}
}
