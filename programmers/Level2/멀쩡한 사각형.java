class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h;
        long count = 0;

        for (int i = 0; i < w; i++) {
            count += Math.ceil((double) h * (i+1) / w) - Math.floor((double) h * i / w);
        }
        return answer - count;
    }
}