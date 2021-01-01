package java_assignment;

import java.util.Random;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        //partA();
        partB();
    }


    public static void partA(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        for (int i = score; i < 5 ; i++){
            double resul = 0; // initially the result is zero
            /* returns number in the range 10-20 inclusive using the formula
             '(max – min) + 1) + min' */
            double fnummber = rand.nextInt((20-10)+1)+10;
            double fnumber2 = rand.nextInt((20-10)+1)+10;
            System.out.println(fnummber+ " % "+fnumber2+" = ?");
            double answ = sc.nextDouble();
            if(fnummber< fnumber2){    // this if condition is basically calculating the remainder
                resul = fnummber;

            } else{
                resul = fnummber - fnumber2;
            }
            if(answ == resul){
                score += 20; // keeps on updating the core by 20 if the answer given is correct

                System.out.println("Correct answer, Current score: "+ score + ", performance: " + (score / 20) + "/" + (i + 1)); // (i+1) is looping it keeps on incrementing until it reaches 5th questions and then it stops
                // (score/20) updates te performance by 1 if the answer is correct 0 otherwise.

            } else{
                System.out.println("Incorrect answer, Current score: " + score + ", performance: " + (score / 20) + "/" + (i + 1));
            }
        }
    }

    public static void partB(){
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int score = 0;
        String entered;
        int answer = 0;
        int qs = 0;
        while (true) {
            boolean correctin = false;
            double result = 0;
            double snumber = rand.nextInt((20 - 10) + 1) + 10;
            double snumber2 = rand.nextInt((20 - 10) + 1) + 10;
            System.out.println(snumber + " % " + snumber2 + " = ?");
            while (true) {
                entered = scan.next();
                if (entered.equals("q")) {
                    Runtime.getRuntime().exit(0);  // if the user inputs the letter 'q' the program finishes
                }
                try {
                    answer = Integer.parseInt(entered);
                    correctin = true;

                } catch (NumberFormatException e) {
                    System.out.println("invalid input");// if any word or letter typed then it prints invalid input and continues asking the asking the question
                    System.out.println(snumber + " % " + snumber2 + " = ?");
                }

                if (correctin == true) {
                    qs++; // questions are being incremented, meaning that it keeps on asking the user to input the remainder until the user inputs 'q'
                    if (snumber <= snumber2) {
                        result = snumber;
                    } else {
                        result = snumber - snumber2;
                    }
                    if (answer == result) {
                        score += 20;
                        System.out.println("Correct answer, Current score: " + score + ", performance: " + (score / 20) + "/" +qs);
                    } else {
                        System.out.println("Incorrect answer, Current score: " + score + ", performance: " + (score / 20) + "/" + qs);
                    }
                    break;
                }
            }
        }
    }
}



