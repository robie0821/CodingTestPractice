import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    Queue<Node> q = new LinkedList<>();
    char[][] map;
    boolean[][] visit;
    
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        
        int si = 0, sj = 0;
        int mi = 0, mj = 0;
        int ei = 0, ej = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if (maps[i].charAt(j) == 'S') {si = i; sj = j;}
                if (maps[i].charAt(j) == 'L') {mi = i; mj = j;}
                if (maps[i].charAt(j) == 'E') {ei = i; ej = j;}
            }
        }
        
        Node start = new Node(si, sj, 0);
        q.offer(start);
        visit[si][sj] = true;
        
        while (true) {
            if (q.isEmpty()) {return -1;}
            
            Node node = q.poll();

            if (map[node.i][node.j] == 'L') {
                answer += node.dist;
                break;
            }
            
            search(node);
            
        }
        
        q.clear();
        visit = new boolean[maps.length][maps[0].length()];
        
        Node lever = new Node(mi, mj, 0);
        q.offer(lever);
        visit[mi][mj] = true;
        
        while (true) {
            if (q.isEmpty()) {return -1;}
            
            Node node = q.poll();

            if (map[node.i][node.j] == 'E') {
                answer += node.dist;
                break;
            }
            
            search(node);
            
        }
        
        return answer;
    }
    
    public void search(Node node) {
        int i = node.i;
        int j = node.j;
        
        if (i > 0 && map[i-1][j] != 'X' && visit[i-1][j] == false) {
            Node temp = new Node(i-1, j, node.dist+1);
            q.offer(temp);
            visit[i-1][j] = true;
        }

        if (j > 0 && map[i][j-1] != 'X' && visit[i][j-1] == false) {
            Node temp = new Node(i, j-1, node.dist+1);
            q.offer(temp);
            visit[i][j-1] = true;
        }

        if (i < map.length-1 && map[i+1][j] != 'X' && visit[i+1][j] == false) {
            Node temp = new Node(i+1, j, node.dist+1);
            q.offer(temp);
            visit[i+1][j] = true;
        }

        if (j < map[0].length-1 && map[i][j+1] != 'X' && visit[i][j+1] == false) {
            Node temp = new Node(i, j+1, node.dist+1);
            q.offer(temp);
            visit[i][j+1] = true;
        }
    }
    
    class Node {
        int i;
        int j;
        int dist;
        
        public Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
}