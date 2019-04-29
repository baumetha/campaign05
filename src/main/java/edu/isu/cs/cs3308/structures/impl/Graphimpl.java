package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Graph;
import edu.isu.cs.cs3308.structures.Edge;
import edu.isu.cs.cs3308.structures.Vertex;
import edu.isu.cs.cs3308.structures.impl.InnerEdge;
import edu.isu.cs.cs3308.structures.impl.InnerVertex;

import java.util.*;

/**
 * Code heavily influenced by in class examples
 * @param <V>
 * @param <E>
 */
public abstract class Graphimpl<V, E> implements Graph<V, E> {

    Map<V, List<Edge<V, E>>> adjMap;

    /**
     * number of vertices in the graph
     *
     * @return number of vertices
     */
    @Override
    public int numVertices() {
        return adjMap.keySet().size();
    }

    /**
     * vertices of the graph
     *
     * @return iteration of vertices in graph
     */
    @Override
    public Iterator<V> vertices() {
        return adjMap.keySet().iterator();
    }

    /**
     * number of edges in graph
     *
     * @return number of edges
     */
    @Override
    public int numEdges() {
        int[] sum = {0};
        adjMap.values().forEach(v -> {
            sum[0] += v.size();
        });
        return sum[0];
    }

    /**
     * The edges in the graphs
     *
     * @return iteration of all edges
     */
    @Override
    public Iterator<Edge<V, E>> edges() {
        List<Edge<V, E>> edges = new ArrayList<>();
        for (List<Edge<V, E>> list : adjMap.values())
            edges.addAll(list);
        return edges.iterator();
    }

    /**
     * finds the edge from vertex v to vertex u
     */
    public Edge<V, E> getEdge(Vertex<V, E> v, Vertex<V, E> u) {
        if (v == null || u == null){
            return null;
    }
        if (adjMap.containsKey(v)) {
            for (Edge<V, E> edge : adjMap.get(v));
        }
        return null;
    }

    /**
     * The end of the vertices
     *
     * @param e
     * @return
     */
/**
    public V[] endVertices(Edge<V,E> e) {
        return null;
    }
*/
    /**
     * Must store in a temp
     * @param v
     * @param e
     * @return vertex that is opposite vertex v on the edge
     */
    public V opposite(V v, Edge<V,E> e) {
        if (v != null && e != null) {
            InnerEdge<V, E> edge = (InnerEdge) e;
            if (edge.getDest().equals(v))
                return edge.getSrc();
            else return edge.getDest();
        }
        return null;
    }

        /**
         *
         * @param v
         * @return number of edges which is the origin
         */
        public int outDegree (V v) {
            if (v != null && adjMap.containsKey(v))
                return adjMap.get(v).size();
            return 0;
        }

        /**
         *
         * @param v
         * @return the number of edges which is the destination
         */
        public int inDegree ( V v) {
            int inDegree = 0;
            if (v != null) {
                for (V k : adjMap.keySet()) {
                    if (!k.equals(v)) {
                  //      InnerEdge<V, E> e = new InnerEdge<V, E>(k, v,null);
                       // if (adjMap.get(k).contains(e)) ;
                        inDegree++;
                    }
                }
            }
            return inDegree;
        }
        /**
         * Must store in a temp
         * @param v
         * @return Iterable collection of edges where v is the origin
         */
        public Iterator<Edge<V,E>> outgoingEdges (Vertex < V,E > v) {
            if (v != null && adjMap.containsKey(v)) {
                return adjMap.get(v).iterator();
            }
            return null;
        }

        /**
         * must store in a temp
         * @param v
         * @return Iterable collection of edges where v is the destination
         */

        public Iterator<Edge<V,E>> incomingEdges (Vertex<V,E> v) {
            List<Edge<V,E>> edges = new ArrayList<>();
            if (v != null){
                for (V k : adjMap.keySet()){
                    if (k.equals(v)) {
                        for (Edge<V, E> edge : adjMap.get(k)) {
                            InnerEdge temp = (InnerEdge)edge;
                            if (temp.getDest().equals(v))
                                edges.add(edge);
                        }
                    }
                }
            }
            return edges.iterator();
        }
/**
 * Inserts a new vertex
 */

        public Vertex<V,E> insertVertex (V v){
            if (v != null && !adjMap.containsKey(v))
                adjMap.put(v, new LinkedList<>());
                return (Vertex<V, E>) v;
        }
/**
 * inserts a new edge
 * Must store in a temp
 */
        public void insertEdge (Vertex<V,E> u, Vertex<V,E> v, E e){
            if (v == null || u == null)
                return;
            if (adjMap.containsKey(v)){
                List<Edge<V,E>> edges = adjMap.get(v);
                InnerEdge<V,E> edge = new InnerEdge<>(v,u,e);
                if (!adjMap.get(v).contains(edge))
                    adjMap.get(v).add(edge);
            }
        }
/**
 * removes a vertex
 * Must store in a temp
 */
        public void removeVertex ( V v) {
            if (v != null) {
                if (adjMap.containsKey(v))
                    adjMap.remove(v);
                List<Edge<V, E>> edges = new ArrayList<>();
                for (List<Edge<V, E>> list : adjMap.values()) {
                    for (Edge<V, E> e : list) {
                        InnerEdge temp = (InnerEdge) e;
                        if (temp.getDest().equals(v))
                            edges.add(e);
                    }
                }
                for (Edge<V, E> edge : edges) {
                    InnerEdge e = (InnerEdge) edge;
                    adjMap.get(e.getSrc()).remove(edge);
                }
            }
        }
/**
 * removes an edge
 */
    public void removeEdge (InnerEdge<V,E> e) {
            if (e != null){
                if (adjMap.containsKey(e.getSrc()))
                    adjMap.get(e.getSrc()).remove(e);
            }
        }
    }