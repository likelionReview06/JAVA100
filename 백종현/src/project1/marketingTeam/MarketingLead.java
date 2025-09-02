package project1.marketingTeam;

import project1.enums.Department;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Lead;
import project1.utils.interfaces.IMarketing;
import project1.utils.interfaces.IWorkable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketingLead extends Lead implements IWorkable, IMarketing {
    
    
    public MarketingLead(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.MARKETING);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 마케팅팀장이 " + hours + "시간 동안 마케팅 전략 업무를 수행합니다.");
    }
    
    @Override
    public int createCampaign(String productName, double budget) { return (int)(budget/500); }
    @Override
    public double analyzeMarketTrends(String industry) { return 8.0; }
    @Override
    public int surveyBrandAwareness(String brandName) { return 80; }
    @Override
    public Map<String, String> performCustomerSegmentation() { 
        Map<String, String> comprehensive = new HashMap<>();
        comprehensive.put("20-30대", "디지털 네이티브");
        comprehensive.put("30-40대", "가치 중시");
        comprehensive.put("40대+", "전통적 접근");
        return comprehensive;
    }
}