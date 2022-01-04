import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> words = new HashMap<>();

        for(int i=0;i<n;i++){
            String curr = br.readLine();
            words.put(curr, curr.length());
        }

        ArrayList<String> list = new ArrayList<String>(words.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
