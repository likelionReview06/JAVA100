package hw1_6_7;

import java.util.Scanner;

public class FindFruit {
    //문자열 배열에 `"사과", "바나나", "딸기", "포도"`를 저장하고,
    //   사용자로부터 과일 이름을 입력받아 배열 안에 존재하는지 찾는 프로그램을 작성하세요.
    public static void main(String[] args) {
        String[] fruits = {"사과", "바나나", "딸기", "포도"};
        Scanner sc = new Scanner(System.in);
        String searchName = writeFruitsName(sc);
        searchFruits(fruits, searchName);
    }

    //과일입력받기
    static String writeFruitsName(Scanner sc){
        System.out.print("검색할 과일 이름을 입력하세요 : ");
        String fruitsName = sc.nextLine();
        return fruitsName;
    }

    //과일검색하기
    static void searchFruits(String[] fruits, String sn) {
        boolean yn =  false;
        for(String s : fruits){
            if(s.equals(sn)){
                yn = true;
                break;
            }
        }
        if(yn) {System.out.println("있습니다");}
        else {System.out.println("없습니다");}
    }
}