package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankMgmtService;

public class TxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		//create ioc container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get proxy obj
		proxy=ctx.getBean("bankService",BankMgmtService.class);
		System.out.println(proxy.getClass()+"  "+proxy.getClass().getSuperclass());
		try {
	     System.out.println(proxy.transferMoney(1009, 1005, 5000));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
