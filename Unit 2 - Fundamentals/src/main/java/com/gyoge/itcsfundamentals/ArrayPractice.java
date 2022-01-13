package com.gyoge.itcsfundamentals;


public class ArrayPractice {

    private ArrayPractice() {
        throw new IllegalStateException("Utility class");
    }

    /** Print out an int array. */
    public static void printArray(int[] nums) {
        for (Object num : nums) {
            System.out.print(num + ", ");
        }
        System.out.print("\n");
    }

    /** Swap the first and last elements of an int array. */
    public static void swapFirstLast(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[nums.length - 1];
        nums[nums.length - 1] = temp;
    }

    /** Find the average of an int array. */
    public static double findAverage(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (double) sum / nums.length;
    }

    /** Find and return the index of the smallest value in an int array. */
    public static int findSmallest(int[] nums) {
        int smallest = nums[0];
        int smallestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < smallest) {
                smallest = nums[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /**
     * Check if a target value is present in a string array.
     *
     * @param words  The array to search.
     * @param target The target value to search for.
     * @return Whether the target is present in the array.
     */
    public static boolean isPresent(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }

    /** Check whether an int array is sorted */
    public static boolean isInOrder(int[] nums) {
        int previous = nums[0];
        for (int num : nums) {
            if (num < previous) {
                return false;
            }
        }
        return true;
    }

}
