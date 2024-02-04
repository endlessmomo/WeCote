import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 외판원_순회2 {

  static int N;
  static int[][] map;
  static boolean[] visited;
  static long result = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(in.readLine());
    map = new int[N][N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      map[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    dfs(0, 0, 0);
    System.out.println(result);
  }

  public static void dfs(int start, int depth, int cost) {
    if (depth == N - 1) {
      if(map[start][0] == 0) {
        return;
      }
      result = Math.min(result, cost + map[start][0]);
    }

    for (int to = 1; to < N; to++) {
      if (map[start][to] != 0 && !visited[to]) {
        visited[to] = true;
        dfs(to ,depth + 1, cost + map[start][to]);
        visited[to] = false;
      }
    }
  }
}
