# [level 2] 삼각 달팽이 - 68645 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/68645) 

### 성능 요약

메모리: 171 MB, 시간: 34.16 ms

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p>정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e1e53b93-dcdf-446f-b47f-e8ec1292a5e0/examples.png" title="" alt="examples.png"></p>

<hr>

<h5>제한사항</h5>

<ul>
<li>n은 1 이상 1,000 이하입니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>4</td>
<td><code>[1,2,9,3,10,8,4,5,6,7]</code></td>
</tr>
<tr>
<td>5</td>
<td><code>[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]</code></td>
</tr>
<tr>
<td>6</td>
<td><code>[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]</code></td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>문제 예시와 같습니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>문제 예시와 같습니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>문제 예시와 같습니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

---

# 문제 풀이

## 문제 이해

![image](https://github.com/shkisme/Algorithm/assets/92802207/fed5bbac-b458-4a36-9b65-af84512ac85d)


목적 : n에 따라 생성되는 도형의 수를 순서대로 출력하기. 수는 달팽이 처럼 반시계 방향 삼각형을 그리며 채워지는 규칙이 있다.

---

## 문제 해결

### 1. 🤔 구상

문제를 읽자 마자 **구현 문제**라는 느낌이 왔다. 규칙을 찾아서 2차원 배열에 값을 채워넣고, 출력하면 되겠다는 생각이 들었다.

### 2. 🧐 검증 & 풀이

![image](https://github.com/shkisme/Algorithm/assets/92802207/e1d44679-b1cf-41c1-80ba-7823ec1c1cc8)

2차원 배열로 수들을 옮긴 그림이다. 그림을 다듬을 여유가 없다 🥲

특정 형태가 반복된다는 것을 알 수 있다. ⬇️ ➡️ ⬆️ 이다.(이때, 마지막 ⬆️ 의 길이가 다른 두 방향에 비해서 한칸 작다.) 따라서 함수로 만들 생각을 했다.

값을 채워나갈 시작점과, 값을 채우는 폭 등등을 구하여 함수를 돌리면 될 것 같다.

## 코드 작성

### 코드 요약

- endPoint (마지막 값), 2차원 배열 arr, depth(값 채울 폭), curr(채울 현재 값), x, y좌표 등을 세팅해준다.
- fill() 함수를 돌린 후 x, y, depth를 문제 조건에 맞게 갱신해준다.
    - 한번 돌았다면 x좌표는 한칸 +, y좌표는 두칸 +, depth는 3- 되어 다시 돈다.
- fill() 함수에서 curr 값이 endPoint보다 크다면, 값 채워넣기가 끝난 것이므로 해당 처리 해준다.
- 마지막에 arr에 남은 값들 중, 0이 아닌 숫자만을 출력한다.

```java
import java.util.*;

class Solution {
    static int endPoint;
    static int[][] arr;
    static int curr = 1;
    static int x = 0, y = 0;
    
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        endPoint = n * (n + 1) / 2;
        arr = new int[n][n];
        int depth = n;
        
        while(true){
            if (fill(depth) == true){
                break;
            }
            x += 1;
            y += 2;
            depth -= 3;
        }
        
        for (int[] a : arr){
            for (int i : a){
                if (i != 0){
                    list.add(i);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public boolean fill(int depth){
        int currX = 0, currY = 0;
        
        for (int i = y; i < depth + y; i++){
            arr[i][x] = curr++;
            if (curr > endPoint) return true;
            currY = i; // 변경된 Y값 저장
        }
        for (int i = x + 1; i < depth + x; i++){
            arr[currY][i] = curr++;
            if (curr > endPoint) return true;
            currX = i; // 변경된 X값 저장
        }
        for (int i = currY - 1; i > y; i--){
            arr[i][currX] = curr++;
            if (curr > endPoint) return true;
        }
        return false;
    }
}
```
