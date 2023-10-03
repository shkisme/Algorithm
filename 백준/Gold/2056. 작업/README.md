# [Gold IV] 작업 - 2056 

[문제 링크](https://www.acmicpc.net/problem/2056) 

### 성능 요약

메모리: 316328 KB, 시간: 1588 ms

### 분류

다이나믹 프로그래밍, 그래프 이론, 위상 정렬

### 문제 설명

<p>수행해야 할 작업 N개 (3 ≤ N ≤ 10000)가 있다. 각각의 작업마다 걸리는 시간(1 ≤ 시간 ≤ 100)이 정수로 주어진다.</p>

<p>몇몇 작업들 사이에는 선행 관계라는 게 있어서, 어떤 작업을 수행하기 위해 반드시 먼저 완료되어야 할 작업들이 있다. 이 작업들은 번호가 아주 예쁘게 매겨져 있어서, K번 작업에 대해 선행 관계에 있는(즉, K번 작업을 시작하기 전에 반드시 먼저 완료되어야 하는) 작업들의 번호는 모두 1 이상 (K-1) 이하이다. 작업들 중에는, 그것에 대해 선행 관계에 있는 작업이 하나도 없는 작업이 반드시 하나 이상 존재한다. (1번 작업이 항상 그러하다)</p>

<p>모든 작업을 완료하기 위해 필요한 최소 시간을 구하여라. 물론, 서로 선행 관계가 없는 작업들은 동시에 수행 가능하다.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다.</p>

<p>두 번째 줄부터 N+1번째 줄까지 N개의 줄이 주어진다. 2번째 줄은 1번 작업, 3번째 줄은 2번 작업, ..., N+1번째 줄은 N번 작업을 각각 나타낸다. 각 줄의 처음에는, 해당 작업에 걸리는 시간이 먼저 주어지고, 그 다음에 그 작업에 대해 선행 관계에 있는 작업들의 개수(0 ≤ 개수 ≤ 100)가 주어진다. 그리고 선행 관계에 있는 작업들의 번호가 주어진다.</p>

### 출력 

 <p>첫째 줄에 모든 작업을 완료하기 위한 최소 시간을 출력한다.</p>

---

# 문제 풀이

## 문제 이해

- 수행해야 할 작업 N개 (3 ≤ N ≤ 10000)는 작업마다 **걸리는 시간(1 ≤ 시간 ≤ 100)**이 있다.
- 어떤 작업을 수행하기 위해 반드시 먼저 완료되어야 할 작업들이 있다.
    - K번 작업을 시작하기 전에 반드시 먼저 완료되어야 하는 작업들의 번호는 모두 1 이상 (K-1) 이하.
- 작업들 중에는, 그것에 대해 선행 관계에 있는 작업이 하나도 없는 작업이 **반드시 하나 이상 존재한다.**
    - 1번 작업이 항상 그러하다
- 서로 선행 관계가 없는 작업들은 동시에 수행 가능하다.
- 모든 작업을 완료하기 위해 필요한 **최소 시간**을 구하여라.

### 예제

```
7
5 0
1 1 1
3 1 2
6 1 1
1 2 2 4
8 2 2 4
4 3 3 5 6
```

## 입출력

### 입력

- 첫째 줄에 N.
- 2번째 줄은 1번 작업, 3번째 줄은 2번 작업, ..., N+1번째 줄은 N번 작업을 각각 나타낸다.
    - 각 줄의 처음에는, 해당 작업에 걸리는 시간이 먼저 주어짐.
        - ex) 5번 작업은 1시간 소요
    - 그 다음에 그 작업에 대해 선행 관계에 있는 작업들의 개수(0 ≤ 개수 ≤ 100)가 주어진다.
        - ex) 5번 작업보다 선행해야 하는 작업은 2개
    - 그리고 선행 관계에 있는 작업들의 번호가 주어진다.
        - ex) 2번, 4번 작업

### 출력

모든 작업을 완료하기 위한 최소 시간을 출력한다.

---

## 문제 해결

### 1. 🤔 구상

- 위상 정렬?

위상 정렬의 개념이 기억이 나지 않아서 유튜브 강의와 블로그 글을 많이 참고했다.

https://www.youtube.com/watch?v=qzfeVeajuyc&t=635s

### 2. 🧐 검증 & 풀이

- 진입 차수 & 시간 & 연결된 노드들을 배열에 저장한다.
- 진입 차수가 0인 노드들을 큐에 넣는다.
- 큐에서 노드를 빼고, 해당 노드에 연결되어 있는 노드들과 비교하여, cost를 찾는다.
    - cost[next] = Math.*max*(cost[current] + times[next], cost[next]);
    - 점화식이 위와 같은 이유는, 특정 작업은 선행 작업이 끝나야만 다음 작업을 수행할 수 있기 때문에 결국에는 더 큰 값을 찾아야 하기 때문이다.
- cost를 비교했다면, 해당 노드의 진입 차수를 1 감소시킨다.
- 다시 진입 차수가 0인 노드를 큐에 넣는다.
- 이를 큐가 빌 때 까지 반복한다.
- 마지막의 cost 배열에는 각 작업이 끝난 시간이 남게 되는데, 이중 max 값을 구하면 그것이 모든 작업을 끝낸 시간이 된다.

## 코드 작성

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    ArrayList<Integer>[] list = new ArrayList[n + 1]; // 연결된 노드 저장소
    int[] indegree = new int[n + 1]; // 진입차수
    int[] times = new int[n + 1]; // 시간
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
      times[i] = scan.nextInt();
      indegree[i] = scan.nextInt();

      for (int j = 0; j < indegree[i]; j++) {
        list[scan.nextInt()].add(i);
      }
    }

    int[] cost = new int[n + 1];
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (indegree[i] == 0) { // 진입차수가 0인 것들을 넣음.
        queue.offer(i);
        cost[i] = times[i];
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();

      for (int i = 0; i < list[current].size(); i++) {
        int next = list[current].get(i);
        cost[next] = Math.max(cost[current] + times[next], cost[next]);
        // 사전의 작업이 모두 수행되어야 하므로 max 값을 구함.
        indegree[next]--;
        if (indegree[next] == 0) {
          queue.offer(next);
        }
      }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) {
      ans = Math.max(ans, cost[i]);
    }
    System.out.println(ans);
  }
}
```
