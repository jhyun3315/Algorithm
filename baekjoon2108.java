import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr= new Integer[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0;
        int mid = (n/2);

        for(int i=0;i<n;i++){
            int curr =  Integer.parseInt(br.readLine());
            arr[i] = curr;
            map.put(curr, map.getOrDefault(curr,0)+1);
            sum+=curr;
        }

        if(sum/n <0) System.out.println(String.format("%.0f",(double)sum/n));
        else System.out.println(sum/n);

        Arrays.sort(arr);
        System.out.println(arr[mid]);

        if(map.size()==1) System.out.println(arr[0]);
        else{
            List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort((o1, o2) -> {
                if(o1.getValue().equals(o2.getValue())) return o1.getKey() - o2.getKey();
                return o2.getValue() - o1.getValue();
            });

            if(entryList.get(0).getValue().equals( entryList.get(1).getValue())) System.out.println(entryList.get(1).getKey());
            else System.out.println(entryList.get(0).getKey());
        }

        System.out.println(Math.abs(arr[n-1] - arr[0]));

    }
}

