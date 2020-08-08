package com.nt.dao;

public interface BankDAO {
	
	public int withdraw(long acno,float amt);
	public int deposit(long acno,float amt);

}
