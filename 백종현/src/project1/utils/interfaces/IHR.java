package project1.utils.interfaces;

import project1.enums.Position;
import project1.utils.abstracts.Employee;
import java.util.List;

/**
 * IHR 인터페이스
 * 인사팀 직원들의 인사 관리와 관련된 기능을 정의합니다.
 * 
 * 채용, 급여 관리, 교육 프로그램, 성과 평가 등
 * 인사부서 특화 기능들을 포함합니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public interface IHR {
    
    /**
     * 지정된 직급으로 신규 직원을 채용합니다.
     * 
     * @param position 채용할 직급
     * @param candidateName 후보자 이름
     * @return 채용 성공 여부
     * @throws IllegalArgumentException position이나 candidateName이 null인 경우
     */
    boolean recruitEmployee(Position position, String candidateName);
    
    /**
     * 급여 계산 및 지급 처리를 수행합니다.
     * 
     * @param month 급여 지급 월 (1-12)
     * @return 지급 완료된 직원 수
     * @throws IllegalArgumentException 월이 1-12 범위를 벗어나는 경우
     */
    int processPayroll(int month);
    
    /**
     * 직원 교육 프로그램을 관리합니다.
     * 
     * @param programName 교육 프로그램명
     * @param participants 참가 직원 목록
     * @return 교육 완료율 (0-100)
     */
    double manageTrainingProgram(String programName, List<Employee> participants);
    
    /**
     * 연간 성과 평가를 실시합니다.
     * 
     * @param employee 평가할 직원
     * @return 평가 등급 ("A", "B", "C", "D", "F")
     */
    String conductAnnualReview(Employee employee);
    
}