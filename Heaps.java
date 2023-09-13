import java.util.*;

import javax.print.attribute.PrintRequestAttribute;

public class Heaps {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            // add at last index
            arr.add(data);

            int x = arr.size()-1;  //x is child index
            int parent = (x-1)/2;   // parent index

            while(arr.get(x) < arr.get(parent)){   // O(logn)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int index) {   // For remove function  //O(logn)
            int left = 2*index+1;
            int right = 2*index+2;
            int minIndex = index;

            if(left < arr.size() && arr.get(minIndex) > arr.get(left)){
                minIndex = left;
            }

            if(right < arr.size() && arr.get(minIndex) > arr.get(right)){
                minIndex = right;
            } 

            if(minIndex != index){
                //swap
                int temp = arr.get(index);
                arr.set(index, arr.get(minIndex));
                arr.set(minIndex, temp);

                heapify(minIndex);
            }
        }

        public int remove() {   //O(logn)
            int data = arr.get(0);

            //step-1 - swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step-2 - delete last
            arr.remove(arr.size()-1);

            //step-3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }



    public static void heapifyForHeapSort(int arr[], int i, int size){
            int left = 2*i +1;
            int right = 2*i +2;
            int maxIndex = i;

            if(left < size && arr[left] > arr[maxIndex]){
                maxIndex = left;
            }

            if(right < size && arr[right] > arr[maxIndex]){
                maxIndex = right;
            }

            if(maxIndex != i){
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;

                heapifyForHeapSort(arr, maxIndex, size);
            }
        }

        public static void heapSort(int arr[]){
            //step-1 - build maxHeap
            int n = arr.length;
            for(int i=n/2; i>=0;i--){
                heapifyForHeapSort(arr, i, n);
            }

            //step-2 - push largest at end
            for(int i=n-1;i>0;i--){
                //swap
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapifyForHeapSort(arr, 0, i);
            }
        }


        // Nearby Cars
        static class Point implements Comparable<Point>{
            int x;
            int y;
            int distSq;
            int index;

            public Point(int x, int y, int distSq, int index){
                this.x = x;
                this.y = y;
                this.distSq = distSq;
                this.index = index;
            }
            @Override
            public int compareTo(Point p2){
                return this.distSq - p2.distSq;    // ascending order
            }

        }





        // Weakest Soldier
        static class Row implements Comparable<Row> {
            int soldiers; 
            int index;

            public Row(int soldiers, int index){
                this.soldiers = soldiers;
                this.index = index;
            }

            @Override
            public int compareTo(Row r2){
                if(this.soldiers == r2.soldiers){
                    return this.index - r2.index;
                } else{
                    return this.soldiers - r2.soldiers;
                }
            }
        }



        
        // SLiding Window Maximum
        static class Pair implements Comparable<Pair>{
            int val;
            int index;

            public Pair(int val, int index){
                this.val = val;
                this.index = index;
            }

            @Override
            public int compareTo(Pair p2) {
                // ascending
                // return this.val -p2.val;
                // descending
                return p2.val - this.val;
            }
        }




    public static void main(String[] args) {
        // Heap h = new Heap();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);

        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }



        //Heap Sort
        // int arr[] = {1, 2, 4, 5, 3};
        // heapSort(arr);
        // // print
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();





        // Nearby Cars
        // int points[][] = {{3, 3}, {5, -1}, {-2, 4}};
        // int k = 2;

        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for(int i=0; i<points.length; i++){
        //     int distSq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        //     pq.add(new Point(points[i][0], points[i][1], distSq, i));
        // }
        // //nearest K
        // for(int i=0;i<k;i++){
        //     System.out.println("C"+pq.remove().index);
        // }

        

        

        // Connect N Ropes
        // int ropes[] = {2, 3, 3, 4, 6};
        
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i=0; i<ropes.length;i++){
        //     pq.add(ropes[i]);
        // }

        // int cost = 0;
        // while(pq.size() > 1){
        //     int min = pq.remove();
        //     int min2 = pq.remove();
        //     cost += min + min2;
        //     pq.add(min+min2);
        // }
        // System.out.println("cost of connecting n ropes = "+cost);





        //Weakest Soldier
        // int army[][] = {{1, 0, 0, 0},
        //                 {1, 1, 1, 1},
        //                 {1, 0, 0, 0},
        //                 {1, 0, 0, 0}};
        // int k = 2;

        // PriorityQueue<Row> pq = new PriorityQueue<>();

        // for(int i=0;i<army.length;i++){
        //     int count = 0;
        //     for(int j=0; j<army[0].length;j++){
        //        count += army[i][j] == 1 ? 1 : 0; 
        //     }
        //     pq.add(new Row(count, i));
        // }

        // for(int i=0; i<k;i++){
        //     System.out.println("R"+pq.remove().index);
        // }





        // Sliding Window Maximum
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int result[] = new int [arr.length-k+1];   // n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window
        for(int i = 0; i<k;i++){
            pq.add(new Pair(arr[i], i));
        }

        result[0] = pq.peek().val;

        for(int i = k;i<arr.length;i++){
            while(pq.size() > 0 && pq.peek().index <= (i-k)){
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            result[i-k+1] = pq.peek().val;
        }
        // print result
        for(int i=0; i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}