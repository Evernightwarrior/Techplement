# Quiz Generator

## Overview
Quiz Generator is a command-line Java application that allows users to create and take multiple-choice quizzes. Users can create quizzes, add questions with four answer choices, specify correct answers, and attempt quizzes to test their knowledge.

## Features
- Create quizzes with custom names.
- Add multiple-choice questions with four options.
- Select the correct answer for each question.
- Take quizzes and receive scores with feedback.
- Store multiple quizzes and questions using Java collections.

## Technologies Used
- Java (JDK 8+)
- Maven (for build management)
- Collections API (`List`, `Map`)

## How to Run the Application
### Prerequisites
- Install **Java JDK 8+**
- Install **Maven**

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/Evernightwarrior/Techplement.git
   cd Techplement/week1-tasks
   ```

2. Compile the project using Maven:
   ```bash
   mvn clean compile
   ```

3. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.quiz.QuizApplication"
   ```

## How to Use the Quiz Generator
### Main Menu
```
Main Menu:
1. Create a new quiz
2. Take a quiz
3. Exit
Enter your choice:
```

### Creating a Quiz
- Choose option `1` from the main menu.
- Enter a quiz name.
- Add questions (each with 4 answer options).
- Specify the correct answer by selecting the corresponding number.
- Continue adding questions or return to the main menu.

### Taking a Quiz
- Choose option `2` from the main menu.
- Select a quiz from the available list.
- Answer each question by selecting the correct option.
- Receive a score and feedback at the end.

### Exiting the Application
- Choose option `3` to exit.

## Example Usage
```
Main Menu:
1. Create a new quiz
2. Take a quiz
3. Exit
Enter your choice: 1

Enter quiz name: Science
Quiz 'Science' created. Now add questions.

Enter question text: What is the chemical symbol for water?
Enter option 1: H2O
Enter option 2: CO2
Enter option 3: O2
Enter option 4: N2
Enter the correct option (1-4): 1

Add another question? (y/n): n
```

## Known Issues & Fixes
### 1. IndexOutOfBoundsException When Taking a Quiz
**Issue:** The application crashes if the user enters an invalid number.
**Fix:** Ensure input validation checks the range before accessing the list.

### 2. Duplicate Questions in a Quiz
**Issue:** The application allows duplicate questions.
**Fix:** Implement a check to prevent adding the same question multiple times.

## Repository Structure
```
Techplement/
├── week1-tasks/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── com/quiz/
│   │   │   │   │   ├── QuizApplication.java
│   │   │   │   │   ├── QuizManager.java
│   │   │   │   │   ├── Quiz.java
│   │   │   │   │   ├── Question.java
│   ├── pom.xml
│   ├── README.md
```

## Contributing
Feel free to submit issues or contribute by creating pull requests!

## License
This project is open-source and available under the **MIT License**.

