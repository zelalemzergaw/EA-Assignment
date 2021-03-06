package edu.mum.cs544;

import java.util.*;

public class ProductService implements IProductService {
	private Collection<Product> productList = new ArrayList<Product>();

	public ProductService() {
		productList.add(new Product(234, "LCD TV", 895.50));
		productList.add(new Product(239, "DVD player", 315.00));
		productList.add(new Product(423, "Plasma TV", 992.55));
		productList.add(new Product(245, "KEC TV", 815.32));
		productList.add(new Product(483, "SONY TV", 452.55));
	}

	public Product getProduct(int productNumber) {
		for (Product product : productList) {
			if (product.getProductNumber() == productNumber)
				return product;
		}
		return null;
	}

}
