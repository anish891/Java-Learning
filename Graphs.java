import java.util.*;
import java.util.LinkedList;

public class Graphs {
    static class Edge {
        int src; 
        int dest;
        int weight;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }


    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));

        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));

        // graph[6].add(new Edge(6, 5));



        // graph[0].add(new Edge(0, 3));

        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 1));
        
        // graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));

        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));






        // graph for Dijkstra's Algorithm
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));





        // graph for Bellman Ford Algorithm
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, -4));

        // graph[2].add(new Edge(2, 3, 2));

        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));




        // graph for Prim's Algorithm
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));


    }

    // graph for Bellman Ford 
    static void createGraph2(ArrayList<Edge> graph){
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }







    //function for BFS
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }


    //function for BFS
    public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]){   // O(n)
        Queue<Integer> q = new LinkedList<>();
        q.add(0);   // source=0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]){  // visit curr
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }




    // function for dfs
    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            dfsUtil(graph, i, vis);
        }
    }


    // function for dfs
    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]){
        // visit
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }



    // hasPath    // O(V+E)
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]){
        if(src == dest){
            return true;
        }

        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }





    //Cycle Detection in Graph Using DFS
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){
                    return true; 
                    //cycle exists in one the parts
                }
            }
        }
        return false;
    }

    //Cycle Detection in Graph Using DFS
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int parent){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //case3
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            //case1
            else if(vis[e.dest] && e.dest != parent){
                return true;
            }
            //case2 -> do nothing -> continue  //hence notinh written foe case2
        }
        return false;
    }








    // isBipartite 
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i] = -1;     // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(col[i] == -1){   // BFS
                q.add(i);
                col[i] = 0;  //yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(col[e.dest] == col[curr]){
                            return false;   //NOT bipartite
                        }
                    }
                }
            }
        }
        return true;
    }








    // Cycle Detection using DFS(improvised for Directed Graph)
    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph, i, vis, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    // Cycle Detection using DFS Utility (improvised for Directed Graph)
    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!stack[e.dest]){  // cycle
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }






    // Topological Sort using DFS
    public static void topSort(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis, s);   // modified DFS
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }
    // Topological Sort Utility using DFS 
    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }







    // Topological Sort using BFS
    //calcualte Indegree
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for(int i=0;i<graph.length;i++){
            int v = i;
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    // Topological Sort using BFS
    public static void topSortusingBFS(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");    // topological sort print

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }








    // All Paths from Source to Target     //O(V^V)
    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path){
        if(src == dest){
            System.out.println(path+dest);
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src);
        }
    }






    // Pairs for Dijkstra's Algorithm
    // static class Pair implements Comparable<Pair>{
    //     int n;
    //     int path;

    //     public Pair(int n, int path) {
    //         this.n = n;
    //         this.path = path;
    //     }

    //     @Override
    //     public int compareTo(Pair p2) {
    //         return this.path - p2.path;  //path based sorting for my pairs
    //     }
    // }

    // Dijkstra's Algorithm  // TC - O(V + ElogV)
    public static void dijkstra(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];   // dist[i] -> src to i
        for(int i=0;i<graph.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;   //+infinity
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        // loop for BFS
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if(dist[u]+wt < dist[v]){  //update dist of src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        //print all source to vertices shortest distance
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }







    // Bellman Ford ALgorithm
    public static void bellmanFord(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        //algo
        for(int i=0;i<V-1;i++){
            //edges - O(E)
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    //u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    //relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        //print
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }




    // Bellman Ford2 ALgorithm
    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V){
        int dist[] = new int[V];
        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //algo
        for(int i=0;i<V-1;i++){
            //edges - O(E)
            for(int j=0;j<graph.size();j++){
                    Edge e = graph.get(j);
                    //u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    //relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }

        //print
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }





    //Pair for Prim's Algorithm
    static class Pair implements Comparable<Pair>{
        int v;  //vertex
        int cost;

        public Pair(int v, int c){
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;    //ascending
        }

    }
    //Prim's Algorithm
    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;   // MST Cost // total Min Weight 

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.weight));
                }
            }
        }
        System.out.println("Final Cost of MST is "+finalCost);
    }



    // Cheapest Flight within K Stops
    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s){
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k){
                break;
            }

            for(int i=0;i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;

                if(curr.cost+wt < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        //dist[dest]
        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        } else{
            return dist[dest];
        }
    }


    public static void main(String[] args) {
        // Creating a Grraph
        // int V = 5;
        // ArrayList<Edge>[] graph = new ArrayList[V];   // null -> empty arraylist

        // for(int i=0;i<V;i++){
        //     graph[i] = new ArrayList<>();
        // }

        // //0 - vertex
        // graph[0].add(new Edge(0, 1, 5));

        // //1 - vertex
        // graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));

        // //2 - vertex
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 4));

        // //3 - vertex
        // graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 2, 1));

        // //4 - vertex
        // graph[4].add(new Edge(4, 2, 2));

        // //2's neighbors
        // for(int i=0; i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);    //src, dest, wt
        //     System.out.println(e.dest);
        // }






        //BFS
        // int V = 7;
        // int V = 6;
        // int V = 5;
        // int V = 4;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);




        // bfs(graph);
        // System.out.println();
        // dfs(graph, 0, new boolean[V]);

        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));

        // Cycle Cetection using DFS
        // System.out.println(detectCycle(graph));


        //isBipartite
        // System.out.println(isBipartite(graph));


        // Cycle Detection using DFS(improvised for Directed Graph)
        // System.out.println(isCycle(graph));


        // Topological Sort using DFS
        // topSort(graph);


        // Topological Sort using BFS
        // topSortusingBFS(graph);


        // All Paths from source to Target
        // int src = 5, dest = 1;
        // printAllPath(graph, src, dest, "");



        // Dijkstra's Algorithm
        // int src = 0;
        // dijkstra(graph, src);


        // Bellman Ford Algorithm
        // bellmanFord(graph, 0);

        // BellmaN ford using an ArayList
        // ArrayList<Edge> edges = new ArrayList<>();
        // createGraph2(edges);
        // bellmanFord2(edges, 0, V);



        // Prim's Algorithm
        //    prims(graph); 



        //Cheapest Flights Within K Stops
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dest = 3, k = 1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));

        



    }
}
