package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements BankMgmtService {
	@Autowired
	private BankDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,timeout = 10)
	public String transferMoney(long srcacno, long destacno,float amt) {
		int count1=0,count2=0;
		//use dao
		/*try {
			Thread.sleep(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	    count1=dao.withdraw(srcacno, amt);
	    count2=dao.deposit(destacno, amt);
	    if(count1==0 || count2==0)
	    	throw new RuntimeException("Problem in money transfering..");
	    else
		  return amt+" amount of money is transfered from "+srcacno+" to "+destacno;
	}

}
