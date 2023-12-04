class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = getCount(h2, m2, s2) - getCount(h1, m1, s1);
        if ((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0) {
            answer += 1; // 0시와 12시인 경우에만 예외적으로 1을 더해줌
        }
        return answer;
    }
    
    // 0시 0분 0초부터 h:m:s까지 겹치는 횟수
    int getCount(int h, int m, int s) {
        double hour = ((h * 30 + m * 0.5 + s * 0.5 / 60) % 360);
        double minute = ((m * 6 + s * 0.1) % 360);
        double second = s * 6;

        int ret = -1; // 0시 0분 0초는 분에 한 번이므로 -1로 시작

        // 마지막 초의 상태를 계산
        if (second >= minute) {
            ret += 1;
        }
        if (second >= hour) {
            ret += 1;
        }

        ret += (h * 60 + m) * 2; // 분당 2번씩 만난다고 계산
        ret -= h; // 59분 -> 0분일 때는 분침과 만나지 않음
        if (h >= 12) {
            ret -= 2; // 11시59분59초 -> 12시인 경우 분, 초침과 만나지 않고 12시에 2번이 아닌 1번만 만나는 것으로 처리
        }
        return ret;
    }
}