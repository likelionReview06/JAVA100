package day6;

import java.util.LinkedList;
import java.util.Queue;

public class GameDFS {
    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist; //거리
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;       // 행
        int m = maps[0].length;    // 열

        // 방문 체크
        boolean[][] visited = new boolean[n][m];

        // 상하좌우 이동
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            // 도착 지점 도달
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위 안 && 길 있음 && 방문 안함
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, cur.dist + 1));
                    }
                }
            }
        }

        // 도착 불가능
        return -1;
    }

    public static void main(String[] args) {
        GameDFS sol = new GameDFS();

        int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        System.out.println("테스트 1 결과: " + sol.solution(maps1)); // 예상: 11
        System.out.println("테스트 2 결과: " + sol.solution(maps2)); // 예상: -1
    }
}
