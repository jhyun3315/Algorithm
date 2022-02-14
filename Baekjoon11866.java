import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringWriter sw = new StringWriter();

        Deque<Integer> deQ = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1;i<=n;i++){
           deQ.addLast(i);
        }

        while(!deQ.isEmpty()){
            for(int i=0;i<k-1;i++){
                if(!deQ.isEmpty()){
                    deQ.addLast(deQ.pollFirst());
                }
            }
            list.add(deQ.pollFirst());
        }

        sw.append('<').append(Integer.toString(list.get(0)));

        for(int i=1;i<n;i++){
            sw.append(", ").append(Integer.toString(list.get(i)));
        }

        sw.append('>');

        System.out.println(sw);
    }
}

