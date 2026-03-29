class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anag = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String str = strs[i];

            int[] numCon = new int[26];
            for(int j=0; j<str.length(); j++){
                char ch = str.charAt(j);
                numCon[ch-'a']++;
            }
            String convertedKey = convertIntoStr(numCon);
            List<String> existing = anag.getOrDefault(convertedKey, new ArrayList<>());
            existing.add(str);
            anag.put(convertedKey, existing);
        }
        List<List<String>> groupAnag = new ArrayList<>();
        for(String str:anag.keySet()){
            groupAnag.add(anag.get(str));
        }
        return groupAnag;
    }

    private String convertIntoStr(int[] numCon){
        String str = "";
        for(int j=0; j<26; j++){
            if(numCon[j] != 0){
                str = str + (char)('a'+j)+ numCon[j];
            }
        }
        return str;
    }
}
