package hw1_1_2;

import java.util.ArrayList;
import java.util.Scanner;

//코드작성 진행 중...
public class MyInfo {
    //TODO : 배운 정보들을 이용해서 만들고 싶은것을 만들어 보세요.
    //작심삼일은 그만! 시뮬레이터
    private String myName;
    private ArrayList<String> routineList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private int count;
    private String s;
    private String[] day = {"월요일", "화요일", "수요일",
                            "목요일", "금요일", "토요일", "일요일"};
    //생성자 - 프로그램 시작 시 처음으로 실행됨
    //1. 이름 입력 받기
    public MyInfo(String myName) {
        this.myName = myName;
        //System.out.println(this.myName);
    }

    //2. 루틴리스트 작성 받기
    protected void writeMyRoutine() {
        System.out.println("끝나면 작성완료 입력");
        while(true) {
            String routine = sc.nextLine();
            if(routine.equals("작성완료")) break;
            routineList.add(routine);
        }
    }

    //3. 체크한 루틴리스트 보여주기
    protected void printRoutineList() {
        for(String r : routineList) {
            System.out.println(r);
        }
    }

    //3. 달성했는지 체크
    protected void checkRoutine () {
        for(int i = 0; i < day.length; i++) {
            System.out.println(day[i] + "시작!");
            System.out.println("루틴개수 : " + routineList.size());
            for(int j = 0; j < routineList.size(); j++) {
                System.out.print(routineList.get(j) + " 달성했나요? (yes or no) ");
                String s = sc.nextLine();
                if(s.equals("Yes")) {
                    count++;
                } else if(s.equals("No")) {
                    count--;
                } else {
                    System.out.println("다시 입력해주세요");
                    j--;
                }
            }
        }

    }














}
