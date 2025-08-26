package day7.ex3.test1;

import day7.ex3.util.ITeacher;
import day7.ex3.util.Person;

public class MathTeacher extends Person implements ITeacher<MathStudent> {
    private String subject;

    public MathTeacher(String name, int age, String gender) {
        super(name, age, gender);
        this.job = "MathTeacher";
        subject = "Math";
    }

    @Override
    public void teach(MathStudent student, int hour) {
        System.out.println(getName() + ": MathTeacher is teaching " + subject);
        student.study(hour);
    }

    @Override
    public boolean grade(MathStudent student, int cutLine) {
        System.out.println(getName() + ": MathTeacher is grading");
        if(student.getScore() >= cutLine){
            System.out.println(student.getName() + " is passed");
            return true;
        }else{
            System.out.println(student.getName() + " is failed");
            return false;
        }
    }

    public void work() {
        System.out.println("MathTeacher is working");
    }

    @Override
    public void state() {
        super.state();
        System.out.println("subject: " + subject);
    }
}
