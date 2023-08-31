package 이코테.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS예제 {

  public static boolean[] visited = new boolean[9];

  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) {
    // 그래프를 초기화 해 봅시다. 빈 어레이리스트를 넣어줘요
    for (int i = 0; i < 9; ++i) {
      graph.add(new ArrayList<>());
    }

    graph.get(1).add(2); // 노드 1에 연결된 노드의 정보를 저장함니다
    graph.get(1).add(3);
    graph.get(1).add(8); // 노드 1은 2,3,8과 연결되어 있군요.

    graph.get(2).add(1);
    graph.get(2).add(7);

    graph.get(3).add(1);
    graph.get(3).add(4);
    graph.get(3).add(5);

    graph.get(4).add(3);
    graph.get(4).add(5);

    graph.get(5).add(3);
    graph.get(5).add(4);

    graph.get(6).add(7);

    graph.get(7).add(2);
    graph.get(7).add(6);
    graph.get(7).add(8);

    graph.get(8).add(1);
    graph.get(8).add(7); // 많이도 연결되어 있군요.

    bfs(1); // 이번에는 bfs 방식으로 방문을 해 봅시다.
  }

  private static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>(); // 큐를 하나 만들어 주네요.
    q.offer(start); // 시작하는 아이를 큐에 넣어줍니다.

    visited[start] = true; // 방문 처리도 잊지 맙시다

    while(q.isEmpty() == false) { // q에 값이 없을때까지, 반복해요. !q.isEmpty()로 적으면 간결합니다.
      int x = q.poll(); // 큐의 최상단 값을 꺼내요. q.poll 은 값을 꺼냄과 동시에 어떤 값인지 반환도 해줍니다.
      System.out.println("x = " + x); // 꺼내온 값을 눈에 보이게 해줍시다.

      for (int i = 0; i < graph.get(x).size(); ++i) { // 요 아이의 자식들을 순회합시다
        int y = graph.get(x).get(i); // 자식 하나를 꺼냈네요
        if (visited[y] == false) { // 꺼내온 자식이 방문하지 않은 자식이라면
          q.offer(y); // 큐에 넣어줍니다. 다음 번에는 요 아이의 자식들을 검사할 예정입니다. (DFS 와 달리 자식 검사를 미루고 있죠. 형제들을 먼저 방문하기 때문입니다)
          visited[y] = true; // 방문했다고 표시하는걸 잊지 마세요!
        }
      }
    }
  }

}
