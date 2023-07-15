import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] split = new String[files.length][3];
        
        for (int t = 0; t < files.length; t++) {
            int index = 0;
            for (int i = 0; i < files[t].length(); i++) {
                if (Character.isDigit(files[t].charAt(i))) {
                    index = i;
                    break;
                }
            }
            
            split[t][0] = files[t].substring(0, index);
            
            for (int i = index; i < files[t].length(); i++) {
                if (!Character.isDigit(files[t].charAt(i))) {
                    split[t][1] = files[t].substring(index, i);
                    split[t][2] = files[t].substring(i);
                    break;
                }
                if (i == files[t].length() - 1) {
                    split[t][1] = files[t].substring(index);
                    split[t][2] = "";
                    break;
                }
            }
        }
        
        Arrays.sort(split, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equalsIgnoreCase(o2[0])) {
                    return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
                } else {
                    return o1[0].compareToIgnoreCase(o2[0]);
                }
            }
        });
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = split[i][0] + split[i][1] + split[i][2];
        }
        
        return answer;
    }
}