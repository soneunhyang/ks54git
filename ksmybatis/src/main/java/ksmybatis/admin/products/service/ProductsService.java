package ksmybatis.admin.products.service;

import java.util.List;

import ksmybatis.admin.products.domain.Products;

public interface ProductsService {
	// 상품 삭제
	boolean removeProductsByCode(String productCode);
	
	// 상품 정보 수정
	void modifyProducts(Products products);
	
	// 상품 정보 조회
	Products getProductsInfoByCode(String productCode);

	// 상품 등록
	void addProducts(Products products);
	
	// 상품 목록 조회
	List<Products> getProductsList();
}
