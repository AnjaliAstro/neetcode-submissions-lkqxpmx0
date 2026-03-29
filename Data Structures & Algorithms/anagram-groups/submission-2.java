class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anag = new HashMap<>();

        for(String str:strs){
            int[] numCon = new int[26];
            for(char c:str.toCharArray()){
                numCon[c-'a']++;
            }
            String convertedKey = Arrays.toString(numCon);
            List<String> existing = anag.getOrDefault(convertedKey, new ArrayList<>());
            existing.add(str);
            anag.put(convertedKey, existing);
        }
        return new ArrayList<>(anag.values());
    }
}
