package project1.marketingTeam;

import project1.enums.Department;
import project1.utils.abstracts.Intern;
import project1.utils.interfaces.IMarketing;
import project1.utils.interfaces.IWorkable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketingIntern extends Intern implements IWorkable, IMarketing {
    
    public MarketingIntern(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.MARKETING);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 마케팅 인턴이 " + hours + "시간 동안 마케팅 보조 업무를 수행합니다.");
    }
    
    @Override
    public int createCampaign(String productName, double budget) { return (int)(budget/2000); }
    @Override
    public double analyzeMarketTrends(String industry) { return 2.0; }
    @Override
    public int surveyBrandAwareness(String brandName) { return 30; }
    @Override
    public Map<String, String> performCustomerSegmentation() { return new HashMap<>(); }
}