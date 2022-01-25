import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringWriter sw = new StringWriter();
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<n;i++){
            int curr = Integer.parseInt(st.nextToken());
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st2.nextToken());
            sw.append(map.getOrDefault(num, 0).toString()).append(" ");
        }

        System.out.println(sw);
    }
}
