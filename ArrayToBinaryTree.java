/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author raviteja
 */
public class ArrayToBinaryTree {
    

    public ArrayToBinaryTree() {
    }
    
    private MyNode arrayToBinaryTree(int[] input){
        MyNode root = constructBinaryTree(input,1);
        return root;
    }
       

    private MyNode constructBinaryTree(int[] input,  int index) {
        if(index<=input.length){
            Integer value = input[index-1];
            MyNode t = new MyNode(value);
            t.setLeft(constructBinaryTree(input, index*2));
            t.setRight(constructBinaryTree(input, index*2+1));
            return t;
        }
        return null;
    }
    
    private void levelOrderTraversal(MyNode node){
        if(node!=null){
            Queue<MyNode> q = new LinkedList<>();
            q.add(node);
            while(!q.isEmpty()){
                int size = q.size();
                MyNode[] temp = new MyNode[size];
                for(int i=0;i<size;i++){
                    temp[i] = q.poll();
                }
                for(int i=0; i< size;i++){
                    System.out.print(" "+temp[i].getData());
                    if(temp[i].getLeft()!=null) q.add(temp[i].getLeft());
                    if(temp[i].getRight()!=null) q.add(temp[i].getRight());
                }
                System.out.println("");
            }

            
        }
    }

    void displayAsBinaryTree(int[] input) {
        MyNode root = arrayToBinaryTree(input);
        //levelOrderTraversal(root);
        BTreePrinter.printNode(root);
        //pressAnyKeyToContinue();
    }
    
    public void pressAnyKeyToContinue()
    { 
        System.out.println("Press enter to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }
    
    
    
}

