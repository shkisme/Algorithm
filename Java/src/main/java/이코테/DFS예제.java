package 이코테;

import java.util.ArrayList;

public class DFS예제 {

  public static boolean[] visited = new boolean[9];

  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) {

    // 그래프를 초기화해봅시다.
    for (int i = 0; i < 9; ++i) {
      graph.add(new ArrayList<>()); // 빈 어레이를 넣어봅시다
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

    dfs(1); // 노드 1부터 dfs 방식으로 방문을 해 봅시다.
  }

  private static void dfs(int x) {
    visited[x] = true; // 방문 처리를 합시다. 그나저나 visited 배열은 설정해주지 않아도 default 값이 false 겠군요.
    System.out.println("x = " + x); // 눈으로 보게 해 줍시다.

    for (int i = 0; i < graph.get(x).size(); ++i) { // 요 아이의 자식들을 순회합니다.
      int y = graph.get(x).get(i); // 자식을 하나 꺼내보죠
      if (visited[y] == false) { // 자식을 아직 방문하지 않았다면
        dfs(y); // 방문을 합니다. 재귀재귀
      }
    }
  }

}
