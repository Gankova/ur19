package com.company;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<T> implements Collection<T> {

    private class Node{
        private Node next;
        private T value;
        public Node(T value){
            this.value = value;
        }
    }
    private class MyIterator implements Iterator<T>{
        private Node current = head; // ссылка на текущий элемент коллекции

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    private Node head;
    private int length;

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        this.length++;
        if (head == null){
            head = new Node(t);
            return false;
        }
        Node n = head;
        boolean found = false;
        while (n.next!=null){
            // true || false =true
            // true || true = true
            // false || false =False
            // false || true = true
                found = found || (n.value.hashCode() == t.hashCode()|| (n.value.equals(t)));
            n = n.next;
        }
        n.next = new Node(t);

        return found;
    }

    @Override
    public boolean remove(Object o) {
        // true - если о есть в коллекции
        // false - если о есть в коллекции
        if (head == null) {
            return false;
        }
        Node n = head;
        Node prev = head;
        while (n != null){
            if (n.value.hashCode() == o.hashCode() || n.value.equals(o)){
                if (n == head){
                    head = head.next;
                } else {
                    prev.next= prev.next.next;
                }
                length--;

                return true;

            }
            prev = n;
            n = n.next;

        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
    @Override
    public String toString(){
        String [] values = new String[length];
        Node n = head;
        int i  = 0;
        while (n != null){
            values[i++]=n.value.toString();

            n = n.next;

        }
        return String.join(", ", values);
    }
}
