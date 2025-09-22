package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class IOT2 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.naver.com");
        url.openStream();
        InputStreamReader isr = new InputStreamReader(url.openStream());
        BufferedReader br = new BufferedReader(isr);
        String message = br.readLine();
        while (message != null) {
            System.out.println(message);
            message = br.readLine();
        }
        br.close();
    }
}
