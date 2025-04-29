package ksmybatis.admin.products.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmybatis.admin.products.domain.Products;

@Mapper
public interface ProductsMapper {
	// 상품 삭제(상품코드)
	int removeProductByCode(String productCode);
		
	// 판매자가 등록한 상품 삭제
	int removeProductsBySellerId(String sellerId);
	
	// 상품 수정
	int modifyProducts(Products products);
	
	// 상품 정보 조회
	Products getProductsInfoByCode(String productCode);
	
	// 상품 등록
	int addProducts(Products products);

	// 상품 목록 조회
	List<Products> getProductsList();

	
	
}
