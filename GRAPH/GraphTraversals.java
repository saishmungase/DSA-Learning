import java.util.*;

public class GraphTraversals {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void BFS(ArrayList<Edge> graph[]){ // O(V + E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int val = q.remove();
                if(vis[val]) continue;
                vis[val] = true;

                for(int p = 0; p < graph[val].size(); p++){
                    int valToAdd = graph[val].get(p).dest;
                    q.add(valToAdd);
                }
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void DFS(ArrayList<Edge> graph[], int i, boolean dfsVis[]){ // O(V + E)
        int size = graph[i].size();
        dfsVis[i] = true;
        System.out.print(i + " ");
        for(int p = 0; p < size; p++){
            int dest = graph[i].get(p).dest;
            if(!dfsVis[dest]){
                DFS(graph, dest, dfsVis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("BFS:-");
        BFS(graph);
        System.out.println("DFS:-");
        DFS(graph, 0, new boolean[V]);
    }
}
