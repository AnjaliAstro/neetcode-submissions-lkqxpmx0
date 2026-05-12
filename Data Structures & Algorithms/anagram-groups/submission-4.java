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

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            
            List<String> list = map.get(key);
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
