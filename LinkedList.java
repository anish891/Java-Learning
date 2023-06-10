public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }  // single node will be created 
    public static Node head;
    public static Node tail;
    public static int size;

    // Methods on LinkesList
    // adding first in a Linked List
    public void addFirst(int data){
        // step 1 - Create New Node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        // step 2 - newNode next = head
        newNode.next = head;  // link

        // step 3 - head = newNode
        head = newNode;
    }    
    // adding last in a Linked List
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }
    // Printing a Linked List
    public void print(){
        if(head == null){
            System.out.println("null");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // Add in the middle of a Linked List
    public void add(int index, int data) {
        if(index ==0 ){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < index-1){
            temp = temp.next;
            i++;
        }
        // i = index-1; temp-> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }
    // remove First Element from a LinkedList
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }
    // remove last Element from Linked List
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size ==1 ){
            int value = head.data;
            head = tail = null;
            size = 0;
        }
        // prev : i = size-2
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int value = prev.next.data;  // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return value;
    }

    // Iterative Serach
    public int iterativeSearch(int key){  // O(n) - Time Complexity
        Node temp = head;
        int index = 0;

        while(temp != null){
            if(temp.data == key){  // key found
                return index;
            }
            temp = temp.next;
            index++;
        }
        // key not found
        return -1;
    }

    // Recursive Search
    public int helperforRecurscieSearch(Node head, int key){  // Actual Recursice Function
        if(head == null){    // O(n) time complexity
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int index = helperforRecurscieSearch(head.next, key);
        if(index == -1){
            return -1;
        }

        return index+1;
    }
    public int recursiveSearch(int key){
        return helperforRecurscieSearch(head, key);
    }

    // Reversing a Linked List
    public void reverse(){   // O(n) - Time Complexity
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Delete nth Node from end
    public void deleteNthNodeFromEnd(int n){
        // calculate size of LinkedList
        int size = 0;
        Node temp = head;
        while(temp != null){  // for calculating size
            temp = temp.next;
            size++;
        }
        if(n == size){
            head = head.next; // remove first
            return;
        }
        // size - n
        int index = 1;
        int indexToFind = size-n;
        Node prev = head;
        while(index < indexToFind){
            prev = prev.next;
            index++;
        }
        prev.next = prev.next.next;
        return;
    }
    // For finding Middle of LinkedList using Slow-Fast Approach
    public Node findMid(Node head) {  // helper
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;   // +1
            fast = fast.next.next;   // +2
        }
        return slow;    // Slow is my Middle Node
    }

    // For checking if a LinkedList is Palindrome or not
    public boolean checkPalindrome(){
        // base case
        if(head == null || head.next == null){
            return true;
        }
        // step1 - find mid
        Node midNode = findMid(head);    // Using Helper Function

        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  // right half head
        Node left = head;   // left half head

        // step3 - check left half & right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // detecting a Cycle in a LinkedList
    public static boolean isCycle() {   // Floyd's Cycle finding
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;  //+1
            fast = fast.next.next;  //+2
            if(slow == fast){
                return true;  // cycle exists
            }
        }
        return false;
    }

    // remove cycle
    public static void removeCycle(){
       // detect cycle
       Node slow = head;
       Node fast = head;
       boolean cycle = false;
       while(fast != null && fast.next != null){
        slow = slow.next;
        fast= fast.next.next;
        if(fast == slow){
            cycle = true;
            break;
        }
       }
       if(cycle == false){
        return;
       }
       // find meeting point
       slow= head;
       Node prev = null;  // last node       
       while(slow!= fast){
        prev = fast;
        slow = slow.next;
        fast= fast.next;
       }

       // remove cycle
       prev.next = null;
    }

    private Node getMid(Node head){  // helper for merge sort
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;  // mid node
    }

    private Node merge(Node head1, Node head2){  // helper for merge sort
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else{
               temp.next = head2; 
               head2= head2.next;
               temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2; 
            head2= head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    // merge sort on LL
    public Node mergeSort(Node head) {
    if(head == null || head.next == null){
         return head;
    }
    // find mid 
    Node mid = getMid(head);
    // left & right merge sort - recursion
    Node rightHead = mid.next;
    mid.next = null;
    Node newLeft = mergeSort(head);
    Node newRight = mergeSort(rightHead);
    // merge
    return merge(newLeft, newRight);
    }

    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        // alternate merging
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);

        // ll.print();
        // ll.addFirst(2);
        // ll.print();
        // ll.addFirst(1);
        // ll.print();
        // ll.addLast(4);
        // ll.print();
        // ll.addLast(5);
        // ll.print();
        // ll.add(2, 3);
        // ll.print();  


        // System.out.println(ll.size);


        // ll.removeFirst();
        // ll.print();


        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);

        // System.out.println(ll.iterativeSearch(3));

        // System.out.println(ll.recursiveSearch(5));

        // ll.reverse();
        // ll.print();

        // ll.deleteNthNodeFromEnd(3);
        // ll.print();

        // Making a new LL for checking whether it is Plindrome or not
        // ll.addLast(1);
        // ll.addLast(2);
        // // ll.addLast(2);
        // ll.addLast(1);

        // ll.print();
        // System.out.println(ll.checkPalindrome());

        // detecting cycle
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1->2->3->1
        // System.out.println(ll.isCycle());

        // removeCycle();
        // System.out.println(isCycle());

        // merge sort on Linked List
        LinkedList ll =new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        // zig zag linkedlist
        ll.print();
        ll.zigZag();
        ll.print();
    }
}

// LL using Collections framework

// create - object - use classes
// LinkedList<Integer> ll = new LinkedList<>();

// // add
// ll.addLast(1);
// ll.addLast(2);
// ll.addFirst(0);
// // 0->1->2
// System.out.println(ll)

// // remove
// ll.removeLast();
// ll.removeFirst();