import java.util.*;

class Solution {
    int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = 50000;
        map = new int[n+1][n+1];
        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;
            
            int a = bfs(n);
            int b = n - a;
            int temp = Math.abs(a-b);
            
            if (temp < answer) {
                answer = temp;
            }
            
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        return answer;
    }
    
    public int bfs (int n) {
        int result = 1;
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        while (!q.isEmpty()) {
            int index = q.poll();
            
            for (int i = 1; i < n+1; i++) {
                if (!visit[i] && map[index][i] == 1) {
                    visit[i] = true;
                    q.add(i);
                    result++;
                }
            }
        }
        return result;
    }
}