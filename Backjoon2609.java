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

        int max= Math.max(n,m);
        int min = Math.min(n,m);

        if(max%min==0){
            System.out.println(min);
            System.out.println(max);
        }else{
            int r1 = max % min;  //prior
            int r2 = min % r1; //curr

            while (r2 != 0) {
                int tmp = r1 % r2;
                r1 = r2;
                r2 = tmp;
            }
            System.out.println(r1);
            System.out.println(max * min / r1);
        }
    }
}
