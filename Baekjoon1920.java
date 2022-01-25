import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
        TreeSet<Integer> set = new TreeSet<>();

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrB = new ArrayList<>();
        StringTokenizer stM = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(stN.nextToken()));
        }

        for(int i=0;i<m;i++){
            arrB.add(Integer.parseInt(stM.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            if (set.contains(arrB.get(i))) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }
        System.out.println(sb);
    }
}
