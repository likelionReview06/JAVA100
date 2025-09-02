package project1.utils.abstracts;

import project1.enums.Position;

/**
 * 팀장 직급 직원의 추상 클래스입니다.
 * Employee 클래스를 상속받으며, 팀장급에 특화된 속성과 제약사항을 정의합니다.
 * 
 * <p>팀장급 특징:
 * <ul>
 *   <li>급여 범위: 8,000만원 ~ 12,000만원</li>
 *   <li>기본 업무 효율성: 95%</li>
 *   <li>직급: LEAD (레벨 3)</li>
 *   <li>경력 수준: 고급/임원급</li>
 *   <li>팀 리더십 및 멘토링 능력 보유</li>
 *   <li>의사결정 권한 보유</li>
 * </ul>
 * 
 * <p>구체적인 부서별 팀장 클래스들:
 * <ul>
 *   <li>HRLead - 인사팀 팀장</li>
 *   <li>ITLead - IT팀 팀장</li>
 *   <li>SalesLead - 영업팀 팀장</li>
 *   <li>MarketingLead - 마케팅팀 팀장</li>
 * </ul>
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public abstract class Lead extends Employee {
    
    /**
     * 팀장 직급 직원의 생성자입니다.
     * 급여 유효성 검사를 수행하고 Position을 LEAD로 설정합니다.
     * 
     * <p>급여 제약사항: 8,000만원 이상 12,000만원 이하</p>
     * 
     * @param salary 직원의 급여 (8,000만원 ~ 12,000만원)
     * @param age 직원의 나이 (양수)
     * @param name 직원의 이름 (null이 아닌 문자열)
     * @throws IllegalArgumentException 급여가 유효 범위를 벗어난 경우
     */
    public Lead(int salary, int age, String name) {
        super(validateLeadSalary(salary), age, name);
        super.setPosition(Position.LEAD);
    }
    
    /**
     * 팀장급 급여의 유효성을 검증합니다.
     * 
     * @param salary 검증할 급여
     * @return 유효한 급여
     * @throws IllegalArgumentException 급여가 8,000만원 미만이거나 12,000만원 초과인 경우
     */
    private static int validateLeadSalary(int salary) {
        if (salary < 80000000 || salary > 120000000) {
            throw new IllegalArgumentException("팀장 급여는 8000만원~12000만원 사이여야 합니다.");
        }
        return salary;
    }
    
    /**
     * 팀장급의 기본 업무 효율성을 반환합니다.
     * 최고 수준의 경험과 리더십을 바탕으로 매우 높은 효율성을 가집니다.
     * 
     * @return 기본 업무 효율성 (95%)
     */
    protected int getBaseWorkEfficiency() {
        return 95; // 95% 기본 효율성
    }
}
