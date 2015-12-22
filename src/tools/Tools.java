package tools;

/**
 * Created by Jógvan 22/12-2015 20:54.
 */
public class Tools {

    /**
     *
     * @param num
     * @param index
     * @return the number at that index
     */
    public static int nthNumber(int num, int index){
        return (int)(num / Math.pow(10, index)) % 10;
    }

    /**
     * Copies <code>array</code> to <code>otherArray</code>
     * copies the indexes from <code>start</code> to <code>end</code>
     *
     * Example usage: <code>copyArray(myArray, 0, myArray.length, newArray);</code>
     * @param array the array you want to copy
     * @param start the index from where you want to copy from
     * @param end to index you want to copy from
     * @param otherArray the new array that you want to copy into
     */
    public static void copyArray(int[] array, int start, int end, int[] otherArray){
        for (int i = start; i < end; i++) {
            otherArray[i] = array[i];
        }
    }

}
