package Arrays.AssignmentMar152026;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Solutions {

    /**
     *You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * <p>
     * Input Format
     * <p>
     * Integer N. Integer array of length N.
     * <p>
     * Constraints
     * <p>
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     * Output Format
     * <p>
     * Integer.
     */
    public static int best_time_to_buy_and_sell_stock(int n, List<Integer> arr) {

        int minPriceSoFar = arr.getFirst(), maxProfit = 0;

        for(int i = 1; i < arr.size(); i++) {

            int profit = arr.get(i) - minPriceSoFar;
            maxProfit = Math.max(maxProfit, profit);
            if(arr.get(i) < minPriceSoFar){
                minPriceSoFar = arr.get(i);
            }
        }

        return maxProfit;
    } // T -> O(n) S -> O(1)

    /**
     * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
     * <p>
     * - For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
     * <p>
     * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
     * <p>
     * - Each element of nums is in exactly one pair, and - The maximum pair sum is minimized.
     * <p>
     * Return the minimized maximum pair sum after optimally pairing up the elements.
     * <p>
     * Input Format
     * <p>
     * Integer n. Integer array of length n.
     * <p>
     * Constraints
     * <p>
     * n == nums.length
     * 2 <= n <= 105
     * n is even.
     * 1 <= nums[i] <= 105
     * Output Format
     * <p>
     * Integer
     */
    public static int minPairSum(int n, List<Integer> arr) {

        Collections.sort(arr);
        int minPairSum = 0, left = 0, right = arr.size() - 1;

        while(left < right) {
            minPairSum = Math.max(minPairSum, arr.get(left) + arr.get(right));
            left++; right--;
        }
        return minPairSum;

    } // T -> O(n log n) S -> O(1)

    /**
     * We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.
     * <p>
     * Given an array, find the maximum possible sum among:
     * <p>
     * all nonempty subarrays.
     * all nonempty subsequences.
     * Print the two values as space-separated integers on one line.
     * <p>
     * Note that empty subarrays/subsequences should not be considered.
     */
    public static List<Integer> maxSubarray(List<Integer> arr) {

        int maxSum = arr.getFirst();
        int maxSumSubSeq = 0;
        int currSum = arr.getFirst();
        boolean hasPositive = false;

        for (int i = 1; i < arr.size(); i++) {
            currSum = Math.max(arr.get(i), currSum + arr.get(i));
            maxSum = Math.max(maxSum, currSum);
        }
        for (Integer integer : arr) {

            if (integer >= 0) {
                maxSumSubSeq += integer;
                hasPositive = true;
            }
        }

        maxSumSubSeq = !hasPositive ? maxSum : maxSumSubSeq;

        return Arrays.asList(maxSum, maxSumSubSeq);

    } // T -> O(n) S -> O(1) since result always size 2

    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]). Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     * Notice that you may not slant the container.
     * <p>
     * Input Format
     * <p>
     * First line is the number of vertical lines.
     * Second line is the array having height for each line.
     * <p>
     * Constraints
     * <p>
     * n == height.length
     * 2 <= n <= 105
     * 0 <= height[i] <= 104
     * <p>
     * Output Format
     * <p>
     * Return the maximum amount of water a container can store.
     */
    public static int maxArea(int n, List<Integer> height) {

        int left = 0, right = height.size() - 1, maxArea = 0;

        while(left < right) {

            maxArea = Math.max(maxArea, (right - left) * Math.min(height.get(left), height.get(right)));

            if(height.get(left) < height.get(right)){
                left++;
            } else if (Objects.equals(height.get(left), height.get(right))){
                left++;
                right--;
            } else {
                right--;
            }
        }

        return maxArea;
    } // T -> O(n) S -> O(1)
}
