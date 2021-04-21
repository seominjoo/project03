package com.spring.fleamarket.domain.account.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.fleamarket.domain.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",	
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class AccountSignupServiceTest {
	
	@Autowired
	AccountSignupService service;
	
	@Test
	public void createAccountTest() {
		Account account = Account.builder()
							.name("test01")
						    .password("test01")
							.build();
		
		service.createAccount(account);
	}
	
}
