package binaryTree;

/**
 * Created by Jógvan on 11/17/15.
 */
public class IntTree {


    /**
     * Exercise 1:
     *
     * Write a method called countLeftNodes that returns
     * the number of left children in the tree.
     * A left child is a node that appears as the root of the
     * left-hand subtree of another node. For example, reference
     * tree #1 has 3 left children (the nodes storing the values 5, 1, and 4).
     */
    public int countLeftNodes() {
        return countLeftNodes(this.overallRoot, false);
    }

    private int countLeftNodes(IntTreeNode root, boolean left) {
        if(root==null) return 0;
        int sum = countLeftNodes(root.left, true) + countLeftNodes(root.right, false);
        return left ? sum+1 : sum;
    }

    /**
     * Exercise 2
     *
     * Write a method called countEmpty that returns the
     * number of empty branches in a tree. An empty tree
     * is considered to have one empty branch (the tree itself).
     * For nonempty trees, your methods should count the total number of
     * empty branches among the nodes of the tree. A leaf node has two empty
     * branches, a node with one nonempty child has one empty branch,
     * and a node with two nonempty children has no empty branches.
     * For example, reference tree #1 has 7 empty branches
     * (two under the value 1, one under 5, and two under each of 4 and 6).
     */
    public int countEmpty() {
        return countEmpty(this.overallRoot, 0);
    }

    private int countEmpty(IntTreeNode root, int c) {
        return ((root.right != null) ? countEmpty(root.right, c) : c + 1)
                +
                ((root.left != null) ? countEmpty(root.left, c) : c + 1);
    }

    /**
     * Exercise 3
     *
     * Write a method called depthSum that returns the sum of
     * the values stored in a binary tree of integers weighted
     * by the depth of each value. The method should return the value
     * at the root, plus 2 times the values stored at the next level of
     * the tree, plus 3 times the values stored at the next level of
     * the tree, and so on. For example, the depth sum of reference tree #1
     * would be computed as (1 * 3) + (2 * (5 + 2)) + (3 * (1 + 4 + 6)) = 50.
     */
    public int depthSum(){
        int[] sum = {0};
        depthSum(overallRoot, 0, sum);
        return sum[0];
    }

    private void depthSum(IntTreeNode node, int l, int[] s) {
        if(node == null) return;

        s[0] += ++l * node.data;
        depthSum(node.left, l, s);
        depthSum(node.right, l, s);
    }


    /**
     * Exercise 4
     *
     * Write a method called countEvenBranches that returns the number of
     * branch nodes in a binary tree that contain even numbers.
     * A branch node has one or two children (i.e., it is not a leaf).
     * For example, if a variable t refers to reference tree #2,
     * then the call t.countEvenBranches() should return 3 because
     * there are three branch nodes with even values (2, 8, and 6).
     * Notice that leaf nodes with even values are not included (the nodes storing 0 and 4).
     */
    public int countEvenBranches() {
        return countEvenBranches(this.overallRoot, 0);
    }

    private int countEvenBranches(IntTreeNode root, int c) {
        if (root != null) {
            if (root.data%2 == 0 && (root.right != null || root.left != null))
                c++;

            c = countEvenBranches(root.right, c);
            c = countEvenBranches(root.left, c);
        }
        return c;
    }

    /**
     * Exercise 5
     *
     * Write a method called printLevel that accepts an
     * integer parameter n and prints the values at level n from
     * left to right, one per line. We will use the convention that
     * the overall root is at level 1, its children are at level 2, and so on.
     * If there are no values at the level, your method should produce no output.
     * Your method should throw an IllegalArgumentException if it is
     * passed a value for a level that is less than 1. For example,
     * if a variable t refers to reference tree #2, then the call of t.printLevel(3);
     * would produce the following output:
     * 0
     * 7
     * 6
     */
    public void printLevel(int n) {
        if (n < 1) throw new IllegalArgumentException("n has to be greater or equal to 1");

        printLevel(n, 1, this.overallRoot);
    }

    private void printLevel(int n, int c, IntTreeNode root) {
        if (root != null) {
            if (n == c) {
                System.out.println(root.data);
            } else if(n>c) {
                printLevel(n, c + 1, root.left);
                printLevel(n, c + 1, root.right);
            }
        }
    }

