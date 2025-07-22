import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.sound.sampled.Line;

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

    // Constructors
    public Tree() {

    }

    public Tree(int val) {
        this.root = new TreeNode(val);
        size++;
    }

    // Public Methods
    public int size() {
        return size;
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

    public void add(int val) {
        if (root != null) {
            addHelper(val);
        } else {
            root = new TreeNode(val);
        }
        size++;
    }

    public void print() {
        printHelper(root, "", true);
    }

    public List<Integer> inOrder() {
        if (root == null)
            return new ArrayList<>();
        return inOrderHelper(root, new ArrayList<>());
    }

    public List<Integer> preOrder() {
        if (root == null)
            return new ArrayList<>();
        return preOrderHelper(root, new ArrayList<>());
    }

    public List<Integer> postOrder() {
        if (root == null)
            return new ArrayList<>();
        return postOrderHelper(root, new ArrayList<>());
    }

    public List<Integer> revInOrder() {
        if (root == null)
            return new ArrayList<>();
        return revInOrderHelper(root, new ArrayList<>());
    }

    public List<Integer> revPreOrder() {
        if (root == null)
            return new ArrayList<>();
        return revPreOrderHelper(root, new ArrayList<>());
    }

    public List<Integer> revPostOrder() {
        if (root == null)
            return new ArrayList<>();
        return revPostOrderHelper(root, new ArrayList<>());
    }

    public List<Integer> levelOrder() {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            arr.add(curr.data);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return arr;
    }

    public List<List<Integer>> levelOrderByLevel() {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.data);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            arr.add(list);
        }
        return arr;
    }

    public int height() {
        return heightHelper(root, 0);
    }

    public boolean contains(int val){
        return containshelper(root,val);
    }

    private boolean containshelper(TreeNode node, int val) {
        if(node==null){
            return false;
        }
        if(node.data==val){
            return true;
        }
        return containshelper(node.left, val) || containshelper(node.right, val);
    }

    // Private Helper Methods
    private int heightHelper(TreeNode node, int h) {
        if (node == null) {
            return h;
        }
        return 1 + Math.max(heightHelper(node.left, h), heightHelper(node.right, h));
    }

    private void addHelper(int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null) {
                curr.left = new TreeNode(val);
                return;
            } else if (curr.right == null) {
                curr.right = new TreeNode(val);
                return;
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    private void printHelper(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }
        printHelper(node.right, prefix + (isLeft ? "|   " : "    "), false);
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
        printHelper(node.left, prefix + (isLeft ? "    " : "|   "), true);
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

    private List<Integer> inOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return arr;
        }
        inOrderHelper(node.left, arr);
        arr.add(node.data);
        inOrderHelper(node.right, arr);
        return arr;
    }

    private List<Integer> preOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return arr;
        }
        arr.add(node.data);
        preOrderHelper(node.left, arr);
        preOrderHelper(node.right, arr);
        return arr;
    }

    private List<Integer> postOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return arr;
        }
        postOrderHelper(node.left, arr);
        postOrderHelper(node.right, arr);
        arr.add(node.data);
        return arr;
    }

    private List<Integer> revInOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return arr;
        }
        revInOrderHelper(node.right, arr);
        arr.add(node.data);
        revInOrderHelper(node.left, arr);
        return arr;
    }

    private List<Integer> revPreOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return arr;
        }
        revPreOrderHelper(node.right, arr);
        revPreOrderHelper(node.left, arr);
        arr.add(node.data);
        return arr;
    }

    private List<Integer> revPostOrderHelper(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return arr;
        }
        arr.add(node.data);
        revPostOrderHelper(node.right, arr);
        revPostOrderHelper(node.left, arr);
        return arr;
    }
}

public class BinaryTreePrinter {
    public static void section(String msg) {
        System.out.println("-----------------------------------" + msg + "-------------------------------------------");
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Tree tree = new Tree();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(60);
        tree.add(70);
        tree.add(80);

        section("PRETTY PRINTING THE TREE");
        tree.print();

        section("SIZE OF THE TREE");
        System.out.println(tree.size());

        section("INORDER TRAVERSAL");
        System.out.println(tree.inOrder()); 

        section("PREORDER TRAVERSAL");
        System.out.println(tree.preOrder()); 

        section("POSTORDER TRAVERSAL");
        System.out.println(tree.postOrder()); 

        section("REVERSE INORDER TRAVERSAL");
        System.out.println(tree.revInOrder()); 

        section("REVERSE PREORDER TRAVERSAL");
        System.out.println(tree.revPreOrder()); 

        section("REVERSE POSTORDER TRAVERSAL");
        System.out.println(tree.revPostOrder());

        section("LEVEL ORDER TRAVERSAL");
        System.out.println(tree.levelOrder());

        section("LEVEL ORDER TRAVERSAL");
        System.out.println(tree.levelOrderByLevel());

        section("HEIGHT OF THE TREE");
        System.out.println(tree.height());

        section("CONTAINS");
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(10));
        System.out.println(tree.contains(99));
        System.out.println(tree.contains(40));
        System.out.println(tree.contains(80));

        section("TOTAL TIME TAKEN");
        System.out.println("Total execution time: " + (System.currentTimeMillis() - start) + " ms");
    }

}