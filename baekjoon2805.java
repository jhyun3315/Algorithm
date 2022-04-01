import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    static int m;
    static int max = 0;

    static long answer =0;

    static void getValue(long lt, long rt){
        if(lt > rt) return;

        long mid = (lt+rt)/2;
        long sum = 0;

        for(Integer e : arr){
            if(e-mid >0) sum += e-mid;
        }

        if(sum >= m) {
            answer = mid;
            getValue(mid + 1, rt);
        }else getValue(lt, mid-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        arr = new int[n];


        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(st2.nextToken());
            arr[i] = curr;
            max = Math.max(max, curr);
        }
        getValue(0, max);

        System.out.println(answer);
    }
}
