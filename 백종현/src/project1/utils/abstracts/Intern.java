package project1.utils.abstracts;

import project1.enums.Position;

/**
 * 인턴 직급 직원의 추상 클래스입니다.
 * Employee 클래스를 상속받으며, 인턴급에 특화된 속성과 제약사항을 정의합니다.
 * 
 * <p>인턴급 특징:
 * <ul>
 *   <li>급여 범위: 1,500만원 ~ 2,500만원</li>
 *   <li>기본 업무 효율성: 50%</li>
 *   <li>직급: INTERN (레벨 0)</li>
 *   <li>경력 수준: 신입/초급</li>
 * </ul>
 * 
 * <p>구체적인 부서별 인턴 클래스들:
 * <ul>
 *   <li>HRIntern - 인사팀 인턴</li>
 *   <li>ITIntern - IT팀 인턴</li>
 *   <li>SalesIntern - 영업팀 인턴</li>
 *   <li>MarketingIntern - 마케팅팀 인턴</li>
 * </ul>
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public abstract class Intern extends Employee {
    
    /**
     * 인턴 직급 직원의 생성자입니다.
     * 급여 유효성 검사를 수행하고 Position을 INTERN으로 설정합니다.
     * 
     * <p>급여 제약사항: 1,500만원 이상 2,500만원 이하</p>
     * 
     * @param salary 직원의 급여 (1,500만원 ~ 2,500만원)
     * @param age 직원의 나이 (양수)
     * @param name 직원의 이름 (null이 아닌 문자열)
     * @throws IllegalArgumentException 급여가 유효 범위를 벗어난 경우
     */
    public Intern(int salary, int age, String name) {
        super(validateInternSalary(salary), age, name);
        super.setPosition(Position.INTERN);
    }
    
    /**
     * 인턴급 급여의 유효성을 검증합니다.
     * 
     * @param salary 검증할 급여
     * @return 유효한 급여
     * @throws IllegalArgumentException 급여가 1,500만원 미만이거나 2,500만원 초과인 경우
     */
    private static int validateInternSalary(int salary) {
        if (salary < 15000000 || salary > 25000000) {
            throw new IllegalArgumentException("인턴 급여는 1500만원~2500만원 사이여야 합니다.");
        }
        return salary;
    }
    
    /**
     * 인턴급의 기본 업무 효율성을 반환합니다.
     * 신입 수준의 경험으로 인해 상대적으로 낮은 효율성을 가집니다.
     * 
     * @return 기본 업무 효율성 (50%)
     */
    protected int getBaseWorkEfficiency() {
        return 50; // 50% 기본 효율성
    }
}
