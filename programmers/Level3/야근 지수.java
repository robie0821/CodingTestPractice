import java.util.Arrays;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        for (int i = 0; i < works.length; i++) {
            answer += works[i];
        }
        
        if(n >= answer) {
            return 0;
        }
        answer = 0;
        
        work(works, n);
        
        for (int i = 0; i < works.length; i++) {
            System.out.println(works[i]);
            answer += (long) Math.pow(works[i], 2);
        }
        
        return answer;
    }
    
    public void work(int[] works, int n) {
        Arrays.sort(works);
        
        int count = 0;
        int max = works[works.length - 1];
        
        for(int i = 0; i < works.length; i++) {
            if (max != works[works.length - 1 - i]) {
                break;
            }
            count = i + 1;
        }
        if (count < works.length) {
            int sub = works[works.length - count] - works[works.length - count - 1];
            
            if (sub * count <= n) {
                for(int i = 0; i < count; i++) {
                    works[works.length - i - 1] -= sub;
                }
                n -= sub * count;
                if (n == 0) {
                    return;
                }
                work(works, n);
            } else {
                sub = n / count;
                int mod = n % count;
                for(int i = 0; i < count; i++) {
                    if (mod > 0) {
                        works[works.length - i - 1] -= sub + 1;
                        mod--;
                    } else {
                        works[works.length - i - 1] -= sub;
                    }
                }
            }
        } else {
            int sub = n / count;
            int mod = n % count;
            
            for(int i = 0; i < count; i++) {
                if (mod > 0) {
                    works[i] -= sub + 1;
                    mod--;
                } else {
                    works[i] -= sub;
                }
            }
        }
        return;
    }
}