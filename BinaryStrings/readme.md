# ✅ Generate All Bit Strings of Length `n` (Recursion)

A simple Java program to recursively generate all binary strings of length `n`.

---

## ❓ Problem Statement

> Generate all strings of `n` bits (0s and 1s).
>
> Assume you have an array `A[0..n-1]`, and you must fill it with all combinations of 0s and 1s using recursion.

---

## 💡 Intuition

### 🧠 In Simple Terms:

If you're given `n` switches, and each can either be **ON (1)** or **OFF (0)**, how many different settings can you create?
That’s exactly what a bit string is—just a series of ONs and OFFs!

So for `n = 3`, you’re just printing all 3-digit binary numbers from `000` to `111`.

---

## 🛠️ Approach

### 🧒 Casual Explanation:

Imagine you're stacking dominoes, and at each layer, you can pick a black one (0) or a white one (1).
You build one block, then call your clone to finish the rest. Once your clone finishes, you come back and try the other block. That’s recursion!

We fix one bit at a time starting from index `0`, then recursively fill the rest. When we reach the end (i.e., index `n`), we print the current arrangement.

---

### 🔁 Algorithm Steps:

1. Start with index `0` of the array.
2. Set `A[index] = 0`, then recurse for `index + 1`.
3. Set `A[index] = 1`, then recurse for `index + 1`.
4. If `index == n`, print the array as a bit string (base case).

---

## 📦 Code

```java
public class BitStringGenerator {

    // Recursive function to generate all bit strings of length n
    public static void generateBits(int[] A, int index) {
        if (index == A.length) {
            // Base case: print current binary string
            for (int bit : A) {
                System.out.print(bit);
            }
            System.out.println();
            return;
        }

        // Recursive step: set current index to 0 and recurse
        A[index] = 0;
        generateBits(A, index + 1);

        // Backtrack: set current index to 1 and recurse
        A[index] = 1;
        generateBits(A, index + 1);
    }

    public static void main(String[] args) {
        int n = 3;                // Length of bit strings
        int[] A = new int[n];     // Array to store each bit string
        generateBits(A, 0);       // Start recursion from index 0
    }
}
```

---

## 🧾 Sample Output

For `n = 3`, the output will be:

```
000  
001  
010  
011  
100  
101  
110  
111
```

---

## 🌳 Recursion Tree / Dry Run (Optional)

For `n = 2`, here's how the recursive calls branch:

```
generateBits(A, 0)
├── A[0]=0
│   └── A[1]=0 → print 00
│   └── A[1]=1 → print 01
└── A[0]=1
    └── A[1]=0 → print 10
    └── A[1]=1 → print 11
```

---

## 📊 Time and Space Complexity

| Complexity | Value                                    |
| ---------- | ---------------------------------------- |
| 🕒 Time    | O(2ⁿ) → All possible bit strings         |
| 🗂 Space   | O(n) → Due to recursive call stack depth |

---

## 🧠 Extra Tip

* You can easily modify this to generate **only strings with a fixed number of 1s**.
* Or you can use a `StringBuilder` instead of an array for a more elegant print-only solution.
* This is also the base idea behind **backtracking** and **combinatorics** problems like subsets and permutations.

---
