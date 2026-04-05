class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastSeen = new int[26];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            lastSeen[ch-'a'] = i;
        }

        int start = 0;
        int end = 0;
        List<Integer> count = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end, lastSeen[ch-'a']);

            if(i==end){
                count.add(end-start+1);
                start = end+1;
            }
        }
        return count;
    }
}
