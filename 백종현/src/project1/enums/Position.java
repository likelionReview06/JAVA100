package project1.enums;

/**
 * 직원의 직급을 나타내는 열거형입니다.
 * 각 직급은 계층적 수준(level)과 한국어 직급명을 가지며, 급여 범위와 권한을 결정하는 데 사용됩니다.
 * 
 * <p>직급 계층 구조 (level 순):
 * <ul>
 *   <li>INTERN (레벨 0) - 인턴: 1,500만원~2,500만원, 업무 효율성 50%</li>
 *   <li>JUNIOR (레벨 1) - 주니어: 3,000만원~5,000만원, 업무 효율성 70%</li>
 *   <li>SENIOR (레벨 2) - 시니어: 5,000만원~8,000만원, 업무 효율성 85%, 멘토링 능력</li>
 *   <li>LEAD (레벨 3) - 팀장: 8,000만원~12,000만원, 업무 효율성 95%, 리더십 및 의사결정 권한</li>
 * </ul>
 * 
 * <p>높은 level일수록 더 높은 권한과 책임을 가집니다.</p>
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public enum Position {
    
    /**
     * 인턴 - 가장 낮은 직급, 신입 수준의 업무 수행
     * 급여 범위: 1,500만원~2,500만원, 기본 효율성: 50%
     */
    INTERN(0, "인턴"),
    
    /**
     * 주니어 - 기본적인 업무를 독립적으로 수행할 수 있는 직급
     * 급여 범위: 3,000만원~5,000만원, 기본 효율성: 70%
     */
    JUNIOR(1, "주니어"),
    
    /**
     * 시니어 - 고도의 전문성을 가지고 멘토링도 가능한 직급
     * 급여 범위: 5,000만원~8,000만원, 기본 효율성: 85%
     */
    SENIOR(2, "시니어"),
    
    /**
     * 팀장 - 최고 직급, 팀 리더십과 의사결정 권한을 가진 직급
     * 급여 범위: 8,000만원~12,000만원, 기본 효율성: 95%
     */
    LEAD(3, "팀장");

    /**
     * 직급의 계층적 수준 (0이 가장 낮음)
     */
    private final int level;
    
    /**
     * 직급의 한국어 명칭
     */
    private final String title;

    /**
     * Position 열거형 생성자
     * 
     * @param level 직급의 계층적 수준 (0부터 시작하는 정수)
     * @param title 직급의 한국어 명칭
     */
    Position(int level, String title) {
        this.level = level;
        this.title = title;
    }

    /**
     * 직급의 계층적 수준을 반환합니다.
     * 수치가 높을수록 상위 직급을 의미합니다.
     * 
     * @return 직급 수준 (0: 인턴, 1: 주니어, 2: 시니어, 3: 팀장)
     */
    public int getLevel() {
        return level;
    }

    /**
     * 직급의 한국어 명칭을 반환합니다.
     * 
     * @return 직급의 한국어 명칭
     */
    public String getTitle() {
        return title;
    }

    /**
     * 주어진 level 값으로부터 해당하는 Position 열거형 값을 찾습니다.
     * 
     * @param level 찾을 직급의 수준 (0~3)
     * @return 일치하는 Position 열거형 값
     * @throws IllegalArgumentException 유효하지 않은 level 값이 주어진 경우
     */
    public static Position fromLevel(int level) {
        for (Position p : Position.values()) {
            if (p.getLevel() == level) {
                return p;
            }
        }
        throw new IllegalArgumentException("그런 직급 없어: " + level);
    }
}
