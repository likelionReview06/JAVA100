package project1.salesTeam;

import project1.enums.Department;
import project1.utils.abstracts.Intern;
import project1.utils.interfaces.ISales;
public class SalesIntern extends Intern implements ISales {
    
    public SalesIntern(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.SALES);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 영업 인턴이 " + hours + "시간 동안 영업 보조 업무를 수행합니다.");
    }
    
    @Override
    public boolean contactClient(String clientName) {
        System.out.println("간단한 고객 연락: " + clientName);
        return Math.random() > 0.5;
    }
    
    @Override
    public boolean signContract(String clientName, double amount) {
        return amount < 1000000; // 100만원 미만만
    }
    
    @Override
    public double reportSalesPerformance(int month) {
        return 5000000; // 500만원 정도
    }
    
    @Override
    public int developNewClients(String industry) {
        return 1; // 1명 정도
    }
}