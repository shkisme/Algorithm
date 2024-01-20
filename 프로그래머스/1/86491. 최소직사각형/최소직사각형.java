class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int n = sizes.length;
        int max = Integer.MIN_VALUE;
        
        int index = 0;
        
        for (int[] size : sizes){
            for (int i = 0; i < 2; i++){
                if (max < size[i]) {
                    max = size[i];
                    index = i;
                }
            }
        }
        
        for (int i = 0; i < sizes.length; i++){
            int t1 = sizes[i][Math.abs(index)];
            int t2 = sizes[i][Math.abs(1 - index)];
            
            if (t1 < t2){
                int tmp = sizes[i][Math.abs(index)];
                sizes[i][Math.abs(index)] = sizes[i][Math.abs(1 - index)];
                sizes[i][Math.abs(1 - index)] = tmp;
            }
        }
        
        int other = Integer.MIN_VALUE;
        
        for (int i = 0; i < sizes.length; i++){
            int t2 = sizes[i][Math.abs(1 - index)];
            if (other < t2) other = t2;
        }
        
        return max * other;
    }
}