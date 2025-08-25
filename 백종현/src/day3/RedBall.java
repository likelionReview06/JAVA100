package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RedBall {
    static int N, M;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, count;

        State(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        // 보드 입력 및 초기 구슬 위치 찾기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        queue.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 10번 초과시 실패
            if (current.count >= 10) {
                continue;
            }

            // 4방향으로 기울이기
            for (int dir = 0; dir < 4; dir++) {
                // 구슬 이동 시뮬레이션
                int[] redResult = move(current.rx, current.ry, dir);
                int[] blueResult = move(current.bx, current.by, dir);

                int newRx = redResult[0], newRy = redResult[1];
                int newBx = blueResult[0], newBy = blueResult[1];

                // 파란 구슬이 구멍에 빠지면 실패
                if (board[newBx][newBy] == 'O') {
                    continue;
                }

                // 빨간 구슬이 구멍에 빠지면 성공
                if (board[newRx][newRy] == 'O') {
                    return current.count + 1;
                }

                // 두 구슬이 같은 위치에 있으면 위치 조정
                if (newRx == newBx && newRy == newBy) {
                    adjustPosition(redResult, blueResult, dir);
                    newRx = redResult[0]; newRy = redResult[1];
                    newBx = blueResult[0]; newBy = blueResult[1];
                }

                // 이미 방문한 상태가 아니면 큐에 추가
                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.offer(new State(newRx, newRy, newBx, newBy, current.count + 1));
                }
            }
        }

        return -1;
    }

    // 구슬을 해당 방향으로 끝까지 이동
    static int[] move(int x, int y, int dir) {
        int moveCount = 0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (board[nx][ny] == '#') break;

            x = nx;
            y = ny;
            moveCount++;

            if (board[x][y] == 'O') break;
        }

        return new int[]{x, y, moveCount};
    }

    // 두 구슬이 같은 위치에 있을 때 위치 조정
    static void adjustPosition(int[] red, int[] blue, int dir) {
        // 더 많이 움직인 구슬이 더 앞쪽에 있었다는 의미
        // 따라서 더 적게 움직인 구슬을 한 칸 뒤로
        if (red[2] > blue[2]) {
            // 빨간 구슬이 더 많이 움직임 -> 파란 구슬을 한 칸 뒤로
            blue[0] -= dx[dir];
            blue[1] -= dy[dir];
        } else {
            // 파란 구슬이 더 많이 움직임 -> 빨간 구슬을 한 칸 뒤로
            red[0] -= dx[dir];
            red[1] -= dy[dir];
        }
    }
}
