package ksmybatis.admin.vendor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmybatis.admin.products.domain.Products;
import ksmybatis.admin.vendor.domain.Vendor;

@Mapper
public interface VendorMapper {
	// 거래처별 상품현황 조회
	List<Vendor> getProductsListByVendor();
	
	// 담당자 아이디로 거래처 삭제
	int removeVendorBySellerId(String sellerId);

	// 상품 등록
	int addProducts(Products products);
	
	// 거래처 목록 조회
	List<Vendor> getVendorList();
}
