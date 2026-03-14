package Arrays.TwoPointers;

public class SortedArray {

    public static void main(String[] args) {

        System.out.println(pairSumExists(new int[]{10, 20, 35, 50, 75, 80}, 110));
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
    }
}
