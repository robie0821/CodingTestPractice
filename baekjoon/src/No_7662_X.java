import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class No_7662_X {
  static int[] solution(String[] operations) {
    int[] queue = new int[0];
    for (int t = 0; t < operations.length; t++) {
      if (operations[t].charAt(0) == 'I') {
        int num = Integer.parseInt(operations[t].substring(2));
        int[] temp = new int[queue.length + 1];
        for (int i = 0; i < queue.length; i++) {
          temp[i] = queue[i];
        }
        temp[temp.length - 1] = num;
        queue = temp;
      }

      if (operations[t].equals("D 1")) {
        if (queue.length != 0) {
          int[] temp = new int[queue.length - 1];
          for (int i = 0; i < temp.length; i++) {
            temp[i] = queue[i];
          }
          queue = temp;
        }
      } else if (operations[t].equals("D -1")) {
        if (queue.length != 0) {
          int[] temp = new int[queue.length - 1];
          for (int i = 0; i < temp.length; i++) {
            temp[i] = queue[i + 1];
          }
          queue = temp;
        }
      }

      Arrays.sort(queue);
    }

    if (queue.length == 0) {
      int[] answer = {0, 0};
      return answer;
    } else {
      int[] answer = {queue[queue.length - 1], queue[0]};
      return answer;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] answer = new int[n][2];
    for (int t = 0; t < n; t++) {
      int len = Integer.parseInt(br.readLine());
      String[] strings = new String[len];
      for (int i = 0; i < len; i++) {
        strings[i] = br.readLine();
      }

      answer[t] = solution(strings);
    }

    for (int i = 0; i < n; i++) {
      if (answer[i][0] == 0 && answer[i][1] == 0) {
        System.out.println("EMPTY");
      } else {

        System.out.printf("%d %d", answer[i][0], answer[i][1]);
      }
    }
  }
}