import java.util.Arrays;

/**
 * CET - CS Academic Level 3
 * <br>This class implements methods that performs a variety of sorting algorithms
 * <br>Section #: 303
 * <br>Course: CST8130 - Data Structures
 * @version 1.0
 */
public class SortingAlgorithms {
	
	
	/**
	 * This is the no-arg constructor
	 */
	public SortingAlgorithms() {
		
	}//end no-arg constructor
	

	/**
	 * This method takes an unsorted array and sort it using bubble Sort algorithm
	 * @param randomArr this is the unsorted array
	 * @return Returns the sorted array 
	 */
	public int[] bubbleSort(int[] randomArr){
		
		//this is a local array that takes the randomArr elements (avoid sorting the input array)
		int[] sortedArray= randomArr.clone();
		//Takes true if at least two elements were switched
		boolean changesMade=true;
		//iterates trough the array and compares adjacent elements
		for (int i=0; i<sortedArray.length && changesMade; i++) {
			changesMade= false;
			for(int j=0; j<sortedArray.length-i-1; j++) {//sortedArray.length-i-1 because if not j+1 takes array.length 
				//if the first element is bigger than the second element it switches them
				if (sortedArray[j]>sortedArray[j+1]) {
					//a temporary variable used to switch two elements
					int temp= sortedArray[j];
					sortedArray[j]=sortedArray[j+1];
					sortedArray[j+1]=temp;
					changesMade= true;
				}
			}//end for j
		}//end for i
		
		return sortedArray;
	}//end bubbleSort
	

	/**
	 * This method calculates and displays the processing time of the Algorithm as well as the sorted array
	 * @param randomArr is the array to be sorted
	 */
	public void bubbleSortTiming (int[] randomArr) {
		
		//this is the time in the beginning of the Algorithm in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the Algorithm in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the algorithm and prints the sorted array
		System.out.print(Arrays.toString(bubbleSort(randomArr)));
		//this is the duration of the Algorithm in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the Algorithm in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);
	}//end bubbleSortiming
	
	/**
	 * This method takes an unsorted array and sort it using insertion Sort algorithm
	 * @param randomArr this is the unsorted array
	 * @return Returns the sorted array 
	 */
	public int[] insertionSort(int[] randomArr) {
		
		//this is a local array that takes the randomArr elements  (avoid sorting the input array)
		int[] sortedArray= randomArr.clone();
		//compares each element with the preceding 
		for (int i=1; i<sortedArray.length; i++) {
			int temp = sortedArray [i];
			int index= i-1;
			//if the current element is smaller than its preceding elements it switches  positions and continues looping
			while(index>=0 && temp<sortedArray[index]) {
				
				sortedArray[index+1]=sortedArray[index];
				index--;
				}
			//it stores the current element before the first found smaller element
			sortedArray[index+1]=temp;

		}//end for
		
		return sortedArray;
	}//end insertionSort
	
	
	/**
	 * This method calculates and displays the processing time of the Algorithm as well as the sorted array
	 * @param randomArr is the array to be sorted
	 */
	public void insertionSortTiming (int[] randomArr) {
		
		//this is the time in the beginning of the Algorithm in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the Algorithm in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the algorithm and prints the sorted array
		System.out.print(Arrays.toString(insertionSort(randomArr)));
		//this is the duration of the Algorithm in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the Algorithm in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);
	}//end insertionSortTiming 
	
	

	/**
	 * This method takes an unsorted array and sort it using selection Sort algorithm
	 * @param randomArr this is the unsorted array
	 * @return Returns the sorted array 
	 */
	public int[] selectionSort(int[] randomArr) {
		
		//this is a local array that takes the randomArr elements (avoid sorting the input array)
		int[] sortedArray= randomArr.clone();
		//stores in the current index "i" it the lowest elements among the following elements
		for (int i=0; i<sortedArray.length; i++) {
			//index of the lowest element
			int minIndex= i;
			//compares the current elements with its followers
			for(int j=i+1; j<sortedArray.length; j++) {
				//if it finds a smaller element it takes it as minIndex
				if (sortedArray[j]<sortedArray[minIndex]) {//******we can inverse the array only by replacing less than by greater than ****************************
					
					minIndex=j;
				}
				
			}//end for j
			//switch the current element with the lowest one
			int temp=sortedArray[i];
			sortedArray[i]=sortedArray[minIndex];
			sortedArray[minIndex]=temp;
		}//end for 
		
		return sortedArray;
	}//end selectionSort
	
	/**
	 * This method calculates and displays the processing time of the Algorithm as well as the sorted array
	 * @param randomArr is the array to be sorted
	 */
	public void selectionSortTiming (int[] randomArr) {
		
		//this is the time in the beginning of the Algorithm in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the Algorithm in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the algorithm and prints the sorted array
		System.out.print(Arrays.toString(selectionSort(randomArr)));
		//this is the duration of the Algorithm in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the Algorithm in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);
	}//end selectionSortTiming
	
