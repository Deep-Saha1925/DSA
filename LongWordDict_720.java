class Solution {
    public String longestWord(String[] words) {
        Set<String> s = new HasSet<>();

        for(String w: words){
            s.add(w);
        }

        String ans = "";

        for(String word: words){
            boolean valid = true;

            for(int i=1; i<word.length(); i++){
                if(!set.contains(word.substring(0, i))){
                    valid = false;
                    break;
                }
            }

            if(valid){
                
            }
        }
    }
}