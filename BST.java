import java.util.*;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    // build a BST
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            // left Subtree
            root.left = insert(root.left, val);
        }

        if(root.data < val){
            // right Subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    //InOrder
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //Search in a BST
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        }

        else{
            return search(root.right, key);
        }
    }


    // Delete Node in a BST
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{ // voila
            //case 1 - leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2 - single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3 - both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
           }
           return root;
    }
    // helper function for delete function
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }


    // print in Range
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }


    // Root to Leaf path
    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }
    // function for root to leaf path
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }


    //Validate a BST 
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }

        if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }


    //Mirror a BST
    public static Node createMirror(Node root){
        if(root == null){
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
    //preorder
    public static void preorder(Node root){  // O(n)
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }


    // Convert Sorted Array to Balanced BST
    public static Node creaBST(int arr[], int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = creaBST(arr, st, mid-1);
        root.right = creaBST(arr, mid+1, end);
        return root;
    }

    

    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }


    // function for Bst to balanced BST
    public static Node createBst(ArrayList<Integer> inorder, int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBst(inorder, st, mid-1);
        root.right = createBst(inorder, mid+1, end);
        return root;
    }
    // Convert BST to balanced BST
    public static Node balancedBST(Node root){
        //inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder -> balanced BST
        root = createBst(inorder, 0, inorder.size()-1);
        return root;
    }


    // Size of largest BST in BT
    // Solved Seperately


    // Merge 2 BSTs
    public static Node mergeBSTs(Node root1, Node root2){
        // step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //merge arr1 and arr2
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            } else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
                i++;
        }

        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
                j++;
        }

        // step4 sortedAl -> Balanced Bst
        return createBst(finalArr, 0, finalArr.size()-1);

    }




    public static void main(String[] args) {
        //Build a BST
        // int values[] = {8, 5, 10, 3, 6, 11};
        // Node root = null;

        // for(int i=0;i<values.length;i++){
        //     root = insert(root, values[i]);
        // }

        // inorder(root);
        // System.out.println();


        // Search in a BST
        // if(search(root, 1)){
        //     System.out.println("found");
        // } else{
        //     System.out.println("not found");
        // }


        //Delete in a BST
        // root = delete(root, 1);
        // System.out.println();

        // inorder(root);


        //Print in Range
        // printInRange(root, 5, 12);

        
        //Root to Leaf path
        // printRootToLeaf(root, new ArrayList<>());


        // Validate BST
        // if(isValidBST(root, null, null)){
        //     System.out.println("valid");
        // } else{
        //     System.out.println("not valid");
        // }


        // Mirror a BST
        // root = createMirror(root);
        // preorder(root);


        //Convert Sorted Array to Balanced BST
        // int arr[] = {3, 5, 6, 8, 10, 11, 12};
        // Node root = creaBST(arr, 0, arr.length-1);
        // preorder(root);


        // Convert BST to Balanced BST
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);

        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // root = balancedBST(root);
        // preorder(root);


        //Merge 2 BSTs
        //BST1 
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        //BST2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);
        preorder(root);


        }
    }