package project1.itTeam;

import project1.enums.Department;
import project1.utils.abstracts.Junior;
import project1.utils.interfaces.ITechnical;
import project1.utils.interfaces.IWorkable;

import java.util.ArrayList;
import java.util.List;

/**
 * ITJunior 클래스
 * IT팀의 주니어 개발자를 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class ITJunior extends Junior implements IWorkable, ITechnical {
    
    private List<String> programmingLanguages = List.of("Java", "JavaScript", "Python");
    
    public ITJunior(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.IT);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 주니어 개발자가 " + hours + "시간 동안 개발 업무를 수행합니다.");
        System.out.println("- 기능 개발 및 구현");
        System.out.println("- 버그 수정 및 테스트");
        System.out.println("- 코드 문서화");
    }
    
    @Override
    public int developSoftware(String requirements) {
        System.out.println("소프트웨어 개발: " + requirements);
        int complexity = requirements.length() / 8;
        return Math.max(12, complexity); // 주니어는 시간이 더 걸림
    }
    
    @Override
    public boolean troubleshootSystem(String issue) {
        System.out.println("시스템 문제 해결 시도: " + issue);
        return Math.random() > 0.4; // 60% 성공률
    }
    
    @Override
    public int performCodeReview(String codeSnippet) {
        int score = 5 + (codeSnippet.length() > 50 ? 1 : 0);
        System.out.println("코드 리뷰 완료. 점수: " + score + "/10");
        return score;
    }
    
    @Override
    public int writeTechnicalDocument(String topic) {
        System.out.println("기술 문서 작성: " + topic);
        return 8; // 주니어 수준
    }

}