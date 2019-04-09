package com.ling;

/**
 * Created by Lian on 04/09/2019.
 */
public class TreeTest {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        for(int i : array){
            tree.insertByTier(i);
        }

        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.tierOrder(tree.getRoot());
        System.out.println();
        tree.midOrder(tree.getRoot());
        System.out.println();
        tree.lastOrder(tree.getRoot());
    }
}
