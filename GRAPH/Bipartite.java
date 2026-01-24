import java.util.*;

public class Bipartite {

    static class Node{
        int src;
        int dst;
        Node(int src, int dst){
            this.src = src;
            this.dst = dst;
        }
    }

    public static void createGraph(ArrayList<Node> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Node(0, 1));
        graph[0].add(new Node(0, 5));

        
        graph[1].add(new Node(1, 0));
        graph[1].add(new Node(1, 2));

        
        graph[2].add(new Node(2, 1));
        graph[2].add(new Node(2, 3));
        
        graph[3].add(new Node(3, 2));
        graph[3].add(new Node(3, 4));
        
        graph[4].add(new Node(4, 3));
        graph[4].add(new Node(4, 5));
        
        graph[5].add(new Node(5, 4));
        graph[5].add(new Node(5, 0));
        
    }

    public static boolean isBipartite(ArrayList<Node> graph[]){

        int N = graph.length;
        int col[] = new int[N];
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j = 0; j < graph[curr].size(); j++){
                        Node edge = graph[curr].get(j);
                        if(col[edge.dst] == -1){
                            col[edge.dst] = (col[curr] == 0) ? 1 : 0;
                            q.add(edge.dst);
                        }
                        else if(col[edge.dst] == col[curr]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Node> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
