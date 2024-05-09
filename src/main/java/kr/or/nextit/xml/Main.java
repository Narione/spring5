package kr.or.nextit.xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppCtx.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Driver driver = context.getBean("driver", Driver.class);
        HankookTire hankookTire = context.getBean("hankookTire", HankookTire.class);
        Car car = context.getBean("car", Car.class);
//        car.setTire(hankookTire);
        driver.printBrand(car);
    }
}
