package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.BankMgmtService;

@SpringBootApplication
public class TxMgmtProj3AspectJaopSpringBootLoclTxmgmt3Application {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
	    //create IOC container	
		ctx=SpringApplication.run(TxMgmtProj3AspectJaopSpringBootLoclTxmgmt3Application.class, args);
		//get proxy obj
				proxy=ctx.getBean("bankService",BankMgmtService.class);
				System.out.println(proxy.getClass()+"  "+proxy.getClass().getSuperclass());
				try {
			     System.out.println(proxy.transferMoney(1001, 1009, 10000));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				//close container
				((ConfigurableApplicationContext) ctx).close();
	}

}
