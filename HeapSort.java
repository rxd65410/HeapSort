/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
/**
 *
 * @author raviteja
 */
public class HeapSort {
    ArrayToBinaryTree arrayToBT;
    private int heapsize;

    public HeapSort() {
        arrayToBT = new ArrayToBinaryTree();
    }
    
    private int[] heapSort(int[] input) {
        
        //Convert the given array into binary tree
        System.out.println("Binary Tree representaion of given array.");
        arrayToBT.displayAsBinaryTree(input);
        arrayToBT.pressAnyKeyToContinue();
        
        //max heapify the binary tree.     
        maxHeapify(input); 
        System.out.println("Max Heapify is Done.");
        arrayToBT.displayAsBinaryTree(input);
        System.out.println("Sorting starts now");
        int[] output = new int[heapsize+1];        
        //int kk=0;
        //sorting
        for (int i = heapsize; i >= 0; i--)
        {
            swap(input,0, i);
            output[i]=input[i];
		//kk++;
            heapsize = heapsize-1;
            arrayToBT.pressAnyKeyToContinue();            
            System.out.println("Swap "+input[0]+", "+input[i]+" and maxheapify ->"+input[0]);
            maxHeapify(input, 0,false);
            arrayToBT.displayAsBinaryTree(input);
            System.out.println("Output Array : "+Arrays.toString(output));
        }
        
        return output;
        
    }
    
    
    private void maxHeapify(int[] input) {
        heapsize = input.length-1;
         for (int i = heapsize/2; i >= 0; i--){
                maxHeapify(input, i,true);
         }     
    }
    
    private void maxHeapify(int[] input,int i,boolean printOut) {
        int left = 2*i+1;
        int right = 2*i + 2;
        int largest = i;
        if(printOut)    System.out.println("Max Heapify -> "+input[i]);        
        if (left <= heapsize && input[left] < input[largest]) largest = left;        
        if (right <= heapsize && input[right] < input[largest]) largest = right;
        
        if (largest != i){
            swap(input, i, largest);
            if(printOut){
                System.out.println("We need to swap "+input[i]+" "+input[largest]);
                arrayToBT.displayAsBinaryTree(input);
                arrayToBT.pressAnyKeyToContinue();
            }            
            maxHeapify(input, largest,printOut);
        }else {
            if(printOut){
                System.out.println("No Change");
                arrayToBT.pressAnyKeyToContinue();
            }            
        } 
        
    }
    
    private void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HeapSort mysort = new HeapSort();
        int[] input = {6,2,5,1,3,8,4,7,9,10};
        System.out.println("Given Input Array : "+Arrays.toString(input));
        int[] output = mysort.heapSort(input);        
    }    
}

