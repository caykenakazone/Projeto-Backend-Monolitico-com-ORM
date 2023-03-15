package com.iftm.E1.Ex1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private int age;
    private List<Product> products = new ArrayList<>();



    public Client(String name, int age,List<Product> products) {
        this.name = name;
        this.age = age;
        this.products = products;
    }
    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", products=" + products +
                '}';
    }
}
