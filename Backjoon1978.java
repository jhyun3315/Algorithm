import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
        int cnt =0;

        for(int i=0;i<n;i++){
            int m = Integer.parseInt(stN.nextToken());
            if(m==1) cnt+=0;
            else if(m ==2) cnt++;
            else{
                int tmp = 1;
                for(int j=2;j<m;j++){
                    if(m%j==0) {
                        tmp =0;
                        break;
                    }
                }
                cnt+=tmp;
            }
        }
        System.out.println(cnt);
    }
}
