package project1.utils.interfaces;

/**
 * IWorkable 인터페이스
 * 직원의 업무 수행 능력과 관련된 기능을 정의합니다.
 * 
 * @author 백종현
 * @version 1.0
 */
public interface IWorkable {
    
    /**
     * 업무를 수행합니다.
     * 
     * @param hours 업무 시간
     */
    default void performWork(int hours) {
        System.out.println("업무를 " + hours + "시간 수행합니다.");
    }
}