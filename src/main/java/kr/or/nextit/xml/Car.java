package kr.or.nextit.xml;

public class Car {
    private Tire tire;

    public Car() {
    }

    public Car(Tire tire) {
        this.tire = tire;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public String getTireBrand(){
        return "장착된 타이어: " + tire.getBrand();
    }
}
