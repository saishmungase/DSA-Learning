import java.util.ArrayList;

public class HasPath {
    
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


    public static boolean hasPath(ArrayList<Edge> graph[], int curr, int dest, boolean visited[]){

        if(curr == dest) return true;

        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            int nextV = graph[curr].get(i).dest;
            if(!visited[nextV]){ 
                return hasPath(graph, nextV, dest, visited);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean exist = hasPath(graph, 0, 5, new boolean[V]);
        if(exist){
            System.out.println("Path Exist");
        }
        else{
            System.out.println("Path Does not Exist");
        }
    }
}
