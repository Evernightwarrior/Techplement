package com.quiz;

import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        QuizManager manager = new QuizManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMainMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    manager.createQuiz(scanner);
                    break;
                case 2:
                    manager.takeQuiz(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Create a new quiz");
        System.out.println("2. Take a quiz");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}
