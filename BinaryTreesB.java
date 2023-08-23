import java.util.*;
import java.util.LinkedList;

public class BinaryTreesB {
    
    // Build Tree PreOrder
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int index =-1;
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }


        // PreOrder Traversal
        public static void preorder(Node root){  // O(n)
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }


        // InOrder Traversal
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        // PostOrder Traversal
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        // LevelOrder Traversal
        public static void  levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node currentNode = q.remove();
                if(currentNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else{
                        q.add(null);
                    }
                } else{
                    System.out.print(currentNode.data+" ");
                    if(currentNode.left != null){
                        q.add(currentNode.left);
                    }
                    if(currentNode.right != null){
                        q.add(currentNode.right);
                    }
                }
            }
        }
    }

    // Height of a Tree
    public static int height(Node root) {
        if(root == null){
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight, rightheight) + 1;
    }

    // Count of no of nodes of a tree
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount+rightCount+1;
    }

    // Sum of all Nodes
    public static int SumOfAllNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = SumOfAllNodes(root.left);
        int rightSum = SumOfAllNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    //Diameter of a Tree(Approach 1)
    public static int diameter1(Node root){   // O(n^2)
        if(root == null){
            return 0;
        }
        int leftDiameter = diameter1(root.left);
        int leftHeight = height(root.left);
        int rightDiameter = diameter1(root.right);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.min(rightDiameter, leftDiameter));
    }

    //Diameter of a Tree(Approach 2)
    static class Info{
        int diam;
        int ht;
        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter(Node root){   // O(n)
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    //SubTree of another Tree
    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    // top view of a Tree
    static class Info1 {
        Node node;
        int hd;

        public Info1(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        // Level Order
        Queue<Info1> q =  new LinkedList<>();
        HashMap<Integer, Node>  map = new HashMap<>();

        int min = 0 , max =0;
        q.add(new Info1(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info1 curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
            } else{
                if(!map.containsKey(curr.hd)) {  // first time hd is occcuring
                map.put(curr.hd, curr.node);
            }

            if(curr.node.left != null){
                q.add(new Info1(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }

            if(curr.node.right != null){
                q.add(new Info1(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
            }
        }
        // printing top view
        for(int i = min;i<= max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
        
    }

    // Kth level of a Tree
    public static void KLevel(Node root, int level, int k){
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.data+" ");
            return;
        }

        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    // Kth ancestor of Node
    public static int KAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDistance = KAncestor(root.left, n, k);
        int rightDistance = KAncestor(root.right, n, k);

        if(leftDistance == -1 && rightDistance == -1){
            return -1;
        }

        int max = Math.max(leftDistance, rightDistance);
        if(max+1 == k){
            System.out.println(root.data);
        }

        return max+1;
    }

    // Transform to Sum Tree
    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }
    // for priting tree of Transform function
    public static void preorder(Node root){  // O(n)
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
    }


    // function for Lowest Commom Ancestor Appraoch1
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }
    // Lowest Commom Ancestor Appraoch1     // O(n)
    public static Node LowestCommonAncestor(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i =0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        // last equal node -> (i-1)th
        
        Node lca = path1.get(i-1);

        return lca;
    }

    // Lowest Commom Ancestor Appraoch2 
    public static Node LowestCommonAncestor_Approch2(Node root, int n1, int n2){
        
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = LowestCommonAncestor_Approch2(root.left, n1, n2);
        Node rightLca = LowestCommonAncestor_Approch2(root.right, n1, n2);

        // leftLCA=valid rightLca=null
        if(rightLca == null){
            return leftLca;
        }
        if(leftLca == null){
            return rightLca;
        }

        return root;
    }

    // Minimum Distance between nodes
    //Helper function for Minimum Distance
    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        } else if(leftDist == -1){
            return rightDist+1;
        } else{
            return leftDist+1;
        }

    }
    public static int minimumDistance(Node root, int n1, int n2){
        Node lca = LowestCommonAncestor_Approch2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2); 

        return dist1 + dist2;
    }


    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // printing PreOrder
        // tree.preorder(root);
    
        //printing InOrder
        // tree.inorder(root);

        // printing PostOrder
        // tree.postorder(root);

        //printing LevelOrder
        // tree.levelOrder(root);

        //Height of a Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(height(root));

        // Count of nodes of a tree
        // System.out.println(count(root));

        // Sum of nodes of a Tree
        // System.out.println(SumOfAllNodes(root));

        // diameter of a tree(Approach 1)
        // System.out.println(diameter1(root));

        // diameter of a tree(Approach 2)
        // System.out.println(diameter(root).diam);   
        // System.out.println(diameter(root).ht);

        // Subtree of Another Tree
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // System.out.println(isSubtree(root, subRoot));

        //Top View of a Tree
        // topView(root);

        // Kth level of a Tree
        // int k = 2;
        // KLevel(root, 1, k);

        // Kth ancestor of node
        // int n=5, k=2;
        // KAncestor(root, n, k);

        // Transform to Sum Tree
        // transform(root);
        // preorder(root);

        // Lowest Commom Ancestor Appraoch1
        // int n1 = 4, n2 = 5;
        // System.out.println(LowestCommonAncestor(root, n1, n2).data);

        // Lowest Commom Ancestor Appraoch2
        // int n1 = 4, n2 = 7;
        // System.out.println(LowestCommonAncestor_Approch2(root, n1, n2).data);

        // Minimum Distance between nodes
        int n1 = 4, n2 = 6;
        System.out.println(minimumDistance(root, n1, n2));

    }
}
