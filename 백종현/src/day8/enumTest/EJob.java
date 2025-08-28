package day8.enumTest;

public enum EJob {
    Teacher(1,"선생님"),
    Student(2,"학생"),
    Doctor(3,"의사"),
    Engineer(4,"엔지니어");

    private final int code;
    private final String korName;

    EJob(int code, String korName) {
        this.code = code;
        this.korName = korName;
    }

    public int getCode() {
        return code;
    }

    public String getKorName() {
        return korName;
    }

    public static EJob forCode(int code) {
        for(EJob job : EJob.values()) {
            if(job.getCode() == code) {
                return job;
            }
        }
        throw new IllegalArgumentException("잘못된 코드: " + code);
    }

    public static EJob forKorName(String korName) {
        for(EJob job : EJob.values()) {
            if(job.getKorName().equals(korName)) {
                return job;
            }
        }
        throw new IllegalArgumentException("잘못된 이름: " + korName);
    }

    public void print() {
        System.out.println("코드: " + code + ", 이름: " + korName);
    }
}
