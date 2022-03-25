import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;

public class Main {
    static int getMaxCount(HashMap<Integer, Integer> hashMap){
        int max = 1;
        ArrayList<Integer> arr = new ArrayList<>();

        for(Integer key : hashMap.keySet()) {
            if (hashMap.get(key) > max) {
                max = hashMap.get(key);
            }
        }

        for(Integer key : hashMap.keySet()) if(hashMap.get(key) == max) arr.add(key);
        if(arr.size()>1){
            Collections.sort(arr);
            return arr.get(1);
        }else return arr.get(0);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double sum =0;
        int[] arr = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<n;i++){
            int curr = Integer.parseInt(br.readLine());
            sum+=curr;
            arr[i] = curr;
            hashMap.put(curr, hashMap.getOrDefault(curr, 0)+1);
        }

        Arrays.sort(arr);

        StringWriter sw = new StringWriter();

        sw.append(Integer.toString((int) Math.round(sum/n))).append('\n');
        if(n==1) sw.append(Integer.toString(arr[0])).append('\n');
        else sw.append(Integer.toString(arr[n/2])).append('\n');
        sw.append(Integer.toString(getMaxCount(hashMap))).append('\n');
        sw.append(Integer.toString(arr[n-1] -arr[0])).append('\n');

        System.out.println(sw);

    }
}
