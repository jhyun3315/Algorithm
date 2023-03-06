// https://www.acmicpc.net/problem/17141 연구소2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj17141 {
    static int N, M;
    static int[][] map;
    static ArrayList<Point> blst;
    static int answer = Integer.MAX_VALUE;
    static int zcnt;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        blst = new ArrayList<>();

        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine()," ");
            for(int c=0;c<N;c++){
                int curr = Integer.parseInt(st.nextToken());
                map[r][c] = curr;
                if(curr == 2) {
                    blst.add(new Point(r,c));
                    map[r][c] =0;
                }
                if(map[r][c]== 0) zcnt++;
            }
        }

        // 0의 개수
        zcnt = zcnt-M;

        int[] sel = new int[M];

        // 바이러스 선택하기
        combi(sel,0,0);

        // 퍼트린 이후에도 갱신이 안됐다면 -1 출력
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer-1);

    }

    private static void combi(int[] sel, int start, int k) {
        // M개의 바이러스를 모두 선택했다면,
        if(k==M){
            //바이러스 퍼트리기
            spray(sel);
            return;
        }
        for(int i=start; i<blst.size();i++){
            sel[k] = i;
            combi(sel, i+1, k+1);
        }
    }

    private static void spray(int[] sel) {
        int[][] mapCopy = new int[N][N];
        int zero = zcnt;
        int time = 0;
        mapCopy = copy(sel);

        Queue<Point> q = new LinkedList<>();
        for(int i=0;i<M;i++){
            Point p = blst.get(sel[i]);
            q.add(p);
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int s=0;s<size;s++){
                Point p = q.poll();
                int r = p.r;
                int c = p.c;

                for(int d=0;d<4;d++){
                    int nr = r+dr[d];
                    int nc = c+dc[d];

                    // 범위내에 있고 0이라면 방문
                    if(nr>=0 && nr<N && nc>=0 && nc<N && mapCopy[nr][nc] == 0 ){
                        // q에 추가
                        q.add(new Point(nr,nc));
                        // 바이러스를 퍼트리고, 0의 개수를 하나 줄임
                        mapCopy[nr][nc] = 2;
                        zero--;
                    }
                }
            }
            // 시간 추가
            time++;
        }

        //다 퍼트린뒤 맵에 0이 없다면, 최소값으로 갱신
        if(zero == 0) answer = Math.min(answer,time);
    }

    private static int[][] copy(int[] sel) {
        int[][] copy = new int[N][N];

        for(int r=0;r<N;r++){
            System.arraycopy(map[r], 0, copy[r], 0, N);
        }

        for(int i=0;i<M;i++){
            Point p = blst.get(sel[i]);
            copy[p.r][p.c] = 2;
        }

        return copy;
    }
}
