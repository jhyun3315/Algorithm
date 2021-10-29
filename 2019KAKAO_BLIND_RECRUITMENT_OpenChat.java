import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;   

public static String[] solution(String[] record) {
  String[] answer ={};
  List<String> tmp = new ArrayList<String>();
  HashMap<String, String> info = new HashMap<>();

  for(int i=0;i<record.length;i++){
    String[] log = record[i].split(" ");
    if(log.length == 3){
      info.put(log[1], log[2]);
    }
  }

  for(int i=0;i<record.length;i++){
    String[] log = record[i].split(" ");
    if(log[0].equals("Change")) continue;
    else tmp.add(info.get(log[1])+"님이 " + log[0].replace("Enter","들어왔습니다.").replace("Leave","나갔습니다."));
  }
  
  int arrListSize = tmp.size();
  answer = tmp.toArray(new String[arrListSize]);
  
  return answer;
}
