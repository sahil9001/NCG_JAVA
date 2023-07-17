package com.adobe.prj.ui;

import com.adobe.prj.entity.Account;

public class AccountClient {

	public static void main(String[] args) {
		System.out.println(Account.getCount()); // class context for static methods
		Account rahulAcc = new Account("SA123", 4500.00);
		System.out.println(Account.getCount());
		Account swethaAcc = new Account("SA890", 9000.00);
		System.out.println(Account.getCount());
		
		System.out.println("Rahul Account:");
		System.out.println(rahulAcc.getAccNo() +" : " + rahulAcc.getBalance());
		
		System.out.println("Swetha Account:");
		System.out.println(swethaAcc.getAccNo() +" : " + swethaAcc.getBalance());
		
	}

}
