package project1.hrTeam;

import project1.enums.Department;
import project1.enums.Position;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Senior;
import project1.utils.interfaces.IHR;
import project1.utils.interfaces.IWorkable;

import java.util.ArrayList;
import java.util.List;

/**
 * HRSenior 클래스
 * 인사팀의 시니어 직원을 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class HRSenior extends Senior implements IWorkable, IHR {
    
    
    public HRSenior(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.HR);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 시니어가 " + hours + "시간 동안 고급 인사 업무를 처리합니다.");
        System.out.println("- 채용 계획 수립 및 실행");
        System.out.println("- 성과 평가 시스템 관리");
        System.out.println("- 팀원 멘토링 및 교육");
    }
    
    // IHR 구현 (시니어 레벨)
    @Override
    public boolean recruitEmployee(Position position, String candidateName) {
        System.out.println(position.getTitle() + " 직급으로 " + candidateName + " 채용을 진행합니다.");
        return true;
    }
    
    @Override
    public int processPayroll(int month) {
        System.out.println(month + "월 급여를 처리합니다.");
        return getAllEmployees().size();
    }
    
    @Override
    public double manageTrainingProgram(String programName, List<Employee> participants) {
        System.out.println("교육 프로그램을 총괄 관리합니다: " + programName);
        return 90.0; // 시니어 수준 관리
    }
    
    @Override
    public String conductAnnualReview(Employee employee) {
        System.out.println(employee.getName() + "의 연간 성과를 평가합니다.");
        return "B"; // 평균 등급
    }
    
}