package com.spring.fleamarket.domain.account.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.fleamarket.domain.productinfo.mapper.ProductMapper;
import com.spring.fleamarket.domain.productinfo.service.ProductService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",	
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class AccountFindServiceTests {

	@Autowired
	AccountFindService service;
	
	@Autowired
	ProductService proservice;
	
	@Autowired
	ProductMapper mapper;
	
	@Test
	public void selectAllTest() {
		log.info(mapper.selectProductAll());
	}
	
}
