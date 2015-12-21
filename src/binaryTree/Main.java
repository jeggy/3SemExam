package binaryTree;

/**
 * Created by Jógvan on 11/17/15.
 */
public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        IntTree t1 = new IntTree(8);
        IntTree t2 = new IntTree(8);
        t1.printSideways();

        System.out.println();
        System.out.println("******** Exercise 1 ********");
        System.out.println(t1.countLeftNodes());
        System.out.println("******** Exercise 2 ********");
        System.out.println(t1.countEmpty());
        System.out.println("******** Exercise 3 ********");
        System.out.println(t1.depthSum());
        System.out.println("******** Exercise 4 ********");
        System.out.println(t1.countEvenBranches());
        System.out.println("******** Exercise 5 ********");
        t1.printLevel(2);
        System.out.println("******** Exercise 6 ********");
        t1.printLeaves();
        System.out.println("******** Exercise 7 ********");
        System.out.println(t1.isFull());
        System.out.println("******** Exercise 8 ********");
        System.out.println(t1.toString());
        System.out.println("******** Exercise 9 ********");
        System.out.println(t1.equal(t2));
        System.out.println("******** Exercise 10 *******");
        t1.doublePositives();
        System.out.println("---------------------");
        t2.printSideways();
    }
}
