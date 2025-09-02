package project1.utils.abstracts;

import project1.enums.Department;
import project1.enums.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 모든 직원의 기본 클래스입니다.
 * 직원의 공통 속성과 기능을 정의하며, 구체적인 직급별 클래스들의 상위 클래스 역할을 합니다.
 * 
 * <p>주요 기능:
 * <ul>
 *   <li>자동 ID 생성 및 관리</li>
 *   <li>전체 직원 목록 관리</li>
 *   <li>직원 검색 기능</li>
 *   <li>부서별 통계 기능</li>
 * </ul>
 * 
 * <p>상속 구조:
 * Employee → {Intern, Junior, Senior, Lead} → {구체적인 팀별 클래스들}
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public abstract class Employee {
    /**
     * 직원의 이름
     */
    private String name;
    
    /**
     * 직원의 나이
     */
    private int age;
    
    /**
     * 직원의 급여 (원 단위)
     */
    private int salary;
    
    /**
     * 직원의 직급
     */
    private Position position;
    
    /**
     * 직원이 속한 부서
     */
    private Department department;
    
    /**
     * 다음에 할당될 직원 ID (자동 증가)
     */
    private static int nextEmployeeId = 1;
    
    /**
     * 직원의 고유 ID (불변)
     */
    final private int employeeId;
    
    /**
     * 전체 직원 목록 (정적 컬렉션)
     */
    protected static List<Employee> employeeList = new ArrayList<>();

    /**
     * Employee 생성자입니다.
     * 자동으로 고유 ID를 할당하고 전체 직원 목록에 추가합니다.
     * 
     * <p>주의: 하위 클래스에서는 생성자에서 반드시 setDepartment()와 setPosition()을 호출해야 합니다.</p>
     * 
     * @param salary 급여 (원 단위, 양수여야 함)
     * @param age 나이 (양수여야 함)
     * @param name 이름 (null이나 빈 문자열이 아니어야 함)
     */
    public Employee(int salary, int age, String name) {
        this.employeeId = nextEmployeeId++;
        this.salary = salary;
        this.age = age;
        this.name = name;
        employeeList.add(this);
    }

    /**
     * 직원의 이름을 반환합니다.
     * 
     * @return 직원의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 직원의 이름을 설정합니다.
     * 
     * @param name 설정할 이름 (null이나 빈 문자열이 아니어야 함)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 직원의 나이를 반환합니다.
     * 
     * @return 직원의 나이
     */
    public int getAge() {
        return age;
    }

    /**
     * 직원의 나이를 설정합니다.
     * 
     * @param age 설정할 나이 (양수여야 함)
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 직원의 급여를 반환합니다.
     * 
     * @return 직원의 급여 (원 단위)
     */
    public int getSalary() {
        return salary;
    }

    /**
     * 직원의 급여를 설정합니다.
     * 
     * @param salary 설정할 급여 (원 단위, 양수여야 함)
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * 직원의 직급을 반환합니다.
     * 
     * @return 직원의 직급
     */
    public Position getPosition() {
        return position;
    }

    /**
     * 직원의 직급을 설정합니다.
     * 
     * @param position 설정할 직급
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * 직원이 속한 부서를 반환합니다.
     * 
     * @return 직원이 속한 부서
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * 직원이 속할 부서를 설정합니다.
     * 
     * @param department 설정할 부서
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * 직원의 고유 ID를 반환합니다.
     * 
     * @return 직원의 고유 ID (불변, 자동 할당)
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * 직원이 지정된 시간 동안 업무를 수행합니다.
     * 구체적인 구현은 하위 클래스에서 정의됩니다.
     * 
     * @param num 업무 시간 (시간 단위)
     */
    abstract public void work(int num);

    /**
     * 직원 객체의 동등성을 비교합니다.
     * 직원 ID를 기준으로 동등성을 판단합니다.
     * 
     * @param o 비교할 객체
     * @return 같은 직원일 경우 true, 그렇지 않으면 false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId;
    }

    /**
     * 직원 객체의 해시코드를 반환합니다.
     * 직원 ID를 기준으로 해시코드를 생성합니다.
     * 
     * @return 직원 ID 기반의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(employeeId);
    }
    
    /**
     * 직원 정보를 문자열로 반환합니다.
     * 모든 기본 정보(ID, 이름, 나이, 급여, 직급, 부서)를 포함합니다.
     * 
     * @return 직원 정보가 포함된 문자열
     */
    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', age=%d, salary=%d, position=%s, department=%s}",
                employeeId, name, age, salary, 
                position != null ? position.getTitle() : "미지정",
                department != null ? department.getName() : "미배정");
    }
    
    // === Static 유틸리티 메서드들 ===
    
    /**
     * 등록된 모든 직원의 목록을 반환합니다.
     * 원본 목록의 복사본을 반환하여 외부에서의 수정을 방지합니다.
     * 
     * @return 모든 직원의 복사본 리스트
     */
    public static List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeList);
    }
    
    /**
     * 이름으로 직원을 검색합니다.
     * 입력된 문자열이 포함된 이름을 가진 모든 직원을 반환합니다.
     * 
     * @param name 검색할 이름 (부분 문자열도 가능)
     * @return 이름이 일치하는 직원들의 리스트
     */
    public static List<Employee> findByName(String name) {
        return employeeList.stream()
                .filter(emp -> emp.getName().contains(name))
                .toList();
    }
    
    /**
     * 특정 부서에 속한 직원 수를 반환합니다.
     * 
     * @param department 조회할 부서
     * @return 해당 부서의 직원 수
     */
    public static long countByDepartment(Department department) {
        return employeeList.stream()
                .filter(emp -> department.equals(emp.getDepartment()))
                .count();
    }
}
