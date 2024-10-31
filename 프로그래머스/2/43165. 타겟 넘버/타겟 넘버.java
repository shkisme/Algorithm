class Solution {
    
    int A = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, 0, target);
        return A;
    }
    
    public void dfs(int sum, int[] numbers, int i, int target){
        if (i == numbers.length){
            if (sum == target) A++;
            return;
        }
        int number = numbers[i];
        dfs(sum + number, numbers, i + 1, target);
        dfs(sum - number, numbers, i + 1, target);
    }
}