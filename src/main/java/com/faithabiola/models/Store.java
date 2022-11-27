package com.faithabiola.models;

import com.faithabiola.enums.Category;
import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Store {
    private String storeName;
    private Double balance;
    private List<Product> productList = new ArrayList<>();
    private Queue<Customer> customersFIFO = new LinkedList<>();
    private PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>(new classComparator());


    public void readProduct(String fileName) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String item;
            int count = 0;
            while ((item = reader.readLine()) != null) {
                if (count > 0) {
                    String[] itemArray = item.split(",");
                    productList.add(new Product(itemArray[0],
                            itemArray[2],
                            Double.valueOf(itemArray[3]),
                            Integer.valueOf(itemArray[4]),
                            Category.valueOf(itemArray[1])));
                }
                ++count;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
