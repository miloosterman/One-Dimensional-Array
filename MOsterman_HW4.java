/*************************************************************************
* Name: HW 4A One Dimensional Array 
* File: MOsterman_HW4.java
* Author: Milo Osterman
* Date: 2/18/2021
* Prompt:
* 
* You will write a Java program does the following:
* 
* 1. Declares an array of 10 ints
* 2. Declares an int to hold the index of the largest array element
* 3. Declares an int to hold the index of the smallest array element
* 4. Declares an int to hold the sum of the array elements
* 5. Declares a double to hold the value of the average of the array elements
* 6. Defines a method that assigns a random value to each array element
* 7. Defines a method that displays all the elements in the array
* 8. Defines a method that sorts the array using the insertion technique (the text provides
* sample code for this)
* 9. Defines a method that identifies and returns the index of the highest value in the array
* 10. Defines a method that identifies and returns the index of the lowest value in the array
* 11. Defines a method that calculates the sum of the array elements
* 12. Defines a method that calculates the average of the array elements
* 13. Defines a method that displays the results calculated by the methods described in items
* 5 through 8.
* 
*************************************************************************/

package mOsterman_HW4;

public class MOsterman_HW4 {

	public static void main(String[] args) {
		//Declare variables for index of small and large elements, sum, and average of array
		int indexOfSmallestElement;
		int indexOfLargestElement;
		int sumOfArray;
		double averageOfArray;
		int[] arrayOfTenInts = new int[10]; //Ten element array

		displayIntro();

		fillArrayWithRandomValues(arrayOfTenInts); //Populate array
		displayArray(arrayOfTenInts); //Display values of array
		indexOfLargestElement = findLargestElementOfArray(arrayOfTenInts); //Calculate and return smallest index
		indexOfSmallestElement = findSmallestElementOfArray(arrayOfTenInts); //Calculate and return largest index
		sumOfArray = calculateSumOfArrayElements(arrayOfTenInts); //Calculate and return sum of array
		averageOfArray = calculateAverageOfArrayElements(arrayOfTenInts); //Calculate and return average of array
		displaySmallLargeSumAvg(indexOfLargestElement, indexOfSmallestElement, //Display above values
				sumOfArray, averageOfArray, arrayOfTenInts);
		sortArray(arrayOfTenInts); //Sort array with selection sort from smallest to largest value
		displayArray(arrayOfTenInts); //Display sorted array
	}

	// Introduce program
	public static void displayIntro() {
		System.out.print("*****************************************************************\n"
				+ "This program declares an array of ten integers, it will\n"
				+ "populate the array with random values between 1 and 200.\n"
				+ "The program will find the largest and smallest element,\n"
				+ "then find the sum and average of the elements. These values\n"
				+ "will be displayed. Finally, the array will be sorted from\n"
				+ "smallest value to largest, the sorted array will be displayed.\n"
				+ "*****************************************************************\n\n\n");

	}

	// Populate array with random values between 1 and 200
	public static void fillArrayWithRandomValues(int[] arrayOfTenInts) {
		for (int i = 0; i < arrayOfTenInts.length; i++) {
			arrayOfTenInts[i] = Input.getRandomNumber(1, 200);
		}
	}

	// Display the initial values of array
	public static void displayArray(int[] arrayOfTenInts) {
		System.out.println("The values within the array are as follows: ");
		// Print each element using for loop
		for (int i = 0; i < arrayOfTenInts.length; i++) {
			System.out.println(arrayOfTenInts[i]);
		}
	}

	// Find and return the largest element of an array
	public static int findLargestElementOfArray(int[] arrayOfTenInts) {
		int highestValue = arrayOfTenInts[0];
		int indexOfLargestValue = 0;
		// Find largest value by setting first element as largest and checking each
		// value to see if larger
		for (int i = 0; i < arrayOfTenInts.length; i++) {
			if (arrayOfTenInts[i] > highestValue) {
				highestValue = arrayOfTenInts[i];
				indexOfLargestValue = i;
			}
		}
		return indexOfLargestValue;
	}

	// Find and return the smallest element of array
	public static int findSmallestElementOfArray(int[] arrayOfTenInts) {
		int smallestValue = arrayOfTenInts[0];
		int indexOfSmallestValue = 0;
		// Find smallest value by setting first element as smallest and checking each
		// value to see if less
		for (int i = 0; i < (arrayOfTenInts.length); i++) {
			if (arrayOfTenInts[i] < smallestValue) {
				smallestValue = arrayOfTenInts[i];
				indexOfSmallestValue = i;
			}
		}

		return indexOfSmallestValue;
	}

	// Calculate and return sum of the array elements
	public static int calculateSumOfArrayElements(int[] arrayOfTenInts) {
		int sum = 0;
		// Find sum by using sum counter variable and adding each element together
		for (int i = 0; i < (arrayOfTenInts.length); i++) {
			sum += arrayOfTenInts[i];
		}

		return sum;
	}

	// Calculate and return average of all elements in array
	public static double calculateAverageOfArrayElements(int[] arrayOfTenInts) {
		int sum = 0;
		double average = 0;

		sum = calculateSumOfArrayElements(arrayOfTenInts); // Call method to find sum of array
		average = (double) sum / arrayOfTenInts.length; // Calculate avg by dividing sum by total elements

		return average;
	}
	
	
	public static void displaySmallLargeSumAvg(int indexOfLargestElement, int indexOfSmallestElement,
				int sumOfArray, double averageOfArray, int [] arrayOfTenInts) {
		System.out.printf("\n%-40s %d", "The index of the largest element is:", indexOfLargestElement);
		System.out.printf("\n%-40s %d", "The value of the largest element is:", arrayOfTenInts[indexOfLargestElement]);
		System.out.printf("\n%-40s %d", "The index of the smallest element is:", indexOfSmallestElement);
		System.out.printf("\n%-40s %d", "The value of the smallest element is:", arrayOfTenInts[indexOfSmallestElement]);
		System.out.printf("\n%-40s %d", "The sum of the array is:", sumOfArray);
		System.out.printf("\n%-40s %.2f\n\n", "The average of the array is:", averageOfArray);
	}
	
	//Sort array with selection sort
	public static void sortArray(int[] arrayOfTenInts) {
		int currentMin = 0;
		int currentMinIndex = 0;
		for (int i = 0; i < arrayOfTenInts.length; i++) {
			currentMin = arrayOfTenInts[i];
			currentMinIndex = i;
			
			for (int j = i + 1; j < arrayOfTenInts.length; j++) {
				if (currentMin > arrayOfTenInts[j]) {
					currentMin = arrayOfTenInts[j];
					currentMinIndex = j;
				}
			}
			
			if (currentMinIndex != i) {
				arrayOfTenInts[currentMinIndex] = arrayOfTenInts[i];
				arrayOfTenInts[i] = currentMin;
			}
		}
		
		System.out.println("The array has now been sorted from low to high.\n");
	}

}
