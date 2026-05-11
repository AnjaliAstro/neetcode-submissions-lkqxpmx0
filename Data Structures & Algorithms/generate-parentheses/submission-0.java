class Solution {
    List<String> parans;
    public List<String> generateParenthesis(int n) {
        parans = new ArrayList<>();
        generate(n, 0, 0, "");//n total, open, close
        return parans;
    }

    private void generate(int n, int open, int close, String str){
        if(open > n || close > n || close > open){
            return;
        }

        if(open == close && open == n){
            String s = str;
            parans.add(s);
        }

        //try and put open first and then close ones
        generate(n, open+1, close, str+"(");

        //try and put close
        generate(n, open, close+1, str+")");
    }
}
//strategy
//open close count
// 0 to 3
// and always balanced

