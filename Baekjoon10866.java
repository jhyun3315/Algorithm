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
        LinkedList<Integer> arr = new LinkedList<>();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cnt = st.countTokens();
            String str = st.nextToken();
            int num = 0;
            if(cnt ==2) num = Integer.parseInt(st.nextToken());

            switch (str) {
                case "push_front":
                    arr.addFirst(num);
                    break;
                case "push_back":
                    arr.addLast(num);
                    break;
                case "pop_front":
                    if (arr.isEmpty()) sw.append("-1").append('\n');
                    else {
                        int tmp = arr.removeFirst();
                        sw.append(Integer.toString(tmp)).append('\n');
                    }
                    break;
                case "pop_back":
                    if (arr.isEmpty()) sw.append("-1").append('\n');
                    else {
                        int tmp = arr.removeLast();
                        sw.append(Integer.toString(tmp)).append('\n');
                    }
                    break;
                case "size":
                    sw.append(Integer.toString(arr.size())).append('\n');
                    break;
                case "empty":
                    if (arr.isEmpty()) sw.append('1').append('\n');
                    else sw.append('0').append('\n');
                    break;
                case "front":
                    if(arr.isEmpty()) sw.append("-1").append('\n');
                    else sw.append(Integer.toString(arr.getFirst())).append('\n');
                    break;
                case "back":
                    if (arr.isEmpty()) sw.append("-1").append('\n');
                    else sw.append(Integer.toString(arr.getLast())).append('\n');
                    break;
            }

        }

        System.out.println(sw);
    }
}

