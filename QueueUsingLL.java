static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queue {
        static Node head = null;
        static Node tail = null;

        // isEmpty function
        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        // add function
        public static void add(int data){
            Node newNode = new Node(data);
            if(head == null){
               head = tail = newNode;
               return; 
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove function
        public static int remove() {
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            
            int front = head.data;
            // single element 
            if(tail == head){
                tail = head = null;
            } else{
                head = head.next;
            }
            return front;
        }

        // peek function
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }
    }
