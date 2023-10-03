# [level 2] 두 큐 합 같게 만들기 - 118667 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=java) 

### 성능 요약

메모리: 95.6 MB, 시간: 17.94 ms

### 구분

코딩테스트 연습 > 2022 KAKAO TECH INTERNSHIP

### 채점결과

Empty

### 문제 설명

<p>길이가 같은 두 개의 큐가 주어집니다. 하나의 큐를 골라 원소를 추출(pop)하고, 추출된 원소를 <strong>다른 큐</strong>에 집어넣는(insert) 작업을 통해 각 큐의 원소 합이 같도록 만들려고 합니다. 이때 필요한 작업의 최소 횟수를 구하고자 합니다. 한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행한 것으로 간주합니다.</p>

<p>큐는 먼저 집어넣은 원소가 먼저 나오는 구조입니다. 이 문제에서는 큐를 배열로 표현하며, 원소가 배열 앞쪽에 있을수록 먼저 집어넣은 원소임을 의미합니다. 즉, pop을 하면 배열의 첫 번째 원소가 추출되며, insert를 하면 배열의 끝에 원소가 추가됩니다. 예를 들어 큐 <code>[1, 2, 3, 4]</code>가 주어졌을 때, pop을 하면 맨 앞에 있는 원소 1이 추출되어 <code>[2, 3, 4]</code>가 되며, 이어서 5를 insert하면 <code>[2, 3, 4, 5]</code>가 됩니다.</p>

<p>다음은 두 큐를 나타내는 예시입니다.</p>
<div class="highlight"><pre class="codehilite"><code>queue1 = [3, 2, 7, 2]
queue2 = [4, 6, 5, 1]
</code></pre></div>
<p>두 큐에 담긴 모든 원소의 합은 30입니다. 따라서, 각 큐의 합을 15로 만들어야 합니다. 예를 들어, 다음과 같이 2가지 방법이 있습니다.</p>

<ol>
<li>queue2의 4, 6, 5를 순서대로 추출하여 queue1에 추가한 뒤, queue1의 3, 2, 7, 2를 순서대로 추출하여 queue2에 추가합니다. 그 결과 queue1은 [4, 6, 5], queue2는 [1, 3, 2, 7, 2]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 7번 수행합니다.</li>
<li>queue1에서 3을 추출하여 queue2에 추가합니다. 그리고 queue2에서 4를 추출하여 queue1에 추가합니다. 그 결과 queue1은 [2, 7, 2, 4], queue2는 [6, 5, 1, 3]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 2번만 수행하며, 이보다 적은 횟수로 목표를 달성할 수 없습니다.</li>
</ol>

<p>따라서 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수는 2입니다.</p>

<p>길이가 같은 두 개의 큐를 나타내는 정수 배열 <code>queue1</code>, <code>queue2</code>가 매개변수로 주어집니다. 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요. 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>queue1</code>의 길이 = <code>queue2</code>의 길이 ≤ 300,000</li>
<li>1 ≤ <code>queue1</code>의 원소, <code>queue2</code>의 원소 ≤ 10<sup>9</sup></li>
<li>주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>queue1</th>
<th>queue2</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[3, 2, 7, 2]</td>
<td>[4, 6, 5, 1]</td>
<td>2</td>
</tr>
<tr>
<td>[1, 2, 1, 2]</td>
<td>[1, 10, 1, 2]</td>
<td>7</td>
</tr>
<tr>
<td>[1, 1]</td>
<td>[1, 5]</td>
<td>-1</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>두 큐에 담긴 모든 원소의 합은 20입니다. 따라서, 각 큐의 합을 10으로 만들어야 합니다. queue2에서 1, 10을 순서대로 추출하여 queue1에 추가하고, queue1에서 1, 2, 1, 2와 1(queue2으로부터 받은 원소)을 순서대로 추출하여 queue2에 추가합니다. 그 결과 queue1은 [10], queue2는 [1, 2, 1, 2, 1, 2, 1]가 되며, 각 큐의 원소 합은 10으로 같습니다. 이때 작업 횟수는 7회이며, 이보다 적은 횟수로 목표를 달성하는 방법은 없습니다. 따라서 7를 return 합니다.</p>

