package com.faithabiola.interfaces;

import com.faithabiola.models.Customer;
import com.faithabiola.models.Product;

import java.util.List;

public interface CustomerServices {
  // Product buyProduct(Product product, int quantity);
  public List<Product> buyProducts();

  void checkout(Customer customer);
}
