package com.spring.fleamarket.domain.productinfo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;

import com.spring.fleamarket.domain.account.dto.AccountImageRequest;
import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.AccountImage;
import com.spring.fleamarket.domain.model.Product;

public interface ProductService {
	// 조회
	public Product selectProduct(String productId);

	public Product selectProductUserId(int userId);

	public List<Product> selectProductAll();

	// 생성
	public void insertProduct(Product product);

	// 수정
	public void updateProduct(Product product) throws Exception;

	// 삭제
	public void deleteProduct(Product product) throws Exception;

}
