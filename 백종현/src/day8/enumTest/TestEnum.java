package day8.enumTest;

import java.util.ArrayList;

public class TestEnum {
    public static void main(String[] args) {

        for (int jobCode = 0; jobCode < 10; jobCode++){
            switch (jobCode){
                case 1, 2, 3, 4 -> EJob.forCode(jobCode).print();
                default -> System.out.println("알 수 없는 직업");
            }
        }


    }
}
