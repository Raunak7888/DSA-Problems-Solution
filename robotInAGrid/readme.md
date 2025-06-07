# ✅ Robot in a Grid (Recursion + Backtracking)

---

## ❓ Problem Statement

> Imagine a robot standing at the top-left corner of a grid with `r` rows and `c` columns.
> The robot can **only move right or down** at any time.
> However, some cells in the grid are **off-limits** (blocked), and the robot **can't step on those**.

**Goal**:
Find a path for the robot from the **top-left cell (0,0)** to the **bottom-right cell (r-1,c-1)**, if one exists.

---

## 🔍 Problem Explanation (Casual)

Think of this as a maze. You're playing as a robot who can only **walk right or down** — no turning back, no going up.

Now here's the catch: some tiles on the floor are broken (i.e., `false` in the grid), and if you step there, you're done.

So you need to carefully move from the **top-left** to the **bottom-right** without falling into any "holes".

---

## 💡 Intuition (Casual)

Instead of blindly guessing every direction like in a maze, think of solving it **backwards** — starting at the end `(r-1,c-1)` and asking:

> "Hey, did someone already reach here from the top or left?"

If yes, then boom — just add this step to the path.
If not, mark it as a dead-end and stop trying that direction in the future (this is called **memoization**).

---

## ⚙️ Approach (Simple Explanation)

1. Start at the **bottom-right** and **recursively** move **up** or **left**.
2. If the current cell is off-limits or out of bounds → return false.
3. If we reach `(0, 0)`, add it to the path and return true.
4. If we can reach here from the cell above or to the left → add this to path and return true.
5. Otherwise → mark it as a failed point and return false.

This way, we **avoid rechecking the same dead ends**, which saves time.

---

## 🧠 Approach (Technical Terms)

* **Recursive backtracking** with memoization.
* Use a `Set<Point>` to cache the cells that we already know lead nowhere.
* Keep building the path by backtracking from the destination to the source.

---

## 👨‍💻 Code

```java
package robotInAGrid;

import java.util.*;

public class RobotInGrid {

    public static List<Point> findPath(boolean[][] grid) {
        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();

        if (getPath(grid, grid.length - 1, grid[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] grid, int i, int j, List<Point> path, Set<Point> failedPoints) {
        if (i < 0 || j < 0 || !grid[i][j]) return false;

        Point point = new Point(i, j);
        if (failedPoints.contains(point)) return false;

        if ((i == 0 && j == 0) ||
            getPath(grid, i - 1, j, path, failedPoints) ||
            getPath(grid, i, j - 1, path, failedPoints)) {
            path.add(point);
            return true;
        }

        failedPoints.add(point);
        return false;
    }

    static class Point {
        int row, col;

        Point(int r, int c) {
            this.row = r;
            this.col = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point) o;
                return row == p.row && col == p.col;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }

    public static void main(String[] args) {
        boolean[][] grid = {
            { true, true, false, true },
            { true, true, true, false },
            { false, true, true, true },
            { true, false, true, true }
        };

        List<Point> path = findPath(grid);

        if (path != null) {
            System.out.println("Path found: " + path);
        } else {
            System.out.println("No path found.");
        }
    }
}
```

---

## 🧪 Sample Output

```
Path found: [(0,0), (1,0), (1,1), (1,2), (2,2), (2,3), (3,3)]
```

---

## 🔁 Dry Run / Recursion Tree (Simplified)

Suppose the robot is at `(3,3)`. It tries:

* Go **up** → `(2,3)` (valid)
* Then from `(2,3)` → `(2,2)`
* Then from `(2,2)` → `(1,2)`
* Then from `(1,2)` → `(1,1)` → `(1,0)` → `(0,0)` ✅

So, it builds the path in reverse and collects:
`(0,0) → (1,0) → (1,1) → (1,2) → (2,2) → (2,3) → (3,3)`

---

## ⏱️ Time & Space Complexity

| Type      | Complexity                   |
| --------- | ---------------------------- |
| **Time**  | O(R × C) in the worst case   |
| **Space** | O(R × C) for path + memo set |

---

