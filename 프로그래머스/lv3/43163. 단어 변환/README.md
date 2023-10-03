# [level 3] 단어 변환 - 43163 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43163) 

### 성능 요약

메모리: 75.7 MB, 시간: 2.98 ms

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p>두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.</p>
<div class="highlight"><pre class="codehilite"><code>1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
</code></pre></div>
<p>예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -&gt; "hot" -&gt; "dot" -&gt; "dog" -&gt; "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.</p>

<p>두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>각 단어는 알파벳 소문자로만 이루어져 있습니다.</li>
<li>각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.</li>
<li>words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.</li>
<li>begin과 target은 같지 않습니다.</li>
<li>변환할 수 없는 경우에는 0를 return 합니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>begin</th>
<th>target</th>
<th>words</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>"hit"</td>
<td>"cog"</td>
<td>["hot", "dot", "dog", "lot", "log", "cog"]</td>
<td>4</td>
</tr>
<tr>
<td>"hit"</td>
<td>"cog"</td>
<td>["hot", "dot", "dog", "lot", "log"]</td>
<td>0</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>예제 #1<br>
문제에 나온 예와 같습니다.</p>

<p>예제 #2<br>
target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

---

# 문제 풀이

## 문제 이해

목적 : `begin` → `target`으로 단어 변환 할 때, 최소 변환 횟수 구하기

단어 변환 규칙.

- `한 번에 한 개의 알파벳만 바꿀 수 있습니다.`
- `words에 있는 단어로만 변환할 수 있습니다.`

제한사항

- 각 단어는 알파벳 소문자
- 3 ≤ 각 단어의 길이 ≤ 10
- 두 단어의 길이는 같다.
- 3 ≤ words에 들어있는 단어의 개수 ≤ 50
- words에는 중복되는 단어는 들어있지 않다.
- begin ≠ target
- begin → target 으로 변환할 수 없는 경우는 0을 return

### 예제

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c256e108-fd9a-4c15-9548-7caa838d19b2/c8b9e16d-e147-4102-b992-361c8b622e68/Untitled.png)

---

## 문제 해결

### 1. 🤔 구상

문제의 분류가 BFS/DFS라고 명시되어 있다.  처음에는 DFS로 문제를 풀면 될 것 같았다. 그런데 찾아보니,

- DFS를 사용하면 좋은 경우
    - 한 정점과 연결된 모든 정점을 다 확인해봐야 할때.
    - 경로의 특징을 저장해야 할 때 (ex. 경로를 구할 때 같은 숫자를 지나오면 안된다.)
- BFS를 사용하면 좋은 경우
    - 정점에서 정점까지 가는 최단거리를 구해야 할 때.
    - DFS는 처음 발견한 경로가 최단거리라는 보장이 없는데 반해 BFS는 처음 발견한 경로가 곧 최단거리이다.

이 문제는 따라서 `BFS`로 푸는 것이 더 좋은 것 같다고 생각했다.

### 2. 🧐 검증 & 풀이

### 3. 😵‍💫 시행 착오

자바에서 `Pair`가 익숙치 않아서 어려웠다 ㅜ

## 코드 작성

### 코드 요약

- target이 포함되어있지 않으면 return
- 큐를 이용하여 풀이.

```java
import javafx.util.Pair;
import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.stream(words).anyMatch(target::equals)){
            return 0;
        }
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(begin, 0));
        
        while(!q.isEmpty()){
            var m = q.peek();
            q.poll();
            
            if (m.getKey().equals(target)) return m.getValue();
            
            for (String w : words){
                if(canChange(w, m.getKey())){
                    q.add(new Pair<>(w, m.getValue() + 1));
                }
            }
        }
        
        return 0;
    }
    
    
    public boolean canChange(String str1, String str2){
        int diffCnt = 0;
        for (int j = 0; j < str1.length(); j++){
            if (str1.charAt(j) != str2.charAt(j)){
                diffCnt++;
                if (diffCnt > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
```
