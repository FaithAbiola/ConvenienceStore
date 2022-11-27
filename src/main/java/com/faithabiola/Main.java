package com.faithabiola;

import com.faithabiola.enums.Gender;
import com.faithabiola.enums.Qualification;
import com.faithabiola.enums.Role;
import com.faithabiola.interfaces.ApplicantServices;
import com.faithabiola.interfaces.CashierServices;
import com.faithabiola.interfaces.CustomerServices;
import com.faithabiola.interfaces.ManagerServices;
import com.faithabiola.models.*;
import com.faithabiola.services.ApplicantServicesImpl;
import com.faithabiola.services.CashierServicesImpl;
import com.faithabiola.services.CustomerServicesImpl;
import com.faithabiola.services.ManagerServicesImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Store faithStore = new Store();
        faithStore.readProduct("convinence_store/src/main/resources/product_list.csv");
        faithStore.setBalance(300_000d);

        Manager Adedotun = new Manager("Adedotun", "Alausa", 31, Gender.MALE, 1, Role.MANAGER);

        Applicant fortune = new Applicant("Fortune", "Osas", 19, Gender.MALE, Qualification.HND);
        ApplicantServices fortuneApply = new ApplicantServicesImpl();
        fortuneApply.applyForJob();
        Applicant ite = new Applicant("Ite", "Adewole", 15, Gender.FEMALE, Qualification.HND);
        ApplicantServices iteApply = new ApplicantServicesImpl();
        iteApply.applyForJob();

        ManagerServices managerAdedotun = new ManagerServicesImpl();
        managerAdedotun.hireApplicant(fortune);
        managerAdedotun.hireApplicant(ite);

        Cashier aishah = new Cashier("Moshood", "Aishah", 31, Gender.MALE, 2, Role.CASHIER);
        CashierServices cashierAisha = new CashierServicesImpl(faithStore);

        Customer martins = new Customer("Martins", "Manga", 50, Gender.FEMALE);
        martins.setWallet(50000d);
        CustomerServicesImpl martinsCustomer = new CustomerServicesImpl(martins, faithStore);
        Customer wunmi = new Customer("Wunmi", "Hope", 34, Gender.MALE);
        wunmi.setWallet(3000d);
        CustomerServicesImpl wunmiCustomer = new CustomerServicesImpl(wunmi, faithStore);
        Customer ali = new Customer("Ali", "Simbi", 33, Gender.MALE);
        ali.setWallet(15000d);
        CustomerServicesImpl aliCustomer = new CustomerServicesImpl(ali, faithStore);
        Customer olami = new Customer("Olamide", "Abiola", 33, Gender.MALE);
        olami.setWallet(500_000_000d);
        CustomerServicesImpl olamiCustomer = new CustomerServicesImpl(olami, faithStore);
        Customer akin = new Customer("Akinbayo", "Diamond", 33, Gender.MALE);
        akin.setWallet(76479d);
        CustomerServicesImpl akinCustomer = new CustomerServicesImpl(akin, faithStore);


        Product milk = faithStore.getProductList().get(0);
        Product milo = faithStore.getProductList().get(1);
        Product rice = faithStore.getProductList().get(2);
        Product beans = faithStore.getProductList().get(3);
        Product carrot = faithStore.getProductList().get(4);

        martinsCustomer.addToCart(rice, milk);
        wunmiCustomer.addToCart(rice, carrot);
        aliCustomer.addToCart(beans, milo);
        olamiCustomer.addToCart(rice, rice, beans, milk);
        akinCustomer.addToCart(carrot, milk);

        martinsCustomer.start();
        wunmiCustomer.start();
        aliCustomer.start();
        olamiCustomer.start();
        akinCustomer.start();

        martinsCustomer.checkout(martins);
        wunmiCustomer.checkout(wunmi);
        aliCustomer.checkout(ali);
        olamiCustomer.checkout(olami);
        akinCustomer.checkout(akin);

        cashierAisha.sellToQueue(faithStore.getCustomersFIFO());

    }
}