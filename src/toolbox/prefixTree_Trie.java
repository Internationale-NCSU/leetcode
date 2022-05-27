package toolbox;

public class prefixTree_Trie {
    static class Trie {
        Trie[] children;
        boolean isWord;
        char val;
        int count;

        public Trie(){
            children=new Trie[26];
            isWord=false;
        }

        public Trie(char c) {
            this.children=new Trie[26];
            this.isWord=false;
            this.val=c;
            count=0;
        }

        public void insert(String word) {
            if(word.length()==0){
                isWord=true;
                return;
            }
            if(this.children[word.charAt(0)-'a']==null) {
                this.children[word.charAt(0) - 'a'] = new Trie(word.charAt(0));
            }

            this.count++;
            this.children[word.charAt(0)-'a'].insert(word.substring(1));
        }

        public boolean search(String word) {
            if(word.length()==0){
                return isWord;
            }
            if(this.children[word.charAt(0)-'a']==null){
                return false;
            }
            return this.children[word.charAt(0)-'a'].search(word.substring(1));
        }

        public boolean startsWith(String prefix) {
            if(prefix.length()==1){

                return count>0&&this.children[prefix.charAt(0)-'a']!=null;
            }
            if(this.children[prefix.charAt(0)-'a']==null){
                return false;
            }
            return this.children[prefix.charAt(0)-'a'].startsWith(prefix.substring(1));

        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("switch");
        trie.insert("start");
        trie.insert("swiss");
        System.out.println(trie.search("switch"));
        System.out.println(trie.startsWith("st"));
    }
}
