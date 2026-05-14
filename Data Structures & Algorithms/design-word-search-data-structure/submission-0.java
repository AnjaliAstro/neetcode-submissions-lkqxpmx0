class WordDictionary {
    Trie root;
    class Trie {
        Trie[] children;
        boolean isEnd;

        Trie(){
            children = new Trie[26];
            isEnd = false;
        }
    }

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(node.children[ch-'a'] != null){
                node = node.children[ch-'a'];
            }
            else{
                node.children[ch-'a'] = new Trie();
                node = node.children[ch-'a'];
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = root;
        return dfs(word, node, 0);
    }

    private boolean dfs(String word, Trie node, int index){
        for(int i=index; i<word.length(); i++){
            char ch = word.charAt(i);

            if(ch == '.'){
                boolean nonEmpty = false;
                for(int j=0; j<26; j++){
                    if(node.children[j] != null){
                        if(dfs(word, node.children[j], i+1)){
                            return true;
                        }
                    }
                }
                return false;
            }
            else if(node.children[ch-'a'] == null){
                return false;
            }
            else{
                node = node.children[ch-'a'];
            }
        }
        return node.isEnd == true;
    }
}
