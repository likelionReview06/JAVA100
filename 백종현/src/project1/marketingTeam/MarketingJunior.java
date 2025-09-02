package project1.marketingTeam;

import project1.enums.Department;
import project1.utils.abstracts.Junior;
import project1.utils.interfaces.IMarketing;
import project1.utils.interfaces.IWorkable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketingJunior extends Junior implements IWorkable, IMarketing {
    
    public MarketingJunior(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.MARKETING);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 주니어 마케터가 " + hours + "시간 동안 마케팅 업무를 수행합니다.");
    }
    
    @Override
    public int createCampaign(String productName, double budget) { return (int)(budget/1000); }
    @Override
    public double analyzeMarketTrends(String industry) { return 4.0; }
    @Override
    public int surveyBrandAwareness(String brandName) { return 50; }
    @Override
    public Map<String, String> performCustomerSegmentation() { 
        Map<String, String> basic = new HashMap<>();
        basic.put("젊은층", "소셜미디어 활용");
        return basic; 
    }
}