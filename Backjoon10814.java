import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        String[][] arr = new String[n][2];

        for(int i=0;i<n;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
            arr[i][0] = st1.nextToken();
            arr[i][1] = st1.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (int i=0; i<n;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}
