package java_assignment;

public class Vehicle implements Comparable<Vehicle>{

    // two fields
    public double speed;
    public String type;

    // creating two constructors one with no parameter the other one with two parameter
    // Constructor it specifies what happens when a new object is created.

    public Vehicle() {
        type = "bicycle";     // the first constructor has two fields with default values
        speed = 20.0;
    }

    public Vehicle(String type, double speed) {
        this.type = type;        // keyword 'this' refers to  as a reference to the current Object,
        this.speed = speed;      // whose Method or constructor is being invoked.
    }

    /*
      there are 4 methods so speedUP doubles the given speed,speedDown half's the given speed.
    */

    public void setType(String type) {
        this.type =type;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double speedUp() {
        speed *= 2;
        return speed;
    }

    public double speedDown() {
        speed /= 2;
        return speed;
    }

    // method compareTo defines the order of objects
    public int compareTo(Vehicle speed){
        return (int)this.speed;
    }
}
