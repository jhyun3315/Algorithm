import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int l = Integer.parseInt(br.readLine());
       String str = br.readLine();
        long h =0;
        double pow = 1; // Math.pow(31,0);

        for(int i=0;i<l;i++) {
            char c = str.charAt(i);
            h += (c-96) * pow;
            pow =pow*31%1234567891;
        }
        System.out.print(h%1234567891);
    }
}
