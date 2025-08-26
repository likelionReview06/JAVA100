package day7.enums;

public enum PitchNames {
    Do("C", "도"), Re("D", "레"), Mi("E", "미"), Fa("F", "파"), Sol("G", "솔"), La("A", "라"), Si("B", "시");

    private final String name;
    private final String korName;

    PitchNames(String name, String korName) {
        this.name = name;
        this.korName = korName;
    }

    public String getName() {
        return name;
    }

    public String getKorName() {
        return korName;
    }
}
