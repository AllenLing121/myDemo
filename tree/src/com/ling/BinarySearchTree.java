package com.ling;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lian on 04/09/2019.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class Node<T>{
        T element;
        Node<T> leftNode;
        Node<T> rightNode;
        public Node(T element){
            this(element,null,null);

        }
        public Node(T element,Node<T> leftNode, Node<T> rightNode){
            this.element = element;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    private Node<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public Node<T> getRoot(){
        return root;
    }

    public void insert(T ele){
        root = this.insert(ele,root);
    }

    private Node<T> insert(T ele, Node<T> root){
        if(root == null){
            return new Node<T>(ele);
        }
        int compareResult = ele.compareTo(root.element);
        if(compareResult < 0){
            root.leftNode = insert(ele,root.leftNode);
        }else if(compareResult > 0){
            root.rightNode = insert(ele,root.rightNode);
        }
        return root;
    }

    public void insertByTier(T ele){
        if(root == null){
            root = new Node<T>(ele);
            return;
        }
        this.insertByTier(ele,root);
    }

    private Node<T> insertByTier(T ele, Node<T> root){
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.peek();
            queue.remove();
            if(root.leftNode == null){
                root.leftNode = new Node<T>(ele);
                break;
            }else{
                queue.add(root.leftNode);
            }

            if(root.rightNode == null){
                root.rightNode = new Node<T>(ele);
                break;
            }else{
                queue.add(root.rightNode);
            }
        }
        return root;
    }

    public void preOrder(Node<T> root){
        if(root == null){
            return;
        }
        System.out.print(root.element + "  ");
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    public void midOrder(Node<T> root){
        if(root == null){
            return;
        }
        midOrder(root.leftNode);
        System.out.print(root.element + "  ");
        midOrder(root.rightNode);
    }

    public void lastOrder(Node<T> root){
        if(root == null){
            return;
        }
        lastOrder(root.leftNode);
        lastOrder(root.rightNode);
        System.out.print(root.element + "  ");
    }

    public void tierOrder(Node<T> root){
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            System.out.print(root.element + "  ");
            if(root.leftNode != null){
                queue.offer(root.leftNode);
            }

            if (root.rightNode != null){
                queue.offer(root.rightNode);
            }
        }
    }
}
