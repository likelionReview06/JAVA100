package day7.ex4.test;

import day7.ex4.util.IBattery;
import day7.ex4.util.IButton;
import day7.ex4.util.ISpeaker;

import java.util.ArrayList;

public class MP3 implements IBattery, IButton, ISpeaker {
    private int battery;
    private boolean isPushed;
    private boolean isPlaying;
    private ArrayList<String> songs;

    public MP3() {
        this.battery = 100;
        this.isPushed = false;
        this.isPlaying = false;
        songs = new ArrayList<>();
    }

    @Override
    public void charge(int gage) {
        System.out.println("충전 중...");
        battery += gage;
        System.out.println("배터리 잔량: " + battery);
    }

    @Override
    public int getBattery() {
        return battery;
    }

    @Override
    public boolean isPushed() {
        return isPushed;
    }

    @Override
    public void pushButton() {
        System.out.println("딸깍");
        isPushed = !isPushed;
        if(isPushed) {
            playSound();
        } else {
            stopSound();
        }
    }

    @Override
    public void playSound() {
        isPlaying = true;
        System.out.println("음악이 재생됩니다.");
    }

    @Override
    public void stopSound() {
        isPlaying = false;
        System.out.println("음악이 정지됩니다.");
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public void showSongs() {
        for(String song : songs) {
            System.out.println(song);
        }
    }

}
