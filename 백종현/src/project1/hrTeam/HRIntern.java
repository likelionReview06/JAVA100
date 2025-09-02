package project1.hrTeam;

import project1.enums.Department;
import project1.enums.Position;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Intern;
import project1.utils.interfaces.IHR;
import project1.utils.interfaces.IWorkable;

import java.util.List;

/**
 * HRIntern 클래스
 * 인사팀의 인턴 직원을 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class HRIntern extends Intern implements IWorkable, IHR {
    
    public HRIntern(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.HR);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 인턴이 " + hours + "시간 동안 인사 업무를 보조합니다.");
        System.out.println("- 서류 정리 및 파일링");
        System.out.println("- 면접 일정 관리");
        System.out.println("- 기본적인 데이터 입력");
    }
    
    
    // IHR 구현 (인턴 레벨)
    @Override
    public boolean recruitEmployee(Position position, String candidateName) {
        System.out.println("인턴은 채용 권한이 없습니다.");
        return false;
    }
    
    @Override
    public int processPayroll(int month) {
        System.out.println("인턴은 급여 처리 권한이 없습니다.");
        return 0;
    }
    
    @Override
    public double manageTrainingProgram(String programName, List<Employee> participants) {
        System.out.println("교육 프로그램 보조 업무를 수행합니다: " + programName);
        return 30.0; // 보조 역할만 가능
    }
    
    @Override
    public String conductAnnualReview(Employee employee) {
        System.out.println("인턴은 성과 평가 권한이 없습니다.");
        return "권한없음";
    }
    
}