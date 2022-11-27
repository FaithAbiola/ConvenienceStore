package com.faithabiola.models;

import java.util.Comparator;

public class classComparator implements Comparator<Customer> {
    @Override
        public int compare(Customer o1, Customer o2) {
            if(o1.getCart().size() < o2.getCart().size())
                return 1;
            else if(o1.getCart().size() > o2.getCart().size())
                return -1;
            else
                return 0;
    }
}

