package ksmybatis.admin.products.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmybatis.admin.orders.mapper.OrdersMapper;
import ksmybatis.admin.products.domain.Products;
import ksmybatis.admin.products.mapper.ProductsMapper;
import ksmybatis.admin.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductsServiceImpl implements ProductsService{
	
	private final ProductsMapper productsMapper;
	private final OrdersMapper ordersMapper;
	
	@Override
	public boolean removeProductsByCode(String productCode) {
		
		
		int delCount = 0;
		// 주문 상세
		delCount += ordersMapper.removeOrderItemsByProductsCode(productCode);
		// 상품
		delCount += productsMapper.removeProductByCode(productCode);
		
		boolean isDel = delCount > 0 ? true : false;
				
		return isDel;
	}
	
	/**
	 * 상품 정보 수정
	 */
	@Override
	public void modifyProducts(Products products) {

		productsMapper.modifyProducts(products);
		
	}
	
	/**
	 * 상품 정보 조회
	 */
	
	@Override
	public Products getProductsInfoByCode(String productCode) {
		
		return productsMapper.getProductsInfoByCode(productCode);
	}
	
	/**
	 * 상품 등록
	 */
	@Override
	public void addProducts(Products products) {
		
		log.info("상품등록 전 : {}", products);
		
		productsMapper.addProducts(products);
		
		log.info("상품등록 후 : {}", products);
		
		
	}
	
	/**
	 * 상품 목록 조회
	 */
	@Override
	public List<Products> getProductsList() {
		
		List<Products> productsList = productsMapper.getProductsList();
		
		return productsList;
	}
	
}
