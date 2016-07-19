package csc364pa5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Main {
    public void timeTests(ArrayList<Integer> arrayList, BST<Integer> bst){
        long startTimeInsert = System.nanoTime();
        for(Integer i : arrayList){
            bst.add(i);
        }
        long endTimeInsert = System.nanoTime();
        System.out.println("Time to insert: " + (endTimeInsert-startTimeInsert)/1000000000);
        Collections.shuffle(arrayList);

        long startTimeSeach = System.nanoTime();
        for(Integer i : arrayList){
            bst.search(i); //don't care about a return value here
        }
        long endTimeSeach = System.nanoTime();
        System.out.println("Time to search: " + (endTimeSeach - startTimeSeach)/1000000000);

        long startTimeDelete = System.nanoTime();
        Collections.shuffle(arrayList);
        for(Integer i : arrayList){
            bst.delete(i);
        }
        long endTimeDelete = System.nanoTime();
        System.out.println("Time to delete: "+ (endTimeDelete-startTimeDelete)/1000000000);


    }

    public static void main(String[] args) {
        Main m = new Main();
        ArrayList<Integer> values1 = new ArrayList<Integer>();
	    for(int i  = 0; i <= 99999; i++){
            values1.add(i);
        }
        System.out.println("Using BST on 100k inorder elements");
        m.timeTests(values1, new BST<Integer>());

        ArrayList<Integer> values2 = new ArrayList<Integer>();
        for(int i  = 0; i <= 99999; i++){
            values2.add(i);
        }
        System.out.println("Using AVLTree on 100k inorder elements");
        m.timeTests(values2, new AVLTree<Integer>());

        //create random seed
        Random rn = new Random();
        ArrayList<Integer> values3 = new ArrayList<Integer>();
        for(int i  = 0; i <= 99999; i++){
            values3.add(rn.nextInt(1000000-0+1)+0);
        }

        System.out.println("Using BST on 100k random elements");
        m.timeTests(values3, new BST<Integer>());

        ArrayList<Integer> values4 = new ArrayList<Integer>();
        for(int i  = 0; i <= 99999; i++){
            values4.add(rn.nextInt(1000000-0+1)+0);
        }
        System.out.println("Using AVLTree on 100k random elements");
        m.timeTests(values4, new AVLTree<Integer>());
    }
}
