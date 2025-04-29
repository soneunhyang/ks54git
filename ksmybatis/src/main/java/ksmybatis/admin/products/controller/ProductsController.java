package ksmybatis.admin.products.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmybatis.admin.products.domain.Products;
import ksmybatis.admin.products.service.ProductsService;
import ksmybatis.admin.vendor.domain.Vendor;
import ksmybatis.admin.vendor.service.VendorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
@Slf4j
public class ProductsController {
	
	private final ProductsService productsService;
	private final VendorService vendorService;
	
	@PostMapping("/removeProducts")
	@ResponseBody
	public boolean removeProducts(@RequestParam(name="productCode") String productCode) {
		log.info("삭제할 상품코드: {}", productCode);
		
		boolean isDel = productsService.removeProductsByCode(productCode);
		
		return isDel;
	}
	
	@PostMapping("/modifyProducts")
	public String modifyProducts(Products products, RedirectAttributes reAttr) {
		
		log.info("상품수정: {}", products);
		
		productsService.modifyProducts(products);
		
		reAttr.addAttribute("productCode", products.getProductCode());
		
		return "redirect:/admin/products/modifyProducts";
	}
	
	@GetMapping("/modifyProducts")
	public String modifyProducts(String productCode, Model model) {
		
		Products productsInfo = productsService.getProductsInfoByCode(productCode);
		var vendorList = vendorService.getVendorList();
		
		model.addAttribute("title", "상품 수정");
		model.addAttribute("productsInfo", productsInfo);
		model.addAttribute("vendorList", vendorList);
		
		return "admin/products/modifyProductsView";
	}
	
	@PostMapping("/addProducts")
	public String addProducts(Products products) {
				
		
		productsService.addProducts(products);
		
		return "redirect:/admin/products/productsList";
	}
	
	@GetMapping("/addProducts")
	public String addProducts(Model model) {
		
		List<Vendor> vendorList = vendorService.getVendorList();
		
		model.addAttribute("title", "상품등록");
		model.addAttribute("vendorList", vendorList);
		
		return "admin/products/addProductsView";
	}

	@GetMapping("/productsList")
	public String getProductsList(Model model) {
		
		List<Products> productsList = productsService.getProductsList();
		
		model.addAttribute("title", "상품목록");
		model.addAttribute("productsList", productsList);
		
		
		return "admin/products/productsListView";
	}

}


