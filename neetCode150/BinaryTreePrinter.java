import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int val) {
        this.data = val;
    }
}

class Tree {
    private int size = 0;
    private TreeNode root = null;

    public Tree() {
    }

    public Tree(int val) {
        root = new TreeNode(val);
        size++;
    }

    // --- Public Methods ---

    public int size() {
        return size;
    }

    public boolean contains(int value) {
        return containsHelper(root, value);
    }

    public List<Integer> inOrder() {
        List<Integer> arr = new ArrayList<>();
        inOrderHelper(root, arr);
        return arr;
    }

    public List<Integer> preOrder() {
        List<Integer> arr = new ArrayList<>();
        preOrderHelper(root, arr);
        return arr;
    }

    public List<Integer> postOrder() {
        List<Integer> arr = new ArrayList<>();
        postOrderHelper(root, arr);
        return arr;
    }

    public void addLeft(int val) {
        if (root != null) {
            addLeftHelper(root, val);
        } else {
            root = new TreeNode(val);
        }
        size++;
    }

    public void addRight(int val) {
        if (root != null) {
            addRightHelper(root, val);
        } else {
            root = new TreeNode(val);
        }
        size++;
    }

    public void prettyPrint() {
        prettyPrintHelper(root, "", true);
    }

    public void add(int val) {
        if (root != null) {
            addHelper(val);
        } else {
            root = new TreeNode(val);
        }
        size++;
    }

    public List<Integer> levelOrder() {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            arr.add(current.data);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return arr;
    }
    public int height(){
        return heightHelper(root);
    }

    // --- Private Helper Methods ---

    private void addHelper(int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left==null){
                current.left = new TreeNode(val);
                return;
            }else if(current.right == null){
                current.right = new TreeNode(val);
                return;
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    private boolean containsHelper(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.data == val) {
            return true;
        }
        return containsHelper(node.left, val) || containsHelper(node.right, val);
    }

    private void inOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left, arr);
        arr.add(node.data);
        inOrderHelper(node.right, arr);
    }

    private void preOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        arr.add(node.data);
        preOrderHelper(node.left, arr);
        preOrderHelper(node.right, arr);
    }

    private void postOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        postOrderHelper(node.left, arr);
        postOrderHelper(node.right, arr);
        arr.add(node.data);
    }

    private void addLeftHelper(TreeNode node, int val) {
        if (node.left == null) {
            node.left = new TreeNode(val);
            return;
        }
        addLeftHelper(node.left, val);
    }

    private void addRightHelper(TreeNode node, int val) {
        if (node.right == null) {
            node.right = new TreeNode(val);
            return;
        }
        addRightHelper(node.right, val);
    }

    private void prettyPrintHelper(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }
        prettyPrintHelper(node.right, prefix + (isLeft ? "|   " : "    "), false);
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
        prettyPrintHelper(node.left, prefix + (isLeft ? "    " : "|   "), true);
    }

    private int heightHelper(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(heightHelper(node.left), heightHelper(node.right));
    }
}



public class BinaryTreePrinter {
    public static void section(String msg) {
        System.out.println("\n-------------------------------------" + msg + "-------------------------------------");
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(10);
        tree.add(20);
        tree.add(30);

        tree.add(40);
        tree.add(50);
        tree.add(60);
        
        tree.add(70);
        tree.add(80);

        
        section("PRETTY PRINT");
        tree.prettyPrint();
        section("HEIGHT");
        System.out.println(tree.height());
        
        section("SIZE OF TREE");
        System.out.println(tree.size());
        
        section("InOrder");
        System.out.println(tree.inOrder());

        section("PreOrder");
        System.out.println(tree.preOrder());

        section("PostOrder");
        System.out.println(tree.postOrder());

        section("LevelOrder");
        System.out.println(tree.levelOrder());

        section("Contains");
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(10));
        System.out.println(tree.contains(99));
    }
}