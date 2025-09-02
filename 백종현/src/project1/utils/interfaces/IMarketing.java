package project1.utils.interfaces;

import java.util.Map;

/**
 * IMarketing 인터페이스
 * 마케팅팀 직원들의 마케팅 활동과 관련된 기능을 정의합니다.
 * 
 * 캠페인 기획, 시장 분석, 브랜드 관리 등
 * 마케팅부서 특화 기능들을 포함합니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public interface IMarketing {
    
    /**
     * 제품을 위한 마케팅 캠페인을 생성합니다.
     * 
     * @param productName 캠페인 대상 제품명
     * @param budget 캠페인 예산
     * @return 예상 도달 고객 수
     * @throws IllegalArgumentException 제품명이 null이거나 예산이 음수인 경우
     */
    int createCampaign(String productName, double budget);
    
    /**
     * 시장 동향을 분석합니다.
     * 
     * @param industry 분석할 업종
     * @return 시장 성장률 (퍼센트)
     */
    double analyzeMarketTrends(String industry);
    
    /**
     * 브랜드 인지도를 조사합니다.
     * 
     * @param brandName 조사할 브랜드명
     * @return 브랜드 인지도 점수 (0-100)
     */
    int surveyBrandAwareness(String brandName);
    
    /**
     * 고객 세그멘테이션을 수행합니다.
     * 
     * @return 고객 세그먼트별 특성 맵 (세그먼트명 -> 특성 설명)
     */
    Map<String, String> performCustomerSegmentation();
}