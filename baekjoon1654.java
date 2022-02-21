import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long k = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        long end = 0;
        
        for(int i=0; i < k; i++){
            int input = Integer.parseInt(br.readLine());
            arr.add(input);
            end = Math.max(end, input);
        }

        long start = 1;

        while(start <= end){
            long mid = (start + end) / 2;
            int total = 0;

            for(Integer e: arr) {
                total += e / mid;
            }

            if(total >= n)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(end);

    }
}

