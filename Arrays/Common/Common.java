package Arrays.Common;

public class Common {

    public static void main(String[] args) {
        majorityElement(new int[]{7, 1, 7, 2, 7, 3, 7});
    }
    /**
     * Find the majority element in the array. A majority element in an array A[] of size n is an
     * element that appears more than n/2 times (and hence there is at most one such
     * element)
     * Input : A[]={3, 3, 4, 2, 4, 4, 2, 4, 4}
     * Output : 4
     * Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size
     */
    private static void majorityElement(int[] arr) {

        int freq = 1, candidate = arr[0];

        for(int i = 1; i < arr.length; i++) {

            if(freq == 0) {
                candidate = arr[i];
                freq++;
            } else if(arr[i] == candidate) {
                freq++;
            } else {
                freq--;
            }
        }

        freq = 0;
        for (int j : arr) {
            if (j == candidate) {
                freq++;
            }
        }

        candidate = freq > (arr.length /2) ? candidate : -1;
        System.out.println("Majority Element: " + candidate);
    } // T -> O(n) S -> O(1)
}
