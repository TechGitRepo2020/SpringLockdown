package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankMgmtService;

public class TxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		//create ioc container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
		//get proxy obj
		proxy=ctx.getBean("bankService",BankMgmtService.class);
		System.out.println(proxy.getClass()+"  "+proxy.getClass().getSuperclass());
		try {
	     System.out.println(proxy.transferMoney(1001, 1007, 5000));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