<p><strong>입출력 예 #3</strong></p>

---

# 문제 풀이

## 문제 이해

숫자가 든 두개의 큐가 주어지고, 두 큐에 들어있는 수의 합이 서로 같아질 때 까지 수를 옮깁니다.

목적 : 수를 옮기는 횟수의 **최솟값**을 구합니다.

### 예제

```
queue1 = [3, 2, 7, 2]
queue2 = [4, 6, 5, 1]
```

> queue1에서 3을 추출하여 queue2에 추가합니다. 그리고 queue2에서 4를 추출하여 queue1에 추가합니다. 그 결과 queue1은 [2, 7, 2, 4], queue2는 [6, 5, 1, 3]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 **2번**만 수행하며, **이보다 적은 횟수로 목표를 달성할 수 없습니다.**
> 

---

## 문제 해결

### 1. 🤔 구상

큐를 활용하여 풀까 했는데, 배열에 수를 넣어서 투포인터 알고리즘을 적용하여 풀 수 있을 것 같았다.

> 큐는 값 순회가 되지 않으니, 배열을 택했는데 생각해보니 서로의 합이 같은지를 확인하는 것이기 때문에, 큐를 사용하여 풀면 더 깔끔할 것 같다.
> 

### 2. 🧐 검증 & 풀이

투포인터 알고리즘을 적용했다.

![image](https://github.com/shkisme/Algorithm/assets/92802207/403c2b7f-d502-4a94-afd1-f523a0de4cb0)

1. 위 처럼 배열 두개에 두 큐의 수들을 나란히 두고, 두개의 포인터를 두었다. (시작값, 끝값)
2. 어떻게 하면 옮기는 횟수를 최소로 할 수 있을 지에 대한 고민을 했는데, 현재의 sum이 더 큰 배열의 값을 다른 쪽으로 옮기면 될 것이다.
3. 두 sum이 같아질 때 까지, 혹은 sum이 같아지지 않을 때 까지 2번 과정을 반복한다.

### 3. ✅ Test Case (반례)

- sum의 타입을 long으로 지정했더니 시간초과를 해결했다.
- while문의 반복 횟수를 더 늘려주니, 테스트 케이스 1번을 해결했다.
    - 좀 더 엄밀하게 풀어야 할 지도…

## 코드 작성

```java
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        int[] arr1 = new int[2 * len + 1];
        int[] arr2 = new int[2 * len + 1];
        
        for (int i= 0; i < len; i++){
            arr1[i] = queue1[i];
            arr2[i] = queue2[i];
        }
        for (int i= 0; i < len; i++){
            arr1[i + len] = queue2[i];
            arr2[i + len] = queue1[i];
        }
        
        int s1 = 0, s2 = 0, e1 = len - 1, e2 = len - 1;
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        int cnt = 0;
        int last = 2 * len - 1;
        
        while(sum1 != sum2){
            if (cnt > (Math.abs(s1 - e1) + Math.abs(s2 - e2)) * 3) {
                return -1;
            }
            if (sum1 > sum2){
                sum1 -= arr1[s1];
                s1 = (s1 == last) ? 0 : s1 + 1;
                e2 = (e2 == last) ? 0 : e2 + 1;
                sum2 += arr2[e2];
                cnt++;
            }
            else if (sum1 < sum2){
                sum2 -= arr2[s2];
                s2 = (s2 == last) ? 0 : s2 + 1;
                e1 = (e1 == last) ? 0 : e1 + 1;
                sum1 += arr1[e1];
                cnt++;
            }
        }
        if (sum1 == sum2){
            return cnt;
        }
        return -1;
    }
}
```

<p>어떤 방법을 쓰더라도 각 큐의 원소 합을 같게 만들 수 없습니다. 따라서 -1을 return 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
