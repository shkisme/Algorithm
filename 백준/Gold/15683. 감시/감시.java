import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] board1 = new int[10][10];
    static int[][] board2 = new int[10][10];
    static List<Pair> cctv = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String[] read = br.readLine().split(" ");
        n = Integer.parseInt(read[0]);
        m = Integer.parseInt(read[1]);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            read = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board1[i][j] = Integer.parseInt(read[j]);
                if (board1[i][j] != 0 && board1[i][j] != 6) {
                    cctv.add(new Pair(i, j));
                }
                if (board1[i][j] == 0) {
                    answer++;
                }
            }
        }

        // 1 << (2 * cctv.size()) -> 4 ^ cctv.size()
        // tmp를 4진법으로 뒀을 때 각 자리수를 cctv의 방향으로 생각할 것이다.
        for (int tmp = 0; tmp < (1 << (2 * cctv.size())); tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board1[i][j]; // TODO: 이거 왜 복사함? -> 기존의 배열 값을 다시 불러오려고.
                }
            }
            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4; // 0, 1, 2, 3
                brute /= 4;
                int x = cctv.get(i).x;
                int y = cctv.get(i).y;
                if (board1[x][y] == 1) {
                    upd(x, y, dir);
                } else if (board1[x][y] == 2) {
                    upd(x, y, dir);
                    upd(x, y, dir + 2);
                } else if (board1[x][y] == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                } else if (board1[x][y] == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                } else if (board1[x][y] == 5) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }

            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board2[i][j] == 0) {
                        val++;
                    }
                }
            }
            answer = Math.min(answer, val);
        }

        bw.write(answer + "");
        bw.flush();
    }

    private static void upd(int x, int y, int dir) {
        dir %= 4; // TODO : 이거 왜 나머지 구함? -> 편하게 계산하기 위해서. 예를 들어 기존 방향이 4라서 4 + 2 = 6, dir이 6으로 주어져도 괜찮게끔.
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (x < 0 || y < 0 || x >= n || y >= m || board2[x][y] == 6) { // 범위 벗어났거나 벽일경우 탈출
                return;
            }
            if (board2[x][y] != 0) { // CCTV 만나면 넘어감.
                continue;
            }
            board2[x][y] = 7; // TODO : 왜 7? 그냥 남은 숫자가 7이라서? -> yes
        }
    }
}
