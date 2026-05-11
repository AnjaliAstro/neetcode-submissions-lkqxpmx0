class PrefixTree {
    Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new Trie();
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie itr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(itr.children[ch-'a'] == null){
                return false;
            }
            itr = itr.children[ch-'a'];
        }
        return itr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie itr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(itr.children[ch-'a'] == null){
                return false;
            }
            itr = itr.children[ch-'a'];
        }
        return true;
    }
}

class Trie {
        boolean isEnd;
        Trie[] children;

        Trie() {
            children = new Trie[26];
            isEnd = false;
        }
}