class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String str: strs){
            encoded += String.valueOf(str.length()) + "#" + str;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            String lenStr = "";
            while(str.charAt(i) != '#'){
                lenStr += str.charAt(i);
                i++;
            }

            int len = Integer.parseInt(lenStr);
            i++;
            decoded.add(str.substring(i, i+len));
            i = i + len;
        }
        return decoded;
    }
}
