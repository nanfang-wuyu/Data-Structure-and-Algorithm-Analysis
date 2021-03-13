package sustech.cs102a.lab10;

import java.util.Scanner;

public enum PhoneModel {
    IPHONE("IPHONE",9999),
    HUAWEI("HUAWEI",8888),
    PIXEL("PIXEL",6666),
    SAMSUNG("SAMSUNG",9399),
    LG("LG",5588);

    private final String name;
    private final int price;

    private PhoneModel(String name,int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    /*public String toString(){
        return this.name+"/t"+getPrice();
    }*/
}
