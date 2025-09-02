package project1.utils.interfaces;

/**
 * ISales 인터페이스
 * 영업팀 직원들의 영업 활동과 관련된 기능을 정의합니다.
 * 
 * 고객 관리, 영업 목표 달성, 계약 체결 등
 * 영업부서 특화 기능들을 포함합니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public interface ISales {
    
    /**
     * 고객에게 연락을 취합니다.
     * 
     * @param clientName 연락할 고객 이름
     * @return 연락 성공 여부
     * @throws IllegalArgumentException 고객 이름이 null이거나 빈 문자열인 경우
     */
    boolean contactClient(String clientName);
    
    /**
     * 고객과 계약을 체결합니다.
     * 
     * @param clientName 계약 고객 이름
     * @param amount 계약 금액
     * @return 계약 성공 여부
     */
    boolean signContract(String clientName, double amount);
    
    /**
     * 영업 실적을 보고합니다.
     * 
     * @param month 보고할 월 (1-12)
     * @return 해당 월의 총 영업 실적
     * @throws IllegalArgumentException 월이 1-12 범위를 벗어나는 경우
     */
    double reportSalesPerformance(int month);
    
    /**
     * 신규 고객을 개발합니다.
     * 
     * @param industry 타겟 업종
     * @return 개발된 신규 고객 수
     */
    int developNewClients(String industry);
}