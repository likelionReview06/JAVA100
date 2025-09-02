package project1.salesTeam;

import project1.enums.Department;
import project1.utils.abstracts.Junior;
import project1.utils.interfaces.ISales;
import project1.utils.interfaces.IWorkable;

import java.util.List;

/**
 * SalesJunior 클래스
 * 영업팀의 주니어 직원을 나타내는 구체 클래스입니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public class SalesJunior extends Junior implements IWorkable, ISales {
    
    private double monthlyTarget = 50000000; // 월 목표 5천만원
    
    public SalesJunior(int salary, int age, String name) {
        super(salary, age, name);
        super.setDepartment(Department.SALES);
    }
    
    @Override
    public void work(int hours) {
        System.out.println(getName() + " 주니어 영업사원이 " + hours + "시간 동안 영업 활동을 합니다.");
        System.out.println("- 기존 고객 관리");
        System.out.println("- 영업 제안서 작성");
        System.out.println("- 신규 고객 발굴");
    }
    
    // ISales 구현 (주니어 레벨)
    @Override
    public boolean contactClient(String clientName) {
        System.out.println("고객 " + clientName + "에게 연락을 취합니다.");
        return Math.random() > 0.3; // 70% 성공률
    }
    
    @Override
    public boolean signContract(String clientName, double amount) {
        if (amount <= 10000000) { // 1천만원 이하만 가능
            System.out.println(clientName + "과 " + String.format("%.0f원", amount) + " 계약 체결");
            return true;
        }
        System.out.println("계약 금액이 권한을 초과합니다. 상위 승인 필요.");
        return false;
    }
    
    @Override
    public double reportSalesPerformance(int month) {
        double performance = monthlyTarget * (0.5 + Math.random() * 0.4); // 50-90%
        System.out.println(month + "월 영업 실적: " + String.format("%.0f원", performance));
        return performance;
    }
    
    @Override
    public int developNewClients(String industry) {
        int newClients = (int)(Math.random() * 3) + 1; // 1-3명
        System.out.println(industry + " 업종에서 " + newClients + "명의 신규 고객을 개발했습니다.");
        return newClients;
    }
}