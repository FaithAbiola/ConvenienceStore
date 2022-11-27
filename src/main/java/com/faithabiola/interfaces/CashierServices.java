package com.faithabiola.interfaces;

import com.faithabiola.models.Customer;
import com.faithabiola.models.Product;

import java.util.Collection;
import java.util.List;

public interface CashierServices {
  void sellProducts(Customer customer);

  void sellToQueue(Collection<Customer> customerList);

  String printReceipt(Customer customer);
}
