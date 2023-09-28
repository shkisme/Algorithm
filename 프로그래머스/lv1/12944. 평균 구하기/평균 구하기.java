import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = Arrays.stream(arr).sum();
        return (double) sum / arr.length;
    }
}