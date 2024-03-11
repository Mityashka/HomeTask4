package org.example.gb_collections.lists;

import org.example.gb_collections.GbList;
import org.example.gb_collections.lists.util.ArrayIterator;

import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E> {
    private Node<E> head;
    private int size;
    public  GbLinkedList(){
        this.size = 0;
        this.head = null;
    }
    @Override
    public void add(E value) {
        if (head == null){
            this.head = new Node<>(value);
        }
        else head.next = new Node<>(value);
        size ++;
    }

    @Override
    public void add(int index, E value) {

    }

    @Override
    public E get(int index) {
        int count = 0;
        Node<E> current = head;
        while(count != index){
            current = current.next;
            count ++;
        }
        return current.value;
    }
    @Override
    public void remove(E value) {
    }
    @Override
    public void removeByIndex(int index) {
        int count = 0;
        Node<E> previous = null;
        Node<E> current = head;
        while(count != index){
            previous = current;
            current = current.next;
            count ++;
        }
        if (previous != null){
            previous.next =current.next;
        }
    }
    @Override
    public int size() {
        return 0;
    }
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(toArray());
    }
    private static class Node<E>{
        private final E value;
        private Node<E> next;

        public Node(E value){
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
    public E[] toArray(){
        E[] result = (E[])new Object[size];
        Node<E> current = head;
        int i = 0;
        while (current.next != null){
            result[i] = current.value;
            i++;
        }
        return result;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        E[] values = toArray();
        while (values[i] != null) {
            builder.append(values[i]).append(", ");
            i++;
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
