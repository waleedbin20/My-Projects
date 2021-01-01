package java_assignment;
import java.util.*;


public class Exercise4 {
    public static void partA() {
        Vehicle va = new Vehicle();
        Vehicle vb = new Vehicle("car", 60.0);
        vb.speedUp();
        System.out.println(va.type + " " + va.speed);
        System.out.println(vb.type + " " + vb.speed);
    }

    public static void partB() {
        String[] typeArray = {"car", "train", "plane", "bicycle",};
        double[] speedArray = {60, 180, 1000, 20};
        TreeSet<Vehicle> vehicles = new TreeSet<>();
        for(int i = 0; i < typeArray.length; i++) {
            vehicles.add(new Vehicle(typeArray[i], speedArray[i]));
        }
    }

    /*  'Exception in thread "main" java.lang.ClassCastException:
         java_assignment.Vehicle cannot be cast to java.lang.Comparable'

         The reason is Problems can become more difficult if all class are closely related.
         Since due to polymorphism in Java(when a parent class reference is used to refer to a child class object.)
         an Object instance can hold any type of Object but you can only cast between same type.
         what makes this problem worse is that it only comes during runtime, ClassCastException
         doesn't come at compile time which makes it hard to detect specially in large enterprise Java application.

         According to the error I'm getting, my Vehicle class doesn't implement the Comparable interface,
         so I'll have to explicitly pass a Comparator to the sort call:
     */

    public static void main(String[] args) {
        partA();
        partB();

    }
}


