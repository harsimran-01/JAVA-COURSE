public class trie_ds {

    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int indx = word.charAt(i) - 'a';
            if(curr.children[indx] == null){
                curr.children[indx] = new Node();
            }
            if(i==word.length()-1){
                curr.children[indx].eow = true;
            }
            curr = curr.children[indx];
        }

    }

    public static boolean search(String key){
        Node curr = root;
        for(int i=0;i<key.length();i++){
            int indx = key.charAt(i) - 'a';
            if(curr.children[indx] == null){
                return false;
            }
            if(i==key.length()-1 && curr.children[indx].eow == false){
                return false;
            }
            curr = curr.children[indx];
        }
        return true;
    }


    // public static boolean WordBreak(String key){
    //     if(key.length()==0){
    //         return true;
    //     }
    //     for(int i=1;i<=key.length();i++){
    //         String firstPart = key.substring(0, i);
    //         String secondPart = key.substring(i);
    //         if(search(firstPart) && WordBreak(secondPart)){
    //             return true;
    //         }

    //     }
    //     return false;
    // }

    // public static boolean StartsWith(String prefix){
    //     Node curr = root;
    //     for(int i=0;i<prefix.length();i++){
    //         int indx = prefix.charAt(i) - 'a';

    //         if(curr.children[indx] == null){
    //             return false;
    //         }
    //         curr = curr.children[indx];
    //     }
    //     return true;
    // }

    // public static int countNodes(Node root){
    //     if(root == null) return 0;
    //     int count = 0;
    //     for(int i=0;i<26;i++){
    //         if(root.children[i]!=null) count += countNodes(root.children[i]);
    //     }
    //     return count+1;
    // }

    public static String ans = " ";
    public static void longestWord(Node root , StringBuilder temp){
        Node curr = root;
        if(root == null) return;
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null && curr.children[i].eow == true){
                temp.append((char)('a'+i));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(curr.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {

        // String words[] = {"i","like","sam","samsung","mobile","ice"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // String str = "ababa";
        // for(int i=0;i<str.length();i++){
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countNodes(root));
        
        // System.out.println(WordBreak("ilikesung"));
        // System.out.println(StartsWith("moon"));
        
        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
}
