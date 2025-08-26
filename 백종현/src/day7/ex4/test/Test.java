package day7.ex4.test;

public class Test {
    public static void main(String[] args) {
        //다중 임플리먼츠 예제

        MP3 mp3 = new MP3();
        mp3.addSong("song1");
        mp3.addSong("song2");
        mp3.addSong("song3");
        mp3.showSongs();
        mp3.charge(10);
        mp3.pushButton();
        mp3.charge(10);
        mp3.pushButton();
        mp3.charge(10);
        mp3.pushButton();
        mp3.charge(10);
        mp3.pushButton();



        Monitor monitor = new Monitor();
        monitor.plugIn();
        monitor.pushButton();
        monitor.plugOut();
        monitor.pushButton();
        monitor.plugIn();
        monitor.pushButton();
        monitor.plugOut();
        monitor.pushButton();
        monitor.plugIn();
        monitor.pushButton();
        monitor.plugOut();
        monitor.pushButton();
        monitor.plugIn();
        monitor.pushButton();
        monitor.plugOut();
        monitor.pushButton();
    }
}
