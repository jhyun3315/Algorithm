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
        int sum = 0;
        Deque<Integer> dequeue = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0 && !dequeue.isEmpty()) dequeue.pollLast();
            else dequeue.addLast(num);
        }

        if(dequeue.isEmpty()) sw.append('0').append('\n');
        else {
            for(Integer e : dequeue) sum+=e;
            sw.append(Integer.toString(sum)).append('\n');
        }
        System.out.println(sw);
    }
}
