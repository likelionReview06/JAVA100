package project1.hrTeam;

import project1.enums.Department;
import project1.enums.Position;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Lead;
import project1.utils.interfaces.IHR;
import project1.utils.interfaces.IWorkable;

import java.util.ArrayList;
import java.util.List;

/**
 * HRLead 클래스
 * 인사팀장을 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class HRLead extends Lead implements IWorkable, IHR {
    
    
    public HRLead(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.HR);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 인사팀장이 " + hours + "시간 동안 전략적 인사 업무를 수행합니다.");
        System.out.println("- 인사 정책 수립 및 전략 기획");
        System.out.println("- 조직 개발 및 문화 조성");
        System.out.println("- 경영진 보고 및 의사결정");
    }
    
    // IHR 구현 (팀장 레벨)
    @Override
    public boolean recruitEmployee(Position position, String candidateName) {
        System.out.println("팀장 권한으로 " + position.getTitle() + " 채용 승인: " + candidateName);
        return true; // 모든 직급 채용 가능
    }
    
    @Override
    public int processPayroll(int month) {
        System.out.println(month + "월 급여를 최종 승인하고 처리합니다.");
        return getAllEmployees().size(); // 전체 직원
    }
    
    @Override
    public double manageTrainingProgram(String programName, List<Employee> participants) {
        System.out.println("교육 프로그램을 전사적으로 관리합니다: " + programName);
        return 95.0; // 팀장급 관리
    }
    
    @Override
    public String conductAnnualReview(Employee employee) {
        System.out.println(employee.getName() + "의 최종 연간 평가를 실시합니다.");
        return "A"; // 팀장은 높은 평가 권한
    }
    
}