package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductStream {
    public static void main(String[] args) {
        //get stream from product info source
        Stream<Product> productInfo=getProducts().stream();

        /*process the stream lets print those products with price greater than 20000
        * by using filter mechanism
        * */
        System.out.println("product depends on values>>");
        List<Product>get=productInfo
                .filter(products->products.getPrice()>20000)
                .sorted(Comparator.comparing(Product::getProductName))
                .toList();
        iterate(get);
        System.out.println();

        /*
        *  process a product depends on length of charcters
        * */
        System.out.println("products depends on length of characters>>");
        List<Product> newList=getProducts()
                .stream()
                .filter(product->product.getProductName().length()>8)
                .sorted(Comparator.comparing(Product::getProductName))
                .collect(Collectors.toList());
        iterate(newList);
    }
    //product provider
    private static List<Product> getProducts(){
        List<Product> products=new ArrayList<>();
        products.add(new Product("Ferari car",10000));
        products.add(new Product("mac book",450000));
        products.add(new Product("hp laptop",10000000));
        products.add(new Product("iphones",20000));
        products.add(new Product("conics product",150000));

        return products;
    }
    // method for iteration
    private static void iterate(List<Product>list){
        Iterator<Product> iterator=list.iterator();
        while(iterator.hasNext()){
            Product item=iterator.next();
            System.out.println(item.getProductName());
        }
    }
}

class Product{
    private final String productName;
    private final double price;

    public Product(String productName, double price) {
        this.productName=productName;
        this.price=price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}