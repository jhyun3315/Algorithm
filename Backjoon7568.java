import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            arr[i][0] = weight;
            arr[i][1] = length;
        }

        for(int i=0;i<n;i++){
            int currWeight = arr[i][0];
            int currLength = arr[i][1];
            int rank = 1;

            for(int j=0;j<n;j++){
                if(currWeight < arr[j][0] && currLength <arr[j][1] && j!=i) rank++;
            }
            System.out.print(rank+" ");
        }
    }
}
