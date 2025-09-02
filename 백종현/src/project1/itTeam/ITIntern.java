package project1.itTeam;

import project1.enums.Department;
import project1.utils.abstracts.Intern;
import project1.utils.interfaces.ITechnical;
public class ITIntern extends Intern implements ITechnical {
    
    public ITIntern(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.IT);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " IT 인턴이 " + hours + "시간 동안 기초 개발 업무를 수행합니다.");
        System.out.println("- 간단한 코딩 실습");
        System.out.println("- 문서 정리 및 테스트 보조");
        System.out.println("- 선배 개발자 업무 지원");
    }
    
    @Override
    public int developSoftware(String requirements) {
        System.out.println("간단한 기능만 개발 가능: " + requirements);
        return requirements.length() / 5; // 시간이 많이 걸림
    }
    
    @Override
    public boolean troubleshootSystem(String issue) {
        System.out.println("기본적인 문제만 해결 가능: " + issue);
        return issue.length() < 20; // 간단한 문제만 해결
    }
    
    @Override
    public int performCodeReview(String codeSnippet) {
        System.out.println("코드 리뷰 연습을 합니다.");
        return 5; // 기본 점수
    }
    
    @Override
    public int writeTechnicalDocument(String topic) {
        System.out.println("간단한 문서를 작성합니다: " + topic);
        return 3; // 기초 수준
    }
    
}