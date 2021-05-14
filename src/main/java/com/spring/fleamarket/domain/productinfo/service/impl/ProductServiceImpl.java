package com.spring.fleamarket.domain.productinfo.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.spring.fleamarket.domain.account.mapper.AccountFindMapper;
import com.spring.fleamarket.domain.productinfo.mapper.ProductMapper;
import com.spring.fleamarket.domain.model.Product;
import com.spring.fleamarket.domain.productinfo.service.ProductService;

import lombok.extern.log4j.Log4j;

@Log4j
@Validated
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper mapper;

	@Override
	public Product selectProduct(String productId) {
		return mapper.selectProduct(productId);
	}

	@Override
	public Product selectProductUserId(int userId) {
		return mapper.selectProductUserId(userId);
	}

	@Override
	public List<Product> selectProductAll() {
		return mapper.selectProductAll();
	}

	@Override
	public void insertProduct(Product product) {
		mapper.insertProduct(product);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		mapper.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) throws Exception {
		mapper.deleteProduct(product);
	}

}
