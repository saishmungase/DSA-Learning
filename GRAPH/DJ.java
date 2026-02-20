import java.util.*;

public class DJ {

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


    static int dist[] = new int[6];
    
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static void dj(ArrayList<Edge>[] graph, int src, int dst){
        if(src == dst){
            return;
        }

        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            dist[e.dest] = Math.min(dist[e.dest], dist[src] + e.wt);
            dj(graph, e.dest, dst);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        createGraph(graph);
        dist[0] = 0;
        dj(graph, 0, 5);
        System.out.println(dist[5]);
    }
}
