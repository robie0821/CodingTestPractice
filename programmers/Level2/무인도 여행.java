import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    static char[][] map;
    static boolean[][] visit;
    
    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (visit[i][j] == false && map[i][j] != 'X') {
                    arr.add(checkSum(i, j));
                }
            }
        }
        
        int[] answer;
        if (arr.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[arr.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = arr.get(i);
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    public int checkSum(int i, int j) {
        int result = Character.getNumericValue(map[i][j]);
        visit[i][j] = true;
        if (i < map.length - 1 && visit[i + 1][j] == false && map[i + 1][j] != 'X') {
            result += checkSum(i + 1, j);
        }
        if (j < map[0].length - 1 && visit[i][j + 1] == false && map[i][j + 1] != 'X') {
            result += checkSum(i, j + 1);
        }
        if (i > 0 && visit[i - 1][j] == false && map[i - 1][j] != 'X') {
            result += checkSum(i - 1, j);
        }
        if (j > 0 && visit[i][j - 1] == false && map[i][j - 1] != 'X') {
            result += checkSum(i, j - 1);
        }
        return result;
    }
}