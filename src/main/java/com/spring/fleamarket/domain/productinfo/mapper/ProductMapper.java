package com.spring.fleamarket.domain.productinfo.mapper;

import java.util.List;

import com.spring.fleamarket.domain.model.Product;

public interface ProductMapper {

	// 조회
	public Product selectProduct(String productId);

	public Product selectProductUserId(int userId);

	public List<Product> selectProductAll();

	// 생성
	public void insertProduct(Product product);

	// 수정
	public void updateProduct(Product product);

	// 삭제
	public void deleteProduct(Product product);

}
