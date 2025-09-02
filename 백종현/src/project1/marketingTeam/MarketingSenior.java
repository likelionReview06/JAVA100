package project1.marketingTeam;

import project1.enums.Department;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Senior;
import project1.utils.interfaces.IMarketing;
import project1.utils.interfaces.IWorkable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MarketingSenior 클래스
 * 마케팅팀의 시니어 직원을 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class MarketingSenior extends Senior implements IWorkable, IMarketing {
    
    
    public MarketingSenior(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.MARKETING);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 시니어 마케터가 " + hours + "시간 동안 마케팅 업무를 수행합니다.");
        System.out.println("- 마케팅 전략 수립");
        System.out.println("- 캠페인 기획 및 실행");
        System.out.println("- 시장 분석 및 트렌드 연구");
    }
    
    // IMarketing 구현
    @Override
    public int createCampaign(String productName, double budget) {
        int expectedReach = (int)(budget / 1000 * 50); // 예산 대비 도달 고객 수
        System.out.println(productName + " 캠페인 생성 (예산: " + String.format("%.0f원", budget) + ")");
        System.out.println("예상 도달 고객: " + expectedReach + "명");
        return expectedReach;
    }
    
    @Override
    public double analyzeMarketTrends(String industry) {
        double growthRate = 3.0 + (Math.random() * 7.0); // 3-10% 성장률
        System.out.println(industry + " 업종 시장 분석 완료");
        System.out.println("예상 성장률: " + String.format("%.1f%%", growthRate));
        return growthRate;
    }
    
    @Override
    public int surveyBrandAwareness(String brandName) {
        int awareness = 40 + (int)(Math.random() * 40); // 40-80%
        System.out.println(brandName + " 브랜드 인지도 조사: " + awareness + "%");
        return awareness;
    }
    
    @Override
    public Map<String, String> performCustomerSegmentation() {
        Map<String, String> segments = new HashMap<>();
        segments.put("20-30대", "디지털 네이티브, 온라인 구매 선호");
        segments.put("30-40대", "가격 대비 품질 중시, 브랜드 충성도 높음");
        segments.put("40대+", "오프라인 매장 선호, 전통적 마케팅에 반응");
        System.out.println("고객 세그멘테이션 완료");
        return segments;
    }
    
}