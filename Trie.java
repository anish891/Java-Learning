public class Trie {

    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }



    public static Node root = new Node();




    public static void insert(String word){   //O(L)
        Node curr = root;
        for(int level=0; level<word.length();level++){
            int index = word.charAt(level) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.eow = true;
    }




    public static boolean search(String key){    //O(L)
        Node curr = root;
        for(int level=0; level<key.length();level++){
            int index = key.charAt(level) - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }
        return curr.eow = true;
    }





    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            //substring(beg idx, last idx)
            if(search(key.substring(0, i)) &&
                wordBreak(key.substring(i))){
                    return true;
                }
        }
        return false;
    }








    //Prefix Problem
    static class Node1{
        Node1[] children = new Node1[26];
        boolean eow;
        int freq;

        public Node1(){
            for(int i=0;i<children.length;i++){
                children[i] = null;
            }
            freq =1;
        }
    }
    public static Node1 root1 = new Node1();


    public static void insert1(String word){
        Node1 curr1 = root1;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr1.children[idx] == null){
                curr1.children[idx] = new Node1();
            } else{
                curr1.children[idx].freq++;
            }

            curr1 = curr1.children[idx];
        }
        curr1.eow = true;
    }

    public static void findPrefix(Node1 root1, String ans){ //O(L) longest word
        if(root1 == null){
            return;
        }
        if(root1.freq == 1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root1.children.length;i++){
            if(root1.children[i] != null){
                findPrefix(root1.children[i], ans+(char)(i+'a'));
            }
        }
    }








    // startsWith problem
    public static boolean startsWith(String prefix){
        Node curr = root;

        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }







    // Count Unique Substrings
    // count Nodes
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
    }





    // Longest Word with all Prefixes
    public static  String ans = "";
    public static void longetsWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }
        
        for(int i=0;i<26;i++){
            if(root.children[i] != null && root.children[i].eow == true){
            char ch = (char)(i+'a');
            temp.append(ch);
            if(temp.length() > ans.length()){
                ans = temp.toString();
            }
            longetsWord(root.children[i], temp);
            temp.deleteCharAt(temp.length()-1);//backtrack

            }
        }
    }



    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }

        // System.out.println(search("thee"));
        // System.out.println(search("thor"));


        // String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for(int i=0;i<arr.length;i++){
        //     insert(arr[i]);
        // }

        // String key = "ilikesamsung";
        // System.out.println(wordBreak(key));



        // Prefix Problem
        // String arr[] = {"zebra", "dog", "duck","dove"};
        // for(int i=0;i<arr.length;i++){
        //  insert1(arr[i]);   
        // }
        // root1.freq = -1;
        // findPrefix(root1, "");





        // startsWith problem
        // String words[] = {"apple", "app", "mango", "man", "woman"};
        // String prefix1= "app";
        // String prefix2= "moon";
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));






        // Count Unique SubStrings
        // String str = "ababa";
        // //suffix -> insert in trie
        // for(int i=0;i<str.length();i++){
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countNodes(root));







        // Longest Word with all Prefixes
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longetsWord(root, new StringBuilder(""));
        System.out.println(ans);


    }
}
