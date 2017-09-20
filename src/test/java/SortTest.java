import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    @Test
    public void SortTestRandomArray() {
        InsertionSorter sorter = new InsertionSorter();
        int[] input = {9,67,23,5,68,120,38,74,26,84,47,78,120,87,32};
        int[] sortedInput ={5,9,23,26,32,38,47,67,68,74,78,84,87,120,120};
        int[] output = sorter.InsertionSort(input);
        Assert.assertArrayEquals(sortedInput, output);
    }
}
