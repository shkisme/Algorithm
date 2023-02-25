package 이코테;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 자료구조예제 {

  public static void main(String[] args) throws IOException {
    // 스택 예제
    Stack<Integer> s = new Stack<>();
    s.push(5);
    s.pop();

    while (!s.empty()) {
      System.out.println(s.peek()); // top 이 아니라 peek 임!
      s.pop();
    }

    // 큐 예제
    Queue<Integer> q = new LinkedList<>();
    q.offer(5); // push
    q.poll(); // pop
    while (!q.isEmpty()) {
      System.out.println(q.poll()); // 반환 값이 있는 pop
    }

    // 무한히 반복되는 재귀함수 예제
    recursiveFunction();

    // 재귀 함수 종료조건 예제
    recursiveFunction_end(1);

    // 2 가지 방식으로 구현한 팩토리얼 예제
    factorialIterative(5);
    factorialRecursive(5);

    // 인접 행렬 예제
    final int INF = 999999999; // 연결되어 있지 않은 노드끼리는 무한의 비용이라고 작성하기.
    // 정답이 될 수 없는 큰 값으로 보통 선언한다.

    int[][] graph = {
        {0, 7, 5},
        {7, 0, INF},
        {5, INF, 0}
    };

    // 인접 리스트 예제
    ArrayList<ArrayList<Node>> graph2 = new ArrayList<>(); // 행이 3개인 인접 리스트 표현

    for (int i = 0; i < 3; ++i) { // 그래프 초기화
      graph2.add(new ArrayList<>());
    }

    graph2.get(0).add(new Node(1, 7)); // 노트 0에 연결된 노드 정보 저장(노트,거리)
    graph2.get(0).add(new Node(2, 5));

    graph2.get(1).add(new Node(0, 7));
    graph2.get(2).add(new Node(0, 5));
  }

  public static class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    public void show() {
      System.out.println("(" + this.index + ", " + this.distance + ")");
    }
  }

  private static int factorialRecursive(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * factorialRecursive(n - 1);
  }

  private static int factorialIterative(int n) {
    int result = 1;
    for (int i = 1; i <= n; ++i) {
      result *= i;
    }
    return result;
  }

  private static void recursiveFunction_end(int i) {
    if (i == 100) {
      return;
    }
    System.out.println(i + "번째 재귀함수에서 " + (i + 1) + "번째 재귀함수를 호출함");
    recursiveFunction_end(i + 1);
    System.out.println(i + "번째 재귀함수를 종료함");
  }

  private static void recursiveFunction() {
    System.out.println("재귀재귀");
    recursiveFunction();
  }
}
