package project1.utils.abstracts;

import project1.enums.Position;

/**
 * 주니어 직급 직원의 추상 클래스입니다.
 * Employee 클래스를 상속받으며, 주니어급에 특화된 속성과 제약사항을 정의합니다.
 * 
 * <p>주니어급 특징:
 * <ul>
 *   <li>급여 범위: 3,000만원 ~ 5,000만원</li>
 *   <li>기본 업무 효율성: 70%</li>
 *   <li>직급: JUNIOR (레벨 1)</li>
 *   <li>경력 수준: 초급/중급</li>
 * </ul>
 * 
 * <p>구체적인 부서별 주니어 클래스들:
 * <ul>
 *   <li>HRJunior - 인사팀 주니어</li>
 *   <li>ITJunior - IT팀 주니어</li>
 *   <li>SalesJunior - 영업팀 주니어</li>
 *   <li>MarketingJunior - 마케팅팀 주니어</li>
 * </ul>
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public abstract class Junior extends Employee {
    
    /**
     * 주니어 직급 직원의 생성자입니다.
     * 급여 유효성 검사를 수행하고 Position을 JUNIOR로 설정합니다.
     * 
     * <p>급여 제약사항: 3,000만원 이상 5,000만원 이하</p>
     * 
     * @param salary 직원의 급여 (3,000만원 ~ 5,000만원)
     * @param age 직원의 나이 (양수)
     * @param name 직원의 이름 (null이 아닌 문자열)
     * @throws IllegalArgumentException 급여가 유효 범위를 벗어난 경우
     */
    public Junior(int salary, int age, String name) {
        super(validateJuniorSalary(salary), age, name);
        super.setPosition(Position.JUNIOR);
    }
    
    /**
     * 주니어급 급여의 유효성을 검증합니다.
     * 
     * @param salary 검증할 급여
     * @return 유효한 급여
     * @throws IllegalArgumentException 급여가 3,000만원 미만이거나 5,000만원 초과인 경우
     */
    private static int validateJuniorSalary(int salary) {
        if (salary < 30000000 || salary > 50000000) {
            throw new IllegalArgumentException("주니어 급여는 3000만원~5000만원 사이여야 합니다.");
        }
        return salary;
    }
    
    /**
     * 주니어급의 기본 업무 효율성을 반환합니다.
     * 일정 수준의 경험을 바탕으로 적절한 효율성을 가집니다.
     * 
     * @return 기본 업무 효율성 (70%)
     */
    protected int getBaseWorkEfficiency() {
        return 70; // 70% 기본 효율성
    }
}
