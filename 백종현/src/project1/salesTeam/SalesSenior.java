package project1.salesTeam;

import project1.enums.Department;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Senior;
import project1.utils.interfaces.ISales;
import project1.utils.interfaces.IWorkable;

import java.util.ArrayList;
import java.util.List;

public class SalesSenior extends Senior implements IWorkable, ISales {
    
    
    public SalesSenior(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.SALES);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 시니어 영업사원이 " + hours + "시간 동안 고급 영업 업무를 수행합니다.");
    }
    
    @Override
    public boolean contactClient(String clientName) {
        System.out.println("VIP 고객 관리: " + clientName);
        return Math.random() > 0.2;
    }
    
    @Override
    public boolean signContract(String clientName, double amount) {
        System.out.println("대형 계약 체결: " + clientName);
        return true;
    }
    
    @Override
    public double reportSalesPerformance(int month) {
        return 80000000; // 8천만원
    }
    
    @Override
    public int developNewClients(String industry) {
        return 5; // 5명
    }
    
}