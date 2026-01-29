import java.util.*;

public class TopologicalSort {

    static class Edge{

        int src;
        int dst;

        Edge(int src, int dst){
            this.src = src;
            this.dst = dst;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }


    public static void bfs(ArrayList<Edge>[] graph, int src, boolean vis[], Stack<Integer> st){

        ArrayList<Edge> g = graph[src];
        vis[src] = true;
        for(Edge e : g){
            int dst = e.dst;
            if(!vis[dst]){
                bfs(graph, dst, vis, st);
            }
        }

        st.push(src);
    }


    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];

        Arrays.fill(vis, false);

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < vis.length; i++){
            if(!vis[i]){
                bfs(graph, i, vis, st);
            }
        }

        while (!st.empty()) {
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph);
        
    }
}
