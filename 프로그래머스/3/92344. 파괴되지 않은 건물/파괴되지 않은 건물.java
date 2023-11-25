class Solution {
    public int solution(int[][] board, int[][] skills) {
        int 높이 = board.length;
        int 너비 = board[0].length;
        int[][] 누적합 = new int[높이 + 1][너비 + 1]; // 편의성을 위해서 1칸 추가 (out of index 방지)
        
        int answer = 0;
        for (int[] skill : skills){ // skill은 길이 6 고정
            int y1 = skill[1], x1 = skill[2];
            int y2 = skill[3], x2 = skill[4];
            int degree = skill[5];
            if (skill[0] == 1){
                degree = skill[5] * -1;
            }
            
            누적합[y1][x1] += degree;
            누적합[y1][x2 + 1] -= degree;
            누적합[y2 + 1][x1] -= degree;
            누적합[y2 + 1][x2 + 1] += degree;
        }
        
        // 상하 방향 합산 시작
        for (int y = 1; y < 높이; y ++){ // 합산이므로, 제일 처음은 건너뛴다.
            for (int x = 0; x < 너비; x ++){
                누적합[y][x] += 누적합[y-1][x];
            }
        }
        
        // 좌우 방향 합산 시작
        for (int x = 1; x < 너비; x++){ // 합산이므로, 제일 처음은 건너뛴다.
            for (int y = 0; y < 높이; y++){
                누적합[y][x] += 누적합[y][x-1];
            }
        }
        
        // 최종 결과 도출
        for (int y = 0; y < 높이; y++){
            for (int x = 0; x < 너비; x++){
                board[y][x] += 누적합[y][x];
                if (0 < board[y][x]) answer++;
            }
        }
        
        return answer;
    }
}