    /**
     * Exercise 6
     *
     * Write a method called printLeaves that prints to System.out the leaves
     * of a binary tree from right to left.
     * More specifically, the leaves should be printed in the reverse order
     * that they would be printed using any of the standard traversals.
     * If the tree is empty, your method should produce the output "no leaves".
     * For example, if a variable t refers to reference tree #2, the call of t.printLeaves();
     * should produce the following output:
     * leaves: 9 4 0
     */
    public void printLeaves() {
        printLeaves(this.overallRoot);
    }

    private void printLeaves(IntTreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null){
            System.out.println(root.data);
        }else {
            printLeaves(root.left);
            printLeaves(root.right);
        }

    }

    /**
     * Exercise 7
     *
     * Write a method called isFull that returns true if a binary tree is full
     * and false if it is not. A full binary tree is one in which every node has 0 or 2 children.
     * For example, reference trees #1 and #2 are not full,
     * but #3 is full. By definition, the empty tree is considered full.
     */
    public boolean isFull() {
        return isFull(this.overallRoot);
    }

    private boolean isFull(IntTreeNode root) {
        if (root == null)
            return true;
        if((root.left==null&&root.right!=null) || (root.left!=null&&root.right==null))
            return false;

        return (isFull(root.left)&&isFull(root.right));
    }

    /**
     * Exercise 8
     *
     * Write a toString method for a binary tree of integers.
     * The method should return "empty" for an empty tree.
     * For a leaf node, it should return the data in the node as a string.
     * For a branch node, it should return a parenthesized String that has
     * three elements separated by commas: the data at the root, a string representation
     * of the left subtree, and then a string representation of the right subtree.
     * For example, if a variable t refers to reference tree #2, then the call t.toString()
     * should return the following String (without the surrounding quotes):
     * "(2, (8, 0, empty), (1, (7, 4, empty), (6, empty, 9)))"
     */
    @Override
    public String toString() {
        return toString(this.overallRoot);
    }

    private String toString(IntTreeNode root){
        String rootS = (root==null) ? "empty" : root.data+"";
        String leftS = (root.left==null) ? "empty" : toString(root.left);
        String rightS = (root.right==null) ? "empty" : toString(root.right);

        if(leftS.equals("empty")&&rightS.equals("empty")){
            return rootS;
        }
        return "("+rootS+", "+leftS+", "+rightS+")";
    }

    /**
     * Exercise 9
     *
     * Write a method called equals that accepts another binary tree of integers
     * as a parameter and compares the two trees to see whether they are equal to each other.
     * For example, if variables of type IntTree called t1 and t2 have been initialized,
     * then t1.equals(t2) will return true if the trees are equal and false otherwise.
     * Two empty trees are considered to be equal to each other.
     */
    public boolean equal(IntTree tree) {
        return toString().equals(tree.toString());
    }

    /**
     * Exercise 10
     *
     * Write a method called doublePositives that doubles all data values greater
     * than 0 in a binary tree of integers.
     */
    public void doublePositives() {
        doublePositives(this.overallRoot);
    }

    private void doublePositives(IntTreeNode root) {
        if (root == null) return;

        root.data*=2;
        doublePositives(root.right);
        doublePositives(root.left);
    }



    /* ------------------------------------------------- */

    private IntTreeNode overallRoot;

    // pre : max >= 0 (throws IllegalArgumentException if not)
    // post: constructs a sequential tree with given number of nodes
    public IntTree(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    // n is greater than max, in which case it returns an
    // empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.println("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.println(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using an inorder traversal
    public void printInorder() {
        System.out.println("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.println(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    // inorder traversal and using indentation to indicate
    // node depth; prints right to left so that it looks
    // correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    // root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);

            printSideways(root.left, level + 1);
        }
    }


    private static class IntTreeNode {
        public int data;
        public IntTreeNode left;
        public IntTreeNode right;

        /**
         * constructs a leaf node with given data
         * @param data
         */
        public IntTreeNode(int data) {
            this(data, null, null);
        }

        /**
         * constructs a branch node with given data, left subtree,
         * right subtree
         * @param data
         * @param left
         * @param right
         */
        public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
            this.data = data;

            this.left = left;
            this.right = right;
        }
    }
}