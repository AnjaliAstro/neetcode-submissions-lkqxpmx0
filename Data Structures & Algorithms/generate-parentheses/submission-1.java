class Solution {
    List<String> parans;
    public List<String> generateParenthesis(int n) {
        parans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        generate(n, 0, 0, str);//n total, open, close
        return parans;
    }

    private void generate(int n, int open, int close, StringBuilder str){
        if(open > n || close > n || close > open){
            return;
        }

        if(open == close && open == n){
            parans.add(str.toString());
        }

        //try and put open first and then close ones
        str.append("(");
        generate(n, open+1, close, str);
        str.deleteCharAt(str.length()-1);

        //try and put close
        str.append(")");
        generate(n, open, close+1, str);
        str.deleteCharAt(str.length()-1);
    }
}
//strategy
//open close count
// 0 to 3
// and always balanced

