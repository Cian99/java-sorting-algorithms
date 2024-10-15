package Assignment;

import java.util.Scanner;

public class SelectionSort {

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
				
		// print the unsorted array using simple loop
		System.out.println("\nUnsorted array:");
		for(int i=0; i<unsorted.length; i++) {
			System.out.print(unsorted[i] + "  ");
		}
		
		// search the array for the lowest element
		// place it at the front of the unsorted array
		// keep iterating this methodology until the whole array is traversed
		
		// call the selection sort method on the array
		selectSort(unsorted);
		
		// print the array after sorting
		System.out.println("\n\nArray after Selection Sort:");
		for(int i=0; i<unsorted.length; i++) {
			System.out.print(unsorted[i] + "  ");
		}
		
		input.close(); // close the scanner to prevent resource leak
		
	}
	
	public static void selectSort(int[] unsorted) {
		
		// create some variables
		// traversing outer, inner loops and store smallest value
		int outer, inner, smallest;
		
		// traverse the array
		for(outer=0; outer<unsorted.length; outer++) {
			// set current element as smallest
			smallest = outer;
			// search for a smaller value
			for(inner=outer+1; inner<unsorted.length; inner++) {
				if(unsorted[inner] < unsorted[smallest]) {
					// change smallest value if a smaller no. is found
					smallest = inner;
				}
			}
			
			// temporary variable to store outer loops value
			int temp = unsorted[outer];
			// move the smallest variable to the front of the unsorted array
			unsorted[outer] = unsorted[smallest];
			// swapping with the outer loops element
			unsorted[smallest] = temp;
			
		}
		
	}

}
