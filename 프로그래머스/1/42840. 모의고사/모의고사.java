import java.util.*;

class Solution {
    public int[] solution(int[] answers) {        
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        
        int sum1 = 0, sum2 = 0, sum3 = 0;
        
        for (int i = 0; i < answers.length; i++){
            int val = answers[i];
            
            if (val == arr1[i % 5]) sum1++;
            if (val == arr2[i % 8]) sum2++;
            if (val == arr3[i % 10]) sum3++;
        }
        
        // System.out.println(sum1);
        // System.out.println(sum2);
        // System.out.println(sum3);
        
        int m = Math.max(sum1, sum2);
        m = Math.max(m, sum3);
        
        int cnt = 0;
        
        if (m == sum1) cnt++;
        if (m == sum2) cnt++;
        if (m == sum3) cnt++;
        
        if (cnt == 3) return new int[]{1,2,3};
        if (cnt == 2){
            if (m == sum1 && m == sum2){
                return new int[]{1,2};
            } else if (m == sum2 && m == sum3){
                return new int[]{2,3};
            } else{
                return new int[]{1,3};
            }
        }
        
        if (m == sum1) return new int[]{1};
        else if (m == sum2) return new int[]{2};
        return new int[]{3};
    }
}