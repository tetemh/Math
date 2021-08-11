package fr.solaris.simplificateur;

import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    public static String methodName;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    private static ArrayList<Double> nbAll = new ArrayList<>();

    public static void medium() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter the number of notes you want to calculate : ");
            double nb = scanner.nextInt();

            for (int i = 0; i < nb; i++) {
                double temp = scanner.nextDouble();
                nbAll.add(temp);
            }

            double temp = nbAll.stream().mapToInt(Double::intValue).sum();

            double res = temp / nb;

            System.out.println(res);

            retry();
        }
    }

    public static void air() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Choose : rectangle, circle");
            String rep = scanner.nextLine();
            if(rep.equalsIgnoreCase("rectangle")){
                System.out.print("Please enter the width : ");
                double width = scanner.nextDouble();
                System.out.print("Please enter the height : ");
                double height = scanner.nextDouble();

                double res = width * height;

                System.out.println("The air is : " + res + "²");

                retry();
            }else if(rep.equalsIgnoreCase("circle")) {
                double pi = Math.PI;

                System.out.print("Enter the radius : ");
                double rad = scanner.nextDouble();
                double res = pi * rad * rad;
                System.out.println("The air in the circle is " + res + "²");
                retry();
            }
        }
    }

    public static void discount() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter the price of the item : ");
            double price = scanner.nextDouble();
            System.out.print("Please enter the object discount : ");
            double discount = scanner.nextDouble();
            double temp = price * discount;
            temp = temp / 100;
            double result = price - temp;
            System.out.println("The value of the object after" + discount +" discount is : " + result);
            retry();
        }
    }

    public static void volume(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose : rectangle, shpere");
            String rep = scanner.nextLine();
            if(rep.equalsIgnoreCase("rectangle")){
                System.out.print("Enter the width : ");
                double width = scanner.nextDouble();
                System.out.print("Enter the height : ");
                double height = scanner.nextDouble();
                System.out.print("Enter the length : ");
                double length = scanner.nextDouble();
                double res = width * height * length;
                System.out.println("The volume is : " + res + "^3");
                retry();
            }else if(rep.equalsIgnoreCase("shpere")){
                double pi = Math.PI;
                System.out.print("Enter radius : ");
                double rad = scanner.nextDouble();
                double res = (4 * pi * (rad * rad * rad)) / 3;
                System.out.println("The volume is : " + res + "^3");
            }
        }
    }

    public static void calcul(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("First number : ");
            double first = scanner.nextDouble();
            System.out.print("Operator : ");
            String operator = scanner.next();
            System.out.print("Second number");
            double second = scanner.nextDouble();

            switch (operator) {
                case "+":
                    double repmore = first + second;
                    msgCalculatrice(first, second, operator, repmore);
                    break;
                case "-":
                    double repminus = first - second;
                    msgCalculatrice(first, second, operator, repminus);
                    break;
                case "*":
                    double repmultiply = first * second;
                    msgCalculatrice(first, second, operator, repmultiply);
                    break;
                case "/":
                    double repdivide = first / second;
                    msgCalculatrice(first, second, operator, repdivide);
                    break;

            }

        }
    }


    private static void msgCalculatrice(double a, double b, String ope, double result) {
        System.out.println("The answer of " + a + " " + ope + " " + b + " is " + result);
        retry();
    }




    public static void retry() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you want to do something else (y / n) : ");
            String rep = scanner.nextLine();

            if(rep.equalsIgnoreCase("y")) {
                firstTime();
            }else{
                System.out.print("you will leave the calculator !");
                Thread.sleep(200);
                return;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void nothing() throws InterruptedException {
        System.out.print("you will leave the calculator !");
        Thread.sleep(200);
        return;
    }

    public static void firstTime() throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(ANSI_PURPLE + "(Air, Medium, Discount, volume rectangle, Calcul, Nothing) \n" +
                    "Please enter the calculation you want to do : ");
            methodName = scanner.nextLine();

            if(methodName.equalsIgnoreCase("medium")) Methods.medium();
            if(methodName.equalsIgnoreCase("air")) Methods.air();
            if(methodName.equalsIgnoreCase("discount")) Methods.discount();
            if(methodName.equalsIgnoreCase("volume")) Methods.volume();
            if(methodName.equalsIgnoreCase("calcul")) Methods.calcul();
            if(methodName.equalsIgnoreCase("nothing")) Methods.nothing();
        }
    }
}
