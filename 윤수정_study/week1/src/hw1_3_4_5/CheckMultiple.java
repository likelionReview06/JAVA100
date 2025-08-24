package hw1_3_4_5;

public class CheckMultiple {
    public static void main(String[] args) {
        multipleThreeFive();
    }

    //static 메서드 연습, 이해
    public static void multipleThreeFive(){
         //1. while 문 사용
        int num = 1;
        System.out.println("1~50까지의 수 중 3과 5의 공배수는 ");
        while(num <= 50) {
            if(num%3 == 0 && num%5 == 0){
                System.out.print(num+"\n");
            }
            num++;
        }

        //2. for문 사용
        System.out.println("1~50까지의 수 중 3과 5의 공배수는");
        for(int i = 1; i <= 50; i++) {
            if((i%3) == 0 && (i%5) == 0) {
                System.out.println(i);
            }
        }
    }
}
