class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int delivery = 0;
        int pickup = 0;
        for (int i = n - 1; i >= 0; i--){ // 가장 먼 곳에서부터 배달, 수거하는 것이 최선의 선택 (그리디)
            delivery -= deliveries[i];
            pickup -= pickups[i];

            int tmp = 0;
            while(delivery < 0 || pickup < 0){
                delivery += cap; // ex. delivery - 5 , cap - 3
                pickup += cap;

                tmp += i + 1;
            }
            answer += tmp * 2;
        }
        return answer;
    }
}