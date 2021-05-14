package com.spring.fleamarket.domain.account.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import com.spring.fleamarket.domain.account.dto.AccountImageRequest;
import com.spring.fleamarket.domain.model.AccountImage;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",	
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class AccountImageServiceTests {
	
	@Autowired
	AccountImageService service;
	
	@Autowired
	AccountFindService accountFindService;
	
	private AccountImageRequest accountImageRequest;
	private AccountImage accountImage;
	
	@Before
	public void initialize() throws IOException {
		String fileDir = "src/test/resources/file";
		String fileName = "image1.png";
		MultipartFile file = new MockMultipartFile("file", 
									 fileName, 
									 null, 
									 new FileInputStream(fileDir + File.separator + fileName));
		
		accountImageRequest = AccountImageRequest.builder()
												 .file(file)
												 .x(100).y(200)
												 .width(200)
												 .height(200)
												 .build();
		accountImage = AccountImage.builder()
								   .accountId(1)
								   .build();
	}
		
	@Test
	public void insertAccountImageByAccountIdTest() throws Exception {
		service.insertAccountImageByAccountId(accountImageRequest, accountImage);
	}
	
//	@Test
//	public void updateAccountImageByAccountIdTest() throws Exception {
//		accountImage = accountFindService.selectAccountImageByAccountId(accountImage.getAccountId());
//		if (accountImage != null) {			
//			accountImage.setPath(accountImage.getPath());
//			service.updateAccountImageByAccountId(accountImageRequest, accountImage);			
//		}
//	}
//
//	@Test
//	public void deleteAccountImageByAccountIdTest() throws Exception {
//		accountImage = accountFindService.selectAccountImageByAccountId(accountImage.getAccountId());
//		if (accountImage != null) {			
//			accountImage.setPath(accountImage.getPath());
//			service.deleteAccountImageByAccountId(accountImage);	
//		}
//	}
//	
}
