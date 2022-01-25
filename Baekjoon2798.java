import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] str = br.readLine().split(" ");
       int n = Integer.parseInt(str[0]);
       int m = Integer.parseInt(str[1]);

       String[] cards = br.readLine().split(" ");

       int sum = 0;

       for(int lt = 0;lt<n-2;lt++){
           for(int rt=0;rt<n-1;rt++){
               if(rt!=lt){
                   for(int t=0;t<n;t++){
                       if(t!=rt && t!=lt){
                           int tmp = Integer.parseInt(cards[lt])
                                   + Integer.parseInt(cards[rt])
                                   + Integer.parseInt(cards[t]);
                          if (tmp <= m) sum = Math.max(sum, tmp);
                       }
                   }
               }
           }
       }
        System.out.println(sum);
    }
}
