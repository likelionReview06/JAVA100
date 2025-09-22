package day10.apiT;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TT {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime newYork = ZonedDateTime.of(
                LocalDateTime.now(),
                ZoneId.of("America/New_York"));
        System.out.println(newYork);



        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime tokyo = ZonedDateTime.of(
                LocalDateTime.now(),
                ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyo);
    }
}
