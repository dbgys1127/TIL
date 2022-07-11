package CodeStatesString;

public class Main {
    public static void main(String[] args) {
        Bike bike = new Bike(); // 각각의 타입으로 선언 + 각각의 타입으로 객체 생성
        Car car = new Car();
        MotorBike motorBike = new MotorBike();

        bike.run();
        car.run();
        motorBike.run();

        Vehicle [] vehicles = new Vehicle[]{new Bike(),new Car(),new MotorBike()};
        for(Vehicle vehicle:vehicles){
            vehicle.run();
        }

    }
}

class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle {
    void run() {
        System.out.println("Bike is running");
    }
}

class Car extends Vehicle {
    void run() {
        System.out.println("Car is running");
    }
}

class MotorBike extends Vehicle {
    void run() {
        System.out.println("MotorBike is running");
    }
}
