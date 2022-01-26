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
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cnt = st.countTokens();
            String str = st.nextToken();
            int num = 0;
            if(cnt ==2) num = Integer.parseInt(st.nextToken());

            switch (str) {
                case "push":
                    arr.add(num);
                    break;
                case "pop":
                    if (arr.isEmpty()) sw.append("-1").append('\n');
                    else {
                        int tmp = arr.get(arr.size()-1);
                        arr.remove(arr.size()-1);
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
                case "top":
                    if (arr.isEmpty()) sw.append("-1").append('\n');
                    else sw.append(Integer.toString(arr.get(arr.size()-1))).append('\n');
                    break;
            }

        }

        System.out.println(sw);
    }
}

