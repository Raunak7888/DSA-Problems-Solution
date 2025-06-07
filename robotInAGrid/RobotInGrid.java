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
        if (i < 0 || j < 0 || !grid[i][j]) {
            return false;
        }
        Point point = new Point(i,j);

        if(failedPoints.contains(point)) return false;

        if((i==0&&j==0)||getPath(grid, i-1, j, path, failedPoints)||getPath(grid, i, j-1, path, failedPoints)){
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

    // Test runner
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
