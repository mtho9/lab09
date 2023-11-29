package Lab9;

/**
 * @author Ellis Fitzgerald
 * @version 29 Novemeber 2023
 *
 */
public class MergeSort {
    
    /**
     * sort - Sorts an Array using recursive mergesort
     * @param input
     * @return - Sorted iteration of {@codeinput}
     */
    public static int[] sort(int[] input) {
        return sort(input, 0, input.length);
    }
    
    /**
     * sort - Helper method to public {@codesort}
     * @param input - Input Array
     * @param start - Start Index
     * @param end - End Index
     * @return - Sorted Array
     */
    private static int[] sort(int[] input, int start, int end) {
        if(input.length > 2) {
            int midPoint = end / 2;
            return merge(sort(input, start, midPoint), sort(input, midPoint, end));
        }
        else {;
            int[] left = {input[start]};
            int[] right = {input[end - 1]};
            return merge(left, right);
            }
        }
        
    /**
     * @param left - Left Array to merge
     * @param right - Right Array to merge
     * @return - Sorted Combination of Left and Right
     */
    private static int[] merge(int[] left, int[] right) {
        int[] mergedArray = new int[left.length + right.length];
        int inputIndex = 0;
        for(int leftIndex = 0; leftIndex < left.length; leftIndex++) {
            for(int rightIndex = 0; rightIndex < right.length; rightIndex++) {
                if(left[leftIndex] < right[rightIndex]) {
                    mergedArray[inputIndex] = leftIndex;
                    inputIndex++;
                }
                else {
                    mergedArray[inputIndex] = right[rightIndex];
                    inputIndex++;
                }
            }
        }
        return mergedArray;
    }
}
