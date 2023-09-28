class Solution {
    public boolean solution(int x) {
        int saveX = x;
        
        int sum = 0;
        while(x > 0){
            int num = x % 10;
            sum += num;
            x /= 10;
        }
        
        if(saveX % sum == 0){
            return true;
        }
        return false;
    }
}