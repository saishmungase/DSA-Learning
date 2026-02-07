import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoBFS {

    static class Edge{
        int src;
        int dst;
        Edge(int src, int dst){
            this.src = src;
            this.dst = dst;
        }
    }

    public static void inDegCalc(ArrayList<Edge> graph[], int indeg[]){
        for(int i = 0; i < graph.length; i++){
            for(Edge e : graph[i]){
                int dst = e.dst;
                indeg[dst] += 1;
            }
        }
    }

    public static void topoBFS(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        inDegCalc(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            for(Edge val : graph[curr]){
                int dst = val.dst;
                indeg[dst]--;
                if(indeg[dst] == 0){
                    q.add(dst);
                }
            }
            System.out.print(curr + " ");
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        int v = graph.length;
        for(int i = 0; i < v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topoBFS(graph);
    }
}
