class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        qsort(A, 0, A.length - 1);
        qsort(B, 0, B.length - 1);
        
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }
        
        return answer;
    }
    
    void qsort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot = arr[right];
        int index = left;
        
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, index, right);
        qsort(arr, left, index - 1);
        qsort(arr, index + 1, right);
    }
    
    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}