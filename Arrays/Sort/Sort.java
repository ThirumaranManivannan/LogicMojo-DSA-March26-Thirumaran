package Arrays.Sort;

import java.util.Arrays;

import static Arrays.IndexManupolution.IndexManipulation.swap;

public class Sort {

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(sortInOrder(new int[]{1, 1, 1, 1})));
        // mergeInOrder(new int[]{1, 5, 5, 8}, new int[]{5, 9, 10});
//        System.out.println(minRequiredPlatforms(new double[]{ 15.00, 16.00 },
//                new double[]{ 16.00, 17.00 }));
        sortInOrderNegAndPos(new int[]{0, -1, 2, -3, 0, 4});
    }

    /**
     * Given an array containing only 0’s, 1’s, and 2’s,
     * sort it in linear time and using constant space
     * [2, 0, 2, 1, 1, 0]
     */
    private static int[] sortInOrder(int[] arr) {

        int zeros = 0, pivot = 0, twos = arr.length - 1;

        while(pivot < twos) {
            if(arr[pivot] == 0) {
                swap(arr, zeros, pivot);
                pivot++;
                zeros++;
            } else if(arr[pivot] == 2) {
                swap(arr, pivot, twos);
                twos--;
            } else {
                pivot++;
            }
        }
        return arr;
    } // T -> O(n) S -> O(1)

    /**
     * Given two sorted arrays, X[] and Y[] of size m and n each, merge elements of X[] with
     * elements of array Y[] by maintaining the sorted order, i.e., fill X[] with the first m the smallest
     * elements and fill Y[] with remaining elements.
     * Input:
     * X[] = { 1, 4, 7, 8, 10 }
     * Y[] = { 2, 3, 9 }
     * Output:
     * X[] = { 1, 2, 3, 4, 7 }
     * Y[] = { 8, 9, 10 }
     */
    private static void mergeInOrder(int[] x, int[] y) {
        int m = x.length, n = y.length, xPtr = 0, yPtr = 0;

        while(xPtr < m) {

            if(y[yPtr] < x[xPtr]) {
                int temp = x[xPtr];
                x[xPtr] = y[yPtr];
                y[yPtr] = temp;
                for(int i = 1; i < n; i++) {
                    if(y[i] < y[ i - 1]) {
                        swap(y, i, i - 1);
                    }
                }
            }
            xPtr++;
        }
        System.out.println("After sort\n" + Arrays.toString(x) + "\n" + Arrays.toString(y));
    } // T -> O(m * n) S -> O(1)

    /**
     * Given a schedule containing the arrival and departure time of trains in a station, find the
     * minimum number of platforms needed to avoid delay in any train’s arrival.
     * Example: Trains arrival = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 }
     * Trains departure = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 }
     * The minimum platforms needed is 2
     * approach sort both of them
     * arr = {2.00, 2.10, 3.00, 3.20, 3.50, 5.00}
     * dep = {2.30, 3.20, 3.40, 4.00, 4.30, 5.20}
     */
    private static int minRequiredPlatforms(double[] arr, double[] dep) {

        int i = 0, j = 0, n = arr.length;
        int minPlatformRequired = 0;
        int currMax = 0;
        Arrays.sort(arr); Arrays.sort(dep);

        while(i < n) {

            if(arr[i] < dep[j]) {
                currMax++;
                minPlatformRequired = Math.max(minPlatformRequired, currMax);
            } else{
                currMax--;
                j++;
            }
            i++;
        }
        return minPlatformRequired;
    } // T -> O(n log n) S -> O(1)

    /**
     * An array contains both positive and negative numbers in random order.
     * Rearrange the array elements so that all negative numbers appear before all
     * positive numbers.
     * Examples :
     * Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
     * Output: -12 -13 -5 -7 -3 -6 11 6 5
     */
    private static void sortInOrderNegAndPos(int[] arr) {
        int neg = 0, pos = arr.length - 1;

        while(neg < pos) {

            if(arr[neg] < 0) {
                neg++;
            } else {
                swap(arr, neg, pos--);
            }
        }
        System.out.println("After sort:\n" + Arrays.toString(arr));
    } // T O(n) S O(1)
}
