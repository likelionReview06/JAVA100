package day7.ex3.test1;

public class Test1 {
    public static void main(String[] args) {
        MathTeacher mathTeacher = new MathTeacher("김수학", 30, "male");
        MathStudent mathStudent1 = new MathStudent("이루트", 20, "female");
        MathStudent mathStudent2 = new MathStudent("최적분", 20, "female");


        System.out.println("========teach==========");
        mathTeacher.teach(mathStudent1, 50);
        mathTeacher.teach(mathStudent2, 50);
        System.out.println();

        System.out.println("========play==========");
        mathStudent2.play(10);
        mathStudent1.play(10);
        System.out.println();

        System.out.println("========study==========");
        mathStudent1.study(30);
        System.out.println();

        System.out.println("========grade==========");
        mathTeacher.grade(mathStudent1, 50);
        mathTeacher.grade(mathStudent2, 50);
        System.out.println();

        System.out.println("=========state=========");
        mathTeacher.state();
        System.out.println("------------------------");
        mathStudent1.state();
        System.out.println("-------------------------");
        mathStudent2.state();
    }
}
