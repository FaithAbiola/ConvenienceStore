package com.faithabiola.services;

import com.faithabiola.interfaces.CashierServices;
import com.faithabiola.models.Customer;
import com.faithabiola.models.Product;
import com.faithabiola.models.Store;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class CashierServicesImpl implements CashierServices {

    private Store store;

    public CashierServicesImpl(Store store)
    {this.store = store;
    }

    @Override
    public void sellProducts(Customer customer) {
        System.out.println("Selling to " + customer.getFirstName() + "...");
        for(Map.Entry<Product, Integer> entry : customer.getCart().entrySet()) {
            store.setBalance(store.getBalance() + (entry.getKey().getPrice() * entry.getValue()));
        }
        customer.getCart().clear();
        customer.setProductQuantityInCart(0);
        customer.setTotalAmountInCart(0d);
    }

    @Override
    public void sellToQueue(Collection<Customer> customerList) {
        System.out.println("Selling to all customers");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        int totalCustomer = store.getCustomersFIFO().size();
        for(int i = 0; i < totalCustomer; ++i) {
            Customer nextCustomer = store.getCustomersFIFO().poll();
            assert nextCustomer != null;
            executorService.execute(() -> {
                try{
                    sleep(4000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(nextCustomer.getFirstName() + " is being attended to on " + Thread.currentThread().getName());
                sellProducts(nextCustomer);
                System.out.println(nextCustomer.getFirstName() + " has been attended to");
            });
        }
        executorService.shutdown();
    }

    @Override
    public String printReceipt(Customer customer) {
        double bill = 0d;
        System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println(customer.getFirstName());
        for (Map.Entry<Product, Integer> entry : customer.getCart().entrySet()) {
            System.out.println(entry.getKey().getProductName()+"\t\t"+entry.getKey().getQuantity()+"\t"+entry.getKey().getPrice()+"\t"+entry.getKey().getPrice()* entry.getKey().getQuantity());
            bill += entry.getKey().getPrice() * entry.getValue();
        }
        System.out.println("Your total bill is: \t"+bill);
        System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        return String.valueOf(bill);
    }
}

