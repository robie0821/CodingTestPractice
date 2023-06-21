class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int RT = 0, CF = 0, JM = 0, AN = 0;
        
        for(int i = 0; i < survey.length; i++) {
            switch(survey[i].substring(0, 1)) {
                case "R":
                    RT -= choices[i] - 4;
                    break;
                case "T":
                    RT += choices[i] - 4;
                    break;
                case "C":
                    CF -= choices[i] - 4;
                    break;
                case "F":
                    CF += choices[i] - 4;
                    break;
                case "J":
                    JM -= choices[i] - 4;
                    break;
                case "M":
                    JM += choices[i] - 4;
                 break;
                case "A":
                    AN -= choices[i] - 4;
                    break;
                case "N":
                    AN += choices[i] - 4;
                 break;
            }
        }
        
        if(RT >= 0) {
            answer += "R";
        } else {
            answer += "T";
        }
        
        if(CF >= 0) {
            answer += "C";
        } else {
            answer += "F";
        }
        
        if(JM >= 0) {
            answer += "J";
        } else {
            answer += "M";
        }
        
        if(AN >= 0) {
            answer += "A";
        } else {
            answer += "N";
        }
        
        return answer;
    }
}