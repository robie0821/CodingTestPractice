import java.util.Scanner;

class No_1932 {
  static int solution(int[][] triangle) {
    int answer = 0;

    for (int i = triangle.length - 2; i >= 0; i--) {
      for (int j = 0; j < i + 1; j++) {
        if (triangle[i + 1][j] > triangle[i + 1][j + 1]) {
          triangle[i][j] += triangle[i + 1][j];
        } else {
          triangle[i][j] += triangle[i + 1][j + 1];
        }
      }
    }

    return triangle[0][0];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] triangle = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        triangle[i][j] = sc.nextInt();
      }
    }

    int answer = solution(triangle);

    System.out.println(answer);
  }
}