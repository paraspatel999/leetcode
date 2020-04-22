package demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {

    class Edge {
        String src;
        String dest;
        double conversion;
        boolean visited;

        public Edge(String src, String dest, double conversion) {
            this.src = src;
            this.dest = dest;
            this.conversion = conversion;
            this.visited = false;
        }
    }

    class Graph {

        Map<String, List<Edge>> edges = null;

        public Graph() {
            this.edges = new HashMap<>();
        }

        public void addEdge(String src, String dest, double conversion) {
            List<Edge> edges = this.edges.get(src) != null ? this.edges.get(src) : new LinkedList<>();
            edges.add(new Edge(src, dest, conversion));
            this.edges.put(src, edges);

            List<Edge> revEdges = this.edges.get(dest) != null ? this.edges.get(dest) : new LinkedList<>();
            revEdges.add(new Edge(dest, src, 1/conversion));
            this.edges.put(dest, revEdges);
        }

        public double getConversion(String src, String dest) {
            if (this.edges.get(src) == null) return 0;
            for (Edge edge : this.edges.get(src)) {
                if (edge.visited) continue;

                if (edge.dest.equals(dest)) {
                    return edge.conversion;
                }
                edge.visited = true;
                double conv = getConversion(edge.dest, dest);
                if (conv != 0) {
                    return edge.conversion * conv;
                }
            }
            return 0;
        }
    }

    public Graph getGraph() {
        return new Graph();
    }

    public static void main(String[] args) {
        CurrencyConverter c = new CurrencyConverter();
        Graph g = c.getGraph();
        g.addEdge("USD" , "INR", 70);
        g.addEdge("USD", "CAD", 20);
        g.addEdge("MXP", "USD", 0.34);

        double conversion = g.getConversion("INR", "MXP");
        System.out.println("");

    }
}
