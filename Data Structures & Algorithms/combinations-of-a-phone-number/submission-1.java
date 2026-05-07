class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> comb = new ArrayList<>();
        if(digits.length() == 0){
            return comb;
        }
        Map<Character, List<Character>> charMap = new HashMap<>();
        charMap.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        charMap.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        charMap.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        charMap.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        charMap.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        charMap.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        charMap.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        charMap.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        comb.add("");
        for(char ch:digits.toCharArray()){
            List<String> newComb = new ArrayList<>();
            List<Character> currList = charMap.get(ch);
            for(char alpha:currList){
                for(String str: comb){
                    newComb.add(str+alpha);
                }
            }
            comb = newComb;
        }
        return comb;
    }
}


// 2 3 9
// AD BD CD
// AE BE CE
// 