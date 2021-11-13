///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 442, NAME: Searching the Graph //////////
/// link: https://pl.spoj.com/problems/TDBFS //////////
/// TIME RESULT FOR THIS SOLUTION = 0,94s /////////////
/// USAGE: BFS, DFS ///////////////////////////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchingTheGraph {
    private static StringBuilder strb;

    static class Graph {
        private int vertices;
        private List<Integer>[] adjacencyList;
        private boolean[] visited;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.visited = new boolean[vertices];
            this.adjacencyList = (List<Integer>[]) new List[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new ArrayList<Integer>();
            }
        }

        public void addEdge(int v, int w) {
            adjacencyList[v].add(w);
        }

        public Iterable<Integer> getAdjacencyList(int v) {
            return adjacencyList[v];
        }

        public void breadthFirstSearch(int vertex) {
            strb.append(vertex + 1).append(" ");
            clearVisited();
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[vertex] = true;
            queue.add(vertex);
            while (queue.size() != 0) {
                vertex = queue.poll();
                for (int n : adjacencyList[vertex]) {
                    if (!visited[n]) {
                        strb.append(n + 1).append(" ");
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

        public void depthFirstSearch(int vertex) {
            strb.append(vertex + 1).append(" ");
            visited[vertex] = true;
            for (int w : getAdjacencyList(vertex)) {
                if (!visited[w]) {
                    depthFirstSearch(w);
                }
            }
        }

        public void clearVisited() {
            this.visited = new boolean[vertices];
        }
    }

    private static class Reader {
        private final int BUFFER_SIZE = 1 << 32;
        private DataInputStream din;
        private byte[] buffer;
        private int pointer, bytesRead;

        public Reader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[BUFFER_SIZE];
            this.pointer = 0;
            this.bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, pointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bytesRead == pointer) fillBuffer();
            return buffer[pointer++];
        }

        private int nextInt() throws IOException {
            int number = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                number = number * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -number : number;
        }
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);

        int tests = reader.nextInt();
        Graph[] graphs = new Graph[tests];
        for (int t = 0; t < tests; t++) {
            strb = new StringBuilder();
            int vertices = reader.nextInt();
            graphs[t] = new Graph(vertices);

            for (int i = 0; i < vertices; i++) {
                int vertex = reader.nextInt() - 1;
                int numberOfAdjacency = reader.nextInt();
                while (numberOfAdjacency-- > 0) {
                    graphs[t].addEdge(vertex, reader.nextInt() - 1);
                }
            }
            // test for graphs
            strb.append("\ngraph ").append(t + 1).append("\n");
            int vertexToStart = reader.nextInt() - 1;
            int kindOfMethod = reader.nextInt(); // 0 -> DFS, 1 -> BFS
            while (!(vertexToStart == -1 && kindOfMethod == 0)) {
                if (kindOfMethod == 0) {
                    graphs[t].clearVisited();
                    graphs[t].depthFirstSearch(vertexToStart);
                }
                if (kindOfMethod == 1) {
                    graphs[t].breadthFirstSearch(vertexToStart);
                }
                vertexToStart = reader.nextInt() - 1;
                kindOfMethod = reader.nextInt();
                strb.append("\n");
            }
            out.write(strb.toString().getBytes());
            out.flush();
        }

    }
}
