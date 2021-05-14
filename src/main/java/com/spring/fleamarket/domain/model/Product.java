package com.spring.fleamarket.domain.model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.User;
import com.spring.fleamarket.domain.model.User.UserBuilder;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Alias("Product")
public class Product {
	
	private String productId;
	private int userId;
	private String productName;
	private String price;
	private String location;
	private String category;
	private String image;
//	private String[] image;
	private String productDescription;
	public Product() {
	}
	
	@Builder
	public Product(String productId, int userId,
	 String productName,
	 String price,
	 String location,
	 String category,
	 String image,
	 String productDescription) {
		this.productId= productId;
		this.userId= userId;
		this.productName= productName;
		this.price= price;
		this.location= location;
		this.category= category;
		this.image= image;
		this.productDescription= productDescription;
	}
	
	
}
