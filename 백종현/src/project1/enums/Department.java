package project1.enums;

/**
 * 회사의 부서를 나타내는 열거형입니다.
 * 각 부서는 고유한 한국어 이름을 가지며, 직원들의 소속 부서를 구분하는 데 사용됩니다.
 * 
 * <p>지원 부서:
 * <ul>
 *   <li>HR - 인사팀 (인사 관리, 채용, 교육, 성과 평가)</li>
 *   <li>MARKETING - 마케팅팀 (캠페인 기획, 시장 분석, 브랜드 관리)</li>
 *   <li>SALES - 영업팀 (고객 관리, 계약 체결, 영업 실적 관리)</li>
 *   <li>IT - IT팀 (소프트웨어 개발, 시스템 관리, 기술 지원)</li>
 * </ul>
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public enum Department {
    
    /**
     * 인사팀 - 직원 채용, 교육, 급여, 성과 평가 등 인사 관리 업무를 담당
     */
    HR("인사팀"),
    
    /**
     * 마케팅팀 - 마케팅 전략 기획, 캠페인 실행, 시장 분석, 브랜드 관리 업무를 담당
     */
    MARKETING("마케팅팀"),
    
    /**
     * 영업팀 - 고객 개발, 영업 활동, 계약 체결, 실적 관리 업무를 담당
     */
    SALES("영업팀"),
    
    /**
     * IT팀 - 소프트웨어 개발, 시스템 운영, 기술 지원, 인프라 관리 업무를 담당
     */
    IT("IT팀");

    /**
     * 부서의 한국어 이름
     */
    private final String name;

    /**
     * Department 열거형 생성자
     * 
     * @param name 부서의 한국어 이름
     */
    Department(String name) {
        this.name = name;
    }

    /**
     * 부서의 한국어 이름을 반환합니다.
     * 
     * @return 부서의 한국어 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 한국어 이름으로부터 해당하는 Department 열거형 값을 찾습니다.
     * 
     * @param name 찾을 부서의 한국어 이름
     * @return 일치하는 Department 열거형 값
     * @throws IllegalArgumentException 일치하는 부서 이름이 없는 경우
     */
    public static Department fromName(String name) {
        for (Department d : Department.values()) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        throw new IllegalArgumentException("Invalid department name: " + name);
    }
}
