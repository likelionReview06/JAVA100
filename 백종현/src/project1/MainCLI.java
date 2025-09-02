package project1;

import project1.enums.Department;
import project1.enums.Position;
import project1.hrTeam.*;
import project1.itTeam.*;
import project1.salesTeam.*;
import project1.marketingTeam.*;
import project1.utils.abstracts.Employee;
import project1.utils.EmployeeFactory;
import project1.utils.interfaces.IHR;
import project1.utils.interfaces.ITechnical;
import project1.utils.interfaces.ISales;
import project1.utils.interfaces.IMarketing;

import java.util.Scanner;

/**
 * 직원 관리 시스템의 메인 CLI 클래스입니다.
 * 사용자가 직원을 관리하고 업무를 할당할 수 있는 대화형 콘솔 인터페이스를 제공합니다.
 * 
 * <p>주요 기능:
 * <ul>
 *   <li>전체 직원 조회</li>
 *   <li>부서별 통계</li>
 *   <li>직원 검색</li>
 *   <li>신규 직원 추가</li>
 *   <li>직원에게 업무 할당</li>
 * </ul>
 * 
 * @author 백종현
 * @version 1.0
 * @since 2024-08-31
 */
public class MainCLI {
    
    
    /**
     * 사용자 입력을 받기 위한 Scanner 객체입니다.
     */
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * 프로그램의 진입점입니다.
     * 기본 직원 데이터를 생성하고 메인 메뉴 루프를 시작합니다.
     * 
     * @param args 명령행 인수 (사용되지 않음)
     */
    public static void main(String[] args) {
        System.out.println("=== 직원 관리 시스템 ===");
        
        // 기본 데이터 생성
        initSampleData();
        
        // 메인 메뉴 루프
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 줄바꿈 처리
            
            switch (choice) {
                case 1 -> showAllEmployees();
                case 2 -> showDepartmentStats();
                case 3 -> searchEmployee();
                case 4 -> addNewEmployee();
                case 5 -> assignWorkToEmployee();
                case 6 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 선택입니다.");
            }
            
            System.out.println("\n계속하려면 Enter를 누르세요...");
            scanner.nextLine();
        }
    }
    
    /**
     * 메인 메뉴를 콘솔에 출력합니다.
     * 6가지 주요 기능을 사용자에게 제시합니다.
     */
    private static void showMenu() {
        System.out.println("\n===============================");
        System.out.println("1. 전체 직원 조회");
        System.out.println("2. 부서별 통계");
        System.out.println("3. 직원 검색");
        System.out.println("4. 직원 추가");
        System.out.println("5. 직원에게 업무 시키기");
        System.out.println("6. 종료");
        System.out.println("===============================");
        System.out.print("선택: ");
    }
    
    /**
     * 시스템 테스트용 샘플 직원 데이터를 생성합니다.
     * 4개 부서(HR, IT, 영업, 마케팅)에 각각 4개 직급(인턴, 주니어, 시니어, 팀장)의 직원을 생성합니다.
     * 
     * <p>생성되는 직원 수: 총 16명 (4개 부서 × 4개 직급)</p>
     * <p>각 직원은 부서와 직급에 맞는 적절한 급여로 설정됩니다.</p>
     */
    private static void initSampleData() {
        System.out.println("기본 데이터 생성 중...");
        
        // HR팀 - 4개 직급 모두
        new HRIntern(20000000, 23, "김인사");
        new HRJunior(35000000, 27, "김관리");
        new HRSenior(65000000, 35, "김승진");
        new HRLead(95000000, 42, "김채용");
        
        // IT팀 - 4개 직급 모두
        new ITIntern(22000000, 24, "이씨쁠");
        new ITJunior(40000000, 28, "이파이");
        new ITSenior(70000000, 33, "이자바");
        new ITLead(105000000, 38, "이서버");
        
        // 영업팀 - 4개 직급 모두
        new SalesIntern(18000000, 22, "최영업");
        new SalesJunior(45000000, 29, "최세일");
        new SalesSenior(75000000, 36, "최할인");
        new SalesLead(100000000, 44, "최발주");
        
        // 마케팅팀 - 4개 직급 모두
        new MarketingIntern(19000000, 25, "박홍보");
        new MarketingJunior(38000000, 30, "박광고");
        new MarketingSenior(68000000, 37, "박전단");
        new MarketingLead(110000000, 41, "박작가");
        
        System.out.println("기본 직원 " + Employee.getAllEmployees().size() + "명 생성 완료!\n");
    }
    
    /**
     * 등록된 모든 직원의 정보를 출력합니다.
     * Employee 클래스의 toString() 메서드를 통해 각 직원의 상세 정보를 표시합니다.
     */
    private static void showAllEmployees() {
        System.out.println("\n=== 전체 직원 목록 ===");
        for (Employee emp : Employee.getAllEmployees()) {
            System.out.println(emp);
        }
    }
    
    /**
     * 부서별 직원 통계를 출력합니다.
     * 각 부서의 직원 수를 집계하여 표시합니다.
     */
    private static void showDepartmentStats() {
        System.out.println("\n=== 부서별 통계 ===");
        for (Department dept : Department.values()) {
            long count = Employee.countByDepartment(dept);
            System.out.println(dept.getName() + ": " + count + "명");
        }
    }
    
    /**
     * 직원 이름으로 검색하여 결과를 출력합니다.
     * 사용자로부터 검색할 이름을 입력받고, 일치하는 직원들을 찾아 출력합니다.
     */
    private static void searchEmployee() {
        System.out.print("검색할 이름: ");
        String name = scanner.nextLine();
        
        var employees = Employee.findByName(name);
        if (employees.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("\n=== 검색 결과 ===");
            employees.forEach(System.out::println);
        }
    }
    
    /**
     * 새로운 직원을 시스템에 추가합니다.
     * 사용자로부터 직원의 기본 정보(이름, 나이, 급여)와 부서, 직급을 입력받아
     * EmployeeFactory를 통해 적절한 직원 객체를 생성합니다.
     * 
     * @throws Exception 직원 생성 과정에서 발생할 수 있는 예외 (급여 범위 초과 등)
     */
    private static void addNewEmployee() {
        System.out.println("\n=== 직원 추가 ===");
        
        System.out.print("이름: ");
        String name = scanner.nextLine();
        
        System.out.print("나이: ");
        int age = scanner.nextInt();
        
        System.out.print("급여: ");
        int salary = scanner.nextInt();
        
        System.out.println("부서 선택:");
        Department[] depts = Department.values();
        for (int i = 0; i < depts.length; i++) {
            System.out.println((i + 1) + ". " + depts[i].getName());
        }
        System.out.print("부서 번호: ");
        int deptChoice = scanner.nextInt() - 1;
        
        System.out.println("직급 선택:");
        Position[] positions = Position.values();
        for (int i = 0; i < positions.length; i++) {
            System.out.println((i + 1) + ". " + positions[i].getTitle());
        }
        System.out.print("직급 번호: ");
        int posChoice = scanner.nextInt() - 1;
        
        try {
            Department dept = depts[deptChoice];
            Position pos = positions[posChoice];
            
            // 팀과 직급에 맞는 클래스 생성
            createEmployee(dept, pos, salary, age, name);
            
            System.out.println("직원이 성공적으로 추가되었습니다!");
            
        } catch (Exception e) {
            System.out.println("직원 추가 실패: " + e.getMessage());
        }
    }
    
    /**
     * 지정된 부서와 직급에 맞는 직원을 생성합니다.
     * EmployeeFactory 패턴을 사용하여 적절한 구체 클래스의 인스턴스를 생성합니다.
     * 
     * @param dept 직원이 속할 부서
     * @param pos 직원의 직급
     * @param salary 직원의 급여
     * @param age 직원의 나이
     * @param name 직원의 이름
     */
    private static void createEmployee(Department dept, Position pos, int salary, int age, String name) {
        EmployeeFactory.createEmployee(salary, age, name, dept, pos);
    }
    
    /**
     * 직원을 선택하고 업무를 할당하는 4단계 프로세스를 진행합니다.
     * 1단계: 부서 선택
     * 2단계: 직급 선택
     * 3단계: 직원 선택
     * 4단계: 업무 선택 및 실행
     */
    private static void assignWorkToEmployee() {
        System.out.println("\n=== 직원에게 업무 시키기 ===");
        
        // 1. 부서 선택
        Department selectedDept = selectDepartment();
        if (selectedDept == null) return;
        
        // 2. 직급 선택  
        Position selectedPos = selectPosition();
        if (selectedPos == null) return;
        
        // 3. 직원 선택
        Employee selectedEmp = selectEmployee(selectedDept, selectedPos);
        if (selectedEmp == null) return;
        
        // 4. 업무 선택 및 실행
        selectAndExecuteTask(selectedEmp, selectedDept);
    }
    
    /**
     * 사용자로부터 부서를 선택받습니다.
     * 
     * @return 선택된 부서 (취소할 경우 null 반환)
     */
    private static Department selectDepartment() {
        System.out.println("\n부서를 선택하세요:");
        Department[] depts = Department.values();
        for (int i = 0; i < depts.length; i++) {
            System.out.println((i + 1) + ". " + depts[i].getName());
        }
        
        System.out.print("부서 번호 (0: 취소): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 0) return null;
        if (choice < 1 || choice > depts.length) {
            System.out.println("잘못된 선택입니다.");
            return null;
        }
        
        return depts[choice - 1];
    }
    
    /**
     * 사용자로부터 직급을 선택받습니다.
     * 
     * @return 선택된 직급 (취소할 경우 null 반환)
     */
    private static Position selectPosition() {
        System.out.println("\n직급을 선택하세요:");
        Position[] positions = Position.values();
        for (int i = 0; i < positions.length; i++) {
            System.out.println((i + 1) + ". " + positions[i].getTitle());
        }
        
        System.out.print("직급 번호 (0: 취소): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 0) return null;
        if (choice < 1 || choice > positions.length) {
            System.out.println("잘못된 선택입니다.");
            return null;
        }
        
        return positions[choice - 1];
    }
    
    /**
     * 지정된 부서와 직급에 해당하는 직원을 선택합니다.
     * 해당 조건에 맞는 직원들의 목록을 보여주고 사용자가 선택할 수 있도록 합니다.
     * 
     * @param dept 선택할 직원의 부서
     * @param pos 선택할 직원의 직급
     * @return 선택된 직원 (취소하거나 해당 조건의 직원이 없을 경우 null 반환)
     */
    private static Employee selectEmployee(Department dept, Position pos) {
        var employees = Employee.getAllEmployees().stream()
                .filter(emp -> emp.getDepartment() == dept && emp.getPosition() == pos)
                .toList();
        
        if (employees.isEmpty()) {
            System.out.println("해당 부서/직급에 직원이 없습니다.");
            return null;
        }
        
        System.out.println("\n직원을 선택하세요:");
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            System.out.println((i + 1) + ". " + emp.getName() + " (" + emp.getAge() + "세)");
        }
        
        System.out.print("직원 번호 (0: 취소): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 0) return null;
        if (choice < 1 || choice > employees.size()) {
            System.out.println("잘못된 선택입니다.");
            return null;
        }
        
        return employees.get(choice - 1);
    }
    
    /**
     * 선택된 직원과 부서에 따라 적절한 업무 메뉴를 표시하고 업무를 실행합니다.
     * 각 부서별로 특화된 업무 메뉴를 제공합니다.
     * 
     * @param employee 업무를 수행할 직원
     * @param dept 직원이 속한 부서 (업무 메뉴 결정에 사용)
     */
    private static void selectAndExecuteTask(Employee employee, Department dept) {
        System.out.println("\n=== " + employee.getName() + "에게 시킬 업무 선택 ===");
        
        switch (dept) {
            case HR -> showHRTasks(employee);
            case IT -> showITTasks(employee);
            case SALES -> showSalesTasks(employee);
            case MARKETING -> showMarketingTasks(employee);
        }
    }
    
    /**
     * HR팀 직원이 수행할 수 있는 업무 메뉴를 표시하고 실행합니다.
     * IHR 인터페이스를 구현한 직원만 전문 업무를 수행할 수 있습니다.
     * 
     * <p>제공되는 업무:
     * <ul>
     *   <li>일반 업무 (8시간)</li>
     *   <li>직원 채용</li>
     *   <li>급여 처리</li>
     *   <li>교육 진행</li>
     *   <li>성과 평가</li>
     * </ul>
     * 
     * @param employee 업무를 수행할 HR팀 직원
     */
    private static void showHRTasks(Employee employee) {
        System.out.println("HR팀 업무 목록:");
        System.out.println("1. 일반 업무 (8시간)");
        System.out.println("2. 직원 채용");
        System.out.println("3. 급여 처리");
        System.out.println("4. 교육 진행");
        System.out.println("5. 성과 평가");
        System.out.print("업무 선택: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1 -> employee.work(8);
            case 2 -> {
                if (employee instanceof IHR hr) {
                    boolean result = hr.recruitEmployee(Position.JUNIOR, "신입사원");
                    System.out.println("채용 결과: " + (result ? "성공" : "실패"));
                } else {
                    System.out.println("이 직원은 채용 업무를 수행할 수 없습니다.");
                }
            }
            case 3 -> {
                if (employee instanceof IHR hr) {
                    int result = hr.processPayroll(12);
                    System.out.println("급여 처리 완료: " + result + "명");
                } else {
                    System.out.println("이 직원은 급여 처리 업무를 수행할 수 없습니다.");
                }
            }
            case 4 -> {
                if (employee instanceof IHR hr) {
                    var participants = Employee.getAllEmployees().stream().limit(3).toList();
                    double result = hr.manageTrainingProgram("신입사원교육", participants);
                    System.out.println("교육 완료율: " + result + "%");
                } else {
                    System.out.println("이 직원은 교육 업무를 수행할 수 없습니다.");
                }
            }
            case 5 -> {
                if (employee instanceof IHR hr) {
                    String grade = hr.conductAnnualReview(employee);
                    System.out.println("성과 평가 등급: " + grade);
                } else {
                    System.out.println("이 직원은 성과 평가 업무를 수행할 수 없습니다.");
                }
            }
            default -> System.out.println("잘못된 선택입니다.");
        }
    }
    
    /**
     * IT팀 직원이 수행할 수 있는 업무 메뉴를 표시하고 실행합니다.
     * ITechnical 인터페이스를 구현한 직원만 전문 업무를 수행할 수 있습니다.
     * 
     * <p>제공되는 업무:
     * <ul>
     *   <li>일반 업무 (8시간)</li>
     *   <li>소프트웨어 개발</li>
     *   <li>시스템 문제 해결</li>
     *   <li>코드 리뷰</li>
     *   <li>기술 문서 작성</li>
     * </ul>
     * 
     * @param employee 업무를 수행할 IT팀 직원
     */
    private static void showITTasks(Employee employee) {
        System.out.println("IT팀 업무 목록:");
        System.out.println("1. 일반 업무 (8시간)");
        System.out.println("2. 소프트웨어 개발");
        System.out.println("3. 시스템 문제 해결");
        System.out.println("4. 코드 리뷰");
        System.out.println("5. 기술 문서 작성");
        System.out.print("업무 선택: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1 -> employee.work(8);
            case 2 -> {
                if (employee instanceof ITechnical tech) {
                    tech.developSoftware("사용자 관리 시스템");
                } else {
                    System.out.println("이 직원은 개발 업무를 수행할 수 없습니다.");
                }
            }
            case 3 -> {
                if (employee instanceof ITechnical tech) {
                    tech.troubleshootSystem("서버 연결 오류");
                } else {
                    System.out.println("이 직원은 문제 해결 업무를 수행할 수 없습니다.");
                }
            }
            case 4 -> {
                if (employee instanceof ITechnical tech) {
                    tech.performCodeReview("public class Example { ... }");
                } else {
                    System.out.println("이 직원은 코드 리뷰 업무를 수행할 수 없습니다.");
                }
            }
            case 5 -> {
                if (employee instanceof ITechnical tech) {
                    tech.writeTechnicalDocument("API 사용법");
                } else {
                    System.out.println("이 직원은 문서 작성 업무를 수행할 수 없습니다.");
                }
            }
            default -> System.out.println("잘못된 선택입니다.");
        }
    }
    
    /**
     * 영업팀 직원이 수행할 수 있는 업무 메뉴를 표시하고 실행합니다.
     * ISales 인터페이스를 구현한 직원만 전문 업무를 수행할 수 있습니다.
     * 
     * <p>제공되는 업무:
     * <ul>
     *   <li>일반 업무 (8시간)</li>
     *   <li>고객 관리</li>
     *   <li>계약 체결</li>
     *   <li>영업 실적 관리</li>
     *   <li>시장 조사</li>
     * </ul>
     * 
     * @param employee 업무를 수행할 영업팀 직원
     */
    private static void showSalesTasks(Employee employee) {
        System.out.println("영업팀 업무 목록:");
        System.out.println("1. 일반 업무 (8시간)");
        System.out.println("2. 고객 관리");
        System.out.println("3. 계약 체결");
        System.out.println("4. 영업 실적 관리");
        System.out.println("5. 시장 조사");
        System.out.print("업무 선택: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1 -> employee.work(8);
            case 2 -> {
                if (employee instanceof ISales sales) {
                    boolean result = sales.contactClient("ABC회사");
                    System.out.println("고객 연락 결과: " + (result ? "성공" : "실패"));
                } else {
                    System.out.println("이 직원은 고객 관리 업무를 수행할 수 없습니다.");
                }
            }
            case 3 -> {
                if (employee instanceof ISales sales) {
                    boolean result = sales.signContract("XYZ회사", 50000000);
                    System.out.println("계약 체결 결과: " + (result ? "성공" : "실패"));
                } else {
                    System.out.println("이 직원은 계약 체결 업무를 수행할 수 없습니다.");
                }
            }
            case 4 -> {
                if (employee instanceof ISales sales) {
                    double result = sales.reportSalesPerformance(12);
                    System.out.println("12월 영업 실적: " + result + "원");
                } else {
                    System.out.println("이 직원은 실적 관리 업무를 수행할 수 없습니다.");
                }
            }
            case 5 -> {
                if (employee instanceof ISales sales) {
                    int result = sales.developNewClients("IT");
                    System.out.println("신규 고객 개발: " + result + "개사");
                } else {
                    System.out.println("이 직원은 시장 조사 업무를 수행할 수 없습니다.");
                }
            }
            default -> System.out.println("잘못된 선택입니다.");
        }
    }
    
    /**
     * 마케팅팀 직원이 수행할 수 있는 업무 메뉴를 표시하고 실행합니다.
     * IMarketing 인터페이스를 구현한 직원만 전문 업무를 수행할 수 있습니다.
     * 
     * <p>제공되는 업무:
     * <ul>
     *   <li>일반 업무 (8시간)</li>
     *   <li>캠페인 기획</li>
     *   <li>시장 분석</li>
     *   <li>브랜드 인지도 조사</li>
     *   <li>고객 분석</li>
     * </ul>
     * 
     * @param employee 업무를 수행할 마케팅팀 직원
     */
    private static void showMarketingTasks(Employee employee) {
        System.out.println("마케팅팀 업무 목록:");
        System.out.println("1. 일반 업무 (8시간)");
        System.out.println("2. 캠페인 기획");
        System.out.println("3. 시장 분석");
        System.out.println("4. 브랜드 인지도 조사");
        System.out.println("5. 고객 분석");
        System.out.print("업무 선택: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1 -> employee.work(8);
            case 2 -> {
                if (employee instanceof IMarketing marketing) {
                    marketing.createCampaign("신제품 런칭", 10000000);
                } else {
                    System.out.println("이 직원은 캠페인 기획 업무를 수행할 수 없습니다.");
                }
            }
            case 3 -> {
                if (employee instanceof IMarketing marketing) {
                    marketing.analyzeMarketTrends("IT 업계");
                } else {
                    System.out.println("이 직원은 시장 분석 업무를 수행할 수 없습니다.");
                }
            }
            case 4 -> {
                if (employee instanceof IMarketing marketing) {
                    marketing.surveyBrandAwareness("우리 브랜드");
                } else {
                    System.out.println("이 직원은 브랜드 조사 업무를 수행할 수 없습니다.");
                }
            }
            case 5 -> {
                if (employee instanceof IMarketing marketing) {
                    marketing.performCustomerSegmentation();
                } else {
                    System.out.println("이 직원은 고객 분석 업무를 수행할 수 없습니다.");
                }
            }
            default -> System.out.println("잘못된 선택입니다.");
        }
    }
}