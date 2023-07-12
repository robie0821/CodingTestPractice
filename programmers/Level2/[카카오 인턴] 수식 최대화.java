import java.util.ArrayList;
class Solution {
    ArrayList<String> expr;
    public long solution(String expression) {
        long answer = 0;
        long result = 0;
        String[] op ={"+-*", "+*-", "*+-", "*-+", "-+*", "-*+"};
        expr = new ArrayList<>();
        
        int index = 0;
        for (int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);
            if (temp == '+' || temp == '-' || temp == '*') {
                expr.add(expression.substring(index, i));
                expr.add(expression.substring(i, i + 1));
                index = i + 1;
            }
        }
        
        expr.add(expression.substring(index));
        ArrayList<String> temp;
        
        for (int i = 0; i < op.length; i++) {
            temp = cal(expr, op[i].substring(0, 1));
            temp = cal(temp, op[i].substring(1, 2));
            temp = cal(temp, op[i].substring(2, 3));
            result = Math.abs(Long.parseLong(temp.get(0)));

            if (answer < result) {
                answer = result;
            }
        }
        
        return answer;
    }
    
    public ArrayList<String> cal(ArrayList<String> arr, String op) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(op)) {
                long a = Long.parseLong(temp.get(temp.size() - 1));
                long b = Long.parseLong(arr.get(i + 1));
                long result = 0;

                switch(op) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;   
                }
                
                temp.remove(temp.size() - 1);
                temp.add(String.valueOf(result));
                i++;
            } else {
                temp.add(arr.get(i));
            }
        }
        return temp;
    }
}