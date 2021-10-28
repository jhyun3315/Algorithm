class Solution {
    public String solution(String new_id) {
        String answer = "";
		
        // 1단계 ~ 4단계
        answer = new_id.toLowerCase().replaceAll("[^-_.a-zA-Z\\d]", "")
                .replaceAll("\\.{2,}", ".")
                .replaceAll("^[.]|[.]$", "");
                
		// 6단계
        if(answer.length()>=16) answer = answer.substring(0, 15).replaceAll("[.]$","");

		// 5단계
        if(answer.equals("")) answer = "a";
        
		// 7단계
        if(answer.length()<=2 && answer.length()>0){
            while(answer.length()!=3){
                answer+= answer.charAt(answer.length()-1);
            }
        }

        return answer;
    }
}
