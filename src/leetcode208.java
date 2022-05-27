public class leetcode208 {

    class TrieNode{

        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        private TrieNode(){
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        public TrieNode get(char ch){
            return links[ch-'a'];
        }
        public void put(char ch,TrieNode trieNode){
            links[ch-'a'] = trieNode;
        }
        public void setEnd(){
            isEnd = true;
        }
        public boolean isEnd(){
            return isEnd;
        }

    }

    class Trie {

        TrieNode trieNode;

        public Trie() {
            trieNode = new TrieNode();
            trieNode.setEnd();
        }

        public void insert(String word) {
            int i = 0;
            TrieNode p = trieNode;
            while(i<word.length()){
                char ch = word.charAt(i);
                i++;
                if(p.containsKey(ch)){
                    p = p.get(ch);
                }else {
                    p.put(ch,trieNode.get(ch));
                    p = p.get(ch);
                }
            }
        }

        public boolean search(String word) {
            return false;
        }

        public boolean startsWith(String prefix) {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
