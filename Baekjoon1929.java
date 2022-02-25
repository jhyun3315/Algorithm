import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        arr[1] =1;

        StringWriter sw = new StringWriter();

        for(int i=2;i<=n;i++) {
            if(arr[i] ==0){
                int k = n/i;
                for(int j=2;j<=k;j++){
                    arr[i*j] =1;
                }
            }
        }

        for (int i=m; i<=n; i++) {
            if(arr[i]==0) sw.append(Integer.toString(i)).append('\n');
        }
        System.out.println(sw);

    }
}

