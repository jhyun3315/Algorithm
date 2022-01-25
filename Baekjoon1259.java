import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String origin = br.readLine();
            if(origin.equals("0")) break;
            String answer = "yes";
            StringBuilder sb = new StringBuilder(origin).reverse();

            for(int i=0;i<origin.length();i++){
                if(origin.charAt(i) != sb.charAt(i)) answer="no";
            }
            System.out.println(answer);
        }
    }
}
