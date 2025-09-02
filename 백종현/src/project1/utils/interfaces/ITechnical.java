package project1.utils.interfaces;

/**
 * ITechnical 인터페이스
 * IT팀 직원들의 기술적 업무 수행 능력을 정의합니다.
 * 
 * 소프트웨어 개발, 시스템 관리, 기술 지원 등
 * IT부서 특화 기능들을 포함합니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public interface ITechnical {
    
    /**
     * 주어진 요구사항에 따라 소프트웨어를 개발합니다.
     * 
     * @param requirements 개발 요구사항 명세
     * @return 개발 완료 시간 (시간 단위)
     * @throws IllegalArgumentException 요구사항이 null이거나 빈 문자열인 경우
     */
    int developSoftware(String requirements);
    
    /**
     * 시스템 문제를 진단하고 해결합니다.
     * 
     * @param issue 발생한 문제 설명
     * @return 해결 성공 여부
     */
    boolean troubleshootSystem(String issue);
    
    /**
     * 코드 리뷰를 수행합니다.
     * 
     * @param codeSnippet 리뷰할 코드
     * @return 리뷰 점수 (1-10, 10이 최고)
     */
    int performCodeReview(String codeSnippet);
    
    /**
     * 기술 문서를 작성합니다.
     * 
     * @param topic 문서화할 주제
     * @return 작성된 문서의 페이지 수
     */
    int writeTechnicalDocument(String topic);
    
}