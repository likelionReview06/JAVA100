package hw1_1_2;

import java.util.Scanner;

//코드작성 진행 중...
public class MyInfoTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력해주세요 : ");
        String myName = sc.nextLine();
        MyInfo myinfo = new MyInfo(myName);

        System.out.println("달성하고 싶은 루틴을 적어주세요");
        myinfo.writeMyRoutine();

        System.out.println("현재 당신의 루틴 리스트");
        myinfo.printRoutineList();

        System.out.println("\n체크시작!");
        myinfo.checkRoutine();
    }

}
