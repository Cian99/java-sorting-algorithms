package Assignment;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		
		// read in the array size and values from user
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the array size: ");
		// unsorted array
		int[] unsorted = new int[input.nextInt()]; 
		
		// traverse the array and set the values
		for(int i=0; i<unsorted.length; i++) {
			System.out.print("Enter the value for element " + ((int)i+1) + ": ");
			unsorted[i] = input.nextInt();
		}
			
		// {47,15,82,64,33,91,28,56,73,9};
		
		// print the unsorted array using a simple loop
		System.out.println("\nUnsorted array:");
		for(int i=0; i<unsorted.length; i++) {
			System.out.print(unsorted[i] + "  ");
		}
		
		// select random value (rightmost element) as the pivot
		// values lower than pivot are swapped to L
		// value greater then pivot are swapped to R
		// repeat on segments of array until sorted
		
		// set the value for left and right (range of the array)
		// left is first element and right is last element (index)
		int left = 0;
		int right = unsorted.length - 1;
		
		// call the quickS method on the unsorted array
		quickS(unsorted, left, right);
		
		// print the array now
		System.out.println("\n\nArray after Quick Sort:");
		for(int i=0; i<unsorted.length; i++) {
			System.out.print(unsorted[i] + "  ");
		}
		
		input.close(); // close the scanner to prevent resource leak

	}
	
	public static void quickS(int[] unsorted, int left, int right) {
		
		// stopping condition - left and right index meet/overlap
		if(left >= right) {
			return;
		}
		
		// select pivot value (rightmost value, more random value may provide slightly better efficiency)
		int pivot = unsorted[right];
		
		// call partition method on the array from left index to right index using the selected pivot
		int partitioning = partition(unsorted, left, right, pivot);
			
		// recursively call quicksort
		quickS(unsorted, left, partitioning - 1); // left of first pivot value
		quickS(unsorted, partitioning + 1, right); // right of first pivot value
			
	}

	private static int partition(int[] unsorted, int left, int right, int pivot) {
		
		int leftCheck = left;
		int rightCheck = right;
		
		// partitioning - move no.s lower than pivot to L and higher to R
		// sorting L to R and R to L
		// loop continues until values left check and right check meet
		while(leftCheck < rightCheck) {
			
			// the partition step takes the array and partitions it into two segments
			// those less than the pivot on the L
			// and those greater than the pivot on the R
			
			
			// find first element from the left that is greater than pivot
			while(leftCheck < rightCheck && unsorted[leftCheck] <= pivot) {
				leftCheck++; // increment
			}
			// find first element from the right that is less than pivot
			while(rightCheck > leftCheck && unsorted[rightCheck] >= pivot) {
				rightCheck--; // decrement
			}
			// swap elements to the correct side of pivot using the swapping method
			swapping(unsorted, leftCheck, rightCheck);
			
		}
			
		// swap the pivot into the array (value leftCheck is at)
		// place pivot in between the values that are less than it and the values that are greater
		swapping(unsorted, leftCheck, right);
		return leftCheck;
	}
	
	private static void swapping(int[] unsorted, int pos1, int pos2) {
		
		int temp = unsorted[pos1]; // temporary variables are useful for swapping
		unsorted[pos1] = unsorted[pos2];
		unsorted[pos2] = temp;
		
	}
		
}