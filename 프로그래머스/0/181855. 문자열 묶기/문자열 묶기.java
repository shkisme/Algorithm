class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] arr = new int[100_001];
        int max = Integer.MIN_VALUE;
        for (String s : strArr){
            arr[s.length()]++;
            if (max < arr[s.length()]) max = arr[s.length()];
        }
        return max;
    }
}