package binaryToMaxHeap;

import java.util.Scanner;

public class ConvertToMaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);

		BinarySearchTree BST = new BinarySearchTree();
		System.out.println("how many numbers will you enter to create binary search tree structure");
		int number = keyboard.nextInt();
		for (int i = 0; i < number; i++) {
			int data = keyboard.nextInt();
			BST.Add(BST.root, data);
		}
		
		System.out.println(
				"If you want to delete an item, please enter 1\nIf you want to convert binary to maxHeap,please enter 2");
		int operation = keyboard.nextInt();
		while (operation == 1 || operation == 2) {
			if (operation == 1) {
				System.out.println("Please enter the element you want to delete ");
				int deletion = keyboard.nextInt();
				BST.Delete(BST.root, deletion);
				System.out.println(
						"If you want to delete an item, please enter 1\nIf you want to convert binary to maxHeap,please enter 2");
				 operation = keyboard.nextInt();

			}
			if (operation == 2) {
				BST.Inorder_Traversal(BST.root);
				int length = BST.arr.size();
				for (int i = 0; i < length; i++) {
					BST.Maxheap(BST.MaxHeapRoot, (Comparable) BST.arr.get(i));

				}
				System.out.println("transaction is completed successfully");
				break;
			}

		}
	}

}
