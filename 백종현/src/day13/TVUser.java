package day13;

import java.util.Scanner;

public class TVUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        TV tv = TVFactory.makeTV(str);

        try {
            tv.powerOn();
            tv.volumeUp();
            tv.volumeDown();
            tv.powerOff();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
