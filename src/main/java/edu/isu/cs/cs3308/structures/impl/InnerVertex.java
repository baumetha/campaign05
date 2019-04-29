package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Edge;
import edu.isu.cs.cs3308.structures.Vertex;

import java.util.LinkedList;
import java.util.List;

/**
 * Nested Vertex class
 */
public class InnerVertex<V,E> implements Vertex<V,E> {
    /**
     * Implmentation of the Vertex interface
     * Somewhat based on in-book example
     *
     * @param <V>
     */
        public V element;
        public List<Edge<V,E>> outgoing;
        public List<Edge<V,E>> incoming;

        public InnerVertex(V elem) {
            this.element = element;
            incoming = new LinkedList<>();
            outgoing = new LinkedList<>();
        }

        @Override
        public V getElement() {
            return element;
        }

        @Override
        public List<Edge<V,E>> getOutgoing() {
            return outgoing;
        }

        @Override
        public List<Edge<V,E>> getIncoming() {
            return incoming;
        }
    }
