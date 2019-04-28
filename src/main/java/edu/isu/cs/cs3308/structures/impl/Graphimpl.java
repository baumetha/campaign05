package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Graph;
import edu.isu.cs.cs3308.structures.Edge;
import edu.isu.cs.cs3308.structures.Vertex;

import java.util.*;

/**
 * Code heavily influenced by in class and book examples
 * @param <V>
 * @param <E>
 */
public abstract class Graphimpl<V, E> implements Graph<V, E> {
    private LinkedList<Vertex<V>> vertices = new LinkedList<>();
    private LinkedList<Edge<E>> edges = new LinkedList<>();

    /**
     * number of vertices in the graph
     *
     * @return
     */
    @Override
    public int numVertices() {
        return vertices.size();
    }

    /**
     * vertices of the graph
     *
     * @return
     */
    @Override
    public Iterator<Vertex<V>> vertices() {
        return vertices;
    }

    /**
     * number of edges in graph
     *
     * @return
     */
    @Override
    public int numEdges() {
        edges.size();
    }

    /**
     * The edges in the graph
     *
     * @return
     */
    @Override
    public Iterable<Edge<E>> edges() {
        return edges;
/**
 * finds the edge
 */
        public Edge<E> getEdge(Vertex < V > u, Vertex < V > v){
            return null;
        }
    }

    /**
     * The end of the vertices
     *
     * @param e
     * @return
     */
    @Override
    public Vertex<V>[] endVertices(Edge<E> e) {
        return e.getEndpoints();
    }

    /**
     * @param v
     * @param e
     * @return vertex that is opposite vertex v on the edge
     */
    public V opposite(Vertex<V> v, Edge<E> e) {
        Vertex<V>[] endpoints = e.getEndpoints();
        if (endpoints[0] == v)
            return endpoints[1];
        else if (endpoints[1] == v)
            return endpoints[0];
        else
            throw new IllegalArgumentException();

        /**
         * Based off book
         * @param v
         * @return number of edges which is the origin
         */
        public int outDegree (Vertex < V > v) {
            return v.getOutgoing().size();
        }

        /**
         * Based off book
         * @param v
         * @return the number of edges which is the destination
         */
        public int inDegree (Vertex < V > v) {
            return v.getIncoming().size();
        }

        /**
         * Based off book
         * @param v
         * @return Iterable collection of edges where v is the origin
         */
        public Iterator<Edge<E>> outgoingEdges (Vertex < V > v) {
            Vertex<V> ver = v;
            return (Iterator<Edge<E>>) ver.getOutgoing();
        }

        /**
         * based off book
         * @param v
         * @return Iterable collection of edges where v is the destination
         */

        public Iterable<Edge<E>> incomingEdges (Vertex < V > v) {
            return v.getIncoming();
        }
/**
 * Inserts a new vertex
 */

        public Vertex<V> insertVertex (V v){
            Vertex<V> vert = new InnerVertex(v);
            vertices.add(vert);
            return vert;

        }
/**
 * inserts a new edge
 */

        public void insertEdge (Vertex < V > u, Vertex < V > v, E e){

        }
/**
 * removes a vertex
 */
        public V removeVertex (Vertex < V > v) {
            for (Edge e : v.getOutgoing()) {
                removeEdge(e);
            }
            for (Edge e : v.getIncoming()) {
                removeEdge(e);
            }
            V elem = v.getElement();
            return elem;
        }
/**
 * removes an edge
 */
        public E removeEdge (Edge < E > e) {
            return null;
        }
        /**
         * Nested Vertex class
         */
        public class InnerVertex implements Vertex<E> {
            /**
             * Implmentation of the Vertex interface
             * Somewhat based on in-book example
             *
             * @param <V>
             */
            public class Verteximpl<V> implements Vertex<V> {
                public V element;
                public List<Edge<E>> outgoing;
                public List<Edge<E>> incoming;

                public Verteximpl(V elem) {
                    this.element = element;
                    incoming = new LinkedList<>();
                    outgoing = new LinkedList<>();
                }

                @Override
                public V getElement() {
                    return element;
                }

                @Override
                public <E> List<Edge<E>> getOutgoing() {
                    return outgoing;
                }

                @Override
                public <E> List<Edge<E>> getIncoming() {
                    return incoming;
                }
            }
        }
    }
        /**
         * Nested Edge class
         */
    public class InnerEdge implements Edge<E>{
        /**
         * Written based on code from in class
         * @author Isaac Griffith
         * @author Ethan Baumgartner
         * @param <V>
         * @param <E>
         */
            V src;
            V dest;
            E element;
            Vertex<V>[] endpoints;
            public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
                element = elem;
                endpoints = (Vertex<V>[]) new Vertex[]{u, v};
            }
            public int hashCode(){
                return Objects.hash(getSrc(), getDest());
            }

            public V getSrc() {
                return src;
            }

            public V getDest(){
                return dest;
            }
            @Override
            public E getElement() {
                return element;
            }
            @Override
            public <V> Vertex<V>[] getEndpoints() {
                return null;
        }
    }
}