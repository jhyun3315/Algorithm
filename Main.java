import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int i=0;i<test;i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n =Integer.parseInt(st.nextToken());

        }

    }
}
