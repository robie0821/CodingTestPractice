class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];
        
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if (board[i - 1][j - 1] != 0) {
                    map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1])) + 1;
                    answer = Math.max(answer, map[i][j]);
                }   
            }
        }
        
        return (int) Math.pow(answer, 2);
    }
}