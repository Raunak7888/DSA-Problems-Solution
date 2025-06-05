# ✅ Check if an Array is Sorted (Recursion)

This project provides a recursive solution in Java to determine if a given array is sorted in non-decreasing order.

---

## ❓ Problem Statement

> Given an array of integers, determine whether the array is sorted in **non-decreasing order** (each element is less than or equal to the next) using recursion.

---

## 💡 Intuition

### 🧠 In Simple Terms:

You only care about whether **each pair of adjacent elements** follows the rule:  
> `current ≤ next`.

So:
- If there's **0 or 1 element**, it's already sorted.
- If the **first two elements** are in order, then check the rest of the list.
- If **any pair** breaks the order, return `false`.

---

## 🛠️ Approach

### 🧒 Casual Explanation:

> “Let me check the first two numbers. If they’re in order, I’ll ask the same question for the rest. If I ever find a pair that’s out of order, I’ll say nope.”

### 🔁 Recursive Steps:
1. **Base Case**:
   - If the list has 0 or 1 elements → it's sorted → return `true`.
2. **Check First Two Elements**:
   - If `arr[0] > arr[1]` → return `false`.
   - Otherwise → call the function recursively on the sublist from index 1 onward.

---

## 📦 Code

```java
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
        System.out.println("Test 1: " + ifSorted(arr1)); // true

        List<Integer> arr2 = Arrays.asList(1, 2, 5, 4, 6);
        System.out.println("Test 2: " + ifSorted(arr2)); // false

        List<Integer> arr3 = Arrays.asList(3, 3, 3, 3);
        System.out.println("Test 3: " + ifSorted(arr3)); // true

        List<Integer> arr4 = Arrays.asList(7);
        System.out.println("Test 4: " + ifSorted(arr4)); // true

        List<Integer> arr5 = new ArrayList<>();
        System.out.println("Test 5: " + ifSorted(arr5)); // true

        List<Integer> arr6 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Test 6: " + ifSorted(arr6)); // true

        List<Integer> arr7 = Arrays.asList(1, 2, 3, 3, 4, 9, 6, 7, 8, 9, 10);
        System.out.println("Test 7: " + ifSorted(arr7)); // false
    }
}
````

---

## 🧾 Sample Output

```
Test 1: true
Test 2: false
Test 3: true
Test 4: true
Test 5: true
Test 6: true
Test 7: false
```

---

## 🌳 Recursion Tree (Example: \[1, 2, 3])

```
ifSorted([1, 2, 3])
├── 1 ≤ 2 → call ifSorted([2, 3])
    ├── 2 ≤ 3 → call ifSorted([3])
        ├── size = 1 → return true
✔️ All return true
```

---

## 📊 Time and Space Complexity

| Complexity | Value                                          |
| ---------- | ---------------------------------------------- |
| 🕒 Time    | `O(n)`                                         |
| 🗂 Space   | `O(n)` (due to recursion and subList creation) |

---

