package project1.itTeam;

import project1.enums.Department;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Lead;
import project1.utils.interfaces.ITechnical;
import project1.utils.interfaces.IWorkable;

import java.util.ArrayList;
import java.util.List;

/**
 * ITLead 클래스
 * IT팀장을 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class ITLead extends Lead implements IWorkable, ITechnical {
    
    private List<String> programmingLanguages = List.of("Java", "Python", "JavaScript", "C++", "Go");
    
    public ITLead(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.IT);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " IT팀장이 " + hours + "시간 동안 기술 리더십 업무를 수행합니다.");
        System.out.println("- 기술 전략 수립 및 아키텍처 설계");
        System.out.println("- 팀 관리 및 프로젝트 총괄");
        System.out.println("- 기술 의사결정 및 경영진 보고");
    }
    
    // ITechnical 구현 (팀장 레벨)
    @Override
    public int developSoftware(String requirements) {
        System.out.println("고급 시스템 아키텍처 설계: " + requirements);
        return requirements.length() / 15; // 효율적인 개발
    }
    
    @Override
    public boolean troubleshootSystem(String issue) {
        System.out.println("복잡한 시스템 문제 해결: " + issue);
        return true; // 팀장은 모든 기술 문제 해결 가능
    }
    
    @Override
    public int performCodeReview(String codeSnippet) {
        System.out.println("전문적인 코드 리뷰 및 아키텍처 검토");
        return 9; // 높은 품질의 리뷰
    }
    
    @Override
    public int writeTechnicalDocument(String topic) {
        System.out.println("기술 표준 및 가이드라인 문서 작성: " + topic);
        return 25; // 포괄적인 문서
    }

}