	/**
	 * This method takes an unsorted array and sort it using merge Sort algorithm
	 * @param array this is the unsorted array
	 * @return Returns the sorted array 
	 */
	public int[] mergeSort(int[] array) {
		
		/*
		 * int[] sortedArray= randomArr.clone();
		 * the cloning of the input array will be done in method main to avoid recursive cloning
		 */
		
		//if array length is 0 or 1 it's already sorted
		if(array.length<2) {
			
			return array;
		}//end if
		
		//this is a local array that takes the first half of the input array
		int[] leftHalf= new int [array.length/2];
		for(int i=0; i<leftHalf.length;i++) {
			
			leftHalf[i] = array[i];
		}//end for 
		
		//this is a local array that takes the second half of the input array
		int[] rightHalf= new int [array.length -array.length/2];
		for(int i=0; i<rightHalf.length;i++) {
			
			rightHalf[i] = array[i+ leftHalf.length];
		}//end for
		
		//Recursively split both array halves and assign them
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		//**************************merge the devised arrays************************
		//leftHalf, rightHalf, array indexes 
		int i=0, j=0, k=0;
		
		//compare leftHalf rightHalf elements 
		while(i<leftHalf.length && j <rightHalf.length) {
			//if leftHalf one is smaller put it in array and increment leftHalf index
			if (leftHalf[i]<=rightHalf[j]) {
				
				array[k]=leftHalf[i];
				i++;
			//otherwise put rightHalf element in array and increment rightHalf index
			}else {
				array[k]=rightHalf[j];
				j++;
			}
			//increment array index
			k++;
			
		}
		//Put the remaining elements into array
		while (i<leftHalf.length ) {
			array[k]=leftHalf[i];
			i++;
			k++;
		}
		
		//Put the remaining elements into array
		while (j<rightHalf.length ) {
			array[k]=rightHalf[j];
			j++;
			k++;
		}
		
		return array;
	}//end mergeSort
	
	/**
	 * This method calculates and displays the processing time of the Algorithm as well as the sorted array
	 * @param array is the array to be sorted
	 */
	public void mergeSortTiming (int[] array) {
		
		//this is the time in the beginning of the Algorithm in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the Algorithm in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the algorithm and prints the sorted array
		System.out.print(Arrays.toString(mergeSort(array)));
		//this is the duration of the Algorithm in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the Algorithm in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);
	}//end mergeSortTiming
	
	/**
	 * This method takes an unsorted array and sort it using quick Sort algorithm
	 * @param array this is the unsorted array
	 * @param start is the first index of array
	 * @param end is the last index of array
	 * @return Returns the sorted array
	 *  
	 */
	public int[] quickSort(int[] array, int start, int end) {
		
		/*int[] sortedArray= randomArr.clone();
		 * the cloning of the input array will be done in method main to avoid recursive cloning
		 */
		
		//The recursive method will stop if the input array has less than two elements
		if (start>=end) {
			return array;
		}//end if
		
		//it defines a pivot index and compares the element at this index with the rest of the array elements
		int pivot= start;
		//represents the boundaries of the partitioned arrays
		// very important declaration otherwise the recursion will take incremented start and decremented  end so it won't iterate within all the input array 
		int left=start+1, right=end;
		//loops through all array's elements
		while (left<right) {//don't use start and end here they are global scope for partitioned method if used
			
			//increments left index until it finds greater element than pivot element
			while(array[left] < array[pivot] && left<right) {
				
				left++;
			}//end while

			//decrements right index until it finds a lower element than pivot element
			while(array[right] > array[pivot] && left<right) {
				right--;	
			}//end while
			//it switches elements when left element is greater than pivot element and right element is lower 
			if(left<right){
			int temp=array[left];
			array[left]=array[right];
			array[right]=temp;
			//increment the indices to advance to check the remaining elements
			left++;
			right--;
			}
		}//end while
		
		//switch pivot and left-1 element if left element is greater than pivot
		if (array[left] >array[pivot]) {
			int temp=array[pivot];
			array[pivot]=array[left-1];
			array[left-1]=temp;
			//Recursively call the mergeSort method on the array that holds elements lower than pivot element
			quickSort(array, start, left-2);
			//Recursively call the mergeSort method on the array that holds elements grater than pivot element
			quickSort(array, left, end);
		//if not switch pivot and left element	
		}else {
			int temp=array[pivot];
			array[pivot]=array[left];
			array[left]=temp;
			//Recursively call the mergeSort method on the array that holds elements lower than pivot element
			quickSort(array, start, left-1);
			//Recursively call the mergeSort method on the array that holds elements grater than pivot element
			quickSort(array, left+1, end);
			
		}//end else

		return array;
	}//end quickSort
	
	/**
	 * This method calculates and displays the processing time of the Algorithm as well as the sorted array
	 * @param array is the array to be sorted
	 */
	public void quickSortTiming (int[] array) {
		
		//this is the time in the beginning of the Algorithm in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the Algorithm in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the algorithm and prints the sorted array
		System.out.print(Arrays.toString(quickSort(array ,0, array.length-1)));
		//this is the duration of the Algorithm in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the Algorithm in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);
		
	}//end quickSortTiming
	
}//end class
