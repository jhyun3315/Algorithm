import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;

public class Main {

    static int answer(int len, int target, String string){
        int[] arr = new int[len];
        String[] st = string.split(" ");
        String[] sortedString = string.split(" ");

       Arrays.sort(sortedString, Collections.reverseOrder());
       Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<len;i++){
            queue.add(i);
        }

        int idx = 0;
        while(!queue.isEmpty()){
            int curr = queue.peek();

            if(st[curr].equals(sortedString[idx])) {
                arr[curr] = idx;
                queue.poll();
                idx++;
            } else queue.add(queue.poll());
        }

        return arr[target]+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringWriter sw = new StringWriter();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

           sw.append(Integer.toString(answer(len, target,  br.readLine()))).append('\n');
        }

       System.out.println(sw);
    }
}
