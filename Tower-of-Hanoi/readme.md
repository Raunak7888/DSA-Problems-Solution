# 🗼 Tower of Hanoi in Java

This project implements the **Tower of Hanoi** problem using recursion in Java.

---

## ❓ Question

> Given `n` disks of different sizes stacked in increasing order (smallest on top) on a source rod, move all the disks to a destination rod using a helper rod.  
> p
> **Rules**:
> - Only one disk can be moved at a time.
> - A larger disk can never be placed on a smaller disk.
> - Only the topmost disk on any rod can be moved.

---

## 💡 Intuition

### 🧠 In Simple Terms:
You're a robot trying to move disks from one rod (source) to another (destination), but you can only pick up the top disk each time. You have a third rod (helper) to temporarily hold disks.

- If there's only **1 disk**, just move it.
- If there are **2 or more disks**, move the top `n-1` disks to the helper rod first.
- Then move the biggest disk directly to the destination.
- Finally, move the `n-1` disks from the helper to the destination.

Think of it like:
> "First I get the little guys out of the way, then move the boss disk, and finally bring the little guys back."

---

## 🛠️ Approach

### 🧒 Casual Explanation:
1. "Let me take all the disks except the bottom one and put them on a temporary rod."
2. "Now I'll move the bottom disk directly to the target rod."
3. "Now I just move all the little disks back on top of the big one."

### 🔁 Technical Recursive Steps:
1. Move `n-1` disks from **source** to **helper**, using **end** as helper.
2. Move the `nth` disk from **source** to **end**.
3. Move `n-1` disks from **helper** to **end**, using **source** as helper.

---

## 📦 Code

```java
public class tOH {
    public static void towerOfHanoi(int n, char source, char end, char helper) {
        if (n == 1) {
            System.out.println("Move Disk 1 from " + source + " to " + end);
            return;
        }
        towerOfHanoi(n - 1, source, helper, end);
        System.out.println("Move Disk " + n + " from " + source + " to " + end);
        towerOfHanoi(n - 1, helper, end, source);
    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}
````

---

## 🧾 Output (for `n = 3`)

```
Move Disk 1 from A to C
Move Disk 2 from A to B
Move Disk 1 from C to B
Move Disk 3 from A to C
Move Disk 1 from B to A
Move Disk 2 from B to C
Move Disk 1 from A to C
```

---

## 🌳 Recursion Tree Visualization

```
towerOfHanoi(3, A, C, B)
├── towerOfHanoi(2, A, B, C)
│   ├── towerOfHanoi(1, A, C, B)
│   │   └── Move Disk 1 from A to C
│   ├── Move Disk 2 from A to B
│   └── towerOfHanoi(1, C, B, A)
│       └── Move Disk 1 from C to B
├── Move Disk 3 from A to C
└── towerOfHanoi(2, B, C, A)
    ├── towerOfHanoi(1, B, A, C)
    │   └── Move Disk 1 from B to A
    ├── Move Disk 2 from B to C
    └── towerOfHanoi(1, A, C, B)
        └── Move Disk 1 from A to C
```

---

## ✅ Time and Space Complexity

* **Time Complexity**: `O(2^n)` – Exponential growth with each additional disk.
* **Space Complexity**: `O(n)` – Due to the recursion stack.




```


