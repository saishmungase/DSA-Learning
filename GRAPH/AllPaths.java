import java.util.*;

public class AllPaths {

    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void print(String path, int dst){
        System.out.println(path+dst);
    }

    public static void printAll(ArrayList<Edge>[] graph, int src, int dst, String path){
        if(src == dst){
            print(path, dst);
            return;
        }
        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            printAll(graph, e.dest, dst, path+src);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Checking path");
        printAll(graph, 5, 1, "");
    }
}
