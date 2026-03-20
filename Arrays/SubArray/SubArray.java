package Arrays.SubArray;

import java.util.HashMap;
import java.util.Map;

public class SubArray {

    public static void main(String[] args) {
//        findArray(new int[]{1, 4, 20, 3, 10, 5}, 33);
//        findArray(new int[]{1, 4, 20, 3, 10, 5}, 12);
//        findLargestSubArrayWithEq(new int[] {0, 1});
        findLongestWithEqOddAndEven(new int[]{1, 2, 1, 2});
    }
    /**
     * Given an unsorted array of integers, find a subarray that adds to a given number. If there
     * is more than one subarray with the sum of the given number, print any of them.
     * Examples:
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, targetSum = 33
     * Output: Sum found between indexes 2 and 4
     * Explanation: Sum of elements between indices
     * 2 and 4 is 20 + 3 + 10 = 33
     */
    private static void findArray(int[] arr, int targetSum) {

        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {

            currSum += arr[i];

            if(currSum == targetSum) {
                System.out.printf("SubArray whose sum %d is starting at %d and end at %d \n", targetSum, 0, i);
                return;
            }

            if(prefixSumMap.containsKey(currSum - targetSum)) {
                System.out.printf("SubArray whose sum %d is starting at %d and end at %d\n",
                        targetSum, prefixSumMap.get(currSum - targetSum) + 1, i);
                return;
            }
            prefixSumMap.put(currSum, i);
        }

        System.out.println("No subArray Found");
    } // T -> O(n) S -> O(n)

    /**
     * Given an array containing only 0s and 1s, find the largest subarray which contains equal
     * no of 0s and 1s.
     * Input: arr[] = {0, 0, 1, 1, 0}
     * Output: 0 to 3 Or 1 to 4
     */
    private static void findLargestSubArrayWithEq(int[] arr) {

        int sum = 0, maxLen = 0, end = -1;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : 1;

            if(sum == 0) {
                maxLen = i + 1;
                end = i;
            }

            if(prefixSumMap.containsKey(sum)) {
                if(maxLen < i - prefixSumMap.get(sum)) {
                    maxLen = i - prefixSumMap.get(sum);
                    end = i;
                }
            } else {
                prefixSumMap.put(sum, i);
            }
        }

        System.out.printf("Maximum len %d and start %d and end %d",
                maxLen, (end - maxLen + 1), end);
    } // T -> O(n) S O(n)

    /**
     * Given an integer array arr[], the task is to find the length of the longest subarray with an
     * equal number of odd and even elements.
     * Input: arr[] = {1, 2, 1, 2}
     * Output: 4
     * Explanation:
     * Subarrays in the given array are –
     * {{1}, {1, 2}, {1, 2, 1}, {1, 2, 1, 2}, {2}, {2, 1}, {2, 1, 2}, {1}, {1, 2}, {2}}
     * where the length of the longest subarray with an equal number of even and odd elements is 4 – {1,
     * 2, 1, 2}
     */
    private static void findLongestWithEqOddAndEven(int[] arr) {
         int maxLen = 0, currSum = 0, end = -1;

         Map<Integer, Integer> prefixSumMap = new HashMap<>();

         for(int i = 0; i < arr.length; i++) {
             currSum += arr[i] % 2 == 0 ? 1 : -1;

             if(currSum == 0) {
                 if(maxLen < i) {
                     maxLen = i + 1;
                     end = i;
                 }
             }

             if(prefixSumMap.containsKey(currSum)) {
                 if(maxLen < i - prefixSumMap.get(currSum)) {
                     maxLen = i - prefixSumMap.get(currSum);
                     end = i;
                 }
             } else {
                 prefixSumMap.put(currSum, i);
             }
         }
         if(end == -1) {
             System.out.println("No subarrays found");
         } else {
             System.out.printf("Maximum len %d and start %d and end %d",
                     maxLen, (end - maxLen + 1), end);
         }
    }
}
