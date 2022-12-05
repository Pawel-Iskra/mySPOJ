///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 3400, NAME: DIJKSTRA ////////////////////
/// link: https://pl.spoj.com/problems/DIJKSTRA/ //////
/// TIME RESULT FOR THIS SOLUTION =       /////////////
/// USAGE: Dijkstra algorithm /////////////////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class DIJKSTRA {

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

    static class DirectedEdge {
        private int from;
        private int to;
        private int weight;

        public DirectedEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return String.format("%d -> %d (%d)", from, to, weight);
        }
    }

    static class DirectedGraph {
        private int vertices;
        private int edges;
        private List<DirectedEdge>[] directedEdgesList;

        public DirectedGraph(int vertices) {
            this.vertices = vertices;
            this.edges = 0;
            this.directedEdgesList = new List[vertices];
            for (int i = 0; i < vertices; i++) {
                directedEdgesList[i] = new ArrayList<>();
            }
        }

        public int getVertices() {
            return vertices;
        }

        public int getEdges() {
            return edges;
        }

        public List<DirectedEdge>[] getDirectedEdgesList() {
            return directedEdgesList;
        }

        public void addEdge(DirectedEdge directedEdge) {
            directedEdgesList[directedEdge.getFrom()].add(directedEdge);
            edges++;
        }

        public List<DirectedEdge> getDirectedEdgesListFromNode(int vertex) {
            return directedEdgesList[vertex];
        }
    }

    static class CurrentDistanceToStart {
        private int from;
        private int to;
        private long dist;

        public CurrentDistanceToStart(int from, int to, long dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public long getDist() {
            return dist;
        }
    }

    static class DijkstraShortestPath {
        private int start;
        private DirectedGraph directedGraph;
        private int vertices;
        private long[] shortestPaths;
        private int[] previous;
        private boolean[] visited;

        public DijkstraShortestPath(int start, DirectedGraph directedGraph) {
            this.start = start;
            this.directedGraph = directedGraph;
            this.vertices = directedGraph.getVertices();
            this.visited = new boolean[vertices];
            this.shortestPaths = new long[vertices];
            this.previous = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                shortestPaths[i] = Long.MAX_VALUE;
            }
            shortestPaths[start] = 0;
            previous[start] = start;
        }


        public void runDijkstraAlgorithm() {
            Queue<CurrentDistanceToStart> currentDistancesQueue =
                    new PriorityQueue<>(vertices, Comparator.comparingLong(o -> o.getDist()));
            currentDistancesQueue.add(new CurrentDistanceToStart(start, start, 0));

            while (!currentDistancesQueue.isEmpty()) {
                visited[start] = true;
                start = currentDistancesQueue.poll().getTo();

                List<DirectedEdge> directedEdgesFromNode = directedGraph.getDirectedEdgesListFromNode(start);
                long currDistToSrc = shortestPaths[start];

                //if... -> update shortestPaths for neighbors, update previous
                int size = directedEdgesFromNode.size();
                for (int i = 0; i < size; i++) {
                    DirectedEdge current = directedEdgesFromNode.get(i);
                    long calcDist = currDistToSrc + current.getWeight();
                    int to = current.getTo();
                    if (calcDist < shortestPaths[to]) {
                        shortestPaths[to] = calcDist;
                        previous[to] = start;
                        if (!visited[to]) {
                            currentDistancesQueue.add(
                                    new CurrentDistanceToStart(current.getFrom(), current.getTo(), calcDist));
                        }
                    }
                }
            }
        }

        public long[] getShortestPaths() {
            return shortestPaths;
        }

        public int[] getPrevious() {
            return previous;
        }

        public boolean[] getVisited() {
            return visited;
        }
    }


    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = rd.nextInt();
        while (tests-- > 0) {
            int vertices = rd.nextInt();
            int edges = rd.nextInt();

            DirectedGraph directedGraph = new DirectedGraph(vertices);
            for (int i = 0; i < edges; i++) {
                directedGraph.addEdge(new DirectedEdge(rd.nextInt() - 1, rd.nextInt() - 1, rd.nextInt()));
            }
            int start = rd.nextInt() - 1;
            int end = rd.nextInt() - 1;

            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(start, directedGraph);
            dijkstraShortestPath.runDijkstraAlgorithm();
            long distance = dijkstraShortestPath.getShortestPaths()[end];
            if (distance == Long.MAX_VALUE) strb.append("NIE");
            else strb.append(distance);
            strb.append("\n");
        }

        out.write(strb.toString().getBytes());
        out.flush();
    }
}
