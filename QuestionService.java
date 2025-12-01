
import java.util.Scanner;

public class QuestionService {
    Question[] question = new Question[5];

    public QuestionService() {
        question[0] = new Question(1, "Which of the following is not a Java primitive data type?", "int", "float", "boolean", "String", "String");
        question[1] = new Question(2, "Which method is the entry point of a Java program?", "start()", "main()", "run()", "execute()", "main()");
        question[2] = new Question(3, "Which of the following is used for memory management in Java?", "Compiler", "Garbage Collector", "Destructor", "JVM Loader", "Garbage Collector");
        question[3] = new Question(4, "What is the output of:\nSystem.out.println(10 + 20 + \"Java\");", "Java30", "1020Java", "30Java", "Error", "30Java");
        question[4] = new Question(5, "Which keyword is used to inherit a class in Java?", "implement", "extends", "super", "this", "extends");
    }
    public void playQuiz() {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (Question q : question) {
            System.out.println(q.getId() + ". " + q.getQuestion() + "\n" + "a. " + q.getOpt1() + "\n" + "b. " + q.getOpt2() + "\n" + "c. " + q.getOpt3() + "\n" + "d. " + q.getOpt4());
            System.out.print("Enter your answer (a/b/c/d): ");
            String userAnswer = sc.next().toLowerCase();


            while (!userAnswer.matches("[abcd]")) {
                System.out.println("Invalid input! Please enter only a, b, c, or d.");
                System.out.print("Enter again : ");
                userAnswer = sc.next().toLowerCase();
            }

            String actualAnswer = q.getAnswer();
            String correctOption = "";

            if (actualAnswer.equals(q.getOpt1())) {
                correctOption = "a";
            }
            else if (actualAnswer.equals(q.getOpt2())) {
                correctOption = "b";
            }
            else if (actualAnswer.equals(q.getOpt3())) {
                correctOption = "c";
            }
            else if (actualAnswer.equals(q.getOpt4())) {
                correctOption = "d";
            }

            if (userAnswer.equals(correctOption)) {
                System.out.println("Correct Answer!");
                score++;
            }
            else {
                System.out.println("Wrong Answer! --> Correct Answer is : " + correctOption + ". " + actualAnswer);
            }
            System.out.println("--------------------------------------------------");
            System.out.println();
            
        }
        displayScore(score);
    }  

    public void displayScore(int n) {
        System.out.println("\n🎯 Quiz Completed!");
        System.out.println("Your score is : " + n + " / " + question.length);
    }
}
