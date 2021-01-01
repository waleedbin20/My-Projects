package java_assignment;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {

        // isNarcissisticNumber method
        System.out.println("Testing whether the given is Narcissistic or not!"+"\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Number =  ");
        int choice = input.nextInt();
        if (isNarcissisticNumber(choice))
            System.out.println("\n"+ "The number "+ choice + " is a Narcissistic Number");
        else {
            System.out.println("\n"+ "The number " + choice + " is not a Narcissistic Number");
        }

        // sum of all Narcissistic numbers
        System.out.println("\n ");
        int a  = sum();
        System.out.println("The sum of all Narcissistic Number is = " + a);
    }


    public static boolean isNarcissisticNumber(int number) {

        int digits = 0;
        int originalnum = number;
        // counting number of digits
        while(originalnum>0){
            digits++;
            originalnum /= 10;
        }
        originalnum = number;
        int sum = 0;
        while (originalnum  > 0) {
            sum += Math.pow(originalnum % 10, digits); // doing the original number to the power of digits
            originalnum /= 10;
        }
        return sum == number;
    }


    public static int sum() {
        int sum = 0;
        for (int Startinglvalue = 100; Startinglvalue < 1000; Startinglvalue++) {
            int number = Startinglvalue;
            LinkedList<Integer> values = new LinkedList<>(); // linked list is used to store the elements.
            while (number > 0) {
                values.push(number % 10);
                number /= 10;
            }
            int number1 = 0;
            for (Integer numbe : values) { //for-each loop is used to access each successive value in a collection of values. Arrays and collections.
                number1 += Math.pow(numbe, values.size());
            }
            if (Startinglvalue == number1) {
                sum += Startinglvalue;
            }
        }
        return (sum);
    }
}

