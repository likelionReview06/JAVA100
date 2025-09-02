package project1.salesTeam;

import project1.enums.Department;
import project1.utils.abstracts.Employee;
import project1.utils.abstracts.Lead;
import project1.utils.interfaces.ISales;
import project1.utils.interfaces.IWorkable;
import java.util.ArrayList;
import java.util.List;

public class SalesLead extends Lead implements IWorkable, ISales {
    
    
    public SalesLead(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.SALES);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 영업팀장이 " + hours + "시간 동안 영업 전략 업무를 수행합니다.");
    }
    
    @Override
    public boolean contactClient(String clientName) { return true; }
    @Override
    public boolean signContract(String clientName, double amount) { return true; }
    @Override
    public double reportSalesPerformance(int month) { return 150000000; }
    @Override
    public int developNewClients(String industry) { return 10; }
}