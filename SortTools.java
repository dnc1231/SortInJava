// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Daniel Canterino
 * djc3323
 * 15460
 * Spring 2017
 * Slip days used: 0
 */

package assignment1;
public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		int i = 0;
		if (n == 0 || x.length == 0) {//checks for edge false cases
			return false;
		}
		while ((i + 1) < n) {
			if (x[i] > x[i + 1]) {//if any of the values are decreasing in order, return false as the array is not sorted
				return false;
			}
			i++;
		}
		return true;
	}
	
	/**
	  * This method tests to see if the given array contains a value.
	  * @param nums is the array
	  * @param n is the size of the input to be checked
	  * @param v is the value to be found
	  * @return the index at which the value is found
	  * @return -1 if the value is not found in the array
	  */
	public static int find(int[] nums, int n, int v) {
		int curIndex = n/2;//starting index is at the median value
		int lowIndex = 0;//the starting lower index is the least value
		if (n > 0) {
			int highIndex = n - 1;//the starting max index is the highest value if n is > 0
			while ((curIndex < n) && (curIndex > 0) && (lowIndex < highIndex)) {
				if (nums[curIndex] == v) {
					return curIndex;
				}
				else if (nums[curIndex] > v) {
					highIndex = curIndex - 1;//updates the new highIndex to be the index left of curIndex
					curIndex = (highIndex + lowIndex) / 2;//if the value is less than the value at the current index, updates check to be median between the lowIndex and curIndex
				}
				else if (nums[curIndex] < v) {
					lowIndex = curIndex + 1;//updates the new lowIndex to be the index right of curIndex
					curIndex = (lowIndex + highIndex) / 2;//if the value is greater than the value at the current index, updates check to be median between the highIndex and curIndex
				}
			}
			if (nums[highIndex] == v) {
				return highIndex;
			}
		}
		if (nums[0] == v) {//checks for edge cases
			return 0;
		}
		else if (nums[lowIndex] == v) {
			return lowIndex;
		}
		curIndex = -1;
		return curIndex;
	}
	
	/**
	  * This method adds a value to an an array passed and returns a new array containing the first n values of the passed array
	  * and the value passed to be added if it is not already in the array.
	  * @param nums is the array
	  * @param n is the size of the input to be checked
	  * @param v is the value to be added to the array
	  * @return a new array containing the first n values of the passed array plus the new value
	  * @return a new array containing only the first n values of the passed array if the value passed was already in the array
	  */
	
	public static int[] insertGeneral(int[] nums, int n, int v) {
		int i = 0;
		int isInArr = find(nums, n, v);
		if (n == 0) {
			int[] newArr = new int[]{v};
			return newArr;
		}
		else if (isInArr >= 0) {//if the value is in the array, creates and returns a copy of the passed array
			int newArr[] = new int[n];
			while (i < n) {
				newArr[i] = nums[i];
				i++;
			}
			return newArr;
		}
		else {
			int newArr[] = new int[n + 1];
			while (nums[i] < v) {//creates copy of array until index where new value to be added is founded
				newArr[i] = nums[i];
				i++;
			}
			newArr[i] = v;//adds the new value to the array
			i++;
			while ((i - 1) < n) {//i-1 for the old array index since it is now offset by one as the new array has one more value in it (v)
				newArr[i] = nums[i - 1];
				i++;
			}
			return newArr;
		}
	}
	
	
	/**
	  * This method inserts a value passed into an array.
	  * @param nums is the array
	  * @param n is the size of the input to be checked
	  * @param v is the value to be added to the array
	  * @return the number of elements sorted/checked in the array
	  */
	public static int insertInPlace(int[] nums, int n, int v) {
		int i = 0;
		int isInArr = find(nums, n, v);//if the value is already in the array, does nothing
		if (isInArr >= 0) {
			return n;
		}
		while (nums[i] < v && i < n) {//finds index where number needs to be inserted
			i++;
		}
		int temp = nums[i];//creates a temp value for values that will be overwritten
		nums[i] = v;
		i++;
		while ((i - 1) < n) {//continues writing over the array until it reaches the n index
			nums[i] = temp;
			temp = nums[i + 1];
			i++;
		}
		return n + 1;
	}
	
	/**
	  * This method sorts an array.
	  * @param nums is the array
	  * @param n is the size of the input to be checked
	  * @return once the array is sorted
	  */	
	public static void insertSort(int[] nums, int n) {
		if (isSorted(nums, n)) {//O(N) if already sorted
			return;
		}
		else {
			for (int i = 1; i < n; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (nums[j] > nums[j + 1]) {//checks the value of the current j index to all in the sorted array and inserts it into its sorted place
						int temp = nums[j];
						nums[j] = nums[j + 1];
						nums[j + 1] = temp;
					}
				}
			}
		}
		return;
	}
}
