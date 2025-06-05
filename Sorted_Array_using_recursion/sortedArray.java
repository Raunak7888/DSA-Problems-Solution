import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sortedArray {

    public static boolean ifSorted(List<Integer> arr) {
        if (arr.size() <= 0 || arr.size() <= 1) {
            return true;
        }
        if (arr.get(0) <= arr.get(1)) {
            List<Integer> newArr = arr.subList(1, arr.size()); 
            return ifSorted(newArr);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Test 1: " + ifSorted(arr1)); 
        List<Integer> arr2 = Arrays.asList(1, 2, 5, 4, 6);
        System.out.println("Test 2: " + ifSorted(arr2)); 
        List<Integer> arr3 = Arrays.asList(3, 3, 3, 3);
        System.out.println("Test 3: " + ifSorted(arr3)); 
        List<Integer> arr4 = Arrays.asList(7);
        System.out.println("Test 4: " + ifSorted(arr4)); 
        List<Integer> arr5 = new ArrayList<>();
        System.out.println("Test 5: " + ifSorted(arr5)); 
        List<Integer> arr6 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Test 6: " + ifSorted(arr6)); 
        List<Integer> arr7 = Arrays.asList(1, 2, 3, 3, 4, 9, 6, 7, 8, 9, 10);
        System.out.println("Test 7: " + ifSorted(arr7)); 
    }
}
