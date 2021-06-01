package com.company;

public class Main {

    public static void main(String[] args) {
	MyLinkedList<Integer> coll  = new MyLinkedList<>();
	    coll.add(12);
        coll.add(45);
        coll.add(65);
        coll.add(78);

        System.out.println(coll);
        coll.remove(45);
        System.out.println(coll);

        //  1)for: it = col.iterator
        // в цикле
        //  2) if (it.hasnext()=true) {i = it.next();}
        //      else {break}
        for (Integer i : coll){
            System.out.println(i);
        }

    }
}
