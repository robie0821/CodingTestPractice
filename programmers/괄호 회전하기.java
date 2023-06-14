import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int t = 0; t < s.length(); t++) {
            String str = s;
            
            if (t != 0) {
                str = s.substring(t) + s.substring(0,t);
            }
            
            
            for (int i = 0; i < str.length(); i++) {
                if (stack.empty()) {
                    stack.push(str.charAt(i));
                } else if(compare(stack.peek(), str.charAt(i))) {
                    stack.pop();
                } else if(isSame(stack.peek(), str.charAt(i))) {
                    stack.push(str.charAt(i));
                } else {
                    stack.push(str.charAt(i));
                    break;
                }
            }
            
            if (stack.empty()) {
                answer++;
            }
            stack.clear();
        }
        return answer;
    }
    
    boolean compare (Character x, Character y) {
        if ((x == '('&& y ==')') || (x == '{'&& y =='}') || (x == '['&& y ==']'))
            return true;
        else
            return false;
    }
    
    boolean isSame(Character x, Character y) {
        if (x == '(' || x == '{' || x == '[') {
            if (y == '(' || y == '{' || y == '[') {
                return true;
            }
        }
        
        if (x == ')' || x == '}' || x == ']') {
            if (y == ')' || y == '}' || y == ']') {
                return true;
            }
        }
        
        return false;
    }  
}