package day7.ex3.util;

public interface ITeacher<T extends IStudent> {
    void teach(T student, int hour);

    boolean grade(T student, int cutLine);
}
