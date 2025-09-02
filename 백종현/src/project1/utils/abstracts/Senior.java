package project1.utils.abstracts;

import project1.enums.Position;

/**
 * 시니어 직급 직원의 추상 클래스입니다.
 * Employee 클래스를 상속받으며, 시니어급에 특화된 속성과 제약사항을 정의합니다.
 * 
 * <p>시니어급 특징:
 * <ul>
 *   <li>급여 범위: 5,000만원 ~ 8,000만원</li>
 *   <li>기본 업무 효율성: 85%</li>
 *   <li>직급: SENIOR (레벨 2)</li>
 *   <li>경력 수준: 중급/고급</li>
 *   <li>멘토링 능력 보유</li>
 * </ul>
 * 
 * <p>구체적인 부서별 시니어 클래스들:
 * <ul>
 *   <li>HRSenior - 인사팀 시니어</li>
 *   <li>ITSenior - IT팀 시니어</li>
 *   <li>SalesSenior - 영업팀 시니어</li>
 *   <li>MarketingSenior - 마케팅팀 시니어</li>
 * </ul>
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public abstract class Senior extends Employee {
    
    /**
     * 시니어 직급 직원의 생성자입니다.
     * 급여 유효성 검사를 수행하고 Position을 SENIOR로 설정합니다.
     * 
     * <p>급여 제약사항: 5,000만원 이상 8,000만원 이하</p>
     * 
     * @param salary 직원의 급여 (5,000만원 ~ 8,000만원)
     * @param age 직원의 나이 (양수)
     * @param name 직원의 이름 (null이 아닌 문자열)
     * @throws IllegalArgumentException 급여가 유효 범위를 벗어난 경우
     */
    public Senior(int salary, int age, String name) {
        super(validateSeniorSalary(salary), age, name);
        super.setPosition(Position.SENIOR);
    }
    
    /**
     * 시니어급 급여의 유효성을 검증합니다.
     * 
     * @param salary 검증할 급여
     * @return 유효한 급여
     * @throws IllegalArgumentException 급여가 5,000만원 미만이거나 8,000만원 초과인 경우
     */
    private static int validateSeniorSalary(int salary) {
        if (salary < 50000000 || salary > 80000000) {
            throw new IllegalArgumentException("시니어 급여는 5000만원~8000만원 사이여야 합니다.");
        }
        return salary;
    }
    
    /**
     * 시니어급의 기본 업무 효율성을 반환합니다.
     * 충분한 경험과 전문성을 바탕으로 높은 효율성을 가집니다.
     * 
     * @return 기본 업무 효율성 (85%)
     */
    protected int getBaseWorkEfficiency() {
        return 85; // 85% 기본 효율성
    }
}
