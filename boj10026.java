// https://www.acmicpc.net/problem/10026 적록색약

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj10026 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visitedRedGreen;
    static int answerNor, redGreen;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    static class Point{
        int r,c;
        char cls;

        public Point(int r, int c, char cls) {
            this.r = r;
            this.c = c;
            this.cls = cls;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        visitedRedGreen = new boolean[N][N];
        answerNor = 0;
        redGreen = 0;

        for(int r=0;r<N;r++){
            char[] tmp = br.readLine().toCharArray();
            for(int c=0;c<N;c++){
                map[r][c] = tmp[c];
            }
        }

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                // 아직 방문 전이라면
                if(!visited[r][c]) {
                    BFS(r,c);
                }
                if(!visitedRedGreen[r][c]){
                    BFSRedGreen(r,c);
                }
            }
        }
        System.out.println(answerNor+" "+redGreen);
    }

    private static void BFSRedGreen(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c,map[r][c]));
        visitedRedGreen[r][c] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            int pr = p.r;
            int pc = p.c;
            char cls = p.cls;

            for(int d=0;d<4;d++){
                int nr = pr+dr[d];
                int nc = pc+dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visitedRedGreen[nr][nc]) {
                    if ( (cls == 'R' && map[nr][nc] == 'G') || (cls=='G' && map[nr][nc] == 'R')) {
                        q.add(new Point(nr, nc, cls));
                        visitedRedGreen[nr][nc] = true;

                    }else if(map[nr][nc] == cls){
                        q.add(new Point(nr, nc, cls));
                        visitedRedGreen[nr][nc] = true;
                    }
                }
            }
        }
        redGreen++;
    }

    private static void BFS(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c,map[r][c]));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            int pr = p.r;
            int pc = p.c;
            char cls = p.cls;

            for(int d=0;d<4;d++){
                int nr = pr+dr[d];
                int nc = pc+dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == cls) {
                    q.add(new Point(nr, nc, cls));
                    visited[nr][nc] = true;
                }
            }
        }
        answerNor++;
    }
}
