package com.sp.dao;

import java.util.List;
import com.sp.dto.ProductDataDto;

public interface ProductDataDao {
	public List<ProductDataDto> viewProductData();
	public ProductDataDto getProductData(String Product_id);
	public int updateProductData(ProductDataDto p);
	public int deleteProductData(ProductDataDto p);
	public int addProductData(ProductDataDto p);
	
}
