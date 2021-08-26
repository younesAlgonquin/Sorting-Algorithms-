
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * <br>Declaration: I declare that this is my own original work and is free from Plagiarism
 * <br>This class tests the program by displaying a menu of options and prompts users to choose one of them.
 * <br>then it displays an array of integers and performs binary & iterative search and sorts the array using the chosen algorithm 
 * <br>Student Name: Younes Boutaleb
 * <br>Student Number: 041019068 
 * <br>Section #: 303
 * <br>Course: CST8130 - Data Structures
 * <br>Professor: James Mwangi PhD.
 * @author Younes Boutaleb.
 * @version 1.0
 * 
 */
public class TestSearchSort {

	/**
	 * This is the method main where we test our program
	 * @param args
	 */
	public static void main(String[] args) {

		//Scanner object used to get the user's inputs
		Scanner input = new Scanner(System.in).useDelimiter("\r\n");
		//BinaryLinearSearch object used to declare an array and call search methods
		BinaryLinearSearch demoSearch = new BinaryLinearSearch(1000);
		//this array will store the elements of the generated array
		int[] randomArr = null;
		//this array will store the elements of randomArray in a sorted way
		int[] sortedRandomArr = null;

		//This is the menu option that will be entered by users
		int option =0;
		//The while loop display the menu and executes the chosen option in each iteration until the Quit option is chosen 
		while(option !=5) {

			//Displays the main menu
			mainMenu ();

			//checks for integer input
			try {
				option = input.nextInt();

				//This is the switch statement  that executes the user's choice
				switch(option) {

				//in this case it generates an array of random integers and print it
				case 1: 
					randomArr= (demoSearch.generateRandomInts()).clone();
					//prints the elements of randomArr
					System.out.println("Array of randomly generated integers:");
					System.out.print(Arrays.toString(randomArr));
					//Clone randomArr elements
					sortedRandomArr= randomArr.clone();
					//sort sortedRandomArr
					Arrays.sort(sortedRandomArr);

					break;

				//in this case the program prompts users to enter the value to search then displays the recursive binary & linear search results and timing
				case 2:
					//checks for integer input
					try {
						System.out.println("Please enter an integer value to search: ");
						int key = input.nextInt();
						//prints the elements of randomArr
						System.out.print(Arrays.toString(randomArr));
						//calls the recursive binary search methods on the sorted method
						demoSearch.recursiveBinarySearchTiming(sortedRandomArr, 0, sortedRandomArr.length-1, key);
						//calls the recursive linear search methods on the unsorted method
						demoSearch.recursiveLinearSearchTiming(randomArr, randomArr.length, key);
						//it outputs an error message in case of non-integer input
					}catch (InputMismatchException ex) {
						System.out.printf("*****Input Mismatch Exception*****", ex);
						input.nextLine();
					}//end try & catch
					//ends the switch statement 
					break;

				//in this case the program prompts users to enter the value to search then displays the iterative binary & linear search results and timing
				case 3:
					//checks for integer input
					try {
						System.out.println("Please enter an integer value to search: ");
						int key = input.nextInt();
						//prints the elements of randomArr
						System.out.print(Arrays.toString(randomArr));
						//calls the iterative binary search method on the sorted method
						demoSearch.iterativeBinarySearchTiming(sortedRandomArr, key);
						//calls the iterative linear search method on the unsorted method
						demoSearch.iterativeLinearSearchTiming(randomArr, key);
					//it outputs an error message in case of non-integer input
					}catch (InputMismatchException ex) {
						System.out.printf("*****Input Mismatch Exception*****", ex);
						input.nextLine();
					}//end try & catch
					//ends the switch statement 
					break;

				//in this case the user chose the sort algorithm then displays the sorted array
				case 4:
					// calls the sort method which display the menu and perform the chosen algorithm
					sortArray(input, randomArr);
					break;

				//This option shutdown the program
				case 5:
					System.out.println("exiting...");
					//ends the switch statement 
					break;

				//it outputs an error message if the option input is not 1, 2, 3, 4 or 5
				default:
					System.out.print("Please choose the option 1 to 5.");
					//ends the switch statement 
					break;

				}//end switch
				//it outputs an error message in case of non-integer input
			}catch (InputMismatchException ex) {
				System.out.printf("*****Input Mismatch Exception*****", ex);
				input.nextLine();
			}//end try & catch
		}//end while

		//closes the Scanner object
		input.close();

	}//end main	

	
	/**
	 * This method generates and displays the main menu
	 */
	public static void mainMenu () {

		//this formats and prints the options menu
		String formatString = "\n\nSelect your option in the menu below:\n";
		formatString += "%d. Initialize and populate an array of 1000 random integers.\n";
		formatString += "%d. Perform recursive binary and linear search.\n";
		formatString += "%d. Perform iterative binary and linear search.\n";
		formatString += "%d. Sort the array.\n";
		formatString += "%d. Quit.\n";
		System.out.print(String.format(formatString, 1, 2, 3, 4, 5));

	}//end mainMenu

	
	/**
	 * This method generates and displays the menu of sort algorithms to be performed 
	 */
	public static void sortMenu () {

		//this formats and prints the options menu
		String formatString = "\n\nSelect a sorting algorithm to sort the data array\n";
		formatString += "	B. Bubble Sort\n";
		formatString += "	I. Insertion Sort\n";
		formatString += "	S. Selection Sort\n";
		formatString += "	M. Merge Sort\n";
		formatString += "	Q. Quick Sort\n";
		formatString += "	R. Return to Main Menu\n";
		System.out.print(String.format(formatString));

	}//end sortMenu

	
	/**
	 * This method displays the sort menu and prompts for user's choice then calls for the appropriate sorting method
	 * @param input this is the scanner object
	 * @param randomArr this is the array to be sorted
	 */
	public static void sortArray(Scanner input, int[] randomArr) {

		//This is the user input for the algorithm to perform
		String AlgorithmInput="";
		//this is the first character of the user input
		char AlgorithmType = ' ';
		//SortAlgorithms object used to call the sorting methods
		SortingAlgorithms demoSort = new SortingAlgorithms();

		//clear the scanner as it has the integer option
		input.nextLine();

		//The while loop continues until the user decides to return to main menu
		while(AlgorithmType != 'R') {

			//Displays menu and Prompts the user for the Algorithm to perform
			sortMenu ();
			AlgorithmInput=input.nextLine();

			//The if statement checks whether the user entered only one character
			if(AlgorithmInput.length()!=1) {
				System.out.println("Invalid entry");
			}else {
				//if the user enters a character it assigns it to the AlgorithmType variable
				AlgorithmType=AlgorithmInput.charAt(0);

				//Switch structure validates the user's choice then sorts the array
				switch(AlgorithmType) {

				case 'B':

					//prints the elements of the unsorted randomArr
					System.out.println(Arrays.toString(randomArr));
					System.out.println("Bubble Sort: Simple sorting algorithm - O(n2) Complexity -");
					//Sorts the array and prints it as well as the algorithm duration
					demoSort.bubbleSortTiming(randomArr);
					break;

				case 'I':

					//prints the elements of the unsorted randomArr
					System.out.println(Arrays.toString(randomArr));
					System.out.println("Insertion Sort: Simple sorting algorithm - O(n2) Complexity -");
					//Sorts the array and prints it as well as the algorithm duration
					demoSort.insertionSortTiming(randomArr);
					break;

				case 'S':

					//prints the elements of the unsorted randomArr
					System.out.println(Arrays.toString(randomArr));
					System.out.println("Selection Sort: Simple sorting algorithm - O(n2) Complexity -");
					//Sorts the array and prints it as well as the algorithm duration
					demoSort.selectionSortTiming(randomArr);
					break;

				case 'M':

					//the cloning of the input array will be done here to avoid recursive cloning if we clone it inside the mergeSort method
					int[] mergeArray= randomArr.clone();
					//prints the elements of the unsorted randomArr
					System.out.println(Arrays.toString(mergeArray));
					System.out.println("Merge Sort: Recursive Divide-And-Conquer - O(n log n) Complexity -");
					//Sorts the array and prints it as well as the algorithm duration
					demoSort.mergeSortTiming(mergeArray);
					break;

				case 'Q':

					//the cloning of the input array will be done here to avoid recursive cloning if we clone it inside the quickSort method
					int[] quickArray= randomArr.clone();
					//prints the elements of the unsorted randomArr
					System.out.println(Arrays.toString(quickArray));
					System.out.println("Quick Sort: Recursive Divide-And-Conquer - O(n log n) Complexity -");
					//Sorts the array and prints it as well as the algorithm duration
					demoSort.quickSortTiming(quickArray);
					break;

				case 'R':
					//returns to the main menu
					System.out.print("Returning to main menu...");
					break;

				default:
					//loop back to the sort menu and asks fo r a valid input
					System.out.print("Invalid algorithm type");
					break;

				}//end switch
			}//end else
		}//end while
	}//end sortArray

}//end class
