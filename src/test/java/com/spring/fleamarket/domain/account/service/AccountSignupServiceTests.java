package com.spring.fleamarket.domain.account.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.User;import com.spring.fleamarket.domain.model.Product;
import com.spring.fleamarket.domain.productinfo.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",	
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class AccountSignupServiceTests {
	
	@Autowired
	AccountSignupService service;
	
	@Autowired
	ProductService proservice;
	
	@Test
	public void createAccountTest() {
		Account account = Account.builder()
							.name("test03")
						    .password("test03")
							.build();
		
		User user = User.builder()
						.firstName("Test")
						.lastName("03")
						.email("test03@test.test")
						.phone(null)
						.build();
		
		Product product = Product.builder()
				.productId("2")
				.userId(1)
				.productName("색상")
				.price("5480")
				.location("대한민국")
				.category("디자인")
				.image("jpg")
				.productDescription("설명1")
				.build();
		try {
//			service.createAccount(account, user);
			
			proservice.insertProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
