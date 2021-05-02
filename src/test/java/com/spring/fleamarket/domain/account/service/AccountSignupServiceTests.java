package com.spring.fleamarket.domain.account.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",	
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class AccountSignupServiceTests {
	
	@Autowired
	AccountSignupService service;
	
	@Test
	public void createAccountTest() {
		Account account = Account.builder()
							.name("test02")
						    .password("test02")
							.build();
		
		User user = User.builder()
						.firstName("Test")
						.lastName("02")
						.email("test02@test.test")
						.phone(null)
						.build();
		
		try {
			service.createAccount(account, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
