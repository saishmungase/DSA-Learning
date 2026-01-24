import java.util.*;

public class CycleDetectInDirected {

    static class Edge{
        int src;
        int dst;

        Edge(int src, int dst){
            this.src = src;
            this.dst = dst;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        int v = graph.length;
        for(int i = 0; i < v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));

    }

    public static boolean isCyclic(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(isCyclicUtil(graph, i, vis, stack)) return true;
            }
        }
        return false;
    }

    public static boolean isCyclicUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]){

        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            int dst = graph[curr].get(i).dst;
            if(stack[dst]){
                return true;
            }

            if(!vis[dst] && isCyclicUtil(graph, dst, vis, stack)){
                return true;
            }

        }

        stack[curr] = false;

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCyclic(graph));
    }
}
