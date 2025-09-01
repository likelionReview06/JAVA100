import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 계정 생성
        HashMap<String, User> userAccounts = new HashMap<>();
        userAccounts.put("사장", new User("사장", "1234"));
        userAccounts.put("알바1", new User("알바1", "5678"));
        userAccounts.put("알바2", new User("알바2", "91011"));

        // 사용자 입력 (로그인)
        System.out.println("사용자를 입력하시오. (사장, 알바1, 알바2)");
        String username = scanner.nextLine();

        if (!userAccounts.containsKey(username)) {
            System.out.println("잘못된 사용자명입니다. 프로그램을 종료합니다.");
            scanner.close();
            return;
        }

        User currentUser = userAccounts.get(username);
        StoreManager manager = currentUser.getStoreManager();

        System.out.printf("환영합니다, %s님. 매장 운영을 시작합니다.\n", currentUser.getUsername());

        // 테이블 준비 (2개로 변경)
        for (int i = 1; i <= 2; i++) {
            manager.addTable(i);
        }

        // 테이블별 주문 시뮬레이션 (2개 테이블)
        for (int i = 1; i <= 2; i++) {
            System.out.printf("\n--- 테이블 %d 주문 받기 ---\n", i);   //테이블 2개중 하나 주문받기
            Table currentTable = manager.getTable(i);

            // 메뉴판 표시
            System.out.println("메뉴를 입력하시오. (종료: q)");
            manager.printMenu();

            // 메뉴 입력
            for (int j = 0; j < 3; j++) {
                System.out.printf("메뉴 %d 입력 (종료: q): ", j + 1);
                String menuName = scanner.nextLine();
                if (menuName.equals("q")) {
                    break;
                }
                MenuItem item = manager.getMenuItem(menuName);
                if (item != null) {
                    currentTable.addOrder(item);
                } else {
                    System.out.println("잘못된 메뉴명입니다. 다시 입력해주세요.");
                    j--;
                }
            }

            // 테이블 번호 자동 지정 및 주문 확인
            System.out.printf("앉을 테이블 번호 입력: %d번으로 자동 지정됩니다.\n", i);
            System.out.printf("테이블 %d번에 다음 주문이 들어갔습니다.\n", i);
            currentTable.printOrderSummary();

            // 결제 및 입금 처리
            manager.deposit(currentTable.getTotalAmount(),
                    String.format("테이블 %d 결제 (%s)", i, currentUser.getUsername()));
        }

        // 영업 종료 및 정산
        System.out.println("\n----------------------------------");
        System.out.println("잠시 후 영업을 종료합니다.");
        System.out.println("----------------------------------");

        int totalProfit = manager.getTotalAsset();

        System.out.println("\n--- 오늘의 최종 정산 ---");
        manager.endOfDaySummary();
        System.out.printf("사용자: %s, %d원 벌었습니다.\n", currentUser.getUsername(), totalProfit);

        scanner.close();
    }
}