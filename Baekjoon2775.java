import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int getValue(int k, int n){
        if(k==0) return n;
        else if(n==1) return 1;
        else return (getValue(k,n-1) + getValue(k-1,n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(getValue(k,n));
        }

    }
}
