package kr.or.nextit.xml;

import java.net.Socket;

public class Driver {
    public void printBrand(Car car){
        String tireBrand = car.getTireBrand();
        System.out.println(tireBrand);
    }
}
