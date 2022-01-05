import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] chess = new char[n][m];

        for(int i=0;i<n;i++){
            String row = br.readLine();
            for(int j=0;j<m;j++){
                chess[i][j] = row.charAt(j);
            }
        }

        String b = "BW";
        String w = "WB";

        int answer=50;

        for(int i=0;i<=n-8;i++){
            for(int k=0;k<=m-8;k++){
                int bwCnt = 0;
                int wbCnt = 0;
            for(int j=i;j<i+8;j++){
                    for(int h=k;h<k+8;h++){
                        if(j%2==0){
                            if(chess[j][h] != b.charAt(h%2)) bwCnt++;
                            else if(chess[j][h] != w.charAt(h%2)) wbCnt++;
                        }else{
                            if(chess[j][h] != w.charAt(h%2)) bwCnt++;
                            else if(chess[j][h] != b.charAt(h%2)) wbCnt++;
                        }
                    }
                }
               answer = Math.min(answer,Math.min(bwCnt,wbCnt));
            }
        }
        System.out.println(answer);
    }
}
