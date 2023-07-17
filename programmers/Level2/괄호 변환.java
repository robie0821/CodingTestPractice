import java.util.ArrayList;
import java.util.Stack;

class Solution {
    
    
    
    public String solution(String p) {
        String answer = dfs(p);
        
        return answer;
    }
    
    public String dfs(String str) {
       
        Stack<Character> stack = new Stack<>();
        
        int count = 0;
        String u = "";
        String v = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
                count++;
            } else {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
                count--;
            }
            
            if (count == 0) {
                u = str.substring(0, i+1);
                v = str.substring(i+1);
                count = 50000;
            }
        }
        
        if (stack.empty()) {
            return str;
        }
        System.out.printf("%s,%s\n", u, v);
        
        stack.clear();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                stack.push(u.charAt(i));
            } else {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(u.charAt(i));
                }
            }
        }
        
        if (stack.empty()) {
            return u + dfs(v);
        }
        
        return "(" + dfs(v) + ")" + swap(u);
        
    }
    
    public String swap(String str) {
        str = str.substring(1, str.length()-1);
        
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                temp += ")";
            } else {
                temp += "(";
            }
        }
        return temp;
    }
}