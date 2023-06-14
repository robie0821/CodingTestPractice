class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        for (int i = 1; ;i++) {
            if (Math.abs(a-b) == 1 && max(a,b) % 2 ==0) {
                answer = i;
                break;
            } else {
                if(a % 2 == 1) {
                    a = (a + 1) / 2;
                } else {
                    a = a / 2;
                }
                
                if(b % 2 == 1) {
                    b = (b + 1) / 2;
                } else {
                    b = b / 2;
                }
            }
        }

        return answer;
    }
    
    public int max (int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}