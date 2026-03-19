package Arrays.IndexManupolution;

import java.util.Arrays;

public class IndexManipulation {

    public static void main(String[] args) {

        // System.out.println(Arrays.toString(moveAllZerosToEnd(new int[]{10,23,0,53,0,21,0})));
        System.out.println(Arrays.toString(findThreeNumbers(new int[]{5, 32, 1, 7, 10, 50, 19, 21, 2})));
    }

    public static void swap(int[] arr, int index1, int index2) {

        if(arr == null || arr.length == 0){
            return;
        }

        if(index1 < 0
                || index1 > arr.length - 1
                || index2 < 0
                || index2 > arr.length - 1
                || index1 == index2
        ){
            return;
        }

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * Given an array of integers, move all the zeros to the end of the array while
     * maintaining the relative order of the other elements.
     * Input: Arr[]={10,23,0,53,0,21,0}
     * Output: Arr[]={10,23,53,21,0,0,0}
     */
    private static int[] moveAllZerosToEnd(int[] arr) {

        int nonZeroPtr = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                swap(arr, ++nonZeroPtr, i);
            }
        }
        return arr;
    } // T -> O(n) S -> O(1)

    /**
     * Given an array of integers, you have to find three numbers such that the sum of two
     * elements equals the third element.
     * Input : {5, 32, 1, 7, 10, 50, 19, 21, 2}
     * Output : 21, 2, 19
     */
    private static int[] findThreeNumbers(int[] arr) {

        Arrays.sort(arr); // {1, 2, 5, 7, 10, 19, 21, 32, 50}

        int n = arr.length;

        for(int i = n - 1; i >= 0; i--) {

            int target = arr[i], left = 0, right = i - 1;

            while(left < right) {

                int currSum = arr[left] + arr[right];

                if(currSum == target) {
                    return new int[] {arr[left], arr[right], target};
                } else if(currSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new int[]{-1, -1, -1};
    } // T -> O(n^2) S -> O(1) since we are using result array 3 in size
}
