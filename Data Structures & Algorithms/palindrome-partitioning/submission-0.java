class Solution {
    List<List<String>> palinStrings;
    public List<List<String>> partition(String s) {
        palinStrings = new ArrayList<>();
        getPalins(s, 0, new ArrayList<>());
        return palinStrings;
    }

    private void getPalins(String s, int index, List<String> list){
        if(index >= s.length()){
            palinStrings.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalin(s.substring(index, i+1))){
                list.add(s.substring(index, i+1));
                getPalins(s, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalin(String s){
        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left)!= s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

//aabaa
//one index and then try to expand both sides simulatneosly
// aaaabaa