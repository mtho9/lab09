package Lab9;

/**
 * 
 * @author mandyho
 * @verison 29 nov 2023
 */
public class RadixSortRC {
    // The array keeping the digit counts
    int[] digitCounts;

    // The array keeping the running counts
    int[] runningCounts;

    // Used for finding digit and running counts
    static final int RADIX_BASE = 10;
    static final int[] POWERS_OF_TEN = { 1, 10, 100 };

    public RadixSortRC() {
        digitCounts = new int[RADIX_BASE];
        runningCounts = new int[RADIX_BASE];
    }

    /**
     * @param input array of int to be sorted (only integers with 3 digits ranging from 100 to 999
     * @return sorted array
     */
    public int[] sort(int[]input)
    {
        // this array will be used in your code as the copy array
        int[] copyArray = new int[input.length];
        
        
        for (int pass = 1; pass<=3; pass++)
        {
            // this value is used to get the corresponding digit in each pass
            int divisor = POWERS_OF_TEN[pass-1];
            
            // this method will update the digit counts array accordingly
            updateDigitCounts(input, divisor);
            
            // updates the running counts
            updateRunningCounts();
            
            
        // 1) Look at digit of current element in array, (interating through it)
            for (int i = 1; i<=input.length-1;i++) {
               if(currentDigit%divisor=0) { // some sort of check here to make sure we're on the same digit for all elements before another pass
        // 2) check it's running count
                   runningCounts[i];
        // 3) whatever that number is, add the digit of index of i in copy array
        // do I need a check somewhere to make sure the structure is stable? ex) 2 same digits, element that's ascending gets added first
                   copyArray.add(currentDigit);
        // 4) increment the running count before you move onto next element            
                   runningCounts[i+1];
               
               }
                
            }
   
            }
            return copyArray;            
            
        }

    // you may modify this line if needed
    return input;

    }

    private void updateRunningCounts() {
        // updats the running counts
        runningCounts = new int[RADIX_BASE];
        runningCounts[0] = 0;
        for (int i = 0; i < runningCounts.length - 1; i++)
            runningCounts[i + 1] = digitCounts[i] + runningCounts[i];
    }

    private void updateDigitCounts(int[] input, int divisor) {
        // updates the digit counts
        digitCounts = new int[RADIX_BASE];
        for (int num : input)
            digitCounts[(num / divisor) % RADIX_BASE]++;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 100, 200, 333, 431, 198 };
        RadixSortRC r = new RadixSortRC();
        r.sort(arr);
    }

}
