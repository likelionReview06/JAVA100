package day8;

import java.util.Objects;

public class MClass {
    String name;

    @Override
    public String toString() {
        return "MClass [name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MClass mClass = (MClass) o;
        return Objects.equals(name, mClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public static void main(String[] args) {
        MClass mClass = new MClass();
        MClass mClass2 = new MClass();
        mClass.name = "백종현";
        mClass2.name = "백종현";
        System.out.println(mClass.equals(mClass2));
    }
}
