package binaryToMaxHeap;

public class BTNode<T> {
T data;
BTNode<T>left;
BTNode<T>right;
     public BTNode(T data) {
    	 this.data=data;
    	 left=right=null;
     }
}
