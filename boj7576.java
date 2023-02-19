import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {

    static int N, M, answer;
    static int[][] map;
    static int total, cnt, empty;
    static Queue<Point> q;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        answer = 0;
        total = N * M;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토인 경우 q에 삽입 및 cnt 개수 카운트
                if (map[i][j] == 1) {
                    cnt++;
                    q.add(new Point(i, j));
                }
                if (map[i][j] == -1) empty++;
            }
        }

        //모든 토마토가 다 익어있는 상태라면
        if (cnt == total) {
            System.out.println(0);
            return;
        }

        total -= (cnt + empty);
        BFS();

        // 토마토가 모두 익지 못하는 상황이라면
        if (total != 0) System.out.println(-1);
        else System.out.println(answer - 1);
    }

    private static void BFS() {
        // q가 다 빌때까지
        while (!q.isEmpty()) {

            //현재 q에 들어있는 토마토 만큼 탐방 (하루치)
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point p = q.poll();

                int r = p.r;
                int c = p.c;

                // 4방 탐색
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 탐색하려는 곳이 아직 안익었고, 범위 내에 있다면
                    if (nr < N && nr >= 0 && nc < M && nc >= 0 && map[nr][nc] == 0) {
                        //토마토 익히고 그곳으로 이동 (q에 삽입)
                        map[nr][nc] = 1;
                        total--;
                        q.add(new Point(nr, nc));
                    }
                }
            }
            answer++;
        }
    }
}
