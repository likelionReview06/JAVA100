package day5;

public class Student {
    String name;
    int score;
    static int STUDENT_COUNT = 0;
    static int TOTAL_SCORE = 0;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        STUDENT_COUNT++;
        TOTAL_SCORE += score;
    }

    public void displayInfo() {
        System.out.println("name : " + name);
        System.out.println("score : " + score);
    }

    public static int getAverage() {
        return TOTAL_SCORE / STUDENT_COUNT;
    }

    public static void displayTotal() {
        System.out.println("total student : " + STUDENT_COUNT);
        System.out.println("total score : " + TOTAL_SCORE);
        System.out.println("average : " + getAverage());
    }

}
