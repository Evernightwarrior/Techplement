package com.quiz;

import java.util.*;

public class QuizManager {
    private Map<String, Quiz> quizzes = new HashMap<>();

    public void createQuiz(Scanner scanner) {
        System.out.print("\nEnter quiz name: ");
        String name = scanner.nextLine();

        if (quizzes.containsKey(name.toLowerCase())) {
            System.out.println("A quiz with this name already exists.");
            return;
        }

        Quiz quiz = new Quiz(name);
        quizzes.put(name.toLowerCase(), quiz);
        System.out.println("Quiz '" + name + "' created. Now add questions.");

        boolean addingQuestions = true;
        while (addingQuestions) {
            System.out.print("\nEnter question text: ");
            String questionText = scanner.nextLine();

            List<String> options = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter option " + (i + 1) + ": ");
                options.add(scanner.nextLine());
            }
            
            System.out.print("Select the correct option: ");
            int correctAnswer = getCorrectAnswer(scanner, 4) - 1; // Convert 1-based input to 0-based index

            quiz.addQuestion(new Question(questionText, options, correctAnswer));

            System.out.print("Add another question? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) {
                addingQuestions = false;
            }
        }
    }

    public void takeQuiz(Scanner scanner) {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available. Please create one first.");
            return;
        }

        System.out.println("\nAvailable Quizzes:");
        List<String> quizNames = new ArrayList<>(quizzes.keySet());
        for (int i = 0; i < quizNames.size(); i++) {
            System.out.println((i + 1) + ". " + quizNames.get(i));
        }

        int quizIndex = getCorrectAnswer(scanner, quizNames.size()) - 1;
        if (quizIndex < 0 || quizIndex >= quizNames.size()) {
            System.out.println("[ERROR] Invalid quiz selection.");
            return;
        }
        Quiz quiz = quizzes.get(quizNames.get(quizIndex));

        int score = 0;
        System.out.println("\nStarting quiz: " + quiz.getName());

        List<Question> questions = new ArrayList<>(quiz.getQuestions());
        Collections.shuffle(questions);

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getQuestionText());

            List<String> options = q.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            int userAnswer = getCorrectAnswer(scanner, options.size()) - 1;
            if (userAnswer < 0 || userAnswer >= options.size()) {
                System.out.println("[ERROR] Invalid answer! Please select a valid option.");
            } else if (userAnswer == q.getCorrectAnswerIndex()) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect! The correct answer was: " + options.get(q.getCorrectAnswerIndex()));
            }
        }

        System.out.println("\nQuiz completed! Your score: " + score + "/" + questions.size());
        double percentage = (double) score / questions.size() * 100;
        System.out.printf("Percentage: %.2f%%\n", percentage);
    }

    private int getCorrectAnswer(Scanner scanner, int max) {
        int answer = -1;
        while (answer < 1 || answer > max) {
            System.out.print("Enter a number (1-" + max + "): ");
            try {
                answer = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
            }
        }
        return answer;
    }
}
