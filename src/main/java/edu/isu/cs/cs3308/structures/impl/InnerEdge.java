package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Edge;
import edu.isu.cs.cs3308.structures.Vertex;

import java.util.Objects;

/**
         * Nested Edge class
         */
        public class InnerEdge<V,E> implements Edge<V,E> {
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
            Vertex<V,E>[] endpoints;
            public InnerEdge(Vertex<V,E> u, Vertex<V,E> v, E elem) {
                element = elem;
                endpoints = (Vertex<V,E>[]) new Vertex[]{u, v};
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
            public <V> Vertex<V,E>[] getEndpoints() {
                return null;
        }
    }
