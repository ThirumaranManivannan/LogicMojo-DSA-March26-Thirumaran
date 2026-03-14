package Arrays.TwoPointers;

import java.util.Arrays;

public class SortedArray {

    public static void main(String[] args) {

        System.out.println(pairSumExists(new int[]{10, 20, 35, 50, 75, 80}, 110));
        System.out.println(Arrays.toString(findTriplets(new int[]{0, -1, 2, -3, 1}, 0)));
        System.out.println(removeAllDuplicates(new int[]{1, 1, 2, 2, 2, 3, 4, 4}));
    }

    /**
     * Given a sorted array A (sorted in ascending order), having N integers, find if there exists any
     * pair of elements (A[i], A[j]) such that their sum is equal to X.
     * For Example: A[] = {10, 20, 35, 50, 75, 80} and the value of X = 110
     */
    private static boolean pairSumExists(int[] arr, int x) {

        int left = 0, right = arr.length - 1;

        while (left < right) {

            int currSum = arr[left] + arr[right];

            if(currSum == x) {
                System.out.println("sum exists. the pair is (" + left + "," + right + ").");
                return true;
            }else if(currSum < x) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    } // T -> O(n), S -> O(1)

    /**
     * Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
     * Examples: Input: arr[] = {0, -1, 2, -3, 1}
     * Output: (0 -1 1), (2 -3 1)
     * Explanation: The triplets with zero sum are 0 + -1 + 1 = 0 and 2 + -3 + 1 = 0
     * Input: arr[] = {1, -2, 1, 0, 5}
     * Output: 1 -2 1
     * Explanation: The triplets with zero sum is 1 + -2 + 1 = 0
     */
    private static int[] findTriplets(int[] arr, int k) { // adding k here to support variations of the same problem

        int[] triplets = new int[arr.length * 2]; // need to replace it with List<List<>>
        int tripletFiller = 0;

        Arrays.sort(arr); // T -> O(n log n)
        for(int i = 0; i < arr.length; i++) {

            int first = arr[i], second = i + 1, third = arr.length - 1;
            int target = k - first;

            while (second < third) {
                int currSum = arr[second] + arr[third];
                if (currSum == target) {
                    triplets[tripletFiller++] = first;
                    triplets[tripletFiller++] = arr[second];
                    triplets[tripletFiller++] = arr[third];
                    second++; third--;
                } else if (currSum < target) {
                    second++;
                } else {
                    third--;
                }
            }
        }
        return triplets;
    } // T -> O(n^2) S O(len(result))

    /**
     * Given a sorted array, remove all duplicates and return the length of the modified array
     * solution.
     * Examples: nums = {1, 1, 2, 2, 2, 3, 4, 4}; Output: 4
     */
    private static int removeAllDuplicates(int[] nums) {

        int length = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[++length] = nums[i];
            }
        }
        return length + 1;
    } // T -> O(n) S -> O(1)
}
