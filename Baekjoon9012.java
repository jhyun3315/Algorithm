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

        for(int i=0;i<n;i++){
            String str = br.readLine();
            Deque<Character> deQueue = new ArrayDeque<>();
            for( char c : str.toCharArray()){
                if(c == '(') deQueue.addLast(c);
                else if(c ==')'){
                    if(deQueue.peekLast() != null && deQueue.peekLast().equals('(')) deQueue.pollLast();
                    else deQueue.addLast(c);
                }
            }

            if(deQueue.isEmpty()) sw.append("YES").append('\n');
            else sw.append("NO").append('\n');
        }

        System.out.println(sw);
    }
}
