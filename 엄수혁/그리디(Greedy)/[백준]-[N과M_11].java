import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_11 {

  static int[] arr, printArr;
  static int N, M;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
    printArr = new int[M];

    dfs(0);
    System.out.println(sb.toString());
  }

  public static void dfs(int depth) {
    if (M == depth) {
      for (int val : printArr) {
        sb.append(val).append(" ");
      }
      sb.append("\n");
      return;
    }

    int prev = -1;
    for (int i = 0; i < N; i++) {
      if (prev != arr[i]) {
        prev = arr[i];
        printArr[depth] = arr[i];
        dfs(depth + 1);
      }
    }
  }
}
