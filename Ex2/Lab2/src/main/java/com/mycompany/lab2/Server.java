package com.mycompany.lab2;

public class Server {
    public static void main(String[] args){
        Producer p = new Producer();
        p.start();
        
        ShopNotifier notifier = new ShopNotifier();
        notifier.start();
    }
}
