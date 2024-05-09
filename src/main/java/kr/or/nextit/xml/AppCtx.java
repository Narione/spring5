package kr.or.nextit.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    @Autowired
    @Qualifier("hankookTire")
    public Tire tire;

    @Bean
    public Driver driver(){
        return new Driver();
    }


    @Bean
    public Car car(){
        return new Car(tire);
    }

    @Bean
    public HankookTire hankookTire(){
        return new HankookTire();
    }

    @Bean
    public KumhoTire kumhoTire(){
        return new KumhoTire();
    }

}
