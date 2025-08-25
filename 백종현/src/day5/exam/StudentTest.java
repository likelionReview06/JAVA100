package day5.exam;

import day5.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("student1", 80);
        Student student2 = new Student("student2", 90);

        Student.displayTotal();

        student1.displayInfo();
        student2.displayInfo();
    }
}
