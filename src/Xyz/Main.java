package Xyz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DbOperations db = new DbOperations();
        db.connectDB("foods", "postgres", "Root@321");
       // db.createTable("foods");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter food " + i + " name: ");
            String name = input.nextLine();

            System.out.print("Enter food " + i + " price: ");
            double price = input.nextDouble();
            input.nextLine(); // Clear newline buffer

            Foods food = new Foods(name, price);
            db.insertFood("foods", food);
        }

        // Show all foods from DB
        db.showAllFoods("foods");

        input.close();
    }
}