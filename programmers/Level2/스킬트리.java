class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        loop: for (int t = 0; t < skill_trees.length; t++) {
            int step = 0;
            for (int i = 0; i < skill_trees[t].length(); i++) {
                int check = skillCheck(skill, skill_trees[t].substring(i, i + 1));
                if (check == -1) {
                    continue;
                } else {
                    if(check > step) {
                        continue loop;
                    } else {
                        step++;
                    }
                }
            }
            answer++;
        }
        
        return answer;
    }
    
    int skillCheck(String skill, String sk) {
        for (int i = 0; i < skill.length(); i++) {
            if(skill.substring(i, i + 1).equals(sk)) {
                return i;
            }
        }
        return -1;
    }
}