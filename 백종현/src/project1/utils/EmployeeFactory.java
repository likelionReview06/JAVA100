package project1.utils;

import project1.enums.*;
import project1.hrTeam.*;
import project1.itTeam.*;
import project1.marketingTeam.*;
import project1.salesTeam.*;
import project1.utils.abstracts.Employee;

/**
 * 직원 객체 생성을 담당하는 팩토리 클래스입니다.
 * Factory Pattern을 구현하여 부서와 직급에 맞는 적절한 직원 객체를 생성합니다.
 * 
 * <p>이 클래스는 16개의 구체적인 직원 클래스(4개 부서 × 4개 직급) 생성을 중앙화하여
 * 객체 생성 로직을 단순화하고 코드 중복을 제거합니다.</p>
 * 
 * <p>지원하는 부서:
 * <ul>
 *   <li>HR (인사팀)</li>
 *   <li>IT (정보기술팀)</li>
 *   <li>SALES (영업팀)</li>
 *   <li>MARKETING (마케팅팀)</li>
 * </ul>
 * 
 * <p>지원하는 직급:
 * <ul>
 *   <li>INTERN (인턴)</li>
 *   <li>JUNIOR (주니어)</li>
 *   <li>SENIOR (시니어)</li>
 *   <li>LEAD (팀장)</li>
 * </ul>
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public class EmployeeFactory {
    
    /**
     * 지정된 부서와 직급에 맞는 직원 객체를 생성합니다.
     * 
     * <p>생성된 직원 객체는 자동으로 전체 직원 목록에 등록되며,
     * 고유한 ID가 할당됩니다.</p>
     * 
     * <p>사용 예시:
     * <pre>{@code
     * Employee hrManager = EmployeeFactory.createEmployee(
     *     50000000, 30, "김관리", Department.HR, Position.JUNIOR
     * );
     * }</pre>
     * 
     * @param salary 직원의 급여 (원 단위, 직급별 범위 검증됨)
     * @param age 직원의 나이 (양수)
     * @param name 직원의 이름 (null이 아닌 문자열)
     * @param department 직원이 속할 부서 (Department enum)
     * @param position 직원의 직급 (Position enum)
     * @return 생성된 Employee 객체 (구체적인 하위 클래스 인스턴스)
     * @throws IllegalArgumentException 유효하지 않은 부서나 직급이 전달된 경우
     * @throws IllegalArgumentException 급여가 해당 직급의 범위를 벗어난 경우
     * @see Department
     * @see Position
     * @see Employee#Employee(int, int, String)
     */
    public static Employee createEmployee(int salary, int age, String name, Department department, Position position) {
        return switch (department) {
            case HR -> switch (position) {
                case LEAD   -> new HRLead(salary, age, name);
                case SENIOR -> new HRSenior(salary, age, name);
                case JUNIOR -> new HRJunior(salary, age, name);
                case INTERN -> new HRIntern(salary, age, name);
                default     -> throw new IllegalArgumentException("Invalid position");
            };
            case MARKETING -> switch (position) {
                case LEAD   -> new MarketingLead(salary, age, name);
                case SENIOR -> new MarketingSenior(salary, age, name);
                case JUNIOR -> new MarketingJunior(salary, age, name);
                case INTERN -> new MarketingIntern(salary, age, name);
                default     -> throw new IllegalArgumentException("Invalid position");
            };
            case SALES -> switch (position) {
                case LEAD   -> new SalesLead(salary, age, name);
                case SENIOR -> new SalesSenior(salary, age, name);
                case JUNIOR -> new SalesJunior(salary, age, name);
                case INTERN -> new SalesIntern(salary, age, name);
                default     -> throw new IllegalArgumentException("Invalid position");
            };
            case IT -> switch (position) {
                case LEAD   -> new ITLead(salary, age, name);
                case SENIOR -> new ITSenior(salary, age, name);
                case JUNIOR -> new ITJunior(salary, age, name);
                case INTERN -> new ITIntern(salary, age, name);
                default     -> throw new IllegalArgumentException("Invalid position");
            };
            default -> throw new IllegalArgumentException("Invalid department");
        };
    }
}
