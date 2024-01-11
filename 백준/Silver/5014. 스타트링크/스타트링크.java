import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int now, cnt;

    public Node(int now, int cnt) {
        this.now = now;
        this.cnt = cnt;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws Exception {
        String[] read = br.readLine().split(" ");

        int F = Integer.parseInt(read[0]); // 건물 층수
        int S = Integer.parseInt(read[1]); // 현재 위치
        int G = Integer.parseInt(read[2]); // 목적지 위치
        int U = Integer.parseInt(read[3]); // 한번 누를 때 위로 올라가는 층 수
        int D = Integer.parseInt(read[4]); // 한번 누를 때 아래로 내려가는 층 수

        if (S == G) {
            bw.write("0");
            bw.flush();
            return;
        }

        boolean[] visit = new boolean[F + 1];
        Queue<Node> queue = new LinkedList<>();

        int answer = -1;
        queue.offer(new Node(S, 0));
        visit[S] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            int up = poll.now + U;
            int down = poll.now - D;
            if (up == G || down == G) {
                answer = poll.cnt + 1;
                break;
            }
            if (up <= F && !visit[up]) {
                queue.offer(new Node(up, poll.cnt + 1));
                visit[up] = true;
            }
            if (down >= 1 && !visit[down]) {
                queue.offer(new Node(down, poll.cnt + 1));
                visit[down] = true;
            }
        }

        if (answer == -1) {
            bw.write("use the stairs");
            bw.flush();
            return;
        }
        bw.write(answer + "");
        bw.flush();
    }
}
