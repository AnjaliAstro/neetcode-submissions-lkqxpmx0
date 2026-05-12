class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str:strs){
            int[] freq = new int[26];
            Arrays.fill(freq, 0);
            for(char ch:str.toCharArray()){
                freq[ch-'a']++;
            }

            String key = "";
            for(int i=0; i<26; i++){
                key += String.valueOf(freq[i])+"#";
            }

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
