package Homework;

import java.util.Arrays;
import java.util.Scanner;
public class HwTasks {

	public static void main(String[] args) {
		
		
		//Task 1
		int[] task1arr = new int[3];
		task1arr[0] = 1;
		task1arr[1] = 2;
		task1arr[2] = 3;
		task1arr.toString();
		for (int i = 0; i < task1arr.length; i++) {
            System.out.println("Element at index " + i + ": " + task1arr[i]);
        }
		
		
		//Task 2
		int[] task2arr = {13,5,7,68,2};
		int task2ans = task2arr.length/2;
		System.out.println(task2arr[task2ans]);
		
		
		
		//Task 3
		String[] originalArray = {"red", "green", "blue", "yellow"};

        System.out.println("Original Array Length: " + originalArray.length);
        String[] copiedArray = originalArray.clone();

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));
        
        
        //Task 5
        int[] task5arr = new int[5];
        for (int i = 0; i < task5arr.length; i++) {
            task5arr[i] = i;
            System.out.print(task5arr[i] + " ");
        }
        System.out.println();
        
        
        //Task 6
        int[] task6arr = new int[5];

        for (int i = 0; i < task6arr.length; i++) {
            task6arr[i] = i * 2;
            System.out.print(task6arr[i]+ " ");
            
        }
        System.out.println();
        
        
        //Task 7
        int[] task7arr = {1, 2, 3, 4, 5};

        for (int i = 0; i < task7arr.length; i++) {
            if (i != task7arr.length/2) { 
                System.out.println("Element at index " + i + ": " + task7arr[i]);
            }
        }
        
        
        //Task 8
        String[] task8arr = {"A", "B", "C", "D", "E"};
        System.out.println("Original Array: " + Arrays.toString(task8arr));
        String temp = task8arr[0];
        task8arr[0] = task8arr[task8arr.length/2];
        task8arr[task8arr.length/2] = temp;
        System.out.println("Array after swapping: " + Arrays.toString(task8arr));
        
        
        //Task 9
        int[] task9arr = {4, 2, 9, 13, 1, 0};

        // This might be cheating
        Arrays.sort(task9arr);
        
        System.out.print("Array in ascending order: ");
        for (int i = 0; i < task9arr.length; i++) {
            System.out.print(task9arr[i]);
            if (i < task9arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        int smallest = task9arr[0];
        int largest = task9arr[task9arr.length - 1];

        System.out.println("The smallest number is " + smallest);
        System.out.println("The biggest number is " + largest);
        
        //Task 11
        
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many favorite things they have
        System.out.print("How many favorite things do you have? ");
        int numFavorites = scanner.nextInt();

        // Create a String array of the correct size
        String[] favoriteThings = new String[numFavorites];

        // Consume the newline character
        scanner.nextLine();

        // Ask the user to enter their favorite things and store them in the array
        for (int i = 0; i < numFavorites; i++) {
            System.out.print("Enter favorite thing #" + (i + 1) + ": ");
            favoriteThings[i] = scanner.nextLine();
        }

        // Close the Scanner
        scanner.close();

        // Print out the contents of the array
        System.out.println("Your favorite things:");
        for (String favorite : favoriteThings) {
            System.out.println(favorite);
        }
	}

}
