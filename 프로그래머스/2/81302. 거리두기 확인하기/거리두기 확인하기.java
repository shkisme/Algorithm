class Solution {
    
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        
        for (int i = 0; i < places.length; i++){ // places
            for (int j = 0; j < places.length; j++){ // place, x좌표
                String[] place = places[i];
                if (!isValidatePlace(place, j)){
                    answer[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    
    public boolean isValidatePlace(String[] place, int x){
        String str = place[x];
        for (int k = 0; k < str.length(); k++){ // 문자열 1개, y좌표
            if (str.charAt(k) == 'P'){
                if(!isValidate(place, x, k, -1)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValidate(String[] place, int x, int y, int pass){
        int[][] arr = {
            {x + 1, y}, // 위 0
            {x - 1, y}, // 아래 1
            {x, y + 1}, // 오른 2
            {x, y - 1} // 왼 3
        };
        
        for (int i = 0; i < arr.length; i++){
            if (i == pass) continue;
            int nx = arr[i][0], ny = arr[i][1];
            if (nx < 0 || ny < 0 || 4 < nx || 4 < ny) continue;
            if (place[nx].charAt(ny) == 'P') return false;
            if (pass != -1) continue;
            if (place[nx].charAt(ny) == 'O'){
                int p = 0;
                if (i == 0) p = 1;
                if (i == 1) p = 0;
                if (i == 2) p = 3;
                if (i == 3) p = 2;
                if (!isValidate(place, nx, ny, p)){
                    return false;
                }
            }
        }
        return true;
    }
}