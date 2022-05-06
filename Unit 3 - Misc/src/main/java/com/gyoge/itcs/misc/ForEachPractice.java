
public class ForEachPractice {

	public static void main(String[] args) {
		/* Problem #1
		 * The following for each loop is meant to
		 * display all values in the array nums.
		 * However, it throws an index out of bounds exception.
		 * Fix the code. This is a very small change no big overhaul needed.
		 */
		int[] nums = {2, 4, 6, 8, 10};
		for (int x : nums) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		/* Problem #2
		 * Write a for each loop that calculates the sum
		 * of all numbers in the above array - nums.
		 */
		int sum = 0;
             for (int x : nums) {
			sum += x;
		}
             System.out.println(sum);
        
		
		
		
		/* Problem #3
		 * Count and report the number of integers
		 * greater than 10 in a 2D array - grid.
		 * This requires a nested for each loop.
		 * The outer loop has been given for you.
		 * Remember that 2D arrays are just arrays of arrays.
		 * row will contain each sub array (each row) of grid.
		 * So the inner loop just needs to access each integer in row
		 */
		int[][] grid = {{3, 2, 34, 9}, {5, 15, 7, 18}, {8, 10, 11, 12}};
		int count = 0; // number of integers above 10
		for (int[] row : grid) {
			// Your code here - use a for each loop and an if statement.			
                 for (int x : row) {count += x > 10 ? 1 : 0;}
		}
System.out.println(count);
	}

}
