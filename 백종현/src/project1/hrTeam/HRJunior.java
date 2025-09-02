package project1.hrTeam;

import project1.enums.Department;
import project1.enums.Position;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Junior;
import project1.utils.interfaces.IHR;
import project1.utils.interfaces.IWorkable;

import java.util.List;

/**
 * HRJunior 클래스
 * 인사팀의 주니어 직원을 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class HRJunior extends Junior implements IWorkable, IHR {
    
    public HRJunior(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.HR);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 주니어가 " + hours + "시간 동안 인사 업무를 처리합니다.");
        System.out.println("- 직원 정보 관리");
        System.out.println("- 채용 프로세스 지원");
        System.out.println("- 교육 프로그램 운영");
    }
    
    
    @Override
    public boolean recruitEmployee(Position position, String candidateName) {
        if (position == Position.INTERN) {
            System.out.println("인턴 채용을 진행합니다: " + candidateName);
            return true;
        }
        return false;
    }
    
    @Override
    public int processPayroll(int month) {
        System.out.println(month + "월 급여 계산을 보조합니다.");
        return 5;
    }
    
    @Override
    public double manageTrainingProgram(String programName, List<Employee> participants) {
        System.out.println("교육 프로그램을 운영합니다: " + programName);
        return 70.0;
    }
    
    @Override
    public String conductAnnualReview(Employee employee) {
        return "참고용";
    }
    
}