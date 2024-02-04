import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로_계란치기 {

  static int N;
  static StringTokenizer st;
  static int[] durability, weight;
  static int result = Integer.MIN_VALUE;
  static int idx = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(in.readLine());
    weight = new int[N];
    durability = new int[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      durability[i] = Integer.parseInt(st.nextToken());
      weight[i] = Integer.parseInt(st.nextToken());
    }

    bt(0, 0);
    System.out.println(result);
  }

  public static void bt(int cur, int cnt) {
    if (cur == N) {
      result = Math.max(result, cnt);
      return;
    }

    if (isCrashed(cur) || cur == N-1) {
      bt(cur + 1, cnt);
      return;
    }

    int curCnt = cnt;
    for (int i = 0; i < N; i++) {
      if (cur == i) {
        continue;
      }
      idx++;

      if (durability[i] <= 0) {
        continue;
      }

      crash(cur, i);
      // hand가 깨진 경우
      if (isCrashed(cur)) cnt++;

      // right가 깨진 경우
      if (isCrashed(i)) cnt++;


      // 두개 다 깨진 경우
      bt(cur + 1, cnt);
      cnt = curCnt;
      recovery(cur, i);
    }
  }

  public static void crash(int cur, int target) {
    durability[cur] -= weight[target];
    durability[target] -= weight[cur];
  }

  public static void recovery(int cur, int target) {
    durability[cur] += weight[target];
    durability[target] += weight[cur];
  }

  public static boolean isCrashed(int cur) {
    return durability[cur] <= 0;
  }

}
