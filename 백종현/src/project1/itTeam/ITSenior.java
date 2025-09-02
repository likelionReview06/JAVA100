package project1.itTeam;

import project1.enums.Department;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Senior;
import project1.utils.interfaces.ITechnical;
import project1.utils.interfaces.IWorkable;

import java.util.ArrayList;
import java.util.List;

/**
 * ITSenior 클래스
 * IT팀의 시니어 개발자를 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class ITSenior extends Senior implements IWorkable, ITechnical {
    
    private List<String> programmingLanguages = List.of("Java", "Python", "JavaScript", "SQL");
    
    public ITSenior(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.IT);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 시니어 개발자가 " + hours + "시간 동안 개발 업무를 수행합니다.");
        System.out.println("- 핵심 기능 개발 및 설계");
        System.out.println("- 코드 리뷰 및 아키텍처 검토");
        System.out.println("- 후배 개발자 멘토링");
    }
    
    // ITechnical 구현
    @Override
    public int developSoftware(String requirements) {
        System.out.println("소프트웨어 개발: " + requirements);
        int complexity = requirements.length() / 10; // 요구사항 복잡도
        return Math.max(8, complexity); // 최소 8시간
    }
    
    @Override
    public boolean troubleshootSystem(String issue) {
        System.out.println("시스템 문제 해결: " + issue);
        return true; // 시니어는 대부분 문제 해결 가능
    }
    
    @Override
    public int performCodeReview(String codeSnippet) {
        int score = 7 + (codeSnippet.length() > 100 ? 2 : 1); // 기본 7점 + 복잡도
        System.out.println("코드 리뷰 완료. 점수: " + score + "/10");
        return score;
    }
    
    @Override
    public int writeTechnicalDocument(String topic) {
        System.out.println("기술 문서 작성: " + topic);
        return 15; // 평균 15페이지
    }

    
}