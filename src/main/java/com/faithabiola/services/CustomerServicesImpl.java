package com.faithabiola.services;

import com.faithabiola.interfaces.CustomerServices;
import com.faithabiola.models.Customer;
import com.faithabiola.models.Product;
import com.faithabiola.models.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CustomerServicesImpl extends Thread implements CustomerServices {

    private Customer customer;
    private Store store;

    public CustomerServicesImpl(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
    }

    public void addToCart(Product... products){
        for (Product product : products) {
            if (product.getQuantity() == 0) {
                System.out.println(product.getProductName() + " is OutOfStock");
            }else {
                customer.setProductQuantityInCart(customer.getProductQuantityInCart() + 1);
                customer.setTotalAmountInCart(customer.getTotalAmountInCart() + product.getPrice());
                if (customer.getCart().containsKey(product)) {
                    customer.getCart().replace(product, customer.getCart().get(product) + 1);
                    System.out.println(product.getProductName() + " added to cart" + " (" + customer.getFirstName() + ")");
                    continue;
                }customer.getCart().put(product, 1);
                System.out.println(product.getProductName() + " added to cart" + " (" + customer.getFirstName() + ")");
            }
        }
    }

    @Override
    public List<Product> buyProducts(){
        // Create a list of products successfully bought
        List<Product> productBought = new ArrayList<>();

        Predicate<Customer> checkCustomerBalance = (customer) -> customer.getWallet() >= customer.getTotalAmountInCart();



        // Check if customer has sufficient balance
        if (checkCustomerBalance.test(customer)){

            customer.getCart().keySet().stream()
                    .filter(product -> product.getQuantity() >= customer.getCart().get(product))
                    .forEach(product -> {
                        customer.setWallet(customer.getWallet() - product.getPrice() * customer.getCart().get(product));
                        product.setQuantity(product.getQuantity() - customer.getCart().get(product));
                        productBought.add(product);
                    });


            // Clear customer cart after buying
            customer.getCart().clear();
            // Set total amount in cart to zero, since cart is empty
            customer.setTotalAmountInCart(0.0);
            //Set total quantity of product to zero, since cart is empty
            customer.setProductQuantityInCart(0);
        } else {
            System.out.println("Insufficient funds. This " + customer.getTotalAmountInCart() + " is the total amount of items in your cart" );
        }
        return productBought;
    }

    @Override
    public void run() {
        buyProducts();
    }

    @Override
public void checkout(Customer customer) {
    store.getCustomersFIFO().offer(customer);
    }
}