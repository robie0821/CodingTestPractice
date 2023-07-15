class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String[][] play = new String[musicinfos.length][2];
        
        while (m.indexOf("#") != -1) {
            int index = m.indexOf("#");
            m = m.substring(0, index - 1) + 
                m.substring(index-1, index).toLowerCase() + 
                m.substring(index+1);
        }
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] arr = musicinfos[i].split(",");
            int time = checkLen(arr[0], arr[1]);
            
            play[i][0] = arr[2];
            
            while (arr[3].indexOf("#") != -1) {
                int index = arr[3].indexOf("#");
                arr[3] = arr[3].substring(0, index - 1) + 
                    arr[3].substring(index-1, index).toLowerCase() + 
                    arr[3].substring(index+1);
            }
            
            
            if (arr[3].length() >= time) {
                play[i][1] = arr[3].substring(0,time);
            } else {
                String str = "";
                for (int t = 0; t < time / arr[3].length(); t++) {
                    str += arr[3];
                }
                str += arr[3].substring(0, time % arr[3].length());
                play[i][1] = str;
            }            
        }
        
        int max = 0;
        for (int i = 0; i < play.length; i++) {
            if (play[i][1].indexOf(m) != -1) {
                if (!answer.equals("None")) {
                    if (play[i][1].length() > max) {
                        answer = play[i][0];
                        max = play[i][1].length();
                    }
                } else {
                    answer = play[i][0];
                    max = play[i][1].length();
                }
            }
        }
        
        return answer;
    }
    
    public int checkLen(String x, String y) {
        String[] start = x.split(":");
        String[] end = y.split(":");
        
        return (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])) - 
            (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
    }
}